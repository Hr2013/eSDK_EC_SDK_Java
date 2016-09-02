package com.huawei.esdk.ec.device.eserver.bean;

public class IMGroupQueryAckImpl extends AbstractAckMsg
{
    @Override
    public Object processAckMsg(String sno, String inMsg)
    {
        /*IMGroupQueryAck ack = new Gson().fromJson(inMsg, IMGroupQueryAck.class);
        IMGroupInfo imGroupInfo = new GroupCapabilityConvert().getIMGroupUDP2Rest(ack);
        processAckSno(imGroupInfo, sno);
        return imGroupInfo;*/
        
        return null;
    }
}
