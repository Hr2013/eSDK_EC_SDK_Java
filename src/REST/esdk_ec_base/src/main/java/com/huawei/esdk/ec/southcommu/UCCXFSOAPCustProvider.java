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
package com.huawei.esdk.ec.southcommu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huawei.esdk.ec.common.UCConstant;
import com.huawei.esdk.ec.interceptor.UCOBGInInterceptor;
import com.huawei.esdk.ec.interceptor.UCOBGOutInterceptor;
import com.huawei.esdk.platform.common.MessageContext;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.commu.itf.ICXFSOAPCustProvider;

public class UCCXFSOAPCustProvider implements ICXFSOAPCustProvider
{
    protected static final Map<String, String> SERVICE_URL = new HashMap<String, String>();

    static
    {
        SERVICE_URL.put("ESGAppMsgSouth", "AppMsg.MsgServer");
        // 呼叫
        SERVICE_URL.put("CTDServiceSouth", "CTDSession.CTDinterface");
        SERVICE_URL.put("thirdPartyCall", "CTDSession.CTDinterface");
        // 会议
        SERVICE_URL.put("UCProfessionalCTCSouth", "CTCSession.CTCInterface");
        // userProfile enterprise
        SERVICE_URL.put("ESGUserProfileEnterpriseListSouth",
                "ESGUserProfile.EnterpriseList");
        // userProfile friend
        SERVICE_URL.put("ESGUserProfileFriendSouth", "ESGUserProfile.Friend");
        // userProfile queryUCpreference
        SERVICE_URL.put("ESGUserProfilePSSvrSouth", "ESGUserProfile.PSSvr");
        // userProfile PublicGroup
        SERVICE_URL.put("ESGUserProfilePublicGroupSouth",
                "ESGUserProfile.PublicGroup");
        // ESGUserProfilePersonListSouth
        SERVICE_URL.put("ESGUserProfilePersonListSouth",
                "ESGUserProfile.PersonList");
        // voice
        SERVICE_URL.put("ESGVoiceFWDNumberSouth", "ESGVoice.FWDNumber");
        // voice bwNumber
        SERVICE_URL.put("ESGVoiceBWNumberSouth", "ESGVoice.BWNumber");
        // voice
        SERVICE_URL.put("ESGVoiceOneNumberSouth", "ESGVoice.OneNumber");
        // client msg
        SERVICE_URL.put("ESGClientMsgServerSouth", "ESGClient.MsgServer");
        // client common
        SERVICE_URL.put("ESGClientCommonSouth", "ESGClient.common");
        // client publicGroup
        SERVICE_URL.put("ESGClientPublicGroupSouth", "ESGClient.PublicGroup");
        // client personal
        SERVICE_URL.put("ESGClientPersonalSouth", "ESGClient.personal");
    }
    
    @Override
    public Map<String, String> getSoapHeaders()
    {
        Map<String, String> resultMap = new HashMap<String, String>(2);
        
        String appId = "";
        String pw = "";

        MessageContext mc = ThreadLocalHolder.get();
        if (mc != null)
        {
            appId = (String) mc.getEntities().get(UCConstant.APP_ID_ESG);
            pw = (String) mc.getEntities().get(UCConstant.PWD_ESG);
        }
        
        resultMap.put("appId", appId);
        resultMap.put("pw", pw);
    
        return resultMap;
    }

    @Override
    public List<Object> getInInterceptors()
    {
        // 添加OBG返回的消息拦截器 ---by jiliang
        List<Object> list = new ArrayList<Object>();
        list.add(new UCOBGInInterceptor());
        
        return list;
    }

    @Override
    public List<Object> getOutInterceptors()
    {
        List<Object> list =  new ArrayList<Object>();
        list.add(new UCOBGOutInterceptor());
        
        return list;
    }

    @Override
    public Map<String, String> getSerivceURIMapping()
    {
        return SERVICE_URL;
    }

    public String reBuildNewUrl(String url, String interfaceName)
    {
        return url;
    }
}
