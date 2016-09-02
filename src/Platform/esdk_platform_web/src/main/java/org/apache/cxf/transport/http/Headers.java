/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.cxf.transport.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.common.util.PropertyUtils;
import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.helpers.HttpHeaderHelper;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageUtils;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.transports.http.configuration.HTTPServerPolicy;
import org.apache.cxf.version.Version;

public class Headers {
    /**
     *  This constant is the Message(Map) key for the HttpURLConnection that
     *  is used to get the response.
     */
    public static final String KEY_HTTP_CONNECTION = "http.connection";
    /**
     * Each header value is added as a separate HTTP header, example, given A header with 'a' and 'b'
     * values, two A headers will be added as opposed to a single A header with the "a,b" value. 
     */
    public static final String ADD_HEADERS_PROPERTY = "org.apache.cxf.http.add-headers";             
       
    public static final String PROTOCOL_HEADERS_CONTENT_TYPE = Message.CONTENT_TYPE.toLowerCase();
    public static final String HTTP_HEADERS_SETCOOKIE = "Set-Cookie";
    public static final String HTTP_HEADERS_LINK = "Link";
    public static final String EMPTY_REQUEST_PROPERTY = "org.apache.cxf.empty.request";
    private static final String SET_EMPTY_REQUEST_CT_PROPERTY = "set.content.type.for.empty.request";
    private static final TimeZone TIME_ZONE_GMT = TimeZone.getTimeZone("GMT");
    private static final Logger LOG = LogUtils.getL7dLogger(Headers.class);
    
    /**
     * Known HTTP headers whose values have to be represented as individual HTTP headers
     */
    private static final Set<String> HTTP_HEADERS_SINGLE_VALUE_ONLY;
    
    static {
        HTTP_HEADERS_SINGLE_VALUE_ONLY = new HashSet<String>();
        HTTP_HEADERS_SINGLE_VALUE_ONLY.add(HTTP_HEADERS_SETCOOKIE);
        HTTP_HEADERS_SINGLE_VALUE_ONLY.add(HTTP_HEADERS_LINK);
    }
    
    private final Message message;
    private final Map<String, List<String>> headers;

    public Headers(Message message) {
        this.message = message;
        this.headers = getSetProtocolHeaders(message);
    }
    public Headers() {
        this.headers = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
        this.message = null;
    }
    
    public Map<String, List<String>> headerMap() {
        return headers;
    }
    

    /**
     * Write cookie header from given session cookies
     * 
     * @param sessionCookies
     */
    public void writeSessionCookies(Map<String, Cookie> sessionCookies) {
        List<String> cookies = null;
        for (String s : headers.keySet()) {
            if (HttpHeaderHelper.COOKIE.equalsIgnoreCase(s)) {
                cookies = headers.remove(s);
                break;
            }
        }
        if (cookies == null) {
            cookies = new ArrayList<String>();
        } else {
            cookies = new ArrayList<String>(cookies);
        }
        headers.put(HttpHeaderHelper.COOKIE, cookies);
        for (Cookie c : sessionCookies.values()) {
            cookies.add(c.requestCookieHeader());
        }
    }

