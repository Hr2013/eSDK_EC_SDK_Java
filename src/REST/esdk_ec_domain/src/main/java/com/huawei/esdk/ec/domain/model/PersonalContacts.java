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

import java.util.Date;
import java.util.List;

import com.huawei.esdk.ec.device.obg.userprofile.UserProfilePersonListCapability;
import com.huawei.esdk.ec.devices.v200r001c03.userprofile.UCV2R1C03UserProfilePersonListCapability;
import com.huawei.esdk.ec.domain.model.bean.LinkmanInfo;
import com.huawei.esdk.ec.domain.model.bean.PeronalChangeInfo;
import com.huawei.esdk.ec.domain.model.bean.PersonalTeam;
import com.huawei.esdk.ec.domain.model.bean.PersonalTeamInfo;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;

public class PersonalContacts extends Contacts
{
    // key：UC用户账号
    private String ucAccount;

    // 通讯录版本号
    private String version;

    // 联系人分组列表
    private List<PersonalTeamInfo> teams;

    // 联系人信息列表
    private List<LinkmanInfo> linkmans;

    public PersonalContacts()
    {
        
    }
    public PersonalContacts(String ucAccount)
    {
        super();
        this.ucAccount = ucAccount;
    }

    // 个人通讯录增量同步
    public SDKResult<PeronalChangeInfo> getPersonIncAddressBook(Date timeStamp) throws SDKException
    {
        UserProfilePersonListCapability personListCapability = getDeviceManager()
        .getDeviceServiceProxy(
                ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfilePersonListCapability.class);
        return personListCapability.getPersonIncAddressBook(getUcAccount(), timeStamp);
    }

    // 添加联系人
    public SDKErrorCode addLinkman(LinkmanInfo linkmanInfo, String teamId)
            throws SDKException
    {
        UserProfilePersonListCapability personListCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UserProfilePersonListCapability.class);
        return personListCapability.addLinkman(ucAccount, linkmanInfo, teamId);
    }

    // 联系人信息查询
    public SDKResult<LinkmanInfo> getLinkmanInfo(String linkmanId,
            Integer qrytype) throws SDKException
    {
        UserProfilePersonListCapability personListCapability =
            getDeviceManager().getDeviceServiceProxy
            (ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfilePersonListCapability.class);
        SDKResult<LinkmanInfo> result = personListCapability.getLinkmanInfo(getUcAccount(),linkmanId,qrytype);
        return result;
    }

    // 增加联系人分组
    public SDKResult<String> addClientTeam(String name, String teamId)
            throws SDKException
    {
        UserProfilePersonListCapability personListCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UserProfilePersonListCapability.class);
        return personListCapability.addClientTeam(ucAccount, name);
    }

    // 删除联系人分组
    public SDKErrorCode delClientTeam(String teamId) throws SDKException
    {
        UserProfilePersonListCapability personListCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UserProfilePersonListCapability.class);
        return personListCapability.delClientTeam(ucAccount, teamId);
    }

    // 修改联系人分组
    public SDKErrorCode modClientTeam(String name, String teamId) throws SDKException
    {
        UserProfilePersonListCapability personListCapability =
            getDeviceManager().getDeviceServiceProxy
            (ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfilePersonListCapability.class);
        SDKErrorCode result = personListCapability.modClientTeam(getUcAccount(), name, teamId);
        return result;
    }

    // 添加分组成员
    public SDKErrorCode addMemToTeam(String teamId, String linkmanId)
            throws SDKException
    {
        UserProfilePersonListCapability personListCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UserProfilePersonListCapability.class);
        return personListCapability.addMemberToTeam(ucAccount, teamId,
                linkmanId);
    }

    // 删除分组成员
    public SDKErrorCode delMemFromTeam(String teamId, String linkManId) throws SDKException
    {
        UserProfilePersonListCapability personListCapability =
            getDeviceManager().getDeviceServiceProxy
            (ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfilePersonListCapability.class);
        SDKErrorCode result = personListCapability.delMemFromTeam(getUcAccount(), linkManId, teamId);
        return result;
    }

    // 删除联系人
    public SDKErrorCode delLinkman(String linkmanId, String teamId)
            throws SDKException
    {
        UserProfilePersonListCapability personListCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UserProfilePersonListCapability.class);
        return personListCapability.delLinkman(ucAccount, teamId, linkmanId);
    }

    // 获取个人分组信息
    public SDKResult<List<PersonalTeam>> getPersonTeamInfo()
            throws SDKException
    {
        UserProfilePersonListCapability personListCapability = getDeviceManager()
                .getDeviceServiceProxy(
                        ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                        UserProfilePersonListCapability.class);
        SDKResult<List<PersonalTeam>> result = personListCapability
                .getPersonTeamInfo(getUcAccount());
        return result;
    }
    
    /**
     * modifyTeamSN（添加修改分组序号）
     * 参数都包含在personalContacts bean中
     * edit by w00208247
     * @author k00207574
     */
    public SDKErrorCode modifyTeamIndex(PersonalTeam personalTeam) throws SDKException{
        UCV2R1C03UserProfilePersonListCapability personListCapability = getDeviceManager()
        .getDeviceServiceProxy(
                ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UCV2R1C03UserProfilePersonListCapability.class);
        return personListCapability.modifyTeamIndex(ucAccount, personalTeam);
    }
    
    /** 
     * addClientTeam（添加联系人群组，C03接口）
     * name -- 群组名
     * edit by gaolinfei
     * @author gaolinfei
     * @throws SDKException 
    */
    public SDKResult<String> addClientTeam(String name) throws SDKException
    {
        UserProfilePersonListCapability personListCapability = getDeviceManager()
        .getDeviceServiceProxy(
                ConfigManager.getInstance().getValue("esdk.ec_appserver_device"),
                UserProfilePersonListCapability.class);
        return personListCapability.addClientTeam(ucAccount, name);
    }
   
    public String getUcAccount()
    {
        return ucAccount;
    }

    public void setUcAccount(String ucAccount)
    {
        this.ucAccount = ucAccount;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public List<PersonalTeamInfo> getTeams()
    {
        return teams;
    }

    public void setTeams(List<PersonalTeamInfo> teams)
    {
        this.teams = teams;
    }

    public List<LinkmanInfo> getLinkmans()
    {
        return linkmans;
    }

    public void setLinkmans(List<LinkmanInfo> linkmans)
    {
        this.linkmans = linkmans;
    }
    


}
