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

public enum ScreenNumType {

    //全号
    FULL_NUM(""),
    //前缀号码
    PREFIX_NUM(""),
    //前缀号码范围
    PREFIX_RANGE_NUM(""),
    //全号范围
    FULL_RANGE_NUM("");

    private final String value;

    ScreenNumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ScreenNumType fromValue(String v) {
        for (ScreenNumType c: ScreenNumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
