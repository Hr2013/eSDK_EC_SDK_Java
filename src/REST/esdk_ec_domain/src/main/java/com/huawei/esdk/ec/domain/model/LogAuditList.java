package com.huawei.esdk.ec.domain.model;

import java.util.List;

import com.huawei.esdk.ec.device.bmu.ILogAuditCapability;
import com.huawei.esdk.ec.domain.model.bean.LogAudit;
import com.huawei.esdk.ec.domain.model.bean.QueryLogAuditInfo;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.config.ConfigManager;
import com.huawei.esdk.platform.common.exception.SDKException;
import com.huawei.esdk.platform.common.utils.ApplicationContextUtil;
import com.huawei.esdk.platform.nemgr.itf.IDeviceManager;

public class LogAuditList
{
    private String amount;
    
    private List<LogAudit> logAudits;
    
    private static IDeviceManager deviceManager = (IDeviceManager)ApplicationContextUtil.getBean("deviceManager");
    
    public SDKResult<LogAuditList> queryLogAudit(QueryLogAuditInfo queryInfo)
        throws SDKException
    {
        ILogAuditCapability client =
            deviceManager.getDeviceServiceProxy(ConfigManager.getInstance().getValue("esdk.ec_bmu_device"),
                ILogAuditCapability.class);
        
        return client.queryLogAudit(queryInfo);
    }
    
    public String getAmount()
    {
        return amount;
    }
    
    public void setAmount(String amount)
    {
        this.amount = amount;
    }
    
    public List<LogAudit> getLogAudits()
    {
        return logAudits;
    }
    
    public void setLogAudits(List<LogAudit> logAudits)
    {
        this.logAudits = logAudits;
    }
}