    /**
     * This call places HTTP Header strings into the headers that are relevant
     * to the ClientPolicy that is set on this conduit by configuration.
     * 
     * REVISIT: A cookie is set statically from configuration? 
     */
    void setFromClientPolicy(HTTPClientPolicy policy) {
        if (policy == null) {
            return;
        }
        if (policy.isSetCacheControl()) {
            headers.put("Cache-Control",
                    createMutableList(policy.getCacheControl()));
        }
        if (policy.isSetHost()) {
            headers.put("Host",
                    createMutableList(policy.getHost()));
        }
        if (policy.isSetConnection()) {
            headers.put("Connection",
                    createMutableList(policy.getConnection().value()));
        }
        if (policy.isSetAccept()) {
            headers.put("Accept",
                    createMutableList(policy.getAccept()));
        } else if (!headers.containsKey("Accept")) {
            headers.put("Accept", createMutableList("*/*"));
        }
        if (policy.isSetAcceptEncoding()) {
            headers.put("Accept-Encoding",
                    createMutableList(policy.getAcceptEncoding()));
        }
        if (policy.isSetAcceptLanguage()) {
            headers.put("Accept-Language",
                    createMutableList(policy.getAcceptLanguage()));
        }
        if (policy.isSetContentType()) {
            message.put(Message.CONTENT_TYPE, policy.getContentType());
        }
        if (policy.isSetCookie()) {
            headers.put("Cookie",
                    createMutableList(policy.getCookie()));
        }
        if (policy.isSetBrowserType()) {
            headers.put("User-Agent",
                    createMutableList(policy.getBrowserType()));
        }
        if (policy.isSetReferer()) {
            headers.put("Referer",
                    createMutableList(policy.getReferer()));
        }
    }
    
    void setFromServerPolicy(HTTPServerPolicy policy) {
        if (policy.isSetCacheControl()) {
            headers.put("Cache-Control",
                        createMutableList(policy.getCacheControl()));
        }
        if (policy.isSetContentLocation()) {
            headers.put("Content-Location",
                        createMutableList(policy.getContentLocation()));
        }
        if (policy.isSetContentEncoding()) {
            headers.put("Content-Encoding",
                        createMutableList(policy.getContentEncoding()));
        }
        if (policy.isSetContentType()) {
            headers.put(HttpHeaderHelper.CONTENT_TYPE,
                        createMutableList(policy.getContentType()));
        }
        if (policy.isSetServerType()) {
            headers.put("Server",
                        createMutableList(policy.getServerType()));
        }
        if (policy.isSetHonorKeepAlive() && !policy.isHonorKeepAlive()) {
            headers.put("Connection",
                        createMutableList("close"));
        } else if (policy.isSetKeepAliveParameters()) {
            headers.put("Keep-Alive", createMutableList(policy.getKeepAliveParameters()));
        }
        
    
        
    /*
     * TODO - hook up these policies
    <xs:attribute name="SuppressClientSendErrors" type="xs:boolean" use="optional" default="false">
    <xs:attribute name="SuppressClientReceiveErrors" type="xs:boolean" use="optional" default="false">
    */
    }

    public void removeAuthorizationHeaders() {
        headers.remove("Authorization");
        headers.remove("Proxy-Authorization");
    }
    
    public void setAuthorization(String authorization) {
        headers.put("Authorization",
                createMutableList(authorization));
    }
    
    public void setProxyAuthorization(String authorization) {
        headers.put("Proxy-Authorization",
                createMutableList(authorization));
    }
    
    
    /**
     * While extracting the Message.PROTOCOL_HEADERS property from the Message,
     * this call ensures that the Message.PROTOCOL_HEADERS property is
     * set on the Message. If it is not set, an empty map is placed there, and
     * then returned.
     * 
     * @param message The outbound message
     * @return The PROTOCOL_HEADERS map
     */
    public static Map<String, List<String>> getSetProtocolHeaders(final Message message) {
        Map<String, List<String>> headers =
            CastUtils.cast((Map<?, ?>)message.get(Message.PROTOCOL_HEADERS));        
        if (null == headers) {
            headers = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
        } else if (headers instanceof HashMap) {
            Map<String, List<String>> headers2 
                = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
            headers2.putAll(headers);
            headers = headers2;
        }
        message.put(Message.PROTOCOL_HEADERS, headers);
        return headers;
    }

    public void readFromConnection(HttpURLConnection connection) {
        Map<String, List<String>> origHeaders = connection.getHeaderFields();
        headers.clear();
        for (String key : connection.getHeaderFields().keySet()) {
            if (key != null) {
                headers.put(HttpHeaderHelper.getHeaderKey(key), 
                    origHeaders.get(key));
            }
        }
    }

    private static List<String> createMutableList(String val) {
        return new ArrayList<String>(Arrays.asList(new String[] {val}));
    }
    
