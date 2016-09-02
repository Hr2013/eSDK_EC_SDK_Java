package com.huawei.esdk.ec.device.eserver.bean;

public class IMGroupMemQueryAckImpl extends AbstractAckMsg
{
    @Override
    public Object processAckMsg(String sno, String inMsg)
    {
        /*IMGroupMemQueryAck ack = new Gson().fromJson(inMsg, IMGroupMemQueryAck.class);
        IMGroupInfo imGroupInfo = new GroupCapabilityConvert().getGroupMemberUDP2Rest(ack);
        processAckSno(imGroupInfo, sno);
        return imGroupInfo;*/
        
        return null;
    }
}
