package com.huawei.esdk.ec.device.eserver.callback;

import org.apache.log4j.Logger;

import com.huawei.esdk.ec.device.eserver.bean.AbstractAckMsg;
import com.huawei.esdk.ec.device.eserver.bean.ChatAckImpl;
import com.huawei.esdk.ec.device.eserver.bean.EsdkGetAppUserStateListAckImpl;
import com.huawei.esdk.ec.device.eserver.bean.GroupAckImpl;
import com.huawei.esdk.ec.device.eserver.bean.IMGroupMemQueryAckImpl;
import com.huawei.esdk.ec.device.eserver.bean.IMGroupQueryAckImpl;
import com.huawei.esdk.ec.device.eserver.bean.JoinGroupAckImpl;
import com.huawei.esdk.ec.device.eserver.bean.LeaveGroupAckImpl;
import com.huawei.esdk.ec.southcommu.callback.CallbackSouthBase;
import com.huawei.esdk.platform.callback.ISouthCallbackService;
import com.huawei.esdk.platform.common.bean.callback.CallbackMessage;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.utils.StringUtils;

public class EServerCallbackService extends CallbackSouthBase implements ISouthCallbackService
{
    private static final Logger LOGGER = Logger.getLogger(EServerCallbackService.class);
    
    @Override
    public String processCallbackMessage(String inMessage)
    {
        String res = null;
        if (StringUtils.isEmpty(inMessage))
        {
            res = "The incoming callback message is empty";
            LOGGER.warn(res);
            return res;
        }
        
        AbstractAckMsg[] objArr =
            {new GroupAckImpl(), new IMGroupQueryAckImpl(), new IMGroupMemQueryAckImpl(), new JoinGroupAckImpl(),
                new LeaveGroupAckImpl(), new ChatAckImpl(), new EsdkGetAppUserStateListAckImpl()};
        String[] parts = inMessage.split("-", 3);
        int index = Integer.parseInt(parts[0]);
        
        CallbackMessage callbackMessage =
            buildCallbackMessage(objArr[index].processAckMsg(String.valueOf(parts[1]), parts[2]),
                null,
                parts[0],
                CallbackManager.getInstance().getAppId(String.valueOf(parts[1])));
        callbackMessage.getCallbackItfInfo().setDevId(ConfigManager.getInstance().getValue("esdk.ec_eserver_device"));
        callbackMessage.getCallbackItfInfo().setConnectionId("_");
        notifyCollector.publishNotify(callbackMessage);
        
        return res;
    }
}
