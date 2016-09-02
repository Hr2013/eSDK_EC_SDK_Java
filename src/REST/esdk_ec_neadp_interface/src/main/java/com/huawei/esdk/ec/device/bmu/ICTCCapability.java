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
package com.huawei.esdk.ec.device.bmu;

import java.util.List;

import com.huawei.esdk.ec.domain.model.Conference;
import com.huawei.esdk.ec.domain.model.bean.DeleteMeetingParam;
import com.huawei.esdk.ec.domain.model.bean.PagedList;
import com.huawei.esdk.ec.domain.model.bean.QueryMeetingParam;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;

public interface ICTCCapability
{
    SDKResult<String> scheduleMeeting(Conference confParam);
    
    SDKErrorCode modifyMeeting(Conference confParam);
    
    SDKResult<List<DeleteMeetingParam>> deleteMeeting(String userId, List<DeleteMeetingParam> params);
    
    SDKResult<PagedList<Conference>> queryMeeting(QueryMeetingParam param);
    
    SDKResult<PagedList<Conference>> queryJoinMeeting(QueryMeetingParam param);
}
