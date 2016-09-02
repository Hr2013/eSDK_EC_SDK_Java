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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "TGroupValType")
@XmlEnum
public enum GroupValType {

    //允许任何人加入
    ALL_ALLOW("ALL_ALLOW"),
    //需要身份验证才可加入
    NEED_PERMIT("NEED_PERMIT");

    private final String value;

    GroupValType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GroupValType fromValue(String v) {
        for (GroupValType c: GroupValType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
