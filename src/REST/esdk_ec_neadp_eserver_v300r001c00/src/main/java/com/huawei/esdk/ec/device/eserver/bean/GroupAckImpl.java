package com.huawei.esdk.ec.device.eserver.bean;

public class GroupAckImpl extends AbstractAckMsg
{
    @Override
    public Object processAckMsg(String sno, String inMsg)
    {
        /*GroupAck ack = new Gson().fromJson(inMsg, GroupAck.class);
        IMGroupInfo imGroupInfo = new GroupCapabilityConvert().operateGroupUDP2Rest(ack);
        processAckSno(imGroupInfo, sno);
        return imGroupInfo;*/
        
        return null;
    }
}
