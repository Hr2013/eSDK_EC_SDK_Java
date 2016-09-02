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
package com.huawei.esdk.ec.device.bmu.phone.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.ec.device.bmu.bean.PhoneInfoListRequest;
import com.huawei.esdk.ec.device.bmu.bean.PhoneInfoRequest;
import com.huawei.esdk.ec.device.bmu.bean.QueryPhoneState;
import com.huawei.esdk.ec.device.bmu.bean.QueryPhoneStateRequest;
import com.huawei.esdk.ec.domain.model.bean.PhoneInfo;
import com.huawei.esdk.ec.domain.model.bean.PhoneState;
import com.huawei.esdk.ec.domain.model.bean.PhoneStateList;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;

public class PhoneCapabilityConvert
{
    public RestReqMessage getQueryPhoneState(String userId, List<PhoneInfo> phoneInfoList)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        QueryPhoneStateRequest queryPhoneStateRequst = new QueryPhoneStateRequest();
        queryPhoneStateRequst.setUserId(userId);
        PhoneInfoListRequest infoListRequest = new PhoneInfoListRequest();
        List<PhoneInfoRequest> pInfoList = new ArrayList<PhoneInfoRequest>();
        PhoneInfoRequest infoRequest = null;
        
        for (PhoneInfo info : phoneInfoList)
        {
            infoRequest = new PhoneInfoRequest();
            infoRequest.setGwIp(info.getGwIp());
            infoRequest.setNumber(info.getNumber());
            infoRequest.setSubPbx(info.getSubPbx());
            pInfoList.add(infoRequest);
        }
        
        infoListRequest.setPhoneInfoList(pInfoList);
        queryPhoneStateRequst.setPhoneInfoList(infoListRequest);
        payload.setBody(queryPhoneStateRequst);
        request.setPayload(payload);
        
        return request;
    }
    
    public PhoneStateList queryPhoneStateRest2Model(List<QueryPhoneState> phoneStateList)
    {
        if (null == phoneStateList || phoneStateList.isEmpty())
        {
            return null;
        }
        
        PhoneStateList list = new PhoneStateList();
        List<PhoneState> pStateList = new ArrayList<PhoneState>();
        PhoneState phoneState = null;
        
        for (QueryPhoneState queryPhoneState : phoneStateList)
        {
            phoneState = new PhoneState();
            phoneState.setGwIp(queryPhoneState.getGwIp());
            phoneState.setNumber(queryPhoneState.getNumber());
            phoneState.setState(queryPhoneState.getState());
            phoneState.setSubPbx(queryPhoneState.getSubPbx());
            pStateList.add(phoneState);
        }
        
        list.setPhoneStateList(pStateList);
        
        return list;
    }
}
