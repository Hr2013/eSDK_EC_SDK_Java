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
package com.huawei.esdk.ec.device.obg.userprofile;

import com.huawei.esdk.ec.domain.model.AddressListInfo;
import com.huawei.esdk.ec.domain.model.PersonInfo;
import com.huawei.esdk.ec.domain.model.bean.EmployeeList;
import com.huawei.esdk.ec.domain.model.bean.EnterpriseList;
import com.huawei.esdk.platform.common.SDKResult;

/**
 * 通讯录接口
 * * * */
public interface UserProfileCapability
{
    /**
     * 
     * 查询个人通讯录
     * @param account
     * @param condition
     * @param pagecount
     * @param pagenum
     * @return
     */
    SDKResult<AddressListInfo> queryAddrList(String account, String condition, int pagecount, int pagenum);

    /**
     * 查询个人详情
     * @param account
     * @param staffAccount
     * @return
     */
    SDKResult<PersonInfo> queryPersonInfo(String account, String staffAccount);

    /**
     * 查询个人信息
     * @param account
     * @param condition
     * @param pagecount
     * @param pagenum
     * @return
     */
    SDKResult<EmployeeList> queryEmployee(String account, String condition, int pagecount, int pagenum);

    /**
     * 查询企业通讯录
     * @param account
     * @param deptId
     * @param pagecount
     * @param pagenum
     * @return
     */
    SDKResult<EnterpriseList> queryEnterprise(String account, String deptId, int pagecount, int pagenum);

}
