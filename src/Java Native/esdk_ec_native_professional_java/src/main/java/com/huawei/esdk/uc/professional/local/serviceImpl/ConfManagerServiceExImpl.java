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
package com.huawei.esdk.uc.professional.local.serviceImpl;

import com.huawei.esdk.uc.professional.local.bean.RestResponse;
import com.huawei.esdk.uc.professional.local.bean.south.BatchQueryMeetingParam;
import com.huawei.esdk.uc.professional.local.bean.south.QueryMeetingInfoList;
import com.huawei.esdk.uc.professional.local.bean.south.QueryMeetingResponse;
import com.huawei.esdk.uc.professional.local.resource.ConfManagerResource;
import com.huawei.esdk.uc.professional.local.service.ConfManagerServiceEx;

public class ConfManagerServiceExImpl implements ConfManagerServiceEx
{
    private ConfManagerResource confManagerResource = new ConfManagerResource();
    
    private static ConfManagerServiceExImpl instance = null;
    
    public static synchronized ConfManagerServiceExImpl getInstance()
    {
        if (null == instance)
        {
            instance = new ConfManagerServiceExImpl();
        }
        return instance;
    }
    
    @Override
    public RestResponse<QueryMeetingInfoList> queryJoinMeeting(BatchQueryMeetingParam param)
    {
        RestResponse<QueryMeetingInfoList> result = new RestResponse<QueryMeetingInfoList>();
        
        QueryMeetingResponse response = confManagerResource.queryJoinMeeting(param);
        
        result.setResult(response.getQueryMeetingInfoList());
        result.setResultCode(response.getResultCode());
        result.setResultContext(response.getResultContext());
        return result;
    }
}
