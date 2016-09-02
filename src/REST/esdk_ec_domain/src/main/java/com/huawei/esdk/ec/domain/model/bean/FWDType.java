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

public enum FWDType {

    //无条件前转
    UNCOND_FWD("UNCOND_FWD"),
    //遇忙前转号码
    BUSY_FWD("BUSY_FWD"),
    //无应答前转号码
    NO_ANSWER_FWD("NO_ANSWER_FWD"),
    //离线前转号码
    OFFLINE_FWD("OFFLINE_FWD");


    private final String value;

    FWDType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FWDType fromValue(String v) {
        for (FWDType c: FWDType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
