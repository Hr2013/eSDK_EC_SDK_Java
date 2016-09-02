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

import com.huawei.esdk.platform.common.constants.ESDKErrorCodeConstant;

public interface ErrInfo
{
    /**
     *  通用服务
     */
    //	int SDK_SYSTEM_ERRORCODE = 0x22009000;
    int SDK_SYSTEM_ERRORCODE = ESDKErrorCodeConstant.ERROR_CODE_SYS_ERROR;
    
    String SDK_SYSTEM_ERRORDESC = "SDK SYSTEM INTERNAL ERROR!";
    
    int DEVICE_UNKNOWN_ERRORCODE = 0x00000001;
    
    String DEVICE_UNKNOWN_ERRORDESC = "Device unknown error!";
    
    int PARLAYX_AUTHORIZE_FAILED_ERRORCODE = 0x00000002;
    
    String PARLAYX_AUTHORIZE_FAILED_ERRORDESC = "Parlaxy authorize failed error!";
    
    /**
     * 消息中缺少必选参数
     */
    int SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE = 0x00000004;
    
    String SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC = "SDK PARAM NOT COMPLETE ERROR!";
    
    /**
     *鉴权失败，密码错误 
     */
    int AUTHORIZE_FAILED_ERRORCODE = 450;
    
    String AUTHORIZE_FAILED_ERRORDESC = "authorize failed error!";
    
    /**
     * 消息中参数不合法
     */
    int SDK_UC_PARAM_NOT_CORRECT_ERRORCODE = 0x00000005;
    
    String SDK_UC_PARAM_NOT_CORRECT_ERRORCODESC = "SDK PARAM NOT CORRECT ERROR!";
    
    /**
     *  配置文件参数非法
     */
    int SDK_UC_CONFIGDATA_INCORRECT_ERRORCODE = 2130000024;
    
    String SDK_UC_CONFIGDATA_INCORRECT_ERRORDESC = "CONFIGURATION DATE INCORRECT!";
    
    /**
     *  密码解密失败
     */
    int SDK_UC_PASSWORD_DECODE_ERRORCODE = 2130000030;
    
    String SDK_UC_PASSWORD_DECODE_ERRORDESC = "PASSWORD DECODE FAILED!";
    
    /**
     *  密码加密失败
     */
    int SDK_UC_PASSWORD_ENCODE_ERRORCODE = 2130000031;
    
    String SDK_UC_PASSWORD_ENCODE_ERRORDESC = "PASSWORD ENCODE FAILED!";
    
    /**
     *  群组号不存在,限parlayx接口使用
     */
    int PARLAYX_GROUPID_NOT_EXISTCODE = 310;
    
    String PARLAYX_GROUPID_NOT_EXISTDESC = "groupid not exist!";
    
    int PARLAYX_UCACCOUNT_NOT_EXISTCODE = 401;
    
    String PARLAYX_UCACCOUNT_NOT_EXISTDESC = "UCAccount not exist!";
    
    /**
     *  批量操作（如增加和删除群组成员）部分成功,限parlayx接口使用
     */
    int PARLAYX_PART_SUCCESS_CODE = 1801;
    
    String PARLAYX_PART_SUCCESS_CODEDESC = "part success!";
    
    /**
     * 群组创建者不存在
     */
    int PARLAYX_CREATOR_NOT_EXISTCODE = 404;
    
    String PARLAYX_CREATOR_NOT_EXISTDESC = "creator not exist!";
    
    /**
     * soap消息header中的appId和消息体中的appId不一致
     */
    int SDK_UC_APPID_UNMATCHED_ERRORCODE = 107;
    
    String SDK_UC_APPID_UNMATCHED_ERRORCODEERRORDESC = "appId is unmatched";
    
    /**
     * Tag无效或匹配有误,请重新鉴权
     */
    String SDK_UC_APPAGENT_RET = "93006";
    
    interface EServerErrInfo
    {
        /**
         * Operate Success
         */
        int OPERATE_SUCCESS_ERRORCODE = 0;
        
        String OPERATE_SUCCESS_ERRORDESC = "Operate Success";
        
        /**
         * Can't find the results of the query user's status.
         */
        int CANNOT_FIND_RESULT_OF_USERSTATE_ERRORCODE = 2130190005;
        
        String CANNOT_FIND_RESULT_OF_USERSTATE_ERRORDESC =
            "Can't find the results of the query user's status.Parameter msgId is not correct or the result has exceeded the eSDK setting of the storage time";
        
        /**
         * Query user state results are not generated
         */
        int IN_REQUEST_PROCESSING_TRY_AGAIN_LATER_ERRORCODE = 2130000045;
        
        String IN_REQUEST_PROCESSING_TRY_AGAIN_LATER_ERRORDESC = "In request processing, try again later.";
        
        /**
         * The number of queries over the upper limit
         */
        int NUMBER_OF_QUERY_OVER_UPPER_LIMIT_ERRORCODE = 2130190007;
        
        String NUMBER_OF_QUERY_OVER_UPPER_LIMIT_ERRORDESC = "The number of queries over the upper limit";
        
        /**
         * Query user status timeout
         */
        int QUERY_USER_STATUS_TIMEOUT_ERRORCODE = 2130190008;
        
        String QUERY_USER_STATUS_TIMEOUT_ERRORDESC = "Query user status timeout";
    }
    
    interface UC20ErrInfo
    {
        /**
         * 消息中缺少必选参数
         */
        int SDK_UC_PARAM_NOT_COMPLETE_ERRORCODE = 19100003;
        
        String SDK_UC_PARAM_NOT_COMPLETE_ERRORCODESC = "SDK PARAM NOT COMPLETE ERROR!";
        
        /**
         * Query user state results are not generated
         */
        int NUMBER_OF_QUERY_OVER_UPPER_LIMIT_ERRORCODE = 332;
        
        String NUMBER_OF_QUERY_OVER_UPPER_LIMIT_ERRORDESC = "The number of queries over the upper limit";
        
        /**
         * 目的UC账号不存在
         */
        int OBJECTIVE_UC_ACCOUNT_DOES_NOT_EXIST_ERRORCODE = 401;
        
        String OBJECTIVE_UC_ACCOUNT_DOES_NOT_EXIST_ERRORDESC = "Objective uc account does not exist";
        
        /**
         * 目的部门不存在
         */
        int OBJECTIVE_DEPARTMENT_DOES_NOT_EXIST_ERRORCODE = 403;
        
        String OBJECTIVE_DEPARTMENT_DOES_NOT_EXIST_ERRORDESC = "Objective department does not exist";
    }
}
