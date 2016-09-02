package com.huawei.esdk.ec.conference.model;

public class RestResponse
{
    /**
     *  返回值
     */
    private Long resultCode;
    
    /**
     * 返回内容
     */
    private String resultContext;
    
    /**
     * 返回描述
     */
    private String resultDesc;
    
    /**
     * 返回结果
     */
    private Object result;
    
    public Long getResultCode()
    {
        return resultCode;
    }
    
    public void setResultCode(Long resultCode)
    {
        this.resultCode = null == resultCode ? Long.valueOf(-1l) : resultCode;//findbugs: BX_UNBOXING_IMMEDIATELY_REBOXED
    }
    
    public String getResultContext()
    {
        return resultContext;
    }
    
    public void setResultContext(String resultContext)
    {
        this.resultContext = resultContext;
    }
    
    public String getResultDesc()
    {
        return resultDesc;
    }
    
    public void setResultDesc(String resultDesc)
    {
        this.resultDesc = resultDesc;
    }
    
    public Object getResult()
    {
        return result;
    }
    
    public void setResult(Object result)
    {
        this.result = result;
    }
}
