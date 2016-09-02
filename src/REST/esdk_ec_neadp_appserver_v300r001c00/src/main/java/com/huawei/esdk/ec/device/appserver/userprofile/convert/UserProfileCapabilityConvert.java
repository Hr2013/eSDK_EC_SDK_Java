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
package com.huawei.esdk.ec.device.appserver.userprofile.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.device.appserver.bean.Department;
import com.huawei.esdk.ec.device.appserver.bean.DepartmentList;
import com.huawei.esdk.ec.device.appserver.bean.EnterpriseResultNum;
import com.huawei.esdk.ec.device.appserver.bean.QueryAddrListRequest;
import com.huawei.esdk.ec.device.appserver.bean.QueryAddrListResponse;
import com.huawei.esdk.ec.device.appserver.bean.QueryEmployeeRequest;
import com.huawei.esdk.ec.device.appserver.bean.QueryEmployeeResponse;
import com.huawei.esdk.ec.device.appserver.bean.QueryEnterpriseRequest;
import com.huawei.esdk.ec.device.appserver.bean.QueryEnterpriseResponse;
import com.huawei.esdk.ec.device.appserver.bean.QueryPersonInfoRequest;
import com.huawei.esdk.ec.device.appserver.bean.ResultNum;
import com.huawei.esdk.ec.device.bean.XMLReqHeader;
import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.ec.domain.model.AddressListInfo;
import com.huawei.esdk.ec.domain.model.PersonInfo;
import com.huawei.esdk.ec.domain.model.bean.Address;
import com.huawei.esdk.ec.domain.model.bean.DepartmentInfo;
import com.huawei.esdk.ec.domain.model.bean.EmployeeList;
import com.huawei.esdk.ec.domain.model.bean.EnterpriseList;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;

public class UserProfileCapabilityConvert
{
    
    public RestReqMessage getAddrListMode2Rest(String account, String condition, int pagecount, int pagenum)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        request.setPayload(payload);
        
        XMLReqHeader head = new XMLReqHeader();
        head.setAccounts(account);
        payload.setHead(head);
        
        // 构建报文体
        QueryAddrListRequest body = new QueryAddrListRequest();
        payload.setBody(body);
        
        body.setCondition(condition);
        body.setPagecount(pagecount);
        body.setPagenum(pagenum);
        
