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
package com.huawei.esdk.ec.device.obg;

import java.util.Date;
import java.util.List;

import com.huawei.esdk.ec.domain.model.Conference;
import com.huawei.esdk.ec.domain.model.HoldingConference;
import com.huawei.esdk.ec.domain.model.Terminal;
import com.huawei.esdk.ec.domain.model.bean.PagedList;
import com.huawei.esdk.ec.domain.model.bean.TerminalInConfInfo;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

public interface ICTCCapability
{
    SDKResult<HoldingConference> getConfInfo(String ucAccount, String confId) throws SDKException;
    
    SDKErrorCode audioToVideoConf(String ucAccount, String confId);
    
    SDKErrorCode joinConf(String confId,String ucAccount, String siteNo,String siteName,String role);

    SDKErrorCode addIntoConf(String ucAccount, List<Terminal> sitelist, String confId);

    SDKErrorCode delFromConf(String ucAccount, List<Terminal> sitelist, String confId);
    
    SDKResult<TerminalInConfInfo> informTerminalType(String confId, String ucAccount,
            String terminalType, String terminalIP,
            String location);
    
     SDKErrorCode modifyTalkMode(String ucAccount, String confId, String ceeNum, int aut);
    
    SDKErrorCode subConfStatus(String appID, String confID);

    SDKResult<String> createConf(Conference confParam);
    
//    SDKResult<List<Conference>> getConfList(String initiator, String qryType,
//            Date beginTime, Date endTime);
    
    SDKErrorCode releaseConf(String ucAccount, String confId);

    SDKResult<List<Terminal>> queryAttendees(String confId);
    
     /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param initiator
     * @param qryType
     * @param beginTime
     * @param endTime
     * @param pageList
     * @param confType2
     * @return
     * @see [类、类#方法、类#成员]
     */
    SDKResult<List<Conference>> getConfList(String initiator, String qryType, Date beginTime, Date endTime,
        PagedList<Object> pageList, String confType2);

    SDKErrorCode upgradeAudio2DataConf(String ucAccount, String confId);
}
