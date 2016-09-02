package com.huawei.esdk.ec.conference.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
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
import com.huawei.esdk.ec.conference.bean.DeleteMeeting;
import com.huawei.esdk.ec.conference.bean.DeleteMeetingBaseParam;
import com.huawei.esdk.ec.conference.bean.DeleteMeetingResponse;
import com.huawei.esdk.ec.conference.constant.UCConstant;
import com.huawei.esdk.ec.conference.js.MyButton;
import com.huawei.esdk.ec.conference.model.RestRequestMessage;
import com.huawei.esdk.ec.conference.model.RestResponse;
import com.huawei.esdk.ec.conference.util.PropertiesUtils;
import com.huawei.esdk.ec.conference.util.RestUtils;
import com.huawei.esdk.ec.conference.utils.StringUtils;

public class DeleteMeetingPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = -8285213367222038440L;
	private static final String REST_URL = PropertiesUtils.getValue("rest.url");
	private static String userName;
	private static String password;
	//删除会议
	private JLabel requestLabel = new JLabel("请求参数:");
	private JLabel urlLabel = new JLabel("eSDK URL：");
	private JLabel userLabel = new JLabel("用户名：");
	private JLabel pwdLabel = new JLabel("密码：");
	private JLabel resultLabel = new JLabel("返回内容：");
	private JLabel userIdLabel = new JLabel("操作用户ID：");
	private JLabel gwIpLabel = new JLabel("网关IP");
	private JLabel confIdLabel = new JLabel("会议ID     ");	
	private JLabel errInfoLabel = new JLabel();	
	private JTextField urlField = new JTextField(26);
	private JTextField userfield = new JTextField(10);
	private JPasswordField pwdField = new JPasswordField(10);
	private JTextField userIdfield = new JTextField(10);	
	private JTextField gwIpfield1 = new JTextField(10);
	private JTextField gwIpfield2 = new JTextField(10);
	private JTextField gwIpfield3 = new JTextField(10);
	private JTextField confIdfield1 = new JTextField(10);
	private JTextField confIdfield2 = new JTextField(10);
	private JTextField confIdfield3 = new JTextField(10);	
	private JTextArea retDescArea = new JTextArea(20, 40);
	private JButton deleteMeeting = new MyButton("删除");
	private JButton cancel = new MyButton("清空");
	private JButton deleteRow = new MyButton("删除行");
	private JButton addRow = new MyButton("添加行");
	private int timerCount = 0;		
	static int rowCount=1;
	JPanel panel;
	GridBagLayout gridbag;
	GridBagConstraints c;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;

	DeleteMeetingPanel() {
		rowCount=1;
 		add(getPanels());
		init();
	}

	private JPanel getPanels() {
				
		gridbag = new GridBagLayout();
		c = new GridBagConstraints();
		panel = new JPanel(gridbag);
		JScrollPane jsp = new JScrollPane(retDescArea);
		buildPanel(panel, gridbag, c, new JComponent[] { requestLabel }, 0, 0, 20, 40, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { urlLabel }, 0, 1, 20, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { urlField }, 1, 1, 20, 10, 3, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { userLabel }, 0, 2, 20, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userfield }, 1, 2, 20, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pwdLabel }, 2, 2, 20, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pwdField }, 3, 2, 20, 10, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { userIdLabel }, 0, 3, 20, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userIdfield }, 1, 3, 20, 10, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { gwIpLabel }, 1, 4, 20, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { confIdLabel }, 2, 4, 20, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { addRow }, 3, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { deleteRow }, 4, 4, 10, 20, 1, 1);		
		buildPanel1(panel, gridbag, c, new JComponent[] { gwIpfield1,confIdfield1 }, 1, 5, 20, 10, 2, 1);
		addRow.addActionListener(this);
		deleteRow.addActionListener(this);		
		//按钮
		buildPanel(panel, gridbag, c, new JComponent[] { deleteMeeting }, 1, 8, 5, 10, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { cancel }, 2, 8, 5, 10, 1, 1);
		cancel.addActionListener(this);		
		buildPanel(panel, gridbag, c, new JComponent[] { resultLabel }, 6, 0, 20, 5, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { errInfoLabel }, 0, 9, 100, 5, 4, 1);				
		//retDescArea.setLineWrap(true);
		retDescArea.setBorder(BorderFactory.createTitledBorder(""));
		retDescArea.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
		buildPanel(panel, gridbag, c, new JComponent[] { jsp }, 6, 1, 20, 200, 1, 9);
		if(rowCount == 1){
			panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 15),
					"删除会议", TitledBorder.CENTER, TitledBorder.TOP, new java.awt.Font("宋体", Font.BOLD, 20)));
		}
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
	
	private void buildPanel1(JPanel panel, GridBagLayout gridbag, GridBagConstraints c, JComponent[] components,
			int gridx, int gridy, int ipadx, int ipady, int gridwidth, int gridheight) {
		
		panel1 = new JPanel();
		for (JComponent component : components) {
			component.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
			panel1.add(component);
		}
		c.fill = GridBagConstraints.BOTH;// 加高组件直到他足以在垂直方向上填满其显示区域，但不更改其高度
		c.anchor = GridBagConstraints.WEST;// 当组件小于其显示区域时，用于确定将组件至于西面
		c.gridx = gridx;
		c.gridy = gridy;
		c.ipadx = ipadx;
		c.ipady = ipady;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		gridbag.setConstraints(panel1, c);
		
		panel.add(panel1);

	}
	private void buildPanel2(JPanel panel, GridBagLayout gridbag, GridBagConstraints c, JComponent[] components,
			int gridx, int gridy, int ipadx, int ipady, int gridwidth, int gridheight) {

		panel2 = new JPanel();
		for (JComponent component : components) {
			component.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
			panel2.add(component);
		}

		c.fill = GridBagConstraints.BOTH;// 加高组件直到他足以在垂直方向上填满其显示区域，但不更改其高度
		c.anchor = GridBagConstraints.WEST;// 当组件小于其显示区域时，用于确定将组件至于西面
		c.gridx = gridx;
		c.gridy = gridy;
		c.ipadx = ipadx;
		c.ipady = ipady;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		gridbag.setConstraints(panel2, c);
		panel.add(panel2);

	}
	private void buildPanel3(JPanel panel, GridBagLayout gridbag, GridBagConstraints c, JComponent[] components,
			int gridx, int gridy, int ipadx, int ipady, int gridwidth, int gridheight) {

		panel3 = new JPanel();
		for (JComponent component : components) {
			component.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
			panel3.add(component);
		}

		c.fill = GridBagConstraints.BOTH;// 加高组件直到他足以在垂直方向上填满其显示区域，但不更改其高度
		c.anchor = GridBagConstraints.WEST;// 当组件小于其显示区域时，用于确定将组件至于西面
		c.gridx = gridx;
		c.gridy = gridy;
		c.ipadx = ipadx;
		c.ipady = ipady;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		gridbag.setConstraints(panel3, c);
		panel.add(panel3);

	}

	private void init() {
		//删除会议
		this.deleteMeeting.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");

				boolean flag = true;
				if(rowCount == 1){
					flag = validateParams(
							new JTextField[] { urlField, userfield, pwdField, userIdfield,gwIpfield1,confIdfield1},
							new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "网关IP1", "会议ID1"});
				}else if(rowCount == 2){
					flag = validateParams(
							new JTextField[] { urlField, userfield, pwdField, userIdfield, gwIpfield1, confIdfield1, gwIpfield2, confIdfield2},
							new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "网关IP1", "会议ID1", "网关IP2", "会议ID2"});
				}else if(rowCount == 3){
					flag = validateParams(
							new JTextField[] { urlField, userfield, pwdField, userIdfield, gwIpfield1, confIdfield1, gwIpfield2, confIdfield2, gwIpfield3, confIdfield3},
							new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "网关IP1", "会议ID1", "网关IP2", "会议ID2", "网关IP3", "会议ID3"});
				}
				

				if (!flag) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						deleteMeeting();
					}
				}).start();
			}
		});
	}
	
	//删除会议
	private void deleteMeeting() {
		DeleteMeeting payload = new DeleteMeeting();
		payload.setUserId(userIdfield.getText());
		
		List<DeleteMeetingBaseParam> deleteItem = new ArrayList<DeleteMeetingBaseParam>();
		payload.setDeleteItem(deleteItem);
		
		DeleteMeetingBaseParam deleteMeetingBaseParam1 =new DeleteMeetingBaseParam();
		DeleteMeetingBaseParam deleteMeetingBaseParam2 =new DeleteMeetingBaseParam();
		DeleteMeetingBaseParam deleteMeetingBaseParam3 =new DeleteMeetingBaseParam();
		
		deleteMeetingBaseParam1.setConfId(confIdfield1.getText());
		deleteMeetingBaseParam1.setGwIp(gwIpfield1.getText());
		deleteItem.add(deleteMeetingBaseParam1);
		
		if(rowCount == 2){
			deleteMeetingBaseParam2.setConfId(confIdfield2.getText());
			deleteMeetingBaseParam2.setGwIp(gwIpfield2.getText());
			deleteItem.add(deleteMeetingBaseParam2);
		}
		
		if(rowCount == 3){
			deleteMeetingBaseParam2.setConfId(confIdfield2.getText());
			deleteMeetingBaseParam2.setGwIp(gwIpfield2.getText());
			deleteItem.add(deleteMeetingBaseParam2);			
			deleteMeetingBaseParam3.setConfId(confIdfield3.getText());
			deleteMeetingBaseParam3.setGwIp(gwIpfield3.getText());
			deleteItem.add(deleteMeetingBaseParam3);
		}
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
		try {
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage, "/ec/bmu/batch_delete_ctc");
			finish();
			if (null == responsePayload) {				
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值
				DeleteMeetingResponse response = new Gson().fromJson(responsePayload, DeleteMeetingResponse.class);				
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
		userIdfield.setText("");
		confIdfield1.setText("");
		gwIpfield1.setText("");
		if(rowCount == 2){
			confIdfield2.setText("");
			gwIpfield2.setText("");
		}
		if(rowCount == 3){
			confIdfield2.setText("");
			gwIpfield2.setText("");
			confIdfield3.setText("");
			gwIpfield3.setText("");
		}
		if("添加行".equals(e.getActionCommand())){
			if(rowCount < 3){
				rowCount++;
				if(rowCount == 2){
					buildPanel2(panel, gridbag, c, new JComponent[] { gwIpfield2,confIdfield2 }, 1, 5+rowCount-1, 20, 10, 2, 1);
					panel.updateUI();
					panel.repaint();
				}
				if(rowCount == 3){
					buildPanel3(panel, gridbag, c, new JComponent[] { gwIpfield3,confIdfield3 }, 1, 5+rowCount-1, 20, 10, 2, 1);
					panel.updateUI();
					panel.repaint();
				}
			}
			
		}
		else if("删除行".equals(e.getActionCommand())){
			if(rowCount > 1){	
				if(rowCount == 3){
					panel.remove(panel3);
					panel.updateUI();
					panel.repaint();
				}
				if(rowCount == 2){
					panel.remove(panel2);
					panel.updateUI();
					panel.repaint();
				}
				rowCount--;
			}
		}
	}
	
	
}
