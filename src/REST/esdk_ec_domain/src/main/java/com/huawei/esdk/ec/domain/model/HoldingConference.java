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
package com.huawei.esdk.ec.domain.model;

import com.huawei.esdk.ec.device.obg.ICTCCapability;
import com.huawei.esdk.ec.devices.v200r001c03.ctc.UCV2R1C03CTCCapability;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;

public class HoldingConference extends Conference
{    
    // 会议是否被锁定
    private boolean ifLocked;

    // 会议是否被静音
    private boolean ifMuted;
    
    public HoldingConference(String id)
    {
        super(id);
    }

    public HoldingConference()
    {
        super();
    }

    // 查询会场信息
    public SDKResult<HoldingConference> getConfInfo(String ucAccount)
            throws SDKException
    {
        ICTCCapability ctcCapability = getDeviceManager()
                .getDeviceServiceProxy(
                		ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        ICTCCapability.class);
        return ctcCapability.getConfInfo(ucAccount, this.getConfId());
    }

    // 查询会议与会成员
    public SDKErrorCode getConfMember(String ucAccount)
    {
        return null;
    }
    
    //选看会场 viewSite
    public SDKErrorCode viewTerminalSite(String ucAccount, String termianlUri) throws SDKException
    {
        UCV2R1C03CTCCapability ctcCapability = getDeviceManager()
            .getDeviceServiceProxy(
            		ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                    UCV2R1C03CTCCapability.class);
        return ctcCapability.viewTerminalSite(getConfId(),ucAccount, termianlUri, isLocked() ? "1" : "0");
    }

    public boolean isLocked()
    {
        return ifLocked;
    }

    public void setLocked(boolean locked)
    {
        this.ifLocked = locked;
    }

    public boolean isMuted()
    {
        return ifMuted;
    }

    public void setMuted(boolean muted)
    {
        this.ifMuted = muted;
    }
}
