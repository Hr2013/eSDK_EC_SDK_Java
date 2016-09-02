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
package com.huawei.esdk.ec.addrdemo.utils;

import java.io.IOException;
import org.apache.log4j.Logger;
import com.google.gson.Gson;
import com.huawei.esdk.ec.addrdemo.bean.GetPublicKeyResponse;
/*import com.huawei.esdk.uc.professional.local.bean.RestRequestMessage;
import com.huawei.esdk.uc.professional.local.bean.platform.GetPublicKeyResponse;
import com.huawei.esdk.uc.professional.local.bean.platform.SetSecretKeyResponse;
import com.huawei.esdk.uc.professional.local.bean.south.RestRequestSecret;
import com.huawei.esdk.uc.professional.local.constant.ResultCode;
import com.huawei.esdk.uc.professional.local.constant.UCConstant;*/
import com.huawei.esdk.ec.addrdemo.bean.RestRequestSecret;
import com.huawei.esdk.ec.addrdemo.bean.SetSecretKeyResponse;
import com.huawei.esdk.ec.addrdemo.constant.UCConstant;
import com.huawei.esdk.ec.addrdemo.model.RestRequestMessage;
import com.huawei.esdk.ec.addrdemo.util.PropertiesUtils;
import com.huawei.esdk.ec.addrdemo.util.RestUtils;

/**
 * 密钥管理类
 * 用于获取公钥，以及密钥协商
 * 
 * @author  wWX233376
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class KeyManagerUtils
{
    /**
     * log日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(KeyManagerUtils.class);
    
    /**
     * Gson，用于进行对象和json之间的转换
     */
    private static final Gson GSON = new Gson();
    
    /**
     * 设置加密方式
     * @author  gaolinfei/gWX169839
     * @return 是否成功
     */
    public static int initTransmissionMode()
    {
        
        String transmissionMode = PropertiesUtils.getValue("sensitive.information.transmission.mode");
        if ("AES128_consulted".equals(transmissionMode))
        {
            return KeyManagerUtils.setSecretkey() ? 0 :
            	UCConstant.FAILED_TO_SET_SECRET_KEY;
        }
        else if ("RSA2048".equals(transmissionMode))
        {
            return KeyManagerUtils.getPublicKey() ? 0 :
            	UCConstant.FAILED_TO_GET_PUTLIC_KEY;
        }
        
        return 0;
    }
    
    /**
     * 获取公钥接口
     * 用于获取公钥
     * 
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static boolean getPublicKey()
    {
        GetPublicKeyResponse result = null;
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        //设置请求类型为GET
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_GET);
        
        String responsePayload = null;
        try
        {
            //发送rest消息，调用获取公钥接口
            responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage, "/secretmanger/publicKey");
            
//            String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage,
//					"/uc/bmu/batch_delete_account");
            
            if (!StringUtils.isEmpty(responsePayload))
            {
                //返回401为鉴权失败，检查rest_config.properties用户密码是否配置正确
                if (!"401".equals(responsePayload))
                {
                    //将JSON结果转化成JavaBean
                    result = GSON.fromJson(responsePayload, GetPublicKeyResponse.class);
                }
            }
        }
        catch (IOException e)
        {
            LOGGER.error("get public key error" + e);
        }
        catch (Exception e)
        {
            LOGGER.error("get public key error" + e);
        }
        
        if (null != result)
        {
            if ("0".equals(result.getHeader().getResultCode()))
            {
                RSA2048Utils.setPublicKey(result.getPublicKey());
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * 密钥协商接口
     * 将协商的工作密钥传给eSDK
     * 
     * @see [类、类#方法、类#成员]
     */
    public static boolean setSecretkey()
    {
        //设置参数
        String secretType = "AES128";
        String secretKeyString = byte2Hex(AES128Utils.getBT_KEY());
        String ivString = byte2Hex(AES128Utils.getBT_IV());
        
        //获取公钥
        if (!getPublicKey())
        {
            LOGGER.error("getPublicKey failed");
            return false;
        }
        
        String secretKeyCode = null;
        String ivCode = null;
        try
        {
            //将密码用RSA2048加密，并使用BASE64编码
            secretKeyCode = Base64Utils.encode(RSA2048Utils.encode(secretKeyString.getBytes("UTF-8")));
            ivCode = Base64Utils.encode(RSA2048Utils.encode(ivString.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            LOGGER.error("password encrypt failed" + e);
        }
        
        //拼装请求bean
        RestRequestSecret restRequestSecret = new RestRequestSecret();
        restRequestSecret.setSecretType(secretType);
        restRequestSecret.setSecretKey(secretKeyCode);
        restRequestSecret.setIv(ivCode);
        
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        //设置请求类型为POST
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
        restRequestMessage.setPayload(restRequestSecret);
        
        SetSecretKeyResponse result = null;
        
        try
        {
            //发送rest消息，调用密钥协商接口
            String responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage, PropertiesUtils.getValue("secretkey.path"));
            
            if (!StringUtils.isEmpty(responsePayload))
            {
                //返回401为鉴权失败，检查rest_config.properties用户密码是否配置正确
                if (!"401".equals(responsePayload))
                {
                    //将JSON结果转化成JavaBean
                    result = GSON.fromJson(responsePayload, SetSecretKeyResponse.class);
                }
            }
        }
        catch (IOException e)
        {
            LOGGER.error("set secret key error" + e);
        }
        catch (Exception e)
        {
            LOGGER.error("set secret key error" + e);
        }
        
        if (null != result)
        {
            if ("0".equals(result.getResultCode()))
            {
                return true;
            }
        }
        
        return false;
    }
    
    public static String byte2Hex(byte[] bytes)
    {
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < bytes.length; i++)
        {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            
            if (hex.length() == 1)
            {
                hex = '0' + hex;
            }
            
            sb.append(hex);
        }
        
        return sb.toString();
    }
}
