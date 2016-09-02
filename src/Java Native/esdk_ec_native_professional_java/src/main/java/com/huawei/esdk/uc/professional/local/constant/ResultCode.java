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
package com.huawei.esdk.uc.professional.local.constant;

/**
 * 返回码合集
 * @author  l00295065
 * @since  2015-08-10
 */
public interface ResultCode
{
    /**
     * 必填参数未填
     */
    int SDK_PARAM_NOT_COMPLETE_ERRORCODE = 570462210;
    
    String SDK_PARAM_NOT_COMPLETE_ERRORDESC = "必填参数未填";
    
    int SDK_TP_PASSWORD_ENCODE_ERRORCODE = 2130000031;
    
    int FAILED_TO_GET_PUTLIC_KEY = 2130000037;
    
    int FAILED_TO_SET_SECRET_KEY = 2130000044;
    
    /**
     * 南向返回码集合
     */
    interface South
    {
        /**
         *成功
         */
        int RESULT_SUCCESS = 0;
        
        /**
         *失败
         */
        int RESULT_FAILED = 1;
        
        /**
         * 未鉴权
         */
        int RESULT_UNAUTHORIZED = 10007;
        
        /**
         * 错误请求
         */
        int RESULT_BADREQUEST = 10001;
    }
    
    /**
     * 北向返回码集合
     */
    interface North
    {
        /**
         *成功
         */
        int RESULT_SUCCESS = 0;
        
        /**
         *失败
         */
        int RESULT_FAILED = 1;
        
        /**
         * 必填参数未填
         */
        int SDK_PARAM_NOT_COMPLETE_ERRORCODE = 19100003;
        
        /**
         * 参数不合法
         */
        int SDK_DATA_INCORRECT_ERRORCODE = 19100004;
        
        /**
         * 终端类型不存在
         */
        int TERMINALTYPE_NOT_EXIST = 19110016;
    }
}
