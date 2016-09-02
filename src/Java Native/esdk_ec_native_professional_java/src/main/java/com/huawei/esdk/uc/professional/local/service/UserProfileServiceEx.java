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
package com.huawei.esdk.uc.professional.local.service;

import com.huawei.esdk.uc.professional.local.bean.RestResponse;
import com.huawei.esdk.uc.professional.local.bean.south.AddAccountRequest;
import com.huawei.esdk.uc.professional.local.bean.south.AddDepartmentResult;
import com.huawei.esdk.uc.professional.local.bean.south.DepartmentRequest;
import com.huawei.esdk.uc.professional.local.bean.south.PersonInfo;
import com.huawei.esdk.uc.professional.local.bean.south.QueryDepartmentInfoList;
import com.huawei.esdk.uc.professional.local.bean.south.SipList;
import com.huawei.esdk.uc.professional.local.bean.south.SipQueryRequest;
import com.huawei.esdk.uc.professional.local.bean.south.SipRequest;

public interface UserProfileServiceEx
{
    /**
     * 企业部门搜索
     * @param userId
     * @param parentId
     * @param pageCount
     * @param pageNum
     * 
     * @return UCSDKResponse<QueryDepartmentInfoList>
     */
    RestResponse<QueryDepartmentInfoList> queryDeptListInfo(String userId, String parentId, String pageCount,
        String pageNum);
    
    /**
     * 企业成员详情查询
     * @param ucAccount
     *
     * @return UCSDKResponse<PersonInfo>
     */
    RestResponse<PersonInfo> queryStaffInfo(String ucAccount);
    
    /** 
     * 增加部门
     * @author wangxiaobo/wWX233376
     * @param DepartmentRequest
     * @return RestResponse<AddDepartmentResult>
     */
    RestResponse<AddDepartmentResult> addDept(DepartmentRequest departmentInfo);
    
    /** 
     * 修改部门
     * @param DepartmentRequest
     * @return Integer
     */
    Integer modifyDept(DepartmentRequest departmentInfo);
    
    /**
     * 删除部门
     * @param userId 用户Id deptId 部门ID
     * @return 返回码
     */
    Integer delDept(String userId, String departmentId);
    
    /**
     * 增加UC账号
     * @param AddAccountRequest 账号信息
     * @return 返回码
     */
    RestResponse<String> addAccount(AddAccountRequest accountInfo);
    
    /** 
     * 修改密码
     * @param acct
     * @return 返回码
     */
    Integer modifyAcountPassword(AddAccountRequest acct);
    
    /**
     * 增加号码
     * @param SipRequest
     * @return 返回码
     */
    Integer addNumber(SipRequest numberInfo);
    
    /**
     * 修改号码
     * @param SipRequest
     * @return 返回信息
     */
    Integer modifyNumber(SipRequest numberInfo);
    
    /**
     * 删除号码
     * @param SipRequest 电话号码
     * @return 返回信息
     */
    Integer delNumber(SipRequest numberInfo);
    
    /**
     * 查询号码
     * @param SipQueryRequest
     * @return 号码信息
     */
    RestResponse<SipList> queryNumber(SipQueryRequest req);
    
    /**
     * 号码绑定
     * @param AddAccountRequest
     * @return 返回信息
     */
    Integer numberBind(AddAccountRequest acct);
    
}
