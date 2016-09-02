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
package com.huawei.esdk.ec.device.appserver.multiapponline;

import org.apache.log4j.Logger;
import com.huawei.esdk.ec.device.AbstractAppServerCapability;
import com.huawei.esdk.ec.device.appserver.bean.HisMsgResponse;
import com.huawei.esdk.ec.device.appserver.multiapponline.convert.HisMsgCapabilityConvert;
import com.huawei.esdk.ec.device.bean.XMLResMsg;
import com.huawei.esdk.ec.devices.app.multiapponline.IHisMsgCapability;
import com.huawei.esdk.ec.domain.model.multiapponline.HisMsg;
import com.huawei.esdk.ec.domain.model.multiapponline.HisMsgInfoModel;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

/**
 * 南向协议无关层
 * <p>
 * @author wangxiaobo/wWX233376
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class HisMsgCapabilityImpl extends AbstractAppServerCapability implements IHisMsgCapability
{
    private static final Logger LOGGER = Logger.getLogger(HisMsgCapabilityImpl.class);
    
    HisMsgCapabilityConvert hisMsgCapabilityConvert = new HisMsgCapabilityConvert();
    
    public HisMsgCapabilityImpl(ISDKProtocolAdapter protocolAdapter)
    {
        super(protocolAdapter);
    }
    
    @Override
    public SDKResult<HisMsgInfoModel> getHisMsg(HisMsg hisMsg)
    {
        LOGGER.debug("getHisMsg start");
        SDKResult<HisMsgInfoModel> result = new SDKResult<HisMsgInfoModel>();
        RestReqMessage request = hisMsgCapabilityConvert.getHisMsgMode2Rest(hisMsg);
        
        try
        {
            XMLResMsg response = sendMessage(request, "openInterface/searchHisMsg.action", HisMsgResponse.class.getName());
            
            result.setErrCode(Integer.valueOf(response.getHead().getRetCode()));
            result.setDescription(response.getHead().getRetContext());
            
            if (0 == result.getErrCode())
            {
            	HisMsgResponse resBean = (HisMsgResponse)response.getBody();
                result.setResult(hisMsgCapabilityConvert.getHisMsgResponseRest2Model(resBean));
            }
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("getHisMsg() error", e);
        }
        
        LOGGER.debug("getHisMsg end");
        
        return result;
        
    }
    
}
