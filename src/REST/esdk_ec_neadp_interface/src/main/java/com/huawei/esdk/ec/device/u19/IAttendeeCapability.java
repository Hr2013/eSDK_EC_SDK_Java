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
package com.huawei.esdk.ec.device.u19;

import com.huawei.esdk.ec.domain.model.Attendee;
import com.huawei.esdk.ec.domain.model.bean.AttendeeInfo;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;

public interface IAttendeeCapability
{
    /** 
     * 操作与会人
     * 
     * @param attendee 与会人信息
     * @return SDKErrorCode 操作结果
     * @see [类、类#方法、类#成员]
     */
    public SDKErrorCode operateAttendee(Attendee attendee);
    
    /** 
     * 主席权限移交
     * <功能详细描述>
     * @param attendee 与会者信息
     * @return SDKErrorCode 操作结果
     * @see [类、类#方法、类#成员]
     */
    public SDKErrorCode transferChairman(Attendee attendee);
    
    /**
     * 添加与会者
     * <功能详细描述>
     * @param attendee
     * @return
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<AttendeeInfo> addAttendee(Attendee attendee);
    
    /**
     * 删除与会者
     * <功能详细描述>
     * @param attendee
     * @return
     * @see [类、类#方法、类#成员]
     */
    public SDKResult<AttendeeInfo> delAttendee(Attendee attendee);
    
    /** 
     * 修改与会者权限
     * 
     * @param attendee 与会人信息
     * @return SDKErrorCode 操作结果
     * @see [类、类#方法、类#成员]
     */
    public SDKErrorCode modifyAttendeeAuthority(Attendee attendee);
}
