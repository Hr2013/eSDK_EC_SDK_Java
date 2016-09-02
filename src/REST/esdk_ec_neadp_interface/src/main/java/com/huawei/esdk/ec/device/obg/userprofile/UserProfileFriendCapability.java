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
package com.huawei.esdk.ec.device.obg.userprofile;

import java.util.List;

import com.huawei.esdk.ec.domain.model.bean.FriendChangeInfo;
import com.huawei.esdk.ec.domain.model.bean.FriendInfo;
import com.huawei.esdk.platform.common.SDKErrorCode;
import com.huawei.esdk.platform.common.SDKResult;

/** * @author w00208247 * * */
public interface UserProfileFriendCapability
{

    SDKResult<List<FriendInfo>> getFriendList(String ucAccount);

    SDKErrorCode delFriend(String ucAccount, String friendAccount);

    SDKErrorCode addFriend(String ucAccount, String friendAccount);


    SDKResult<FriendInfo> getFriendInfo(String ucAccount, int type,
            String friendAccount);

    SDKResult<List<FriendChangeInfo>> getPersonIncFriendList(String ucAccount,
            String timeStamp);

}
