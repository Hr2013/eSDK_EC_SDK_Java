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
package com.huawei.esdk.ec.north.rest.bean.eserver;

public class SendMessage
{
    
    /**
     * 发送方UC账号
     */
    private String ucAccount;
    
    /**
     * 接收方UC账号
     */
    private String target;
    
    /**
     * 消息类型，目前只支持点对点信息，填0
     */
    private String recvType;
    
    /**
     * 内容需要进行html编码
     */
    private String content;
    
    public String getUcAccount()
    {
        return ucAccount;
    }
    
    public void setUcAccount(String ucAccount)
    {
        this.ucAccount = ucAccount;
    }
    
    public String getTarget()
    {
        return target;
    }
    
    public void setTarget(String target)
    {
        this.target = target;
    }
    
    public String getRecvType()
    {
        return recvType;
    }
    
    public void setRecvType(String recvType)
    {
        this.recvType = recvType;
    }
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
}
