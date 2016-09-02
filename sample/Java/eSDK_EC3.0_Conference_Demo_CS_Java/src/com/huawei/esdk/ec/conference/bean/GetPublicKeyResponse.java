package com.huawei.esdk.ec.conference.bean;


public class GetPublicKeyResponse
{
    
    protected Header header;
    
    protected String publicKey;
    
    public Header getHeader()
    {
        return header;
    }
    
    public void setHeader(Header header)
    {
        this.header = header;
    }
    
    public String getPublicKey()
    {
        return publicKey;
    }
    
    public void setPublicKey(String publicKey)
    {
        this.publicKey = publicKey;
    }
    
}
