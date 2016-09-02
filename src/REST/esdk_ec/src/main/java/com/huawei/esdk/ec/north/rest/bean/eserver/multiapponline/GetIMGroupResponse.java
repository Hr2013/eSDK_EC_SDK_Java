package com.huawei.esdk.ec.north.rest.bean.eserver.multiapponline;

import java.util.List;

import com.huawei.esdk.ec.business.professional.rest.multiapponline.callback.AbstractCallbackMsg;
import com.huawei.esdk.ec.domain.model.multiapponline.IMGroupInfo;
import com.huawei.esdk.ec.domain.model.multiapponline.MultiAppOnlineModel;
import com.huawei.esdk.ec.north.rest.eserver.resource.multiapponline.convert.GroupResourceConvert;
import com.huawei.esdk.ec.northcommu.rest.callback.RestEServerListener;

public class GetIMGroupResponse extends AbstractCallbackMsg
{
    private String resultCode;
    
    private String recordAmount;
    
    private String count;
    
    private List<IMGroup> imGroupList;
    
    private String pageIndex;
    
    public String getResultCode()
    {
        return resultCode;
    }
    
    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }
    
    public String getRecordAmount()
    {
        return recordAmount;
    }
    
    public void setRecordAmount(String recordAmount)
    {
        this.recordAmount = recordAmount;
    }
    
    public String getCount()
    {
        return count;
    }
    
    public void setCount(String count)
    {
        this.count = count;
    }
    
    public List<IMGroup> getImGroupList()
    {
        return imGroupList;
    }
    
    public void setImGroupList(List<IMGroup> imGroupList)
    {
        this.imGroupList = imGroupList;
    }
    
    public String getPageIndex()
    {
        return pageIndex;
    }
    
    public void setPageIndex(String pageIndex)
    {
        this.pageIndex = pageIndex;
    }
    
    @Override
    public void notifyCallbackMsg(RestEServerListener listener, MultiAppOnlineModel msg)
    {
        GetIMGroupResponse payload = new GroupResourceConvert().getIMGroupModel2Rest((IMGroupInfo)msg);
        processNorthSno(msg, payload);
        listener.sendCallbackMsg(payload, "imgroup");
    }
}
