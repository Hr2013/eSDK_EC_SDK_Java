package com.huawei.esdk.ec.conference.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.google.gson.Gson;

import com.huawei.esdk.ec.conference.bean.ModifyMeeting;
import com.huawei.esdk.ec.conference.bean.ModifyMeetingResponse;
import com.huawei.esdk.ec.conference.bean.ScheduledMeeting;
import com.huawei.esdk.ec.conference.bean.ScheduledMeetingResponse;
import com.huawei.esdk.ec.conference.constant.UCConstant;
import com.huawei.esdk.ec.conference.js.MyButton;
import com.huawei.esdk.ec.conference.model.RestRequestMessage;
import com.huawei.esdk.ec.conference.model.RestResponse;
import com.huawei.esdk.ec.conference.util.PropertiesUtils;
import com.huawei.esdk.ec.conference.util.RestUtils;
import com.huawei.esdk.ec.conference.utils.Encrypt;
import com.huawei.esdk.ec.conference.utils.StringUtils;

public class MeetingPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = -8285213367222038440L;
	private static final String REST_URL = PropertiesUtils.getValue("rest.url");
	private static String userName;
	private static String password;
	// 预定会议
	private JLabel requestLabel = new JLabel("请求参数:");
	private JLabel urlLabel = new JLabel("eSDK URL：");
	private JLabel userLabel = new JLabel("用户名：");
	private JLabel pwdLabel = new JLabel("密码：");
	private JLabel resultLabel = new JLabel("返回内容：");
	private JLabel userIdLabel = new JLabel("操作用户ID：");
	private JLabel gwIpLabel = new JLabel("统一网关IP：");
	private JLabel subPbxLabel = new JLabel("虚拟PBX的ID：");
	private JLabel enterPromptLabel = new JLabel("入会提示：");
	private JLabel leavePromptLabel = new JLabel("离会提示：");
	private JLabel amountLabel = new JLabel("与会人数：");
	private JLabel guestPwdLabel = new JLabel("来宾密码：");
	private JLabel chairmanPwdLabel = new JLabel("主席密码：");
	private JLabel startTimeLabel = new JLabel("会议开始时间：");
	private JLabel endTimeLabel = new JLabel("会议结束时间：");
	private JLabel confModeLabel = new JLabel("会议类型：");
	private JLabel recordFlagLabel = new JLabel("否录音：");
	private JLabel confNameLabel = new JLabel("会议主题：");
	private JLabel srtpModeLabel = new JLabel("会议是否加密：");
	private JLabel confIdLabel = new JLabel("会议ID：");
	private JLabel errInfoLabel = new JLabel();
	// 预定会议
	private JTextField urlField = new JTextField(26);
	private JTextField userfield = new JTextField(10);
	private JPasswordField pwdField = new JPasswordField(10);
	private JTextField userIdfield = new JTextField(10);
	private JTextField gwIpfield = new JTextField(10);
	private JTextField subPbxfield = new JTextField(10);
	private JTextField enterPromptfield = new JTextField(10);
	private JTextField leavePromptfield = new JTextField(10);
	private JTextField amountfield = new JTextField(10);
	private JPasswordField guestPwdfield = new JPasswordField(10);
	private JPasswordField chairmanPwdfield = new JPasswordField(10);
	private JTextField startTimefield = new JTextField(10);
	private JTextField endTimefield = new JTextField(10);
	private JTextField confModefield = new JTextField(10);
	private JTextField recordFlagfield = new JTextField(10);
	private JTextField confNamefield = new JTextField(10);
	private JTextField srtpModefield = new JTextField(10);
	private JTextField confIdfield = new JTextField(10);

	private JTextArea retDescArea = new JTextArea(20, 30);
	private JButton scheduledMeeting = new MyButton("预定会议");
	private JButton modifyMeeting = new MyButton("修改会议");
	private JButton addAttendee = new MyButton("添加与会人");
	private JButton queryMeeting = new MyButton("查询会议列表");
	private JButton deleteMeeting = new MyButton("删除会议");
	private int timerCount = 0;
	private JPanel jl;

	MeetingPanel() {
		add(getPanels());
		init();
	}

	private JPanel getPanels() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		JScrollPane jsp = new JScrollPane(retDescArea);
		buildPanel(panel, gridbag, c, new JComponent[] { requestLabel }, 0, 0,
				10, 40, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { urlLabel }, 0, 1, 5,
				10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { urlField }, 1, 1, 5,
				10, 3, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { userLabel }, 0, 2, 5,
				10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userfield }, 1, 2, 5,
				10, 1, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { pwdLabel }, 2, 2, 5,
				10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pwdField }, 3, 2, 5,
				10, 1, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { confIdLabel }, 0, 3,
				5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { confIdfield }, 1, 3,
				5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userIdLabel }, 2, 3,
				5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userIdfield }, 3, 3,
				5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { gwIpLabel }, 4, 3, 5,
				10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { gwIpfield }, 5, 3, 5,
				10, 1, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { subPbxLabel }, 0, 4,
				5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { subPbxfield }, 1, 4,
				5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { enterPromptLabel }, 2,
				4, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { enterPromptfield }, 3,
				4, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { leavePromptLabel }, 4,
				4, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { leavePromptfield }, 5,
				4, 5, 10, 1, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { amountLabel }, 0, 5,
				5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { amountfield }, 1, 5,
				5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { guestPwdLabel }, 2, 5,
				5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { guestPwdfield }, 3, 5,
				5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { chairmanPwdLabel }, 4,
				5, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { chairmanPwdfield }, 5,
				5, 5, 10, 1, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { startTimeLabel }, 0,
				6, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { startTimefield }, 1,
				6, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { endTimeLabel }, 2, 6,
				5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { endTimefield }, 3, 6,
				5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { confModeLabel }, 4, 6,
				5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { confModefield }, 5, 6,
				5, 10, 1, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { recordFlagLabel }, 0,
				7, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { recordFlagfield }, 1,
				7, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { confNameLabel }, 2, 7,
				5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { confNamefield }, 3, 7,
				5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { srtpModeLabel }, 4, 7,
				5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { srtpModefield }, 5, 7,
				5, 10, 1, 1);

		// 按钮
		buildPanel(panel, gridbag, c, new JComponent[] { scheduledMeeting }, 0,
				8, 5, 10, 2, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { modifyMeeting }, 2, 8,
				5, 10, 2, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { addAttendee }, 0, 9,
				5, 10, 2, 1);
		addAttendee.addActionListener(this);
		buildPanel(panel, gridbag, c, new JComponent[] { queryMeeting }, 2, 9,
				5, 10, 2, 1);
		queryMeeting.addActionListener(this);
		buildPanel(panel, gridbag, c, new JComponent[] { deleteMeeting }, 4, 9,
				5, 10, 2, 1);
		deleteMeeting.addActionListener(this);
		
		buildPanel(panel, gridbag, c, new JComponent[] { resultLabel }, 6, 0,
				20, 5, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { errInfoLabel }, 0, 13,
				100, 5, 6, 1);

		//retDescArea.setLineWrap(true);
		retDescArea.setBorder(BorderFactory.createTitledBorder(""));
		retDescArea.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
		buildPanel(panel, gridbag, c, new JComponent[] { jsp }, 6, 1,
				20, 200, 1, 12);
		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(new Color(220, 220, 220), 15),
				"会议管理", TitledBorder.CENTER, TitledBorder.TOP,
				new java.awt.Font("宋体", Font.BOLD, 20)));
		urlField.setText(REST_URL);
		userfield.setText(PropertiesUtils.getValue("username"));
		pwdField.setText(PropertiesUtils.getValue("password"));	
		return panel;

	}

	private void buildPanel(JPanel panel, GridBagLayout gridbag,
			GridBagConstraints c, JComponent[] components, int gridx,
			int gridy, int ipadx, int ipady, int gridwidth, int gridheight) {
		JPanel subPanel = new JPanel();

		for (JComponent component : components) {
			component.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
			subPanel.add(component);
		}

		c.fill = GridBagConstraints.BOTH;// 加高组件直到他足以在垂直方向上填满其显示区域，但不更改其高度
		c.anchor = GridBagConstraints.WEST;// 当组件小于其显示区域时，用于确定将组件至于西面
		c.gridx = gridx;
		c.gridy = gridy;
		c.ipadx = ipadx;
		c.ipady = ipady;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		gridbag.setConstraints(subPanel, c);
		panel.add(subPanel);

	}

	private void init() {
		System.out.println("init方法");
		// 预定会议，发起POST请求
		this.scheduledMeeting.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");

				boolean flag = validateParams(new JTextField[] { urlField,
						userfield, pwdField, userIdfield, gwIpfield,
						subPbxfield, enterPromptfield, leavePromptfield,
						amountfield, guestPwdfield, chairmanPwdfield,
						startTimefield, endTimefield, confModefield,
						recordFlagfield, confNamefield, srtpModefield },
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID",
								"统一网关IP", "虚拟PBX的ID", "入会提示", "离会提示", "与会人数",
								"来宾密码", "主席密码", "会议开始时间", "会议结束时间", "会议类型",
								"是否录音", "会议主题", "会议是否加密" });

				if (!flag) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						scheduledMeeting();
					}
				}).start();
			}
		});

		// 修改会议，发起POST请求
		this.modifyMeeting.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");

				boolean flag = validateParams(new JTextField[] { urlField,
						userfield, pwdField, userIdfield, gwIpfield,
						subPbxfield, confIdfield ,enterPromptfield, leavePromptfield,
						amountfield, guestPwdfield, chairmanPwdfield,
						startTimefield, endTimefield, confModefield,
						recordFlagfield, confNamefield, srtpModefield }, new String[] { "eSDK URL",
						"用户名", "密码", "操作用户ID", "统一网关IP", "虚拟PBX的ID", "会议ID","入会提示", "离会提示", "与会人数",
						"来宾密码", "主席密码", "会议开始时间", "会议结束时间", "会议类型",
						"是否录音", "会议主题", "会议是否加密" });

				if (!flag) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						modifyMeeting();
					}
				}).start();
			}
		});

	}

	// 预约会议
	private void scheduledMeeting() {
		ScheduledMeetingResponse response;
		int resp = com.huawei.esdk.ec.conference.utils.KeyManagerUtils.initTransmissionMode();
        if(0 != resp)
        {
        	retDescArea.setText( String.valueOf(resp));
            return;
        }	
		ScheduledMeeting payload = new ScheduledMeeting();
		payload.setUserId(userIdfield.getText());
		payload.setGwIp(gwIpfield.getText());
		payload.setSubPbx(subPbxfield.getText());
		payload.setEnterPrompt(enterPromptfield.getText());
		payload.setLeavePrompt(leavePromptfield.getText());
		payload.setAmount(amountfield.getText());
		try {
			payload.setGuestPwd(Encrypt.getEncryptPwd(String.valueOf(guestPwdfield.getPassword())));
			payload.setChairmanPwd(Encrypt.getEncryptPwd(String.valueOf(chairmanPwdfield.getPassword())));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		payload.setStartTime(startTimefield.getText());
		payload.setEndTime(endTimefield.getText());
		payload.setConfMode(confModefield.getText());
		payload.setRecordFlag(recordFlagfield.getText());
		payload.setConfName(confNamefield.getText());
		payload.setSrtpMode(srtpModefield.getText());
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
		try {
			String responsePayload = RestUtils.getInstance().sendMessage(
					restRequestMessage, "/ec/bmu/ctc");
			finish();
			if (null == responsePayload) {
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值

				response = new Gson().fromJson(
						responsePayload, ScheduledMeetingResponse.class);
				confIdfield.setText(response.getResult());

				if ("0".equals(response.getResultCode())) {
					showErrInfoWithColor("操作成功");
				} else {
					showErrInfoWithColor("操作失败");
				}
			}
		} catch (Exception e) {
			finish();
			// retCodeField.setText("1");
			retDescArea.setText("失败");
			showErrInfoWithColor("操作失败");
		}

	}

	// 修改会议
	private void modifyMeeting() {
		ModifyMeetingResponse response;
		int resp = com.huawei.esdk.ec.conference.utils.KeyManagerUtils.initTransmissionMode();
        if(0 != resp)
        {
        	retDescArea.setText( String.valueOf(resp));
            return;
        }	
		ModifyMeeting payload = new ModifyMeeting();
		payload.setUserId(userIdfield.getText());
		payload.setGwIp(gwIpfield.getText());
		payload.setSubPbx(subPbxfield.getText());
		payload.setEnterPrompt(enterPromptfield.getText());
		payload.setLeavePrompt(leavePromptfield.getText());
		payload.setAmount(amountfield.getText());
		try {
			payload.setGuestPwd(Encrypt.getEncryptPwd(String.valueOf(guestPwdfield.getText())));
			payload.setChairmanPwd(Encrypt.getEncryptPwd(String.valueOf(chairmanPwdfield.getText())));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		payload.setStartTime(startTimefield.getText());
		payload.setEndTime(endTimefield.getText());
		payload.setConfMode(confModefield.getText());
		payload.setRecordFlag(recordFlagfield.getText());
		payload.setConfName(confNamefield.getText());
		payload.setSrtpMode(srtpModefield.getText());
		payload.setConfId(confIdfield.getText());
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_PUT);
		try {
			String responsePayload = RestUtils.getInstance().sendMessage(
					restRequestMessage, "/ec/bmu/ctc");
			finish();
			if (null == responsePayload) {
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值

				response = new Gson().fromJson(
						responsePayload, ModifyMeetingResponse.class);

				if ("0".equals(response.getResultCode())) {
					showErrInfoWithColor("操作成功");
				} else {
					showErrInfoWithColor("操作失败");
				}
			}
		} catch (Exception e) {
			finish();
			// retCodeField.setText("1");
			retDescArea.setText("失败");
			showErrInfoWithColor("操作失败");
		}

	}

	private void begin() {
		System.out.println("begin方法");
		timerCount = 0;
	}

	private void finish() {
		System.out.println("finish方法");
		timerCount = -1;
	}

	private void loading() {
		// System.out.println("loading方法");
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				if (timerCount < 0) {
					return;
				}

				if (timerCount < 5) {
					timerCount++;
				} else {
					timerCount = 0;
				}

				String temp = "";
				for (int i = 0; i < timerCount; i++) {
					temp += ". ";
				}

				temp = "正在请求" + temp;
				showErrInfoWithColor(temp);

				loading();
			}
		}, 250);
	}

	private boolean validateParams(JTextField[] textFields, String[] errTexts) {
		System.out.println("validateParams方法");
		for (int i = 0; i < textFields.length; i++) {
			if (null == textFields[i] || null == textFields[i].getText()
					|| "".equals(textFields[i].getText())) {
				showErrInfoWithColor(errTexts[i] + "不能为空！");
				return false;
			}

			// if (errTexts[i].contains("号码")) {
			// if (!textFields[i].getText().matches("\\d+")) {
			// showErrInfoWithColor(errTexts[i] + "格式不对！");
			// return false;
			// }
			// }
		}

		return true;
	}

	private void showErrInfoWithColor(String errInfo) {
		// System.out.println("showErrInfoWithColor方法");
		if (errInfo == null) {
			return;
		}

		errInfoLabel.setForeground(Color.red);
		errInfoLabel.setText(errInfo);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("添加与会人".equals(e.getActionCommand())) {
			JFrame frame = new JFrame("添加与会人");// 构造一个新的JFrame，作为新窗口。
			frame.setBounds(// 让新窗口与原窗口示例错开50像素。
			new Rectangle((int) this.getBounds().getX() + 50, (int) this
					.getBounds().getY() + 50,
					(int) this.getBounds().getWidth(), (int) this.getBounds()
							.getHeight()));
			jl = new AddAttendeePanel();
			frame.getContentPane().add(jl);
			frame.setVisible(true);
		}else if("查询会议列表".equals(e.getActionCommand())){
			JFrame frame = new JFrame("查询会议列表");// 构造一个新的JFrame，作为新窗口。
			frame.setBounds(// 让新窗口与原窗口示例错开50像素。
			new Rectangle((int) this.getBounds().getX() + 50, (int) this
					.getBounds().getY() + 50,
					(int) this.getBounds().getWidth(), (int) this.getBounds()
							.getHeight()));
			jl = new QueryMeetingPanel();
			frame.getContentPane().add(jl);
			frame.setVisible(true);
		}else if("删除会议".equals(e.getActionCommand())){
			JFrame frame = new JFrame("删除会议");// 构造一个新的JFrame，作为新窗口。
			frame.setBounds(// 让新窗口与原窗口示例错开50像素。
			new Rectangle((int) this.getBounds().getX() + 50, (int) this
					.getBounds().getY() + 50,
					(int) this.getBounds().getWidth(), (int) this.getBounds()
							.getHeight()));
			jl = new DeleteMeetingPanel();
			frame.getContentPane().add(jl);
			frame.setVisible(true);
		}
	}
}
