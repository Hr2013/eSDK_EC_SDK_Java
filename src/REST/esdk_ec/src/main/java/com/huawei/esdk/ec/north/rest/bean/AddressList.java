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
package com.huawei.esdk.ec.north.rest.bean;

import java.util.List;

public class AddressList
{
    
    /**
     * 搜索结果集中成员的总数
     */
    private String total;
    
    /**
     * 当前分页消息中成员的数量
     */
    private String sum;
    
    /**
     * 个人通讯录
     */
    private List<Address> addresses;
    
    public String getTotal()
    {
        return total;
    }
    
    public void setTotal(String total)
    {
        this.total = total;
    }
    
    public String getSum()
    {
        return sum;
    }
    
    public void setSum(String sum)
    {
        this.sum = sum;
    }
    
    public List<Address> getAddresses()
    {
        return addresses;
    }
    
    public void setAddresses(List<Address> addresses)
    {
        this.addresses = addresses;
    }
    
}
