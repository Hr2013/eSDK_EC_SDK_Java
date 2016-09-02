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
package com.huawei.esdk.ec.device.bmu.attendee;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.device.AbstractBMUCapability;
import com.huawei.esdk.ec.device.bean.XMLResMsg;
import com.huawei.esdk.ec.device.bmu.IAttendeeCapability;
import com.huawei.esdk.ec.device.bmu.attendee.convert.AttendeeCapabilityConvert;
import com.huawei.esdk.ec.device.bmu.bean.DelAttendeeResponse;
import com.huawei.esdk.ec.device.bmu.bean.QueryAttendeeResponse;
import com.huawei.esdk.ec.domain.model.Attendee;
import com.huawei.esdk.ec.domain.model.bean.DelAttendeeFailedList;
import com.huawei.esdk.ec.domain.model.bean.DelAttendeeInfoList;
import com.huawei.esdk.ec.domain.model.bean.QueryAttendeeInfoList;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.commu.itf.ISDKProtocolAdapter;
import com.huawei.esdk.platform.exception.ProtocolAdapterException;

/**
 * 与会者新增、修改、查询能力类
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  [eSDK UC V100R003C30]
 */
public class AttendeeCapabilityImpl extends AbstractBMUCapability implements IAttendeeCapability
{
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(AttendeeCapabilityImpl.class);
    
    /**
     * 与会者能力转换类
     */
    private AttendeeCapabilityConvert attendeeCapabilityConvert = new AttendeeCapabilityConvert();
    
    public AttendeeCapabilityImpl(ISDKProtocolAdapter protocolAdapter)
    {
        super(protocolAdapter);
    }
    
