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
package com.huawei.esdk.ec.north.rest.bmu.resource.userlevel.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.domain.model.UserLevel;
import com.huawei.esdk.ec.domain.model.bean.UserLevelInfo;
import com.huawei.esdk.ec.north.rest.bean.QueryUserLevelResponse;

public class UserLevelResourceConvert
{

    public QueryUserLevelResponse queryUserLevelModal2Rest(UserLevel result)
    {
        if(null == result)
        {
            return null;
        }
        QueryUserLevelResponse queryUserLevelInfoResponse = new QueryUserLevelResponse();
        queryUserLevelInfoResponse.setAmount(result.getCount());
        List<UserLevelInfo> userLevelsModal = result.getUserLevelInfos();
        if(null != userLevelsModal)
        {
            List<com.huawei.esdk.ec.north.rest.bean.UserLevelInfo> userLevelInfos = new 
                ArrayList<com.huawei.esdk.ec.north.rest.bean.UserLevelInfo>();
            for(UserLevelInfo roleModal : userLevelsModal)
            {
                com.huawei.esdk.ec.north.rest.bean.UserLevelInfo userLevel = 
                    new com.huawei.esdk.ec.north.rest.bean.UserLevelInfo();
                userLevel.setDescription(roleModal.getDescription());
                userLevel.setLevelId(roleModal.getLevelId());
                userLevel.setLevelName(roleModal.getLevelValue());
                userLevel.setLevelValue(roleModal.getLevelValue());
                userLevelInfos.add(userLevel);
            }
            queryUserLevelInfoResponse.setUserLevelInfos(userLevelInfos);
        }
        return queryUserLevelInfoResponse;
    }
    
}
