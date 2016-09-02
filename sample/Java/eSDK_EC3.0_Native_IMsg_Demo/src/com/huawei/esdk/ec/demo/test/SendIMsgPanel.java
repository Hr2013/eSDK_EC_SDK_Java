package com.huawei.esdk.ec.demo.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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

import com.google.gson.Gson;
import com.huawei.esdk.ec.demo.js.MyButton;
import com.huawei.esdk.uc.professional.local.bean.RestResponse;
import com.huawei.esdk.uc.professional.local.bean.south.AddDepartmentResult;
import com.huawei.esdk.uc.professional.local.bean.south.AppSendMsgToDept;
import com.huawei.esdk.uc.professional.local.bean.south.AppSendMsgToGroup;
import com.huawei.esdk.uc.professional.local.bean.south.AppSendMsgToUC;
import com.huawei.esdk.uc.professional.local.bean.south.DepartmentRequest;
import com.huawei.esdk.uc.professional.local.bean.south.QueryDepartmentInfoList;
import com.huawei.esdk.uc.professional.local.factory.ServiceFactoryEx;
import com.huawei.esdk.uc.professional.local.service.IMServiceEx;
import com.huawei.esdk.uc.professional.local.service.UserProfileServiceEx;
import com.huawei.esdk.uc.professional.local.utils.PropertiesUtils;

public class SendIMsgPanel extends JPanel {
	private static final long serialVersionUID = -8285213367222038440L;
	private JLabel requestLabel = new JLabel("请求参数:");
	private JLabel urlLabel = new JLabel("  eSDK URL：");
	private JLabel userLabel = new JLabel("  用 户 名：");
	private JLabel pwdLabel = new JLabel("    密   码：");
	private JLabel sendNumberLabel = new JLabel("发送者EC账号：");
	private JLabel ucAccountLabel = new JLabel("  接收者EC账号:");
	private JLabel groupIdLabel = new JLabel(" 群组Id:");
	private JLabel deptIdLabel = new JLabel("部门号:");
	private JLabel messageLabel = new JLabel(" 消息内容:");
	private JLabel subjectLabel = new JLabel(" 通知消息标题:");
//	private JLabel dateTimeLabel = new JLabel(" 消息提交时间:");
	private JLabel deptGradeLabel = new JLabel(" 向该部门及以下多少级部门发送消息:");
	private JLabel priorityLevelLabel = new JLabel(" 消息优先级:");
	private JLabel resultLabel = new JLabel("返回内容：");
	
	private JLabel errInfoLabel = new JLabel();
	private JTextField urlField = new JTextField(26);
	private JTextField userfield = new JTextField(10);
	private JPasswordField pwdField = new JPasswordField(10);
	private JTextField sendNumberfield = new JTextField(10);
	private JTextField ucAccountfield = new JTextField(10);
	private JTextField groupIdfield = new JTextField(10);
	private JTextField deptIdfield = new JTextField(10);
	private JTextField messagefield = new JTextField(10);
	private JTextField subjectfield = new JTextField(10);
//	private JTextField dateTimefield = new JTextField(10);
	private JTextField deptGradefield = new JTextField(10);
	private JTextField priorityLevelfield = new JTextField(10);
	private JTextArea retDescArea = new JTextArea(20, 40);
	private JButton appSendMsgToUC = new MyButton("向EC用户发送消息");
	private JButton appSendMsgToGroup = new MyButton("向群组发送消息");
	private JButton appSendMsgToDept = new MyButton("向部门发送系统通知消息");
	private int timerCount = 0;

	// 获取服务句柄 
	private IMServiceEx imService = ServiceFactoryEx.getService(IMServiceEx.class);

	
	SendIMsgPanel() {
		add(getPanels());
		init();
	}

	private JPanel getPanels() {

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		JScrollPane jsp = new JScrollPane(retDescArea);
		buildPanel(panel, gridbag, c, new JComponent[] { requestLabel }, 0, 0, 10, 40, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { urlLabel }, 0, 1, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { urlField }, 1, 1, 10, 20, 2, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userLabel }, 0, 2, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userfield }, 1, 2, 6, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pwdLabel }, 2, 2, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pwdField }, 3, 2, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { sendNumberLabel }, 0, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { sendNumberfield }, 1, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { ucAccountLabel }, 2, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { ucAccountfield }, 3, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { groupIdLabel }, 0, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { groupIdfield }, 1, 4, 10, 20, 1, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { deptIdLabel }, 2, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { deptIdfield }, 3, 4, 10, 20, 1, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { messageLabel }, 0, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { messagefield }, 1, 5, 10, 20, 1, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { subjectLabel }, 2, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { subjectfield }, 3, 5, 10, 20, 1, 1);
		
