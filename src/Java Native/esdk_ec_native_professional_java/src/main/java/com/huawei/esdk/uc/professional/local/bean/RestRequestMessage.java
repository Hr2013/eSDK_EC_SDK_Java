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

import java.util.HashMap;
import java.util.Map;

public class RestRequestMessage
{
    /**
     * GET, POST, PUT, DELETE
     */
    private String httpMethod;
    
    /**
     * Query, Delete parameters
     */
    private Map<String, String> parameters;
    
    /**
     * Message payload, 传bean
     */
    private Object payload;
    
    public RestRequestMessage()
    {
        parameters = new HashMap<String, String>();
    }
    
    public String getHttpMethod()
    {
        return httpMethod;
    }
    
    public void setHttpMethod(String httpMethod)
    {
        this.httpMethod = httpMethod;
    }
    
    public Map<String, String> getParameters()
    {
        return parameters;
    }
    
    public void setParameters(Map<String, String> parameters)
    {
        this.parameters = parameters;
    }
    
    public Object getPayload()
    {
        return payload;
    }
    
    public void setPayload(Object payload)
    {
        this.payload = payload;
    }
    
}
