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
package com.huawei.esdk.ec.common;

public interface UCConstant
{
    String INITATOR_PREFIX = "APP:";
    
    String APP_ID_ESDK = "app_id_esdk";
    
    String APP_ID_ESG = "app_id_esg";
    
    String APP_ID_BMP = "app_id_bmp";
    
    String PWD_ESDK = "pwd_esdk";
    
    String PWD_ESG = "pwd_esg";
    
    String APP_ID_DEV = "appid";
    
    String PWD_DEV = "pwd_dev";
    
    int MSG_FLAG_NORMAL = 0;
    
    int MSG_FLAG_COMPRESSED = 1;// 压缩消息
    
    int MSG_FLAG_GROUP = 2;
    
    int MSG_FLAG_TEMPGROUNP = 6;
    
    int MSG_CONTENT_TYPE_HTML = 0;
    
    /**
     * 批量查询UC用户状态信息。（专业接口最多支持同时查询10个用户）
     */
    int UC_PRESENCE_MAX_SIZE = 10;
    
    /**
     * 批量查询UC用户状态信息。（行业接口最多支持同时查询30个用户）
     */
    int UC_LIST_PRESENCE_MAX_SIZE = 30;
    
    String UC_DEV_LOGIN_STATUS = "uc_dev_login_status";
    
    int SEND_TO_DEPT_DEFAULT_POOLSIZE = 100; // 初始默认的线程池大小
    
    int MAX_LEVEL = 5; // 最大遍历层级数目
    
    int MIN_LEVEL = 1; // 最小遍历层级数目
    
    String DEFAULT_LEVEL = "1"; // 默认遍历层级数目
    
    int QUERY_MODE = 1; // 分页查询
    
    int OFF_SET = -1; // 偏移量，当分页查询时，固定-1
    
    int PAGE_SIZE = Integer.MAX_VALUE; // 每页100条
    
    public static final String LOGIN_SUCCESS = "登录成功";
    
    public static final String LOGIN_FAILED = "登录失败";
    
    public static final String PASSWORD_ERROR = "密码错误";
    
    public static final String USER_NOT_EXIST = "用户不存在";
    
    public static final String USER_HAVED_LOGIN_IN_OTHER = "用户已在别处登录";
    
    public static final String OPERATE_SUCCESS = "操作成功";
    
    public static final String OPERATE_FAILED = "操作失败";
    
    public static final String USERID = "12345";
}
