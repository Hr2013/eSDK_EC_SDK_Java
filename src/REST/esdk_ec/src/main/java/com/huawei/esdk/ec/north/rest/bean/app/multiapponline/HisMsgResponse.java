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
package com.huawei.esdk.ec.north.rest.bean.app.multiapponline;

import java.util.List;

public class HisMsgResponse
{
    private String resultCode;
    
    private String resultDesc;
    
    private String total;
    
    private String sum;
    
    private List<HisMsgInfo> hisMsgInfoList;
    
    public String getResultCode()
    {
        return resultCode;
    }
    
    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }
    
    public String getResultDesc()
    {
        return resultDesc;
    }
    
    public void setResultDesc(String resultDesc)
    {
        this.resultDesc = resultDesc;
    }
    
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
    
    public List<HisMsgInfo> getHisMsgInfoList()
    {
        return hisMsgInfoList;
    }
    
    public void setHisMsgInfoList(List<HisMsgInfo> hisMsgInfoList)
    {
        this.hisMsgInfoList = hisMsgInfoList;
    }
    
}
