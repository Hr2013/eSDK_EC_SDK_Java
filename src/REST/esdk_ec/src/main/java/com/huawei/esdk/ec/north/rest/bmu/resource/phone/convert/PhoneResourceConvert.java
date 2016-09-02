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
package com.huawei.esdk.ec.north.rest.bmu.resource.phone.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.domain.model.bean.PhoneInfo;
import com.huawei.esdk.ec.domain.model.bean.PhoneStateList;
import com.huawei.esdk.ec.north.rest.bean.PhoneState;

public class PhoneResourceConvert
{
    public List<PhoneInfo> queryPhoneStateRest2Model(List<com.huawei.esdk.ec.north.rest.bean.PhoneInfo> phoneList)
    {
        List<PhoneInfo> pInfoList = new ArrayList<PhoneInfo>();
        PhoneInfo pInfo = null;
        
        for (com.huawei.esdk.ec.north.rest.bean.PhoneInfo phoneInfo : phoneList)
        {
            pInfo = new PhoneInfo();
            pInfo.setGwIp(phoneInfo.getGwIp());
            pInfo.setNumber(phoneInfo.getNumber());
            pInfo.setSubPbx(phoneInfo.getSubPbx());
            pInfoList.add(pInfo);
        }
        
        return pInfoList;
    }
    
    public List<PhoneState> queryPhoneStateModel2Rest(PhoneStateList phoneStateList)
    {
        if (null == phoneStateList || null == phoneStateList.getPhoneStateList()
            || phoneStateList.getPhoneStateList().isEmpty())
        {
            return null;
        }
        
        List<PhoneState> list = new ArrayList<PhoneState>();
        PhoneState state = null;
        
        for (com.huawei.esdk.ec.domain.model.bean.PhoneState phoneState : phoneStateList.getPhoneStateList())
        {
            state = new PhoneState();
            state.setGwIp(phoneState.getGwIp());
            state.setNumber(phoneState.getNumber());
            state.setState(phoneState.getState());
            state.setSubPbx(phoneState.getSubPbx());
            list.add(state);
        }
        
        return list;
    }
}
