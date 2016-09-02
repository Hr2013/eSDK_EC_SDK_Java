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
package com.huawei.esdk.ec.device.bmu.userlevel.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.ec.device.bmu.bean.QueryUserLevelRequest;
import com.huawei.esdk.ec.device.bmu.bean.QueryUserLevelResponse;
import com.huawei.esdk.ec.device.bmu.bean.UserLevelInfo;
import com.huawei.esdk.ec.device.bmu.bean.UserLevelInfoArray;
import com.huawei.esdk.ec.domain.model.UserLevel;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;

public class UserLevelCapabilityConvert
{
    public RestReqMessage getQueryUserLevelRequest(String userId, String pageCount, String pageNum)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        
        // 构建报文体
        QueryUserLevelRequest acctRequest = new QueryUserLevelRequest();
        
        acctRequest.setUserId(userId);
        acctRequest.setPageCount(pageCount);
        acctRequest.setPageNum(pageNum);
        
        payload.setBody(acctRequest);
        
        request.setPayload(payload);
        
        return request;
    }

    public UserLevel getQueryUserLevelResponse(QueryUserLevelResponse body)
    {
        if(null == body)
        {
            return null;
        }
        UserLevel userLevel = new UserLevel();
        userLevel.setCount(body.getAmount());
        UserLevelInfoArray userLevelInfoArray = body.getUserLevelInfoArray();
        if(null != userLevelInfoArray && null != userLevelInfoArray.getUserLevelInfos())
        {
            List<com.huawei.esdk.ec.domain.model.bean.UserLevelInfo> userLevelInfos = new
                ArrayList<com.huawei.esdk.ec.domain.model.bean.UserLevelInfo>();
            for(UserLevelInfo rl : userLevelInfoArray.getUserLevelInfos())
            {
                com.huawei.esdk.ec.domain.model.bean.UserLevelInfo userLevelModal = new 
                    com.huawei.esdk.ec.domain.model.bean.UserLevelInfo();
                userLevelModal.setDescription(rl.getDescription());
                userLevelModal.setLevelId(rl.getLevelId());
                userLevelModal.setLevelName(rl.getLevelName());
                userLevelModal.setLevelValue(rl.getLevelValue());
                
                userLevelInfos.add(userLevelModal);
            }
            
            userLevel.setUserLevelInfos(userLevelInfos);
        }
        return userLevel;
    }
}
