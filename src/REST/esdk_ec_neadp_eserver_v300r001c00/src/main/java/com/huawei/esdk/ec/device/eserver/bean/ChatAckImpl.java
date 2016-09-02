package com.huawei.esdk.ec.device.eserver.bean;

public class ChatAckImpl extends AbstractAckMsg
{
    @Override
    public Object processAckMsg(String sno, String inMsg)
    {
        /*ChatAck ack = new Gson().fromJson(inMsg, ChatAck.class);
        GroupIMResult groupIMResult = new GroupIMCapabilityConvert().sendGroupImUDP2Rest(ack);
        processAckSno(groupIMResult, sno);
        return groupIMResult;*/
        
        return null;
    }
}
