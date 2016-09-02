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
package com.huawei.esdk.uc.professional.local.resource;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.huawei.esdk.uc.professional.local.bean.RestRequestMessage;
import com.huawei.esdk.uc.professional.local.bean.south.BatchQueryMeetingParam;
import com.huawei.esdk.uc.professional.local.bean.south.QueryMeetingResponse;
import com.huawei.esdk.uc.professional.local.constant.ResultCode;
import com.huawei.esdk.uc.professional.local.constant.UCConstant;
import com.huawei.esdk.uc.professional.local.utils.PropertiesUtils;
import com.huawei.esdk.uc.professional.local.utils.RestUtils;
import com.huawei.esdk.uc.professional.local.utils.StringUtils;

public class ConfManagerResource
{
    private static final Logger LOGGER = Logger.getLogger(ConfManagerResource.class);
    
    /**
     * Gson，用于进行对象和json之间的转换
     */
    private static final Gson GSON = new Gson();
    
    /** 
     * 获取与会会议列表
     * 
     * @author wangxiaobo/wWX233376
     * @param param
     * @return
     * @see [类、类#方法、类#成员]
     */
    public QueryMeetingResponse queryJoinMeeting(BatchQueryMeetingParam param)
    {
        QueryMeetingResponse result = null;
        
        RestRequestMessage restRequestMessage = new RestRequestMessage();
        restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
        restRequestMessage.setPayload(param);
        
        try
        {
            String responsePayload =
                RestUtils.getInstance().sendMessage(restRequestMessage,
                    PropertiesUtils.getValue("query_join_meeting.path"));
            
            if (!StringUtils.isEmpty(responsePayload))
            {
                if ("401".equals(responsePayload))
                {
                    result = new QueryMeetingResponse();
                    result.setResultCode("401");
                }
                else
                {
                    return (QueryMeetingResponse)GSON.fromJson(responsePayload, QueryMeetingResponse.class);
                }
            }
            else
            {
                result = new QueryMeetingResponse();
                result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
            }
        }
        catch (IOException e)
        {
            LOGGER.error("queryJoinMeeting error" + e);
        }
        catch (Exception e)
        {
            LOGGER.error("queryJoinMeeting error" + e);
        }
        
        result = new QueryMeetingResponse();
        result.setResultCode(String.valueOf(ResultCode.North.RESULT_FAILED));
        return result;
    }
}
