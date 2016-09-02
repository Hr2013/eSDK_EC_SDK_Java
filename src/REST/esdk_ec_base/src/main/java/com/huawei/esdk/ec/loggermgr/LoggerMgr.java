/**
 * Copyright 2015 Huawei Technologies Co., Ltd. All rights reserved.
 * eSDK is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huawei.esdk.ec.loggermgr;

import org.apache.log4j.Logger;
import com.google.gson.Gson;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.config.ConfigManager;

public class LoggerMgr
{
    private static Gson gson = new Gson();
    
    private static final Logger LOGGER = Logger.getLogger(LoggerMgr.class);
    
    private static String[] SENSITIVE_WORDS;
    
    static
    {
        SENSITIVE_WORDS = getSensitiveWords();
    }
    
    /**
     *调用时间、操作类型、调用接口名称、
     *详细的接口参数、客户端IP、
     *调用者的用户标识、成功或失败标识
     */
    public static void interfacelogger(String operationType, String interfaceName, Object msg, String errCode)
    {
        MessageContext mc = ThreadLocalHolder.get();
        
        StringBuffer sb = new StringBuffer();
        sb.append(operationType).append(" | ");
        sb.append(interfaceName).append(" | ");
        
        String msgStr = null;
        if (null != msg)
        {
            msgStr = gson.toJson(msg);
        }
        else
        {
            Object queryParams = mc.getEntities().get("queryParams");
            msgStr = gson.toJson(queryParams);
        }
        
        msgStr = hideSensitiveWords(msgStr, SENSITIVE_WORDS);
        sb.append(msgStr).append(" | ");
        
        String remoteIp = (String)mc.getEntities().get("remoteIp");
        sb.append(remoteIp).append(" | ");
        String userName = (String)mc.getEntities().get("userName");
        sb.append(userName).append(" | ");
        
        String status = "0".equals(errCode) ? errCode + " successfully" : errCode + " failed";
        sb.append(status).append(" | ");
        
        LOGGER.info(sb.toString());
    }
    
    private static String hideSensitiveWords(String msgStr, String[] sensitiveWords)
    {
        for (String str : sensitiveWords)
        {
            String indexStr = str + "\":\"";
            int index = msgStr.indexOf(indexStr);
            if (-1 != index)
            {
                String s1 = msgStr.substring(0, index + indexStr.length());
                String s2 = msgStr.substring(index + indexStr.length());
                s2 = "******" + s2.substring(s2.indexOf("\""));
                msgStr = s1 + s2;
            }
        }
        return msgStr;
    }
    
    private static String[] getSensitiveWords()
    {
        String proper = ConfigManager.getInstance().getValue("sensitive.words");
        return null == proper ? new String[0] : proper.split(",");
    }
}
