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
package com.huawei.esdk.ec.device.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "message", propOrder = {
    "head",
    "bodyAsString"
})
@XmlRootElement(name = "message")
public class XMLResMsg
{
    private XMLResHeader head;
    
    @XmlElement(name = "body")
    private String bodyAsString;
    
    @XmlTransient
    private Object body;

    public XMLResHeader getHead()
    {
        return head;
    }

    public void setHead(XMLResHeader head)
    {
        this.head = head;
    }

    public String getBodyAsString()
    {
        return bodyAsString;
    }

    public void setBodyAsString(String bodyAsString)
    {
        this.bodyAsString = bodyAsString;
    }

    public Object getBody()
    {
        return body;
    }

    public void setBody(Object body)
    {
        this.body = body;
    }
}