    /** 
     * 添加与会者
     * 
     * @param attendee 与会者对象
     * @return SDKResult SDK结果对象
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<String> addAttendee(Attendee attendee)
    {
        LOGGER.debug("add attendee start");
        
        SDKResult<String> result = new SDKResult<String>();
        
        // 拼装报文
        RestReqMessage reqMessage = attendeeCapabilityConvert.getAddAttendeeModel2Rest(attendee);
        
        try
        {
            // 发送消息
            XMLResMsg xmlResMsg = sendMessage(reqMessage, "addAttendee.action", null);
            result.setErrCode(Integer.valueOf(xmlResMsg.getHead().getRetCode()));
            result.setDescription(xmlResMsg.getHead().getRetContext());
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("add attendee error", e);
        }
        
        LOGGER.debug("add attendee end");
        
        return result;
    }
    
    /** 
     * 修改与会者
     * 
     * @param attendee 与会者对象
     * @return SDKResult SDK结果对象
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<String> modifyAttendee(Attendee attendee)
    {
        LOGGER.debug("modify attendee start");
        
        SDKResult<String> result = new SDKResult<String>();
        
        // 拼装报文
        RestReqMessage reqMessage = attendeeCapabilityConvert.getAddAttendeeModel2Rest(attendee);
        
        try
        {
            // 发送消息
            XMLResMsg xmlResMsg = sendMessage(reqMessage, "modifyAttendee.action", null);
            result.setErrCode(Integer.valueOf(xmlResMsg.getHead().getRetCode()));
            result.setDescription(xmlResMsg.getHead().getRetContext());
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("add attendee error", e);
        }
        
        LOGGER.debug("modify attendee end");
        
        return result;
    }
    
    /** 
     * 查询与会人列表
     * 
     * @param userId 操作用户
     * @param gwIp 网关IP
     * @param confId 会议ID
     * @param pageNum 当前页数
     * @param pageCount 分页大小
     * @return SDKResult<QueryAttendeeInfoList> 与会人列表
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<QueryAttendeeInfoList> queryAttendee(String userId, String gwIp, String confId, int pageCount,
        int pageNum)
    {
        LOGGER.debug("query attendee start");
        
        SDKResult<QueryAttendeeInfoList> result = new SDKResult<QueryAttendeeInfoList>();
        
        // 拼装报文
        RestReqMessage reqMessage =
            attendeeCapabilityConvert.getQueryAttendeeRequest(userId, gwIp, confId, pageCount, pageNum);
        
        try
        {
            // 发送消息
            XMLResMsg xmlResMsg =
                sendMessage(reqMessage, "queryAttendee.action", QueryAttendeeResponse.class.getName());
            result.setErrCode(Integer.valueOf(xmlResMsg.getHead().getRetCode()));
            result.setDescription(xmlResMsg.getHead().getRetContext());
            
            // 转换成领域对象
            if (0 == result.getErrCode() && null != xmlResMsg.getBody())
            {
                result.setResult(attendeeCapabilityConvert.getQueryAttendeeRest2Model((QueryAttendeeResponse)xmlResMsg.getBody()));
            }
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("query attendee error", e);
        }
        
        LOGGER.debug("query attendee end");
        
        return result;
    }
    
    /** 
     * 删除与会者列表
     * 
     * @param attendeeInfoList 需要删除的与会者列表
     * @return SDKResult<DelAttendeeFailedList> 删除结果，包括删除失败的与会者列表
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<DelAttendeeFailedList> deleteAttendee(DelAttendeeInfoList attendeeInfoList)
    {
        LOGGER.debug("delete attendee start");
        
        SDKResult<DelAttendeeFailedList> result = new SDKResult<DelAttendeeFailedList>();
        
        // 拼装报文
        RestReqMessage reqMessage = attendeeCapabilityConvert.getDeleteAttendeeRequest(attendeeInfoList);
        
        try
        {
            // 发送消息
            XMLResMsg xmlResMsg = sendMessage(reqMessage, "deleteAttendee.action", DelAttendeeResponse.class.getName());
            result.setErrCode(Integer.valueOf(xmlResMsg.getHead().getRetCode()));
            result.setDescription(xmlResMsg.getHead().getRetContext());
            
            // 删除失败的与会人列表，转换
            if (null != xmlResMsg.getBody())
            {
                result.setResult(attendeeCapabilityConvert.getDeleteAttendeeRest2Model((DelAttendeeResponse)xmlResMsg.getBody()));
            }
            
        }
        catch (ProtocolAdapterException e)
        {
            result.setErrCode(e.getErrorCode());
            LOGGER.error("delete attendee error", e);
        }
        
        LOGGER.debug("delete attendee end");
        
        return result;
    }

    /** 
     * 操作与会人
     * 
     * @param attendee 与会人信息
     * @return SDKErrorCode 操作结果
     * @see [类、类#方法、类#成员]
     */
    public SDKErrorCode operateAttendee(Attendee attendee)
    {
        LOGGER.debug("operate attendee start");
        
        SDKErrorCode sdkResult = new SDKErrorCode();
        RestReqMessage request = attendeeCapabilityConvert.getOperateAttendeeRequest(attendee);
        
        try
        {
            XMLResMsg result = sendMessage(request, "operateAttendee.action", null);
            
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("operate attendee error", e);
        }
        
        LOGGER.debug("operate attendee end");
        
        return sdkResult;
    }

    /** 
     * 主席权限转移
     * 
     * @param attendee 与会人信息
     * @return SDKErrorCode 操作结果
     * @see [类、类#方法、类#成员]
     */
    public SDKErrorCode transferChairman(Attendee attendee)
    {
        LOGGER.debug("transferChairman() start");
        SDKErrorCode sdkResult = new SDKErrorCode();
        
        RestReqMessage request = attendeeCapabilityConvert.getChairmanRequest(attendee);
        
        try
        {
            XMLResMsg result = sendMessage(request, "transferChairman.action", null);
            
            sdkResult.setErrCode(Integer.valueOf(result.getHead().getRetCode()));
            sdkResult.setDescription(result.getHead().getRetContext());
            
        }
        catch (ProtocolAdapterException e)
        {
            sdkResult.setErrCode(e.getErrorCode());
            LOGGER.error("transferChairman() error", e);
        }
        
        LOGGER.debug("transferChairman() end");
        return sdkResult;
    } 
}
