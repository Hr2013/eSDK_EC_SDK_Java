/**
 * Copyright 2015 Huawei Technologies Co., Ltd. All rights reserved.
 * eSDK is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huawei.esdk.uc.professional.local.bean;

/**
 * 查询账号返回响应信息
 * @author l00287354
 * @date 2015年10月10日
 *
 */
public class QueryAccountResponse 
{
    /**
     *  返回码
     */
    private Integer resultCode;
    
    /**
     * 返回内容
     */
    private String resultContext;
    
    /**
     * 返回结果
     */
    private QueryAccountResult result;

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultContext() {
		return resultContext;
	}

	public void setResultContext(String resultContext) {
		this.resultContext = resultContext;
	}

	public QueryAccountResult getResult() {
		return result;
	}

	public void setResult(QueryAccountResult result) {
		this.result = result;
	}

}