//		buildPanel(panel, gridbag, c, new JComponent[] { dateTimeLabel }, 0, 6, 10, 20, 1, 1);
//		buildPanel(panel, gridbag, c, new JComponent[] { dateTimefield }, 1, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { priorityLevelLabel }, 0, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { priorityLevelfield }, 1, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { deptGradeLabel }, 0, 7, 10, 20, 2, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { deptGradefield }, 2, 7, 10, 20, 1, 1);


		buildPanel(panel, gridbag, c, new JComponent[] { appSendMsgToUC }, 0, 8, 100, 30, 2, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { appSendMsgToGroup }, 2, 8, 100, 30, 2, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { appSendMsgToDept }, 0, 9, 100, 40, 2, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { resultLabel }, 4, 0, 150, 5, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { errInfoLabel }, 0, 10, 100, 5, 4, 1);
		// retDescArea.setLineWrap(true);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		retDescArea.setBorder(BorderFactory.createTitledBorder(""));
		retDescArea.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
		buildPanel(panel, gridbag, c, new JComponent[] { jsp }, 4, 1, 150, 200, 1, 10);
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
		System.out.println("init方法");
		urlField.setText(PropertiesUtils.getValue("rest.url"));
		userfield.setText(PropertiesUtils.getValue("username"));
		pwdField.setText(PropertiesUtils.getValue("password"));
		urlField.setEditable(false);
		userfield.setEditable(false);
		pwdField.setEditable(false);

		//向UC用户发送消息
		this.appSendMsgToUC.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");

				boolean flag = validateParams(
						new JTextField[] { sendNumberfield, ucAccountfield, messagefield},
						new String[] { "发送者EC账号", "接收者EC账号", "消息内容", "消息提交时间" });

				if (!flag) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						appSendMsgToUC();
					}
				}).start();
			}
		});

		// 向群组发送消息
		this.appSendMsgToGroup.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");

				boolean flag = validateParams(
						new JTextField[] { sendNumberfield, groupIdfield, messagefield },
						new String[] { "发送者EC账号", "群组Id","消息内容", "消息提交时间" });

				if (!flag) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						appSendMsgToGroup();
					}
				}).start();
			}
		});

		// 向部门发送系统通知消息
		this.appSendMsgToDept.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");

				boolean flag = validateParams(
						new JTextField[] { sendNumberfield, deptIdfield, messagefield, subjectfield },
						new String[] { "发送者EC账号", "部门号", "消息内容", "通知消息标题" });

				if (!flag) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						appSendMsgToDept();
					}
				}).start();
			}
		});
	}

	private void appSendMsgToUC() {
		
		//构建请求数据
		AppSendMsgToUC msg = new AppSendMsgToUC();
		msg.setSendNumber(sendNumberfield.getText());
		msg.setUcAccount(ucAccountfield.getText());
		msg.setMessage(messagefield.getText());
		msg.setDateTime(new Date());
		msg.setPriorityLevel(priorityLevelfield.getText());

		//如果返回0，则表示消息发送成功
		int resultCode = imService.appSendMsgToUC(msg);
		finish();
		
		retDescArea.setText("resultCode:"+resultCode+"");
		if( 401 == resultCode )
		{
			//鉴权失败
			showErrInfoWithColor("操作失败");
		}
		else if( 1 == resultCode)
		{
			//操作失败，可能由于网络原因
			showErrInfoWithColor("操作失败");
		}
		else
		{
			//操作成功
			if(0 == resultCode){
				showErrInfoWithColor("操作成功");
			}
			else
			{
				showErrInfoWithColor("操作失败");
			}
		}

	}

	private void appSendMsgToGroup() {
		
		//构建请求数据
		AppSendMsgToGroup msg = new AppSendMsgToGroup();
		msg.setSendNumber(sendNumberfield.getText());
		msg.setGroupId(groupIdfield.getText());
		msg.setMessage(messagefield.getText());
		msg.setDateTime(new Date());
		msg.setPriorityLevel(priorityLevelfield.getText());

		//如果返回0，则表示消息发送成功
		int resultCode = imService.appSendMsgToGroup(msg);
		finish();
		
		retDescArea.setText("resultCode:"+resultCode+"");
		if( 401 == resultCode )
		{
			//鉴权失败
			showErrInfoWithColor("操作失败");
		}
		else if( 1 == resultCode)
		{
			//操作失败，可能由于网络原因
			showErrInfoWithColor("操作失败");
		}
		else
		{
			//操作成功
			if(0 == resultCode){
				showErrInfoWithColor("操作成功");
			}
			else
			{
				showErrInfoWithColor("操作失败");
			}
		}
		
	}

	private void appSendMsgToDept() {
		
		//构建请求数据
		AppSendMsgToDept msg = new AppSendMsgToDept();
		msg.setSendNumber(sendNumberfield.getText());
		msg.setDeptId(deptIdfield.getText());
		msg.setMessage(messagefield.getText());
		msg.setSubject(subjectfield.getText());
		msg.setDeptGrade(deptGradefield.getText());
		msg.setPriorityLevel(priorityLevelfield.getText());

		//如果返回0，则表示消息发送成功
		int resultCode = imService.appSendMsgToDept(msg);
		finish();
		
		retDescArea.setText("resultCode:"+resultCode+"");
		if( 401 == resultCode )
		{
			//鉴权失败
			showErrInfoWithColor("操作失败");
		}
		else if( 1 == resultCode)
		{
			//操作失败，可能由于网络原因
			showErrInfoWithColor("操作失败");
		}
		else
		{
			//操作成功
			if(0 == resultCode){
				showErrInfoWithColor("操作成功");
			}
			else
			{
				showErrInfoWithColor("操作失败");
			}
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

			if (errTexts[i].contains("号码")) {
				if (!textFields[i].getText().matches("\\d+")) {
					showErrInfoWithColor(errTexts[i] + "格式不对！");
					return false;
				}
			}
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

}