    /**
     * This procedure logs the PROTOCOL_HEADERS from the 
     * Message at the specified logging level.
     * 
     * @param level   The Logging Level.
     * @param headers The Message protocol headers.
     */
    void logProtocolHeaders(Level level) {
        if (LOG.isLoggable(level)) {
            for (String header : headers.keySet()) {
                List<?> headerList = headers.get(header);
                for (Object value : headerList) {
                    // replace cookie before log --add by jirunfang start
                    String logMessage = value == null ? "<null>" : value.toString();
                    if ("Cookie".equals(header))
                    {
                        int begin = 0;
                        if(logMessage.contains("ASP.NET_SessionId="))
                        {
                            begin = logMessage.indexOf("ASP.NET_SessionId=");
                        }
                        else if(logMessage.contains("ASP.NET_SessionID="))
                        {
                            begin = logMessage.indexOf("ASP.NET_SessionID=");
                        }
                        else
                        {
                            begin = -1;
                        }
                        
                        if (-1 < begin)
                        {
                            begin += "ASP.NET_SessionId=".length();
                            int end = logMessage.length();
                            if (end > begin)
                            {
                                String exp = logMessage.substring(begin, (end + begin) / 2);
                                StringBuffer rep = new StringBuffer();
                                for (int i = 0; i < exp.length(); i++)
                                {
                                    rep.append("*");
                                }
                                logMessage = logMessage.replace(exp, rep);
                            }
                        }
                    }  
                    // replace cookie before log --add by jirunfang end
                    
                    LOG.log(level, header + ": " 
                        + (value == null ? "<null>" : value.toString()));
                }
            }
        }
    }
    
    /**
     * Set content type and protocol headers (Message.PROTOCOL_HEADERS) headers into the URL
     * connection. 
     * Note, this does not mean they immediately get written to the output
     * stream or the wire. They just just get set on the HTTP request.
     * 
     * @param connection 
     * @throws IOException
     */
    public void setProtocolHeadersInConnection(HttpURLConnection connection) throws IOException {
        // If no Content-Type is set for empty requests then HttpUrlConnection:
        // - sets a form Content-Type for empty POST 
        // - replaces custom Accept value with */* if HTTP proxy is used
        boolean contentTypeSet = headers.containsKey(Message.CONTENT_TYPE);
        if (!contentTypeSet) {
            // if CT is not set then assume it has to be set by default
            boolean dropContentType = false;
            boolean getRequest = "GET".equals(message.get(Message.HTTP_REQUEST_METHOD));
            boolean emptyRequest = getRequest || PropertyUtils.isTrue(message.get(EMPTY_REQUEST_PROPERTY));
            // If it is an empty request (without a request body) then check further if CT still needs be set
            if (emptyRequest) { 
                Object setCtForEmptyRequestProp = message.getContextualProperty(SET_EMPTY_REQUEST_CT_PROPERTY);
                if (setCtForEmptyRequestProp != null) {
                    // If SET_EMPTY_REQUEST_CT_PROPERTY is set then do as a user prefers.
                    // CT will be dropped if setting CT for empty requests was explicitly disabled
                    dropContentType = PropertyUtils.isFalse(setCtForEmptyRequestProp);
                } else if (getRequest) {
                    // otherwise if it is GET then just drop it
                    dropContentType = true;
                }
                
            }
            if (!dropContentType) {
                String ct = emptyRequest && !contentTypeSet ? "*/*" : determineContentType();
                connection.setRequestProperty(HttpHeaderHelper.CONTENT_TYPE, ct);
            }
        } else {        
            connection.setRequestProperty(HttpHeaderHelper.CONTENT_TYPE, determineContentType());
        }
         
        transferProtocolHeadersToURLConnection(connection);
        logProtocolHeaders(Level.FINE);
    }

