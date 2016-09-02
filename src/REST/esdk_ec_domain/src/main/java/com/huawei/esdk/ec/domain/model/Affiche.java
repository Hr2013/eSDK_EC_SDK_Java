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

import java.util.List;

import com.huawei.esdk.ec.device.obg.IMCapability;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class Affiche
{
    private String initiatorId;
    
    /**
     * 公告主题
     */
    private String afficheTitle;
    
    /**
     * 公告内容
     */
    private String afficheContent;
    
    /**
     * 0代表部门发送，1代表按用户发送
     */
    private String receiverType;
    
    /**
     * espace号码
     */
    private List<String> staffAccount;
    
    /**
     * 部门ID。-1表示根部门
     */
    private List<String> departmentId;
    
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    public static IDeviceManager getDeviceManager()
    {
        return deviceManager;
    }
    
    public static void setDeviceManager(IDeviceManager deviceManager)
    {
        Affiche.deviceManager = deviceManager;
    }
    
    public SDKErrorCode sendAffiche(Affiche affiche)
        throws SDKException
    {
        IMCapability imCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"), IMCapability.class);
        SDKErrorCode errorCode = imCapability.sendAffiche(affiche);
        return errorCode;
        
    }
    
    public SDKErrorCode sendAfficheRest(Affiche affiche)
        throws SDKException
    {
        IMCapability imCapability =
            getDeviceManager().getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                IMCapability.class);
        SDKErrorCode errorCode = imCapability.sendAffiche(affiche);
        return errorCode;
    }
    
    public String getInitiatorId()
    {
        return initiatorId;
    }
    
    public void setInitiatorId(String initiatorId)
    {
        this.initiatorId = initiatorId;
    }
    
    public String getAfficheTitle()
    {
        return afficheTitle;
    }
    
    public void setAfficheTitle(String afficheTitle)
    {
        this.afficheTitle = afficheTitle;
    }
    
    public String getAfficheContent()
    {
        return afficheContent;
    }
    
    public void setAfficheContent(String afficheContent)
    {
        this.afficheContent = afficheContent;
    }
    
    public String getReceiverType()
    {
        return receiverType;
    }
    
    public void setReceiverType(String receiverType)
    {
        this.receiverType = receiverType;
    }
    
    public List<String> getStaffAccount()
    {
        return staffAccount;
    }
    
    public void setStaffAccount(List<String> staffAccount)
    {
        this.staffAccount = staffAccount;
    }
    
    public List<String> getDepartmentId()
    {
        return departmentId;
    }
    
    public void setDepartmentId(List<String> departmentId)
    {
        this.departmentId = departmentId;
    }
    
}
