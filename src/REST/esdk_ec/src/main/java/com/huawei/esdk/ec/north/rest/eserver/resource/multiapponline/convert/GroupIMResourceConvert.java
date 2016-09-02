package com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.convert;

import java.io.UnsupportedEncodingException;

import com.huawei.esdk.ec.domain.model.multiapponline.GroupIMModel;
import com.huawei.esdk.ec.domain.model.multiapponline.GroupIMResult;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.GroupIMRequest;
import com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline.GroupIMResponse;
import com.huawei.esdk.platform.common.utils.Base64Utils;

public class GroupIMResourceConvert
{
    public GroupIMModel sendGroupImRest2Model(GroupIMRequest request)
    {
        GroupIMModel model = new GroupIMModel();
        
        model.setOrigin(request.getOrigin());
        model.setTarget(request.getTarget());
        model.setFlag(request.getFlag());
        model.setContentType(request.getContentType());
        try
        {
            model.setContent(new String(Base64Utils.getFromBASE64(request.getContent()), "UTF-8"));
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        model.setGroupID(request.getGroupID());
        model.setDeliverTime(request.getDeliverTime());
        model.setOriginAppID(request.getOriginAppID());
        model.setOriginAppName(request.getOriginAppName());
        model.setSenderType(request.getSenderType());
        model.setMsgEx(request.getMsgEx());
        
        return model;
    }
    
    public GroupIMResponse sendGroupImModel2Rest(GroupIMResult groupIMResult)
    {
        GroupIMResponse response = new GroupIMResponse();
        
        if (null != groupIMResult)
        {
            response.setOrigin(groupIMResult.getOrigin());
            response.setTarget(groupIMResult.getTarget());
            response.setResult(groupIMResult.getResult());
        }
        
        return response;
    }
    
}
