package com.huawei.esdk.ec.device.eserver.multiapponline.convert;

public class GroupIMCapabilityConvert
{
    /*
    public Chat sendGroupImModal2Rest(GroupIMModel groupIm)
    {
        if (null == groupIm)
        {
            return null;
        }
        
        Chat chat = new Chat();
        chat.origin = groupIm.getOrigin();
        chat.target = groupIm.getTarget();
        chat.flag = parseString2Byte(groupIm.getFlag());
        chat.contentType = parseString2Byte(groupIm.getContentType());
        chat.groupID = groupIm.getGroupID();
        
        if (null != groupIm.getDeliverTime())
        {
            chat.deliverTime = groupIm.getDeliverTime().getTime();
        }
        
        chat.content = addMsgContentFormat(groupIm.getOrigin(), UCConstant.MSG_FLAG_NORMAL, groupIm.getContent());
        
        chat.originAppID = groupIm.getOriginAppID();
        chat.originAppName = groupIm.getOriginAppName();
        chat.senderType = parseString2Byte(groupIm.getSenderType());
        chat.msgEx = groupIm.getMsgEx();
        
        return chat;
    }
    
    private String addMsgContentFormat(String ucAccount, int flag, String msg)
    {
        StringBuilder sb = new StringBuilder();
        
        sb.append("<r>");
        sb.append("<n>");
        try
        {
            sb.append(Base64Utils.encode(null == ucAccount ? "".getBytes() : ucAccount.getBytes("UTF-8")));
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        sb.append("</n>");
        sb.append("<g>");
        sb.append(flag);
        sb.append("</g>");
        sb.append("<c>");
        
        if (UCConstant.MSG_FLAG_COMPRESSED == flag)
        {
            sb.append(Base64Utils.encode(compress(msg)));
        }
        else
        {
            sb.append(msg);
        }
        
        sb.append("</c>");
        sb.append("</r>");
        
        return sb.toString();
    }
    
    private byte[] compress(String msg)
    {
        if ((msg == null) || (msg.length() == 0))
        {
            return new byte[0];
        }
        
        byte[] compressed = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream(msg.length());
        GZIPOutputStream gos;
        try
        {
            gos = new GZIPOutputStream(bos);
            gos.write(msg.getBytes("UTF-8"));
            gos.close();
            
            compressed = bos.toByteArray();
            bos.close();
        }
        catch (IOException e)
        {
            return new byte[0];
        }
        
        return compressed;
    }
    
    private byte parseString2Byte(String str)
    {
        try
        {
            return Byte.parseByte(str);
        }
        catch (NumberFormatException e)
        {
            return 0;
        }
    }
    
    public GroupIMResult sendGroupImUDP2Rest(ChatAck chatAck)
    {
        if (null == chatAck)
        {
            return null;
        }
        
        GroupIMResult groupIMResult = new GroupIMResult();
        groupIMResult.setOrigin(chatAck.origin);
        groupIMResult.setTarget(chatAck.target);
        groupIMResult.setResult(String.valueOf(chatAck.result));
        
        return groupIMResult;
    }
    */}
