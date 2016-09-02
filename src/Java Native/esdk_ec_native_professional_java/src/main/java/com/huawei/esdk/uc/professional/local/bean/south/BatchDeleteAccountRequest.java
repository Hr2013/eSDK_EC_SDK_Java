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
package com.huawei.esdk.uc.professional.local.bean.south;

import java.util.List;

/**
 * 批量删除账号请求
 * @author l00287354
 * @date 2015年10月10日
 *
 */
public class BatchDeleteAccountRequest 
{
    /**
     * 操作用户标识ID
     */
	private String userId;
    /**
     * 操作账号ID
     */
    private List<String> accountIds;
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public List<String> getAccountIds()
    {
        return accountIds;
    }
    
    public void setAccountIds(List<String> accountIds)
    {
        this.accountIds = accountIds;
    }
}