    public String determineContentType() {
        String ct = null;
        List<Object> ctList = CastUtils.cast(headers.get(Message.CONTENT_TYPE));
        if (ctList != null && ctList.size() == 1) {
            ct = ctList.get(0).toString();
        } else {
            ct  = (String)message.get(Message.CONTENT_TYPE);
        }
        
        String enc = (String)message.get(Message.ENCODING);
        if (null != ct) {
        	// modify ct.toLowerCase() to ct.toLowerCase(Locale.US) -- add by jirunfang one row
            if (enc != null 
                && ct.indexOf("charset=") == -1
                && !ct.toLowerCase(Locale.US).contains("multipart/related")) {
                ct = ct + "; charset=" + enc;
            }
        } else if (enc != null) {
            ct = "text/xml; charset=" + enc;
        } else {
            ct = "text/xml";
        }
        return ct;
    }
    
    /**
     * This procedure sets the URLConnection request properties
     * from the PROTOCOL_HEADERS in the message.
     */
    private void transferProtocolHeadersToURLConnection(URLConnection connection) {
        boolean addHeaders = MessageUtils.isTrue(
                message.getContextualProperty(ADD_HEADERS_PROPERTY));
        for (String header : headers.keySet()) {
            List<String> headerList = headers.get(header);
            if (HttpHeaderHelper.CONTENT_TYPE.equalsIgnoreCase(header)) {
                continue;
            }
            if (addHeaders || HttpHeaderHelper.COOKIE.equalsIgnoreCase(header)) {
                for (String s : headerList) {
                    connection.addRequestProperty(header, s);
                }
            } else {
                StringBuilder b = new StringBuilder();
                for (int i = 0; i < headerList.size(); i++) {
                    b.append(headerList.get(i));
                    if (i + 1 < headerList.size()) {
                        b.append(',');
                    }
                }
                connection.setRequestProperty(header, b.toString());
            }
        }
        // make sure we don't add more than one User-Agent header
        if (connection.getRequestProperty("User-Agent") == null) {
            connection.addRequestProperty("User-Agent", Version.getCompleteVersionString());
        }
    }
    
    /**
     * Copy the request headers into the message.
     * 
     * @param message the current message
     * @param headers the current set of headers
     */
    protected void copyFromRequest(HttpServletRequest req) {

        //TODO how to deal with the fields        
        for (Enumeration<String> e = req.getHeaderNames(); e.hasMoreElements();) {
            String fname = e.nextElement();
            String mappedName = HttpHeaderHelper.getHeaderKey(fname);
            List<String> values;
            if (headers.containsKey(mappedName)) {
                values = headers.get(mappedName);
            } else {
                values = new ArrayList<String>();
                headers.put(mappedName, values);
            }
            for (Enumeration<String> e2 = req.getHeaders(fname); e2.hasMoreElements();) {
                String val = e2.nextElement();
                values.add(val);
            }
        }
        if (!headers.containsKey(Message.CONTENT_TYPE)) {
            headers.put(Message.CONTENT_TYPE, Collections.singletonList(req.getContentType()));
        }
        // delete -- delete by jirunfang
//        if (LOG.isLoggable(Level.FINE)) {
//            LOG.log(Level.FINE, "Request Headers: " + headers.toString());
//        }
    }

    private String getContentTypeFromMessage() {
        final String ct  = (String)message.get(Message.CONTENT_TYPE);
        final String enc = (String)message.get(Message.ENCODING);
        // modify ct.toLowerCase() to ct.toLowerCase(Locale.US) -- add by jirunfang one row
        if (null != ct 
            && null != enc
            && ct.indexOf("charset=") == -1
            && !ct.toLowerCase(Locale.US).contains("multipart/related")) {
            return ct + "; charset=" + enc;
        } else {
            return ct;
        }
    }
    
    // Assumes that response body is not available only
    // if Content-Length is available and set to 0
    private boolean isResponseBodyAvailable() {
        List<String> ctLen = headers.get("Content-Length");
        if (ctLen == null || ctLen.size() != 1) {
            return true;
        }
        try {
            if (Integer.valueOf(ctLen.get(0)) == 0) {
                return false;
            }
        } catch (NumberFormatException ex) {
            // ignore
        }
        return true;
    }
    
