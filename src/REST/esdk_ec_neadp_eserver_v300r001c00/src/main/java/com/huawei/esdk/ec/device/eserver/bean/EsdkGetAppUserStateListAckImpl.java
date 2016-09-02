package com.huawei.esdk.ec.device.eserver.bean;

public class EsdkGetAppUserStateListAckImpl extends AbstractAckMsg
{
    @Override
    public Object processAckMsg(String sno, String inMsg)
    {
        //        EsdkGetAppUserStateListAck ack = new Gson().fromJson(inMsg, EsdkGetAppUserStateListAck.class);
        //        AppUserStates appUserStates = new AppUserStatesCapabilityConvert().getAppUserStatesUDP2Modal(ack);
        //        processAckSno(appUserStates, sno);
        return null;
    }
}
