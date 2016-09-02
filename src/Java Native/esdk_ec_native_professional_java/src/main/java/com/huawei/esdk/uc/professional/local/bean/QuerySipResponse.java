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

import com.huawei.esdk.uc.professional.local.bean.south.SipList;

public class QuerySipResponse
{
    /**
     *  返回码
     */
    private Integer resultCode;
    
    /**
     * 返回内容
     */
    private String resultContext;
    
    /**
     * 返回结果
     */
    private SipList sipList;
    
    public Integer getResultCode()
    {
        return resultCode;
    }
    
    public void setResultCode(Integer resultCode)
    {
        this.resultCode = null == resultCode ? Integer.valueOf(-1) : resultCode;//findbugs: BX_UNBOXING_IMMEDIATELY_REBOXED
    }
    
    public String getResultContext()
    {
        return resultContext;
    }
    
    public void setResultContext(String resultContext)
    {
        this.resultContext = resultContext;
    }
    
    public SipList getResult()
    {
        return sipList;
    }
    
    public void setResult(SipList result)
    {
        this.sipList = result;
    }
    
}
