package com.huawei.esdk.ec.device.eserver.bean;

public class LeaveGroupAckImpl extends AbstractAckMsg
{
    @Override
    public Object processAckMsg(String sno, String inMsg)
    {
        /*LeaveGroupAck ack = new Gson().fromJson(inMsg, LeaveGroupAck.class);
        GroupMember groupMember = new GroupCapabilityConvert().delGroupMembersUDP2Rest(ack);
        processAckSno(groupMember, sno);
        return groupMember;*/
        
        return null;
    }
}
