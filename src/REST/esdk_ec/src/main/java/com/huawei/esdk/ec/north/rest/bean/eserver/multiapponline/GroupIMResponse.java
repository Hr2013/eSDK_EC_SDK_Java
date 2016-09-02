package com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline;

import com.huawei.esdk.ec.business.professional.rest.multiapponline.callback.AbstractCallbackMsg;
import com.huawei.esdk.ec.domain.model.multiapponline.GroupIMResult;
import com.huawei.esdk.ec.domain.model.multiapponline.MultiAppOnlineModel;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.convert.GroupIMResourceConvert;
import com.huawei.esdk.ec.northcommu.rest.callback.RestEServerListener;

public class GroupIMResponse extends AbstractCallbackMsg
{
    private String origin;
    
    private String target;
    
    private String result;
    
    public String getOrigin()
    {
        return origin;
    }
    
    public void setOrigin(String origin)
    {
        this.origin = origin;
    }
    
    public String getTarget()
    {
        return target;
    }
    
    public void setTarget(String target)
    {
        this.target = target;
    }
    
    public String getResult()
    {
        return result;
    }
    
    public void setResult(String result)
    {
        this.result = result;
    }
    
    @Override
    public void notifyCallbackMsg(RestEServerListener listener, MultiAppOnlineModel msg)
    {
        GroupIMResponse payload = new GroupIMResourceConvert().sendGroupImModel2Rest((GroupIMResult)msg);
        processNorthSno(msg, payload);
        listener.sendCallbackMsg(payload, "groupim");
    }
}
