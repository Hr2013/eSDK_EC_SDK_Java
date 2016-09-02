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
package com.huawei.esdk.ec.common;

import java.io.UnsupportedEncodingException;

import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.constants.ESDKConstant;
import com.huawei.esdk.platform.common.constants.ESDKErrorCodeConstant;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.AES128App;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.common.utils.Base64Utils;
import com.huawei.esdk.platform.common.utils.RSA2048Utils;
import com.huawei.esdk.platform.session.itf.ISessionMgr;

public class CipherUtilsRest
{
    public static final String model = ConfigManager.getInstance().getValue("sensitive.information.transmission.mode",
        ESDKConstant.SENSITIVE_INFO_TRANSMISSION_MODE_AES128_CONSULTED);
    
    private static ISessionMgr sessionMgrPlatform = ApplicationContextUtil.getBean("sessionMgrC50");
    
    public static byte[] decrypt(byte[] pwd)
        throws SDKException
    {
        if (ESDKConstant.SENSITIVE_INFO_TRANSMISSION_MODE_AES128_CONSULTED.equalsIgnoreCase(model))
        {
            AES128App aes128 = new AES128App();
            MessageContext mc = ThreadLocalHolder.get();
            if (null != mc)
            {
                String sdkSession = (String)mc.getEntities().get(ESDKConstant.SDK_SESSION_ID);
                
                byte[] secretKey = sessionMgrPlatform.getSecretKey(sdkSession);
                byte[] iv = sessionMgrPlatform.getIv(sdkSession);
                if (null == secretKey || null == iv)
                {
                    SDKException sdkException = new SDKException(ESDKErrorCodeConstant.SECRETKEY_LACK_ERRORDESC);
                    sdkException.setSdkErrCode(ESDKErrorCodeConstant.SECRETKEY_LACK_ERRORCODE);
                    throw sdkException;
                }
                
                aes128.setBT_KEY(secretKey);
                aes128.setBT_IV(iv);
                try
                {
                    return aes128.decode(pwd);
                }
                catch (Exception e)
                {
                    SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORDESC);
                    sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORCODE);
                    throw sdkException;
                }
            }
            else
            {
                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORCODE);
                throw sdkException;
            }
        }
        else if (ESDKConstant.SENSITIVE_INFO_TRANSMISSION_MODE_RSA2048.equalsIgnoreCase(model))
        {
            byte[] decode = RSA2048Utils.decrypt(pwd);
            if (null != pwd && 0 < pwd.length && null == decode)
            {
                decode = RSA2048Utils.decrypt(pwd, "RSA");
                if (null == decode)
                {
                    SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORDESC);
                    sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORCODE);
                    throw sdkException;
                }
            }
            return decode;
        }
        else if (ESDKConstant.SENSITIVE_INFO_TRANSMISSION_MODE_AES128_FIXED.equalsIgnoreCase(model))
        {
            try
            {
                return AESCbc128Utils.decode(pwd);
            }
            catch (Exception e)
            {
                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORCODE);
                throw sdkException;
            }
        }
        else
        {
            return pwd;
        }
    }
    
    public static byte[] encrypt(byte[] pwd)
        throws SDKException
    {
        if (ESDKConstant.SENSITIVE_INFO_TRANSMISSION_MODE_AES128_CONSULTED.equalsIgnoreCase(model))
        {
            AES128App aes128 = new AES128App();
            MessageContext mc = ThreadLocalHolder.get();
            if (null != mc)
            {
                String sdkSession = (String)mc.getEntities().get(ESDKConstant.SDK_SESSION_ID);
                
                byte[] secretKey = sessionMgrPlatform.getSecretKey(sdkSession);
                byte[] iv = sessionMgrPlatform.getIv(sdkSession);
                if (null == secretKey || null == iv)
                {
                    SDKException sdkException = new SDKException(ESDKErrorCodeConstant.SECRETKEY_LACK_ERRORDESC);
                    sdkException.setSdkErrCode(ESDKErrorCodeConstant.SECRETKEY_LACK_ERRORCODE);
                    throw sdkException;
                }
                
                aes128.setBT_KEY(secretKey);
                aes128.setBT_IV(iv);
                try
                {
                    return aes128.encode(pwd);
                }
                catch (Exception e)
                {
                    SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_ENCODE_ERRORDESC);
                    sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_ENCODE_ERRORCODE);
                    throw sdkException;
                }
            }
            else
            {
                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_ENCODE_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_ENCODE_ERRORCODE);
                throw sdkException;
            }
        }
        else if (ESDKConstant.SENSITIVE_INFO_TRANSMISSION_MODE_AES128_FIXED.equalsIgnoreCase(model))
        {
            try
            {
                return AESCbc128Utils.encode(pwd);
            }
            catch (Exception e)
            {
                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_ENCODE_ERRORDESC);
                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_ENCODE_ERRORCODE);
                throw sdkException;
            }
        }
        else
        {
            return pwd;
        }
    }
    
    public static String decodeFromBase64(String pwd)
        throws SDKException
    {
        if (ESDKConstant.SENSITIVE_INFO_TRANSMISSION_MODE_PLAINTEXT.equalsIgnoreCase(model))
        {
            return pwd;
        }
        try
        {
            byte[] decodePwd = decrypt(Base64Utils.getFromBASE64(pwd));
            return new String(null == decodePwd ? new byte[0] :decodePwd , "UTF-8");
        }
        catch (SDKException e)
        {
            throw e;
        }
        catch (UnsupportedEncodingException e)
        {
            SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORDESC);
            sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_DECODE_ERRORCODE);
            throw sdkException;
        }
    }
    
    public static String encode(String pwd)
        throws SDKException
    {
        if (ESDKConstant.SENSITIVE_INFO_TRANSMISSION_MODE_PLAINTEXT.equalsIgnoreCase(model))
        {
            return pwd;
        }
        try
        {
            return Base64Utils.encode(encrypt(pwd.getBytes("UTF-8")));
        }
        catch (UnsupportedEncodingException e)
        {
            SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PASSWORD_ENCODE_ERRORDESC);
            sdkException.setSdkErrCode(ErrInfo.SDK_UC_PASSWORD_ENCODE_ERRORCODE);
            throw sdkException;
        }
    }
}
