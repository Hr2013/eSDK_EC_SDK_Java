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
package com.huawei.esdk.ec.north.rest.app.resource.userprofile.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.domain.model.AddressListInfo;
import com.huawei.esdk.ec.domain.model.bean.EnterpriseList;
import com.huawei.esdk.ec.north.rest.bean.Address;
import com.huawei.esdk.ec.north.rest.bean.AddressList;
import com.huawei.esdk.ec.north.rest.bean.DepartmentInfo;
import com.huawei.esdk.ec.north.rest.bean.EmployeeList;
import com.huawei.esdk.ec.north.rest.bean.PersonInfo;
import com.huawei.esdk.ec.north.rest.bean.QueryAddressResponse;
import com.huawei.esdk.ec.north.rest.bean.QueryEmployeeResponse;
import com.huawei.esdk.ec.north.rest.bean.QueryEnterpriseResponse;
import com.huawei.esdk.ec.north.rest.bean.QueryPersonInfoResponse;
import com.huawei.esdk.platform.common.SDKResult;

public class UserProfileConvert
{
    
    public QueryAddressResponse getQueryAddressListResponseModel2Rest(SDKResult<AddressListInfo> result)
    {
        QueryAddressResponse response = new QueryAddressResponse();
        response.setResultCode(String.valueOf(result.getErrCode()));
        response.setResultContext(result.getDescription());
        
        AddressListInfo model = result.getResult();
        if (null != model)
        {
            AddressList addressList = new AddressList();
            response.setAddressList(addressList);
            
            addressList.setTotal(String.valueOf(model.getTotal()));
            addressList.setSum(String.valueOf(model.getSum()));
            
            List<com.huawei.esdk.ec.domain.model.bean.Address> addrModels = model.getAddresses();
            if (null != addrModels && !addrModels.isEmpty())
            {
                List<Address> addresses = new ArrayList<Address>();
                addressList.setAddresses(addresses);
                
                for (com.huawei.esdk.ec.domain.model.bean.Address addrModel : addrModels)
                {
                    if (null != addrModel)
                    {
                        Address address = new Address();
                        addresses.add(address);
                        
                        address.setBindno(addrModel.getBindno());
                        address.setEmail(addrModel.getEmail());
                        address.setFax(addrModel.getFax());
                        address.setHomephone(addrModel.getHomephone());
                        address.setMemberId(addrModel.getMemberId());
                        address.setMobile(addrModel.getMobile());
                        address.setName(addrModel.getName());
                        address.setOfficephone(addrModel.getOfficephone());
                        address.setSex(addrModel.getSex());
                        address.setShortphone(addrModel.getShortphone());
                        address.setStaffAccount(addrModel.getStaffAccount());
                    }
                }
                
            }
        }
        
        return response;
    }
    
    public QueryPersonInfoResponse getQueryPersonInfoModel2Rest(
        SDKResult<com.huawei.esdk.ec.domain.model.PersonInfo> result)
    {
        QueryPersonInfoResponse response = new QueryPersonInfoResponse();
        response.setResultCode(String.valueOf(result.getErrCode()));
        response.setResultContext(result.getDescription());
        
        com.huawei.esdk.ec.domain.model.PersonInfo model = result.getResult();
        if (null != model)
        {
            PersonInfo personInfo = new PersonInfo();
            response.setPersonInfo(personInfo);
            
            personInfo.setAddr(model.getAddr());
            personInfo.setBindNum(model.getBindNum());
            personInfo.setCredit(model.getCredit());
            personInfo.setEmail(model.getEmail());
            personInfo.setFax(model.getFax());
            personInfo.setHeadId(model.getHeadId());
            personInfo.setHomePhone(model.getHomePhone());
            personInfo.setMobile(model.getMobile());
            personInfo.setName(model.getName());
            personInfo.setOfficePhone(model.getOfficePhone());
            personInfo.setOtherPhone(model.getOtherPhone());
            personInfo.setSeat(model.getSeat());
            personInfo.setSex(model.getSex());
            personInfo.setShortPhone(model.getShortPhone());
            personInfo.setSignature(model.getSignature());
            personInfo.setStaffAccount(model.getStaffAccount());
            personInfo.setStaffId(model.getStaffId());
            personInfo.setStaffNO(model.getStaffNO());
            personInfo.setUnderwrite(model.getUnderwrite());
            personInfo.setVoip(model.getVoip());
            personInfo.setZip(model.getZip());
        }
        
        return response;
    }
    