    /**
     * Copy the response headers into the response.
     * 
     * @param message the current message
     * @param headers the current set of headers
     */
    protected void copyToResponse(HttpServletResponse response) {
        String contentType = getContentTypeFromMessage();
 
        if (!headers.containsKey(Message.CONTENT_TYPE) && contentType != null 
            && isResponseBodyAvailable()) {
            response.setContentType(contentType);
        }

        boolean addHeaders = MessageUtils.isTrue(
                message.getContextualProperty(ADD_HEADERS_PROPERTY));
        for (Iterator<?> iter = headers.keySet().iterator(); iter.hasNext();) {
            String header = (String)iter.next();
            List<?> headerList = headers.get(header);
            
            if (addHeaders || HTTP_HEADERS_SINGLE_VALUE_ONLY.contains(header)) {
                for (int i = 0; i < headerList.size(); i++) {
                    Object headerObject = headerList.get(i);
                    if (headerObject != null) {
                        response.addHeader(header, headerObjectToString(headerObject));
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < headerList.size(); i++) {
                    Object headerObject = headerList.get(i);
                    if (headerObject != null) {
                        sb.append(headerObjectToString(headerObject));
                    }
                    
                    if (i + 1 < headerList.size()) {
                        sb.append(',');
                    }
                }
                response.addHeader(header, sb.toString());
            }

            
        }
    }
    
    private String headerObjectToString(Object headerObject) {
        if (headerObject.getClass() == String.class) {
            // Most likely 
            return headerObject.toString();    
        } else {
            // We may consider introducing CXF HeaderDelegate interface 
            // so that the below code may be pushed back to the JAX-RS 
            // front-end where non String header objects are more likely 
            // to be set. Though the below code may be generally useful
            
            String headerString;
            if (headerObject instanceof Date) {
                headerString = toHttpDate((Date)headerObject);
            } else if (headerObject instanceof Locale) {
                headerString = toHttpLanguage((Locale)headerObject);
            } else {
                headerString = headerObject.toString();
            }
            return headerString;
        }
    }
    
    void removeContentType() {
        if (headers.containsKey(PROTOCOL_HEADERS_CONTENT_TYPE)) {
            headers.remove(PROTOCOL_HEADERS_CONTENT_TYPE);
        }
    }

    public String getAuthorization() {
        if (headers.containsKey("Authorization")) {
            List<String> authorizationLines = headers.get("Authorization"); 
            return authorizationLines.get(0);
        } else {
            return null;
        }
    }

    public static SimpleDateFormat getHttpDateFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        dateFormat.setTimeZone(TIME_ZONE_GMT);
        return dateFormat;
    }
    
    public static String toHttpDate(Date date) {
        SimpleDateFormat format = getHttpDateFormat();
        return format.format(date);
    }
    
    public static String toHttpLanguage(Locale locale) {
        StringBuilder sb = new StringBuilder();
        sb.append(locale.getLanguage());
        if (locale.getCountry() != null) {
            // Locale.toString() will add "_" instead, '-' is typically expected
            sb.append('-').append(locale.getCountry());
        }
        return sb.toString();
    }
    
    // the function add by jirunfang 
	private String replaceSession(String logMessage) {
		int begin = logMessage.indexOf("JSESSIONID=");
		if (-1 < begin) {
			begin = begin + 11;
		} else {
			return logMessage;
		}
		int end = logMessage.indexOf("]", begin);
		if (end > begin) {
			int length = (end - begin) / 2;
			String temp = logMessage.substring(begin, end);
			StringBuffer rep = new StringBuffer();
			for (int i = 0; i < length; i++) {
				rep.append("*");
			}
			rep.append(logMessage.substring(begin + length, end));
			logMessage = logMessage.replace(temp, rep);
		}
		return logMessage;
	}
}
