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
package com.huawei.esdk.ec.device.appserver.multiapponline.convert;

import java.util.ArrayList;
import java.util.List;

import message.Chat;

import com.huawei.esdk.ec.common.UCConstant;
import com.huawei.esdk.ec.device.appserver.bean.HisMsgRequest;
import com.huawei.esdk.ec.device.appserver.bean.HisMsgResponse;
import com.huawei.esdk.ec.device.appserver.bean.ResultNum;
import com.huawei.esdk.ec.device.bean.XMLReqHeader;
import com.huawei.esdk.ec.device.bean.XMLReqMsg;
import com.huawei.esdk.ec.domain.model.multiapponline.HisMsg;
import com.huawei.esdk.ec.domain.model.multiapponline.HisMsgInfo;
import com.huawei.esdk.ec.domain.model.multiapponline.HisMsgInfoModel;
import com.huawei.esdk.platform.common.ThreadLocalHolder;
import com.huawei.esdk.platform.common.bean.commu.RestReqMessage;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.common.utils.Base64Utils;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class HisMsgCapabilityConvert
{
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    private static final String APPID = (String)deviceManager.queryDeviceInfo(ConfigManager.getInstance()
        .getValue("esdk.ec_eserver_device"))
        .get(0)
        .get("reserver1");
    
    public RestReqMessage getHisMsgMode2Rest(HisMsg hisMsg)
    {
        RestReqMessage request = new RestReqMessage();
        request.setHttpMethod("POST");
        
        XMLReqMsg payload = new XMLReqMsg();
        request.setPayload(payload);
        
        XMLReqHeader head = new XMLReqHeader();
        head.setAccounts(hisMsg.getAccounts());
        payload.setHead(head);
        ThreadLocalHolder.get().getEntities().put(UCConstant.APP_ID_DEV, APPID);
        
        // 构建报文体
        HisMsgRequest body = new HisMsgRequest();
        payload.setBody(body);
        
        body.setGroupid(hisMsg.getGroupId());
        body.setContenttype(hisMsg.getContentType());
        body.setPagecount(hisMsg.getPageCount());
        body.setPagenum(hisMsg.getPageNum());
        body.setBegintime(hisMsg.getBeginTime());
        body.setEndtime(hisMsg.getEndTime());
        
        return request;
    }
    
    public HisMsgInfoModel getHisMsgResponseRest2Model(HisMsgResponse resBean)
    {
        
        if (null == resBean)
        {
            return null;
        }
        
        HisMsgInfoModel model = new HisMsgInfoModel();
        
        ResultNum num = resBean.getNum();
        if (null != num)
        {
            model.setTotal(String.valueOf(num.getTotal()));
            ;
            model.setSum(String.valueOf(num.getSum()));
        }
        
        List<com.huawei.esdk.ec.device.appserver.bean.HisMsgInfo> hisMsgInfoList = resBean.getHisMsgInfoList();
        if (null != hisMsgInfoList && !hisMsgInfoList.isEmpty())
        {
            List<HisMsgInfo> hisMsgInfoMList = new ArrayList<HisMsgInfo>();
            model.setHisMsgInfoList(hisMsgInfoMList);
            
            for (com.huawei.esdk.ec.device.appserver.bean.HisMsgInfo hisMsgInfo : hisMsgInfoList)
            {
                if (null != hisMsgInfo)
                {
                    HisMsgInfo hisMsgInfoModel = new HisMsgInfo();
                    hisMsgInfoMList.add(hisMsgInfoModel);
                    
                    hisMsgInfoModel.setSender(hisMsgInfo.getSender());
                    hisMsgInfoModel.setMsgId(String.valueOf(hisMsgInfo.getMsgid()));
                    hisMsgInfoModel.setMsgType(String.valueOf(hisMsgInfo.getMsgtype()));
                    hisMsgInfoModel.setMsgContent(hisMsgInfo.getMsgcontent());
                    
                    Chat chat = new Chat();
                    try
                    {
                        chat.decodeMessage(Base64Utils.getFromBASE64(hisMsgInfo.getMsgcontentstr()));
                        hisMsgInfoModel.setMsgContentStr(chat.content);
                    }
                    catch (Exception e)
                    {
                        hisMsgInfoModel.setMsgContentStr(hisMsgInfo.getMsgcontentstr());
                    }
                    
                    hisMsgInfoModel.setRecordTime(hisMsgInfo.getRecordtime());
                    hisMsgInfoModel.setCompressed(String.valueOf(hisMsgInfo.getCompressed()));
                    hisMsgInfoModel.setContentType(String.valueOf(hisMsgInfo.getContenttype()));
                    
                }
            }
        }
        
        return model;
        
    }
    
}
