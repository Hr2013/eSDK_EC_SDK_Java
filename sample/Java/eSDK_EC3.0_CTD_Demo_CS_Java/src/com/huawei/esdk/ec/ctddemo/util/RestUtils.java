package com.huawei.esdk.ec.ctddemo.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.DigestScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class RestUtils
{
    private static final RestUtils REST_UTIL = new RestUtils();

    private static final String REST_URL_MAPPING = "/esdk/rest";

    private static final Gson GSON = new Gson();

    private static String restURL;

    private static String userName;

    private static String password;

    private static String scheme;

    private static String hostname;

    private static int port;

    private DefaultHttpClient httpClient;

    private BasicHttpContext localContext;

    private HttpHost target;

    private int serverNounceCount;

    private RestUtils()
    {
    }

    public synchronized static RestUtils getInstance(String url, String name, String pwd)
    {
        restURL = url;
        userName = name;
        password = pwd;

        scheme = restURL.substring(0, restURL.indexOf("://"));
        port = Integer.parseInt(restURL.substring(restURL.lastIndexOf(":") + 1));
        hostname = restURL.substring(restURL.indexOf("://") + 3, restURL.lastIndexOf(":"));
        return REST_UTIL;
    }

    @SuppressWarnings("unchecked")
    public Map<String, String> sendMessage(Map<String, String> parameters, String resourcePath)
        throws ClientProtocolException, URISyntaxException, IOException
    {
        adapterScheme();
        buildBasicHttpContext();

        HttpPost request = new HttpPost(REST_URL_MAPPING + resourcePath);
        request.setEntity(new StringEntity(GSON.toJson(parameters), ContentType.APPLICATION_JSON));

        // 设置编码格式
        request.addHeader("content-type", "application/json;charset=UTF-8");

        httpClient.getCredentialsProvider().setCredentials(new AuthScope(target.getHostName(), target.getPort()),
            new UsernamePasswordCredentials(userName, password));
        Map<String, String> responseMap = null;
        try
        {
            HttpResponse response = httpClient.execute(target, request, localContext);

            if (response != null)
            {
                if (200 == response.getStatusLine().getStatusCode())
                {
                    HttpEntity entity = response.getEntity();
                    String responsePayload = EntityUtils.toString(entity);
                    responseMap = GSON.fromJson(responsePayload, Map.class);

                    if (null != responseMap && null != responseMap.get("resultCode")
                        && (null == responseMap.get("resultContext") || "".equals(responseMap.get("resultContext"))))
                    {
                        responseMap.put("resultContext", PropertiesUtils.getValue(responseMap.get("resultCode")));
                    }

                    return responseMap;
                }
                else if (401 == response.getStatusLine().getStatusCode())
                {
                    responseMap = new HashMap<String, String>();
                    responseMap.put("resultCode", "401");
                    responseMap.put("resultContext", "用户名或密码错误。");

                    return responseMap;
                }
            }

            return null;

        }
        catch (Exception e)
        {
            responseMap = new HashMap<String, String>();
            responseMap.put("resultCode", "1");
   if (e.getMessage().contains("Connection") && e.getMessage().contains("refused"))
   {
 responseMap.put("resultContext", "连接被拒绝，请检查eSDK地址是否正确，包括IP及端口号");
}
else
{
  responseMap.put("resultContext", e.getMessage());
}

            return responseMap;
        }
        finally
        {
            if (null != request)
            {
                request.releaseConnection();
            }
        }

    }

    private void adapterScheme()
    {
        ClientConnectionManager conMgr = new PoolingClientConnectionManager();
        httpClient = new DefaultHttpClient(conMgr);
        target = new HttpHost(hostname, port, scheme);
        if ("https".equalsIgnoreCase(scheme))
        {
            try
            {
                SSLContext ctx = SSLContext.getInstance("TLS");
                X509TrustManager tm = new X509TrustManager()
                {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers()
                    {
                        return new java.security.cert.X509Certificate[] {};
                    }

                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
                        throws java.security.cert.CertificateException
                    {
                    }

                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
                        throws java.security.cert.CertificateException
                    {
                    }

                };
                ctx.init(null, new TrustManager[] {tm}, null);
                SSLSocketFactory sslSocketFactory =
                    new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                SchemeRegistry registry = conMgr.getSchemeRegistry();
                registry.register(new Scheme(scheme, port, sslSocketFactory));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    private void buildBasicHttpContext()
    {
        AuthCache authCache = new BasicAuthCache();
        DigestScheme digestScheme = new DigestScheme();
        digestScheme.overrideParamter("nc", String.valueOf(serverNounceCount++));
        digestScheme.overrideParamter("cnonce", UUID.randomUUID().toString().replaceAll("-", ""));
        digestScheme.overrideParamter("qop", "auth");
        authCache.put(target, digestScheme);

        localContext = new BasicHttpContext();
        localContext.setAttribute(ClientContext.AUTH_CACHE, authCache);
    }
}