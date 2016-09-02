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
package com.huawei.esdk.uc.professional.local.bean;

import java.util.List;

/**
 * 批量删除账号返回结果
 *
 */
public class BatchDeleteAccountResult 
{
	/**
	 * 操作失败数
	 */
    private String failedAmount;
    
    /**
     * 删除失败记录返回信息
     */
    private List<FailedDelAccount> failedAccounts;
    
    public String getFailedAmount()
    {
        return failedAmount;
    }
    
    public void setFailedAmount(String failedAmount)
    {
        this.failedAmount = failedAmount;
    }
    
    public List<FailedDelAccount> getFailedAccounts()
    {
        return failedAccounts;
    }
    
    public void setFailedAccounts(List<FailedDelAccount> failedAccounts)
    {
        this.failedAccounts = failedAccounts;
    }
}
