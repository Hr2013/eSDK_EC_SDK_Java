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
package com.huawei.esdk.ec.domain.model.bean;

public enum UCPresQryResult {

    RES_OK("RES_OK"), // 200 支持查询
    RES_ACCEPT("RES_ACCEPT"), // 202 用户授权未决
    RES_FORBIDDEN("RES_FORBIDDEN"), // 403 用户授权拒绝
    RES_NOT_FOUND("RES_NOT_FOUND"), // 404 用户不存在
    RES_SERVER_ERR("RES_SERVER_ERR"); // 500 服务器内部异常

    private final String value;

    UCPresQryResult(String v)
    {
        value = v;
    }

    public String value()
    {
        return value;
    }

    public static UCPresQryResult fromValue(String v)
    {
        for (UCPresQryResult c : UCPresQryResult.values())
        {
            if (c.value.equals(v))
            {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
