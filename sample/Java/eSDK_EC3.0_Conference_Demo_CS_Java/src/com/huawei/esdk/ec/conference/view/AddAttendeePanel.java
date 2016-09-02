package com.huawei.esdk.ec.conference.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.google.gson.Gson;

import com.huawei.esdk.ec.conference.bean.AddAttendee;
import com.huawei.esdk.ec.conference.bean.AddAttendeeResponse;
import com.huawei.esdk.ec.conference.constant.UCConstant;
import com.huawei.esdk.ec.conference.js.MyButton;
import com.huawei.esdk.ec.conference.model.RestRequestMessage;
import com.huawei.esdk.ec.conference.model.RestResponse;
import com.huawei.esdk.ec.conference.util.PropertiesUtils;
import com.huawei.esdk.ec.conference.util.RestUtils;
import com.huawei.esdk.ec.conference.utils.StringUtils;


public class AddAttendeePanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = -8285213367222038440L;	
	private static final String REST_URL = PropertiesUtils.getValue("rest.url");
	private static String userName;
	private static String password;
	//预定会议
	private JLabel requestLabel = new JLabel("请求参数:");
	private JLabel urlLabel = new JLabel("eSDK URL：");
	private JLabel userLabel = new JLabel("用户名：");
	private JLabel pwdLabel = new JLabel("密码：");
	private JLabel resultLabel = new JLabel("返回内容：");
	private JLabel userIdLabel = new JLabel("操作用户ID：");
	private JLabel gwIpLabel = new JLabel("统一网关IP：");
	private JLabel subPbxLabel = new JLabel("虚拟PBX的ID：");
	private JLabel confIdLabel = new JLabel("会议ID：");
	private JLabel accountLabel = new JLabel("与会人的姓名：");
	private JLabel attNumberLabel = new JLabel("与会人号码：");
	private JLabel attTypeLabel = new JLabel("与会者类型：");
	private JLabel emailLabel = new JLabel("邮箱地址：");	
	private JLabel errInfoLabel = new JLabel();
	//添加与会人
	private JTextField urlField = new JTextField(26);
	private JTextField userfield = new JTextField(10);
	private JPasswordField pwdField = new JPasswordField(10);
	private JTextField userIdfield = new JTextField(10);
	private JTextField gwIpfield = new JTextField(10);
	private JTextField subPbxfield = new JTextField(10);
	private JTextField confIdfield = new JTextField(10);
	private JTextField accountfield = new JTextField(10);
	private JTextField attNumberfield = new JTextField(10);
	private JTextField attTypefield = new JTextField(10);
	private JTextField emailfield = new JTextField(10);	
	private JTextArea retDescArea = new JTextArea(20, 30);
	private JButton addAttendee = new MyButton("添加");
	private JButton cancel = new MyButton("清空");
	private int timerCount = 0;	
	AddAttendeePanel() {
		add(getPanels());
		init();
	}
	private JPanel getPanels() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		JScrollPane jsp = new JScrollPane(retDescArea);
		buildPanel(panel, gridbag, c, new JComponent[] { requestLabel }, 0, 0, 10, 40, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { urlLabel }, 0, 1, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { urlField }, 1, 1, 5, 10, 3, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { userLabel }, 0, 2, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userfield }, 1, 2, 5, 10, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { pwdLabel }, 2, 2, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pwdField }, 3, 2, 5, 10, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { userIdLabel }, 0, 3, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userIdfield }, 1, 3, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { gwIpLabel }, 2, 3, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { gwIpfield }, 3, 3, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { subPbxLabel }, 4, 3, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { subPbxfield }, 5, 3, 5, 10, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { confIdLabel }, 0, 4, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { confIdfield }, 1, 4, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { accountLabel }, 2, 4, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { accountfield }, 3, 4, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { attNumberLabel }, 4, 4, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { attNumberfield }, 5, 4, 5, 10, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { attTypeLabel }, 0, 5, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { attTypefield }, 1, 5, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { emailLabel }, 2, 5, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { emailfield }, 3, 5, 5, 10, 1, 1);				
		//按钮
		buildPanel(panel, gridbag, c, new JComponent[] { addAttendee }, 0, 6, 5, 10, 2, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { cancel }, 2, 6, 5, 10, 2, 1);
		cancel.addActionListener(this);		
		buildPanel(panel, gridbag, c, new JComponent[] { resultLabel }, 6, 0, 20, 5, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { errInfoLabel }, 0, 7, 100, 5, 6, 1);				
		//retDescArea.setLineWrap(true);
		retDescArea.setBorder(BorderFactory.createTitledBorder(""));
		retDescArea.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
		buildPanel(panel, gridbag, c, new JComponent[] { jsp }, 6, 1, 20, 200, 1, 8);
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 15),
				"添加与会人", TitledBorder.CENTER, TitledBorder.TOP, new java.awt.Font("宋体", Font.BOLD, 20)));
		urlField.setText(REST_URL);
		userfield.setText(PropertiesUtils.getValue("username"));
		pwdField.setText(PropertiesUtils.getValue("password"));	
		return panel;
	}

	private void buildPanel(JPanel panel, GridBagLayout gridbag, GridBagConstraints c, JComponent[] components,
			int gridx, int gridy, int ipadx, int ipady, int gridwidth, int gridheight) {
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
	
		//添加与会人addAttendee
		this.addAttendee.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");
				boolean flag = validateParams(
						new JTextField[] { urlField, userfield, pwdField, userIdfield, gwIpfield, subPbxfield, confIdfield, accountfield, attNumberfield, attTypefield},
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "统一网关IP", "虚拟PBX的ID" , "会议ID", "与会人的姓名", "与会人号码", "与会者类型"});

				if (!flag) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						addAttendee();
					}
				}).start();
			}
		});
	}
	
	//添加与会人
	private void addAttendee() {
		AddAttendeeResponse response;
		 int resp = com.huawei.esdk.ec.conference.utils.KeyManagerUtils.initTransmissionMode();
	        if(0 != resp)
	        {
	        	retDescArea.setText( String.valueOf(resp));
	            return;
	        }	
		AddAttendee payload = new AddAttendee();
		payload.setUserId(userIdfield.getText());
		payload.setGwIp(gwIpfield.getText());
		payload.setSubPbx(subPbxfield.getText());
		payload.setConfId(confIdfield.getText());
		payload.setAccount(accountfield.getText());
		payload.setAttNumber(attNumberfield.getText());
		payload.setAttType(attTypefield.getText());
		payload.setEmail(emailfield.getText());
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
		try {
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage, "/ec/bmu/attendee");
			finish();
			if (null == responsePayload) {				
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值
				response = new Gson().fromJson(responsePayload, AddAttendeeResponse.class);				
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
			if (null == textFields[i] || null == textFields[i].getText() || "".equals(textFields[i].getText())) {
				showErrInfoWithColor(errTexts[i] + "不能为空！");
				return false;
			}

//			if (errTexts[i].contains("号码")) {
//				if (!textFields[i].getText().matches("\\d+")) {
//					showErrInfoWithColor(errTexts[i] + "格式不对！");
//					return false;
//				}
//			}
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		userIdfield.setText("");
		gwIpfield.setText("");
		subPbxfield.setText("");
		confIdfield.setText("");
		accountfield.setText("");
		attNumberfield.setText("");
		attTypefield.setText("");
		emailfield.setText("");
	}

}
