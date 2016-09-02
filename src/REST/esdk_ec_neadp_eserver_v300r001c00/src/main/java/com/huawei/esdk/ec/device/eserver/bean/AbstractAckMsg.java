package com.huawei.esdk.ec.device.eserver.bean;

import com.huawei.esdk.ec.domain.model.multiapponline.MultiAppOnlineModel;

public abstract class AbstractAckMsg
{
    public abstract Object processAckMsg(String sno, String inMsg);
    
    protected void processAckSno(MultiAppOnlineModel model, String sno)
    {
        model.setSno(sno);
    }
}