        return request;
    }
    
    public AddressListInfo getAddressListInfoRest2Model(QueryAddrListResponse resBean)
    {
        if (null == resBean)
        {
            return null;
        }
        
        AddressListInfo model = new AddressListInfo();
        
        ResultNum num = resBean.getNum();
        if (null != num)
        {
            model.setTotal(num.getTotal());
            model.setSum(num.getSum());
        }
        
        List<com.huawei.esdk.ec.device.appserver.bean.Address> addrs = resBean.getAddrs();
        if (null != addrs && !addrs.isEmpty())
        {
            List<Address> addresses = new ArrayList<Address>();
            model.setAddresses(addresses);
            
            for (com.huawei.esdk.ec.device.appserver.bean.Address addr : addrs)
            {
                if (null != addr)
                {
                    Address addrModel = new Address();
                    addresses.add(addrModel);
                    
                    addrModel.setBindno(addr.getBindno());
                    addrModel.setEmail(addr.getEmail());
                    addrModel.setFax(addr.getFax());
                    addrModel.setHomephone(addr.getHomephone());
                    addrModel.setMemberId(addr.getMemberId());
                    addrModel.setMobile(addr.getMobile());
                    addrModel.setName(addr.getName());
                    addrModel.setOfficephone(addr.getOfficephone());
                    addrModel.setSex(addr.getSex());
                    addrModel.setShortphone(addr.getShortphone());
                    addrModel.setStaffAccount(addr.getStaffAccount());
                }
            }
        }
        
        return model;
    }
    
    public RestReqMessage getPersonInfoMode2Rest(String account, String staffAccount)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        request.setPayload(payload);
        
        XMLReqHeader head = new XMLReqHeader();
        head.setAccounts(account);
        payload.setHead(head);
        
        // 构建报文体
        QueryPersonInfoRequest body = new QueryPersonInfoRequest();
        payload.setBody(body);
        
        body.setStaffAccount(staffAccount);
        
        return request;
    }
    
    public PersonInfo getPersonInfoRest2Model(com.huawei.esdk.ec.device.appserver.bean.PersonInfo personInfo)
    {
        PersonInfo model = new PersonInfo();
        model.setAddr(personInfo.getAddr());
        model.setBindNum(personInfo.getBindNum());
        model.setCredit(personInfo.getCredit());
        model.setEmail(personInfo.getEmail());
        model.setFax(personInfo.getFax());
        model.setHeadId(personInfo.getHeadId());
        model.setHomePhone(personInfo.getHomePhone());
        model.setMobile(personInfo.getMobile());
        model.setName(personInfo.getName());
        model.setOfficePhone(personInfo.getOfficePhone());
        model.setOtherPhone(personInfo.getOtherPhone());
        model.setSeat(personInfo.getSeat());
        model.setSex(personInfo.getSex());
        model.setShortPhone(personInfo.getShortPhone());
        model.setSignature(personInfo.getSignature());
        model.setStaffAccount(personInfo.getStaffAccount());
        model.setStaffId(personInfo.getStaffId());
        model.setStaffNO(personInfo.getStaffNO());
        model.setUnderwrite(personInfo.getUnderwrite());
        model.setVoip(personInfo.getVoip());
        model.setZip(personInfo.getZip());
        
        return model;
    }
    
    public RestReqMessage getEmployeeMode2Rest(String account, String condition, int pagecount, int pagenum)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        request.setPayload(payload);
        
        XMLReqHeader head = new XMLReqHeader();
        head.setAccounts(account);
        payload.setHead(head);
        
        // 构建报文体
        QueryEmployeeRequest body = new QueryEmployeeRequest();
        payload.setBody(body);
        
        body.setCondition(condition);
        body.setPagecount(pagecount);
        body.setPagenum(pagenum);
        
        return request;
    }
    
    public EmployeeList getEmployeeRest2Model(QueryEmployeeResponse resBean)
    {
        EmployeeList model = new EmployeeList();
        
        ResultNum num = resBean.getNum();
        model.setTotal(num.getTotal());
        model.setSum(num.getSum());
        
        List<com.huawei.esdk.ec.device.appserver.bean.PersonInfo> personInfos = resBean.getPersonInfos();
        if (null != personInfos && !personInfos.isEmpty())
        {
            List<PersonInfo> employeeModels = new ArrayList<PersonInfo>();
            model.setEmployees(employeeModels);
            
            for (com.huawei.esdk.ec.device.appserver.bean.PersonInfo personInfo : personInfos)
            {
                PersonInfo employeeModel = new PersonInfo();
                employeeModels.add(employeeModel);
                
                employeeModel.setAddr(personInfo.getAddr());
                employeeModel.setBindNum(personInfo.getBindNum());
                employeeModel.setCredit(personInfo.getCredit());
                employeeModel.setEmail(personInfo.getEmail());
                employeeModel.setFax(personInfo.getFax());
                employeeModel.setHeadId(personInfo.getHeadId());
                employeeModel.setHomePhone(personInfo.getHomePhone());
                employeeModel.setMobile(personInfo.getMobile());
                employeeModel.setName(personInfo.getName());
                employeeModel.setOfficePhone(personInfo.getOfficePhone());
                employeeModel.setOtherPhone(personInfo.getOtherPhone());
                employeeModel.setSeat(personInfo.getSeat());
                employeeModel.setSex(personInfo.getSex());
                employeeModel.setShortPhone(personInfo.getShortPhone());
                employeeModel.setSignature(personInfo.getSignature());
                employeeModel.setStaffAccount(personInfo.getStaffAccount());
                employeeModel.setStaffId(personInfo.getStaffId());
                employeeModel.setStaffNO(personInfo.getStaffNO());
                employeeModel.setUnderwrite(personInfo.getUnderwrite());
                employeeModel.setVoip(personInfo.getVoip());
                employeeModel.setZip(personInfo.getZip());
            }
        }
        return model;
    }
    
    public RestReqMessage getEnterpriseMode2Rest(String account, String deptId, int pagecount, int pagenum)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        request.setPayload(payload);
        
        XMLReqHeader head = new XMLReqHeader();
        head.setAccounts(account);
        payload.setHead(head);
        
        // 构建报文体
        QueryEnterpriseRequest body = new QueryEnterpriseRequest();
        payload.setBody(body);
        
        body.setDepartmentId(deptId);
        body.setPageCount(pagecount);
        body.setPageNum(pagenum);
        
        return request;
    }
    
    public EnterpriseList getEnterpriseRest2Model(QueryEnterpriseResponse resBean)
    {
        EnterpriseList model = new EnterpriseList();
        
        EnterpriseResultNum num = resBean.getNum();
        if (null != num)
        {
            model.setTotal(num.getTotal());
            model.setEmployeeSum(num.getEmployeeSum());
            model.setDeptSum(num.getDeptSum());
            model.setParentdept(num.getParentDept());
        }
        
        DepartmentList departmentList = resBean.getDepartmentList();
        if (null != departmentList)
        {
            List<Department> departments = departmentList.getDepartments();
            
            if (null != departments && !departments.isEmpty())
            {
                List<DepartmentInfo> deptModels = new ArrayList<DepartmentInfo>();
                model.setDepartments(deptModels);
                for (Department department : departments)
                {
                    DepartmentInfo dept = new DepartmentInfo();
                    deptModels.add(dept);
                    dept.setDeptId(department.getDeptId());
                    dept.setDeptName(department.getDeptName());
                    dept.setSubDeptCount(department.getSubDeptCount());
                    dept.setSubEmployeeCount(department.getSubEmployeeCount());
                }
            }
            
            com.huawei.esdk.ec.device.appserver.bean.EmployeeList employeeList = resBean.getEmployeeList();
            if (null != employeeList)
            {
                List<com.huawei.esdk.ec.device.appserver.bean.PersonInfo> employees = employeeList.getPersonInfos();
                if (null != employees && !employees.isEmpty())
                {
                    List<PersonInfo> employeeModels = new ArrayList<PersonInfo>();
                    model.setEmployees(employeeModels);
                    
                    for (com.huawei.esdk.ec.device.appserver.bean.PersonInfo personInfo : employees)
                    {
                        PersonInfo employeeModel = new PersonInfo();
                        employeeModels.add(employeeModel);
                        
                        employeeModel.setAddr(personInfo.getAddr());
                        employeeModel.setBindNum(personInfo.getBindNum());
                        employeeModel.setCredit(personInfo.getCredit());
                        employeeModel.setEmail(personInfo.getEmail());
                        employeeModel.setFax(personInfo.getFax());
                        employeeModel.setHeadId(personInfo.getHeadId());
                        employeeModel.setHomePhone(personInfo.getHomePhone());
                        employeeModel.setMobile(personInfo.getMobile());
                        employeeModel.setName(personInfo.getName());
                        employeeModel.setOfficePhone(personInfo.getOfficePhone());
                        employeeModel.setOtherPhone(personInfo.getOtherPhone());
                        employeeModel.setSeat(personInfo.getSeat());
                        employeeModel.setSex(personInfo.getSex());
                        employeeModel.setShortPhone(personInfo.getShortPhone());
                        employeeModel.setSignature(personInfo.getSignature());
                        employeeModel.setStaffAccount(personInfo.getStaffAccount());
                        employeeModel.setStaffId(personInfo.getStaffId());
                        employeeModel.setStaffNO(personInfo.getStaffNO());
                        employeeModel.setUnderwrite(personInfo.getUnderwrite());
                        employeeModel.setVoip(personInfo.getVoip());
                        employeeModel.setZip(personInfo.getZip());
                    }
                }
            }
        }
        
        return model;
    }
    
}
