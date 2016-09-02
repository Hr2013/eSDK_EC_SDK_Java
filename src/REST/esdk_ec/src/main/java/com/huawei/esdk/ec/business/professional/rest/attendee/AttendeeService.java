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
package com.huawei.esdk.ec.business.professional.rest.attendee;

import com.huawei.esdk.ec.domain.model.Attendee;
import com.huawei.esdk.ec.domain.model.bean.DelAttendeeFailedList;
import com.huawei.esdk.ec.domain.model.bean.DelAttendeeInfoList;
import com.huawei.esdk.ec.domain.model.bean.QueryAttendeeInfoList;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.exception.SDKException;

/**
 * 与会者服务层对象
 * <p>
 * @author  cWX191990
 * @see  [相关类/方法]
 * @since  [eSDK UC V100R003C30]
 */
public class AttendeeService
{
    
    /** 
    * 添加与会者
    * 
    * @param attendee 领域层与会者对象
    * @return SDKResult SDK结果对象
    * @throws SDKException SDK系统异常
    * @see [类、类#方法、类#成员]
    */
    public SDKResult<String> addAttendee(Attendee attendee)
        throws SDKException
    {
        return attendee.addAttendee(attendee);
    }
    
    /** 
     * 修改与会者
     * 
     * @param attendee 领域层与会者对象
     * @return SDKResult SDK结果对象
     * @throws SDKException SDK系统异常
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<String> modifyAttendee(Attendee attendee)
        throws SDKException
    {
        return attendee.modifyAttendee(attendee);
    }
    
    /** 
    * 查询与会者列表
    * 
    * @param userId 操作用户
    * @param gwIp 网关IP
    * @param confId 会议ID
    * @param pageCount 分页大小
    * @param pageNum 当前页数
    * @return SDKResult<QueryAttendeeInfoList> 与会者列表
    * @throws SDKException SDK系统异常
    * @see [类、类#方法、类#成员]
    */
    public SDKResult<QueryAttendeeInfoList> queryAttendee(String userId, String gwIp, String confId, int pageCount,
        int pageNum)
        throws SDKException
    {
        return new Attendee().queryAttendee(userId, gwIp, confId, pageCount, pageNum);
    }
    
    /** 
    * 删除与会者列表
    * 
    * @param attendeeInfoList 需要删除的与会者列表
    * @return SDKResult<DelAttendeeFailedList> 删除结果，包括删除失败的与会者列表
    * @throws SDKException SDK系统异常
    * @see [类、类#方法、类#成员]
    */
    public SDKResult<DelAttendeeFailedList> deleteAttendee(DelAttendeeInfoList attendeeInfoList)
        throws SDKException
    {
        return new Attendee().deleteAttendee(attendeeInfoList);
    }
    
    /** 
     * 操作与会人
     * 
     * @param attendee 与会人信息
     * @return SDKErrorCode 操作结果
     * @throws SDKException SDK系统异常
     * @see [类、类#方法、类#成员]
     */
    public SDKErrorCode operateAttendee(Attendee attendee)
        throws SDKException
    {
        return attendee.operateAttendee(attendee);
    }
    
    /** 
     * 主席权限转移
     * 
     * @param attendee 与会人信息
     * @return SDKErrorCode 操作结果
     * @throws SDKException SDK系统异常
     * @see [类、类#方法、类#成员]
     */
    public SDKErrorCode transferChairman(Attendee attendee)
        throws SDKException
    {
        return attendee.transferChairman(attendee);
    }
}
