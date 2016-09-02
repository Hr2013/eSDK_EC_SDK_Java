/**
 * Copyright 2016 Huawei Technologies Co., Ltd. All rights reserved.
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
package com.huawei.esdk.ec.north.rest.app.resource.multiapponline.convert;

import java.util.ArrayList;
import java.util.List;

import com.huawei.esdk.ec.domain.model.multiapponline.HisMsg;
import com.huawei.esdk.ec.domain.model.multiapponline.HisMsgInfoModel;
import com.huawei.esdk.ec.north.rest.bean.app.multiapponline.HisMsgInfo;
import com.huawei.esdk.ec.north.rest.bean.app.multiapponline.HisMsgRequest;
import com.huawei.esdk.ec.north.rest.bean.app.multiapponline.HisMsgResponse;
import com.huawei.esdk.platform.common.SDKResult;
import com.huawei.esdk.platform.common.utils.StringUtils;

public class HisMsgResourceConvert {
	public HisMsg getHisMsgRest2Model(HisMsgRequest request) {
		HisMsg hisMsg = new HisMsg();
		if (null != request) {
			hisMsg.setAccounts(request.getAccounts());
			hisMsg.setGroupId(request.getGroupId());
			hisMsg.setContentType(request.getContentType());
			hisMsg.setPageCount(request.getPageCount());
			hisMsg.setPageNum(request.getPageNum());
			hisMsg.setBeginTime(request.getBeginTime());
			hisMsg.setEndTime(request.getEndTime());
		}

		return hisMsg;
	}

	public HisMsgResponse getHisMsgModel2Rest(SDKResult<HisMsgInfoModel> result) {
		HisMsgResponse hisMsgResponse = new HisMsgResponse();
		if (null != result) {
			hisMsgResponse.setResultCode(String.valueOf(result.getErrCode()));
			hisMsgResponse.setResultDesc(StringUtils.avoidNull(result
					.getDescription()));

			HisMsgInfoModel hisMsgInfoModel = result.getResult();
			if (null != hisMsgInfoModel) {
				hisMsgResponse.setTotal(hisMsgInfoModel.getTotal());
				hisMsgResponse.setSum(hisMsgInfoModel.getSum());
			}

			List<com.huawei.esdk.ec.domain.model.multiapponline.HisMsgInfo> HisMsgInfoModelList = hisMsgInfoModel
					.getHisMsgInfoList();
			if (null != HisMsgInfoModelList && !HisMsgInfoModelList.isEmpty()) {
				List<HisMsgInfo> HisMsgInfos = new ArrayList<HisMsgInfo>();
				hisMsgResponse.setHisMsgInfoList(HisMsgInfos);

				for (com.huawei.esdk.ec.domain.model.multiapponline.HisMsgInfo hisMsgInfo : HisMsgInfoModelList) {
					if (null != hisMsgInfo) {
						HisMsgInfo HisMsgInfoRest = new HisMsgInfo();
						HisMsgInfos.add(HisMsgInfoRest);

						HisMsgInfoRest.setSender(hisMsgInfo.getSender());
						HisMsgInfoRest.setMsgId(hisMsgInfo.getMsgId());
						HisMsgInfoRest.setMsgType(hisMsgInfo.getMsgType());
						HisMsgInfoRest
								.setMsgContent(hisMsgInfo.getMsgContent());
						HisMsgInfoRest.setMsgContentStr(hisMsgInfo
								.getMsgContentStr());
						HisMsgInfoRest
								.setCompressed(hisMsgInfo.getCompressed());
						HisMsgInfoRest.setContentType(hisMsgInfo
								.getContentType());
					}

				}
			}
		}
		return hisMsgResponse;
	}

}
