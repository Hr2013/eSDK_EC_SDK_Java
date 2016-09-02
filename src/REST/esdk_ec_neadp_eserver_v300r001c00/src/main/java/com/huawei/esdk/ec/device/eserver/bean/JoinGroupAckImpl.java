package com.huawei.esdk.ec.device.eserver.bean;

public class JoinGroupAckImpl extends AbstractAckMsg
{
    @Override
    public Object processAckMsg(String sno, String inMsg)
    {
        /*JoinGroupAck ack = new Gson().fromJson(inMsg, JoinGroupAck.class);
        GroupMember groupMember = new GroupCapabilityConvert().addGroupMembersUDP2Rest(ack);
        processAckSno(groupMember, sno);
        return groupMember;*/
        
        return null;
    }
}
