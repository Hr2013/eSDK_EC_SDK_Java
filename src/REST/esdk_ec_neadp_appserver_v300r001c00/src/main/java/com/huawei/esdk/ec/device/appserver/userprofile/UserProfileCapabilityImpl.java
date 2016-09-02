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
package com.huawei.esdk.ec.device.appserver.userprofile;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.device.AbstractAppServerCapability;
import com.huawei.esdk.ec.device.appserver.bean.QueryAddrListResponse;
import com.huawei.esdk.ec.device.appserver.bean.QueryEmployeeResponse;
import com.huawei.esdk.ec.device.appserver.bean.QueryEnterpriseResponse;
import com.huawei.esdk.ec.device.appserver.im.IMCapabilityImpl;
import com.huawei.esdk.ec.device.appserver.userprofile.convert.UserProfileCapabilityConvert;
import com.huawei.esdk.ec.device.bean.XMLResMsg;
import com.huawei.esdk.ec.device.obg.userprofile.UserProfileCapability;
import com.huawei.esdk.ec.domain.model.AddressListInfo;
import com.huawei.esdk.ec.domain.model.PersonInfo;
import com.huawei.esdk.ec.domain.model.bean.EmployeeList;
import com.huawei.esdk.ec.domain.model.bean.EnterpriseList;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

public class UserProfileCapabilityImpl extends AbstractAppServerCapability implements UserProfileCapability
{
    
    private static final Logger LOGGER = Logger.getLogger(IMCapabilityImpl.class);
    
    private UserProfileCapabilityConvert userProfileCapabilityConvert = new UserProfileCapabilityConvert();
    
    public UserProfileCapabilityImpl(ISDKProtocolAdapter protocolAdapter)
    {
        super(protocolAdapter);
    }
    
    @Override
    public SDKResult<AddressListInfo> queryAddrList(String account, String condition, int pagecount, int pagenum)
    {
        LOGGER.debug("queryAddrList() start");
        SDKResult<AddressListInfo> result = new SDKResult<AddressListInfo>();
        RestReqMessage request = userProfileCapabilityConvert.getAddrListMode2Rest(account, condition, pagecount, pagenum);
        
        try
        {
            XMLResMsg response = sendMessage(request, "openInterface/searchAddrList.action", QueryAddrListResponse.class.getName());
            
            result.setErrCode(Integer.valueOf(response.getHead().getRetCode()));
            result.setDescription(response.getHead().getRetContext());
            
            if (0 == result.getErrCode())
            {
                QueryAddrListResponse resBean = (QueryAddrListResponse)response.getBody();
                result.setResult(userProfileCapabilityConvert.getAddressListInfoRest2Model(resBean));
            }
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("queryAddrList() error", e);
        }
        
        LOGGER.debug("queryAddrList() end");
        return result;
    }

    @Override
    public SDKResult<PersonInfo> queryPersonInfo(String account, String staffAccount)
    {
        LOGGER.debug("queryPersonInfo() start");
        SDKResult<PersonInfo> result = new SDKResult<PersonInfo>();
        RestReqMessage request = userProfileCapabilityConvert.getPersonInfoMode2Rest(account, staffAccount);
        
        try
        {
            XMLResMsg response =
                sendMessage(request,
                    "openInterface/queryPersonInfo.action",
                    com.huawei.esdk.ec.device.appserver.bean.PersonInfo.class.getName());
            
            result.setErrCode(Integer.valueOf(response.getHead().getRetCode()));
            result.setDescription(response.getHead().getRetContext());
            
            if (null != response.getBody())
            {
                com.huawei.esdk.ec.device.appserver.bean.PersonInfo resBean =
                    (com.huawei.esdk.ec.device.appserver.bean.PersonInfo)response.getBody();
                result.setResult(userProfileCapabilityConvert.getPersonInfoRest2Model(resBean));
            }
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("queryPersonInfo() error", e);
        }
        
        LOGGER.debug("queryPersonInfo() end");
        return result;
    }

    @Override
    public SDKResult<EmployeeList> queryEmployee(String account, String condition, int pagecount, int pagenum)
    {
        LOGGER.debug("queryEmployee() start");
        SDKResult<EmployeeList> result = new SDKResult<EmployeeList>();
        RestReqMessage request = userProfileCapabilityConvert.getEmployeeMode2Rest(account, condition, pagecount, pagenum);
        
        try
        {
            XMLResMsg response = sendMessage(request, "openInterface/searchEmployee.action", QueryEmployeeResponse.class.getName());
            
            result.setErrCode(Integer.valueOf(response.getHead().getRetCode()));
            result.setDescription(response.getHead().getRetContext());
            
            if (0 == result.getErrCode())
            {
                QueryEmployeeResponse resBean = (QueryEmployeeResponse)response.getBody();
                result.setResult(userProfileCapabilityConvert.getEmployeeRest2Model(resBean));
            }
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("queryEmployee() error", e);
        }
        
        LOGGER.debug("queryEmployee() end");
        return result;
    }

    @Override
    public SDKResult<EnterpriseList> queryEnterprise(String account, String deptId, int pagecount, int pagenum)
    {
        LOGGER.debug("queryEnterprise() start");
        SDKResult<EnterpriseList> result = new SDKResult<EnterpriseList>();
        RestReqMessage request = userProfileCapabilityConvert.getEnterpriseMode2Rest(account, deptId, pagecount, pagenum);
        
        try
        {
            XMLResMsg response = sendMessage(request, "openInterface/queryEnterprise.action", QueryEnterpriseResponse.class.getName());
            
            result.setErrCode(Integer.valueOf(response.getHead().getRetCode()));
            result.setDescription(response.getHead().getRetContext());
            
            if (0 == result.getErrCode())
            {
                QueryEnterpriseResponse resBean = (QueryEnterpriseResponse)response.getBody();
                result.setResult(userProfileCapabilityConvert.getEnterpriseRest2Model(resBean));
            }
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("queryEnterprise() error", e);
        }
        
        LOGGER.debug("queryEnterprise() end");
        return result;
    }
}
