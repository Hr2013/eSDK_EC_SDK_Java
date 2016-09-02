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
import com.huawei.esdk.ec.conference.bean.QueryMeeting;
import com.huawei.esdk.ec.conference.bean.QueryMeetingResponse;
import com.huawei.esdk.ec.conference.constant.UCConstant;
import com.huawei.esdk.ec.conference.js.MyButton;
import com.huawei.esdk.ec.conference.model.RestRequestMessage;
import com.huawei.esdk.ec.conference.model.RestResponse;
import com.huawei.esdk.ec.conference.util.PropertiesUtils;
import com.huawei.esdk.ec.conference.util.RestUtils;
import com.huawei.esdk.ec.conference.utils.StringUtils;

public class QueryMeetingPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = -8285213367222038440L;	
	private static final String REST_URL = PropertiesUtils.getValue("rest.url");
	private static String userName;
	private static String password;
	//查询会议列表
	private JLabel requestLabel = new JLabel("请求参数:");
	private JLabel urlLabel = new JLabel("eSDK URL：");
	private JLabel userLabel = new JLabel("用户名：");
	private JLabel pwdLabel = new JLabel("密码：");
	private JLabel resultLabel = new JLabel("返回内容：");
	private JLabel userIdLabel = new JLabel("操作用户ID：");
	private JLabel confIdLabel = new JLabel("会议ID：");
	private JLabel phoneLabel = new JLabel("与会人号码：");
	private JLabel confNameLabel = new JLabel("会议主题：");
	private JLabel startTimeLabel = new JLabel("会议开始时间：");
	private JLabel endTimeLabel = new JLabel("会议结束时间：");
	private JLabel pageNumLabel = new JLabel("当前页数：");
	private JLabel pageCountLabel = new JLabel("每页显示数：");	
	private JLabel errInfoLabel = new JLabel();
	//添加与会人
	private JTextField urlField = new JTextField(26);
	private JTextField userfield = new JTextField(10);
	private JPasswordField pwdField = new JPasswordField(10);
	private JTextField userIdfield = new JTextField(10);
	private JTextField confIdfield = new JTextField(10);
	private JTextField phonefield = new JTextField(10);
	private JTextField confNamefield = new JTextField(10);
	private JTextField startTimefield = new JTextField(10);
	private JTextField endTimefield = new JTextField(10);
	private JTextField pageNumfield = new JTextField(10);
	private JTextField pageCountfield = new JTextField(10);	
	private JTextArea retDescArea = new JTextArea(20, 30);
	private JButton queryMeeting = new MyButton("查询");
	private JButton cancel = new MyButton("清空");
	private int timerCount = 0;	
	QueryMeetingPanel() {
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
		buildPanel(panel, gridbag, c, new JComponent[] { confIdLabel }, 2, 3, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { confIdfield }, 3, 3, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { phoneLabel }, 4, 3, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { phonefield }, 5, 3, 5, 10, 1, 1);	
		buildPanel(panel, gridbag, c, new JComponent[] { confNameLabel }, 0, 4, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { confNamefield }, 1, 4, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { startTimeLabel }, 2, 4, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { startTimefield }, 3, 4, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { endTimeLabel }, 4, 4, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { endTimefield }, 5, 4, 5, 10, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { pageNumLabel }, 0, 5, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pageNumfield }, 1, 5, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pageCountLabel }, 2, 5, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pageCountfield }, 3, 5, 5, 10, 1, 1);	
		//按钮
		buildPanel(panel, gridbag, c, new JComponent[] { queryMeeting }, 0, 6, 5, 10, 2, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { cancel }, 2, 6, 5, 10, 2, 1);
		cancel.addActionListener(this);		
		buildPanel(panel, gridbag, c, new JComponent[] { resultLabel }, 6, 0, 20, 5, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { errInfoLabel }, 0, 7, 100, 5, 6, 1);		
		//retDescArea.setLineWrap(true);
		retDescArea.setBorder(BorderFactory.createTitledBorder(""));
		retDescArea.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
		buildPanel(panel, gridbag, c, new JComponent[] { jsp }, 6, 1, 20, 200, 1, 8);
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 15),
				"查询会议列表", TitledBorder.CENTER, TitledBorder.TOP, new java.awt.Font("宋体", Font.BOLD, 20)));
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
		System.out.println("init方法");
		
		//查询会议列表
		this.queryMeeting.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");
				boolean flag = validateParams(
						new JTextField[] { urlField, userfield, pwdField, userIdfield,confNamefield, startTimefield, endTimefield, pageNumfield, pageCountfield},
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID","会议主题", "会议开始时间", "会议结束时间", "每页显示数", "当前页数"});

				if (!flag) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						queryMeeting();
					}
				}).start();
			}
		});
	}
	
	//查询会议列表
	private void queryMeeting() {
		QueryMeetingResponse response;
		int resp = com.huawei.esdk.ec.conference.utils.KeyManagerUtils.initTransmissionMode();
        if(0 != resp)
        {
        	retDescArea.setText( String.valueOf(resp));
            return;
        }	
		QueryMeeting payload = new QueryMeeting();
		payload.setUserId(userIdfield.getText());
		payload.setConfId(confIdfield.getText());
		payload.setPhone(phonefield.getText());
		payload.setConfName(confNamefield.getText());
		payload.setStartTime(startTimefield.getText());
		payload.setEndTime(endTimefield.getText());
		payload.setPageNum(pageNumfield.getText());
		payload.setPageCount(pageCountfield.getText());
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
		try {
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage, "/ec/bmu/batch_query_ctc");
			finish();
			if (null == responsePayload) {				
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值
				response = new Gson().fromJson(responsePayload, QueryMeetingResponse.class);				
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
		confIdfield.setText("");
		phonefield.setText("");
		confNamefield.setText("");
		startTimefield.setText("");
		endTimefield.setText("");
		pageNumfield.setText("");
		pageCountfield.setText("");
	}

}
