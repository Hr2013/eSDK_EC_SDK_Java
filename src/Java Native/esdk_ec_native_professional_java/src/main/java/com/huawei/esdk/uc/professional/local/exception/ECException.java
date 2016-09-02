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
package com.huawei.esdk.uc.professional.local.exception;

import org.apache.log4j.Logger;

public class ECException extends Exception
{
    private static final long serialVersionUID = 1L;
    
    protected static final Logger LOGGER = Logger.getLogger(ECException.class);
    
    private Integer resultCode;
    
    private String resultDesc;
    
    public ECException(Integer resultCode, String resultDesc)
    {
        super(resultDesc);
        this.resultCode = resultCode;
        this.resultDesc = resultDesc;
        LOGGER.error("Error Message:" + resultDesc);
    }
    
    public Integer getResultCode()
    {
        return resultCode;
    }
    
    public void setResultCode(Integer resultCode)
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
}