    public QueryEmployeeResponse getEmployeeModel2Rest(
        SDKResult<com.huawei.esdk.ec.domain.model.bean.EmployeeList> result)
    {
        QueryEmployeeResponse response = new QueryEmployeeResponse();
        
        response.setResultCode(String.valueOf(result.getErrCode()));
        response.setResultContext(result.getDescription());
        
        com.huawei.esdk.ec.domain.model.bean.EmployeeList employeeListModel = result.getResult();
        if (null != employeeListModel)
        {
            EmployeeList employeeList = new EmployeeList();
            response.setEmployeeList(employeeList);
            employeeList.setTotal(String.valueOf(employeeListModel.getTotal()));
            employeeList.setSum(String.valueOf(employeeListModel.getSum()));
            
            List<com.huawei.esdk.ec.domain.model.PersonInfo> employeeModels = employeeListModel.getEmployees();
            if (null != employeeModels && !employeeModels.isEmpty())
            {
                List<PersonInfo> employees = new ArrayList<PersonInfo>();
                employeeList.setEmployees(employees);
                
                for (com.huawei.esdk.ec.domain.model.PersonInfo employeeModel : employeeModels)
                {
                    PersonInfo personInfo = new PersonInfo();
                    employees.add(personInfo);
                    
                    personInfo.setAddr(employeeModel.getAddr());
                    personInfo.setBindNum(employeeModel.getBindNum());
                    personInfo.setCredit(employeeModel.getCredit());
                    personInfo.setEmail(employeeModel.getEmail());
                    personInfo.setFax(employeeModel.getFax());
                    personInfo.setHeadId(employeeModel.getHeadId());
                    personInfo.setHomePhone(employeeModel.getHomePhone());
                    personInfo.setMobile(employeeModel.getMobile());
                    personInfo.setName(employeeModel.getName());
                    personInfo.setOfficePhone(employeeModel.getOfficePhone());
                    personInfo.setOtherPhone(employeeModel.getOtherPhone());
                    personInfo.setSeat(employeeModel.getSeat());
                    personInfo.setSex(employeeModel.getSex());
                    personInfo.setShortPhone(employeeModel.getShortPhone());
                    personInfo.setSignature(employeeModel.getSignature());
                    personInfo.setStaffAccount(employeeModel.getStaffAccount());
                    personInfo.setStaffId(employeeModel.getStaffId());
                    personInfo.setStaffNO(employeeModel.getStaffNO());
                    personInfo.setUnderwrite(employeeModel.getUnderwrite());
                    personInfo.setVoip(employeeModel.getVoip());
                    personInfo.setZip(employeeModel.getZip());
                }
            }
        }
        return response;
    }

    public QueryEnterpriseResponse getEnterpriseModel2Rest(SDKResult<EnterpriseList> result)
    {
        QueryEnterpriseResponse response = new QueryEnterpriseResponse();
        response.setResultCode(String.valueOf(result.getErrCode()));
        response.setResultContext(result.getDescription());
        
        EnterpriseList model = result.getResult();
        if (null != model)
        {
            com.huawei.esdk.ec.north.rest.bean.EnterpriseList rest = new com.huawei.esdk.ec.north.rest.bean.EnterpriseList();
            response.setEnterpriseList(rest);
            rest.setTotal(String.valueOf(model.getTotal()));
            rest.setDeptSum(String.valueOf(model.getDeptSum()));
            rest.setEmployeeSum(String.valueOf(model.getEmployeeSum()));
            rest.setParentDept(model.getParentdept());
            
            List<com.huawei.esdk.ec.domain.model.bean.DepartmentInfo> deptModels = model.getDepartments();
            if (null != deptModels && !deptModels.isEmpty())
            {
                List<DepartmentInfo> departments = new ArrayList<DepartmentInfo>();
                rest.setDepartments(departments);
                for (com.huawei.esdk.ec.domain.model.bean.DepartmentInfo deptModel : deptModels)
                {
                    DepartmentInfo departmentInfo = new DepartmentInfo();
                    departments.add(departmentInfo);
                    
                    departmentInfo.setDeptId(deptModel.getDeptId());
                    departmentInfo.setDeptName(deptModel.getDeptName());
                    departmentInfo.setSubDeptCount(deptModel.getSubDeptCount());
                    departmentInfo.setSubEmployeeCount(deptModel.getSubEmployeeCount());
                }
            }
            
            List<com.huawei.esdk.ec.domain.model.PersonInfo> employeeModels = model.getEmployees();
            if (null != employeeModels && !employeeModels.isEmpty())
            {
                List<PersonInfo> employees = new ArrayList<PersonInfo>();
                rest.setEmployees(employees);
                for (com.huawei.esdk.ec.domain.model.PersonInfo employeeModel : employeeModels)
                {
                    PersonInfo employee = new PersonInfo();
                    employees.add(employee);
                    
                    employee.setAddr(employeeModel.getAddr());
                    employee.setBindNum(employeeModel.getBindNum());
                    employee.setCredit(employeeModel.getCredit());
                    employee.setEmail(employeeModel.getEmail());
                    employee.setFax(employeeModel.getFax());
                    employee.setHeadId(employeeModel.getHeadId());
                    employee.setHomePhone(employeeModel.getHomePhone());
                    employee.setMobile(employeeModel.getMobile());
                    employee.setName(employeeModel.getName());
                    employee.setOfficePhone(employeeModel.getOfficePhone());
                    employee.setOtherPhone(employeeModel.getOtherPhone());
                    employee.setSeat(employeeModel.getSeat());
                    employee.setSex(employeeModel.getSex());
                    employee.setShortPhone(employeeModel.getShortPhone());
                    employee.setSignature(employeeModel.getSignature());
                    employee.setStaffAccount(employeeModel.getStaffAccount());
                    employee.setStaffId(employeeModel.getStaffId());
                    employee.setStaffNO(employeeModel.getStaffNO());
                    employee.setUnderwrite(employeeModel.getUnderwrite());
                    employee.setVoip(employeeModel.getVoip());
                    employee.setZip(employeeModel.getZip());
                }
            }
            
        }
        
        
        
        return response;
    }
    
}
