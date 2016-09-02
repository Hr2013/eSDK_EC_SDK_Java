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
package com.huawei.esdk.ec.north.rest.eserver.resource.im.convert;

import java.io.UnsupportedEncodingException;

import com.huawei.esdk.ec.common.ErrInfo;
import com.huawei.esdk.ec.domain.model.DeptInstanceMessage;
import com.huawei.esdk.ec.domain.model.GroupInstanceMessage;
import com.huawei.esdk.ec.domain.model.UCUserInstanceMessage;
import com.huawei.esdk.ec.north.rest.bean.eserver.AppSendMsgToDept;
import com.huawei.esdk.ec.north.rest.bean.eserver.AppSendMsgToGroup;
import com.huawei.esdk.ec.north.rest.bean.eserver.AppSendMsgToUC;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.Base64Utils;
import com.huawei.esdk.platform.common.utils.StringUtils;


public class IMResourceConvert
{
    
    public UCUserInstanceMessage appSendMsgToUCRest2Modal(AppSendMsgToUC msg) throws SDKException
    {
        UCUserInstanceMessage im = new UCUserInstanceMessage();
        im.setSender(msg.getSendNumber());
        im.setUcAccount(msg.getUcAccount());

        try
        {
            im.setContent(new String(Base64Utils.getFromBASE64(msg.getMessage()), "UTF-8"));
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        
        im.setDateTime(msg.getDateTime());
        if(StringUtils.isNotEmpty(msg.getPriorityLevel()))
        {
            try
            {
                im.setPriorityLevel(Integer.parseInt(msg.getPriorityLevel()));
            }
            catch(NumberFormatException e)
            {
                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODESC);
                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODE);
                throw sdkException;
            }
        }
        return im;
    }

    public DeptInstanceMessage appSendMsgToDeptRest2Modal(AppSendMsgToDept msg) throws SDKException
    {
        DeptInstanceMessage im = new DeptInstanceMessage();
        im.setSender(msg.getSendNumber());
        im.setDeptNo(msg.getDeptId());
        im.setContent(msg.getMessage());
        im.setSubject(msg.getSubject());
        im.setDeptGrade(msg.getDeptGrade());
        
        if(StringUtils.isNotEmpty(msg.getPriorityLevel()))
        {
            try
            {
                im.setPriorityLevel(Integer.parseInt(msg.getPriorityLevel()));
            }
            catch(NumberFormatException e)
            {
                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODESC);
                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODE);
                throw sdkException;
            }
        }
        return im;
    }
    
    public GroupInstanceMessage appSendMsgToGroupRest2Modal(AppSendMsgToGroup msg) throws SDKException
    {
        GroupInstanceMessage im = new GroupInstanceMessage();
        im.setSender(msg.getSendNumber());
        im.setGroupId(msg.getGroupId());
//        im.setContent(msg.getMessage());
        im.setDateTime(msg.getDateTime());
        
        try
        {
            im.setContent(new String(Base64Utils.getFromBASE64(msg.getMessage()), "UTF-8"));
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        
        if(StringUtils.isNotEmpty(msg.getPriorityLevel()))
        {
            try
            {
                im.setPriorityLevel(Integer.parseInt(msg.getPriorityLevel()));
            }
            catch(NumberFormatException e)
            {
                SDKException sdkException = new SDKException(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODESC);
                sdkException.setSdkErrCode(ErrInfo.SDK_UC_PARAM_NOT_CORRECT_ERRORCODE);
                throw sdkException;
            }
        }
        return im;
    }
}
