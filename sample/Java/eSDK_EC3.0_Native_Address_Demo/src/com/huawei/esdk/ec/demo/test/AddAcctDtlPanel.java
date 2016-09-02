package com.huawei.esdk.ec.demo.test;

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

import com.google.gson.Gson;
import com.huawei.esdk.ec.demo.js.MyButton;
import com.huawei.esdk.ec.demo.util.StringUtils;
import com.huawei.esdk.uc.professional.local.bean.RestResponse;
import com.huawei.esdk.uc.professional.local.bean.south.Account;
import com.huawei.esdk.uc.professional.local.bean.south.AddAccountRequest;
import com.huawei.esdk.uc.professional.local.factory.ServiceFactoryEx;
import com.huawei.esdk.uc.professional.local.service.UserProfileServiceEx;
import com.huawei.esdk.uc.professional.local.utils.PropertiesUtils;

public class AddAcctDtlPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = -8285213367222038440L;
	private JLabel requestLabel = new JLabel("请求参数:");
	private JLabel urlLabel = new JLabel("  eSDK URL：");
	private JLabel userLabel = new JLabel("  用 户 名：");
	private JLabel pwdLabel = new JLabel("    密   码：");
	private JLabel userIdLabel = new JLabel("操作用户ID：");
	private JLabel actTypeLabel = new JLabel("帐号类型:");
	private JLabel loginNamLabel = new JLabel("登录名:");
	private JLabel pwsLabel = new JLabel("登录密码:");
	private JLabel nameLabel = new JLabel("用户姓名:");
	private JLabel sexLabel = new JLabel("用户性别:");
	private JLabel homephoneLabel = new JLabel("家庭电话:");
	private JLabel callphoneLabel = new JLabel("手机号码:");
	private JLabel ofcphoneLabel = new JLabel("办公电话:");
	private JLabel shortphoneLabel = new JLabel("短号:");
	private JLabel otherphoneLabel = new JLabel("其他电话:");
	private JLabel faxLabel = new JLabel("传真号码:");
	private JLabel emailLabel = new JLabel("电子邮箱:");
	private JLabel addrLabel = new JLabel("联系地址:");
	private JLabel titleLabel = new JLabel("职务:");
	private JLabel deptIdLabel = new JLabel("归属部门ID:");
	private JLabel userLevelLabel = new JLabel("帐号级别ID:");
	private JLabel roleIdLabel = new JLabel("帐号角色ID:");
	private JLabel otherphone2Label = new JLabel("其他电话号码2:");
	private JLabel zipLabel = new JLabel("邮编号码:");
	private JLabel staffNumLabel = new JLabel("员工工号:");
	private JLabel userStateLabel = new JLabel("用户状态:");
	private JLabel notesMailLabel = new JLabel("Notes邮箱:");
	private JLabel birthdayLabel = new JLabel("生日日期:");
	private JLabel desLabel = new JLabel("备注:");
	private JLabel websiteLabel = new JLabel("个人主页:");
	private JLabel resultLabel = new JLabel("返回内容：");
	
	private JLabel errInfoLabel = new JLabel();

	private JTextArea retDescArea = new JTextArea(20, 40);
	private JTextField urlField = new JTextField(26);
	private JTextField userfield = new JTextField(10);
	private JPasswordField pwdField = new JPasswordField(10);
	private JTextField userIdfield = new JTextField(10);
	private JTextField actTypeField = new JTextField(10);
	private JTextField loginNamField = new JTextField(10);
	private JPasswordField loginpwdField = new JPasswordField(10);
	private JTextField nameField = new JTextField(10);
	private JTextField sexIdField = new JTextField(10);
	private JTextField homephoneField = new JTextField(10);
	private JTextField callphoneField = new JTextField(10);
	private JTextField ofcphoneField = new JTextField(10);
	private JTextField shortphoneField = new JTextField(10);
	private JTextField otherphoneField = new JTextField(10);
	private JTextField faxField = new JTextField(10);
	private JTextField emailField = new JTextField(10);
	private JTextField addrField = new JTextField(10);
	private JTextField titleField = new JTextField(10);
	private JTextField deptIdField = new JTextField(10);
	private JTextField userLevelField = new JTextField(10);
	private JTextField roleIdField = new JTextField(10);
	private JTextField otherphone2Field = new JTextField(10);
	private JTextField zipField = new JTextField(10);
	private JTextField staffNumField = new JTextField(10);
	private JTextField userStateField = new JTextField(10);
	private JTextField notesMailField = new JTextField(10);
	private JTextField birthdayField = new JTextField(10);
	private JTextField desField = new JTextField(10);
	private JTextField websiteField = new JTextField(10);
	
	private JButton add = new MyButton("添加");
	private JButton cancel = new MyButton("清空");
	private int timerCount = 0;

	// 获取服务句柄 
    private UserProfileServiceEx userProfileServiceEx = ServiceFactoryEx.getService(UserProfileServiceEx.class); 
    
	AddAcctDtlPanel() {
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
		buildPanel(panel, gridbag, c, new JComponent[] { urlField }, 1, 1, 10, 20, 3, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userLabel }, 0, 2, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userfield }, 1, 2, 6, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pwdLabel }, 2, 2, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pwdField }, 3, 2, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { userIdLabel }, 0, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userIdfield }, 1, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { actTypeLabel }, 2, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { actTypeField }, 3, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { loginNamLabel }, 4, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { loginNamField }, 5, 3, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { pwsLabel }, 0, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { loginpwdField }, 1, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { nameLabel }, 2, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { nameField }, 3, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { sexLabel }, 4, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { sexIdField }, 5, 4, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { homephoneLabel }, 0, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { homephoneField }, 1, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { callphoneLabel }, 2, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { callphoneField }, 3, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { ofcphoneLabel }, 4, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { ofcphoneField }, 5, 5, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { shortphoneLabel }, 0, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { shortphoneField }, 1, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { otherphoneLabel }, 2, 6, 6, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { otherphoneField }, 3, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { faxLabel }, 4, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { faxField }, 5, 6, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { emailLabel }, 0, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { emailField }, 1, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { addrLabel }, 2, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { addrField }, 3, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { titleLabel }, 4, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { titleField }, 5, 7, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { deptIdLabel }, 0, 8, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { deptIdField }, 1, 8, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userLevelLabel }, 2, 8, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userLevelField }, 3, 8, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { roleIdLabel }, 4, 8, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { roleIdField }, 5, 8, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { otherphone2Label }, 0, 9, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { otherphone2Field }, 1, 9, 10, 20, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { zipLabel }, 2, 9, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { zipField }, 3, 9, 10, 20, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { staffNumLabel }, 4, 9, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { staffNumField }, 5, 9, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { userStateLabel }, 0, 10, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userStateField }, 1, 10, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { notesMailLabel }, 2, 10, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { notesMailField }, 3, 10, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { birthdayLabel }, 4, 10, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { birthdayField }, 5, 10, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { desLabel }, 0, 11, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { desField }, 1, 11, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { websiteLabel }, 2, 11, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { websiteField }, 3, 11, 10, 20, 1, 1);		

		buildPanel(panel, gridbag, c, new JComponent[] { add }, 2, 12, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { cancel }, 3, 12, 10, 20, 1, 1);
		cancel.addActionListener(this);
		buildPanel(panel, gridbag, c, new JComponent[] { resultLabel }, 7, 0, 460, 5, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { errInfoLabel }, 2, 13, 100, 5, 6, 1);
//		retDescArea.setLineWrap(true);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		retDescArea.setBorder(BorderFactory.createTitledBorder(""));
		retDescArea.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
		buildPanel(panel, gridbag, c, new JComponent[] { jsp }, 7, 1, 150, 200, 1, 13);

		return panel;

	}

	private void buildPanel(JPanel panel, GridBagLayout gridbag, GridBagConstraints c, JComponent[] components,
			int gridx, int gridy, int ipadx, int ipady, int gridwidth, int gridheight) {
		JPanel subPanel = new JPanel();

		for (JComponent component : components) {
			component.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
			subPanel.add(component);
		}

		c.fill = GridBagConstraints.VERTICAL;// 加高组件直到他足以在垂直方向上填满其显示区域，但不更改其高度
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

		// 增加部门
		this.add.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");

				boolean flag = validateParams(
						new JTextField[] { userIdfield,actTypeField, loginNamField, loginpwdField, nameField, deptIdField,
								userLevelField, roleIdField },
						new String[] { "操作用户ID","帐号类型", "登录名", "登录密码", "用户姓名", "归属部门ID", "帐号级别ID", "帐号角色ID" });

				if (!flag) {
					return;
				}
				
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						addAcct();

					}
				}).start();
			}
		});
		

		
	}

	private void addAcct() {
		AddAccountRequest accountInfo = new AddAccountRequest();
		accountInfo.setUserId(userIdfield.getText());
		Account acct = new Account();
		accountInfo.setAccount(acct);
		
		acct.setAccountType(actTypeField.getText());
		acct.setLoginName(loginNamField.getText());
		acct.setPassword(String.valueOf(loginpwdField.getPassword()));
		acct.setName(nameField.getText());
		acct.setSex(sexIdField.getText());
		acct.setHomePhone(homephoneField.getText());
		acct.setCellPhone(callphoneField.getText());
		acct.setOfficePhone(ofcphoneField.getText());
		acct.setShortPhone(shortphoneField.getText());
		acct.setOtherPhone(otherphoneField.getText());
		acct.setFax(faxField.getText());
		acct.setEmail(emailField.getText());
		acct.setAddr(addrField.getText());
		acct.setTitle(titleField.getText());
		acct.setDepartmentId(deptIdField.getText());
		acct.setUserLevel(userLevelField.getText());
		acct.setRoleId(roleIdField.getText());
		acct.setOtherphone2(otherphone2Field.getText());
		acct.setZip(zipField.getText());
		acct.setStaffNum(staffNumField.getText());
		acct.setUserState(userStateField.getText());
		acct.setNotesMail(notesMailField.getText());
		acct.setBirthday(birthdayField.getText());
		acct.setDes(desField.getText());
		acct.setWebsite(websiteField.getText());
		
    	//调用userProfileServiceEx服务中的addAccount方法，返回错误码
    	RestResponse<String> reponse = userProfileServiceEx.addAccount(accountInfo);
    	finish();
    	
    	String retDesc = "{\n" +"  \"result\":"+"\""+reponse.getResult()+"\""+"\n"
    						+"  \"resultCode\":"+"\""+reponse.getResultCode()+"\""+"\n"
    						+"  \"resultContest\":"+"\""+reponse.getResultContext()+"\""+"\n"
    					+"}";
    	retDescArea.setText(retDesc);
    	
//    	retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
    	
    	
    	
 		if("401".equals(reponse.getResultCode()))
 		{
 			//鉴权失败
 			showErrInfoWithColor("操作失败");
 		}
 		else if("1".equals(reponse.getResultCode()))
 		{
 			//操作失败，可能由于网络原因
 			showErrInfoWithColor("操作失败");
 		}
 		else
 		{
 			//操作成功
 			if("0".equals(reponse.getResultCode())){
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
		System.out.println("validateParams方法");
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
		actTypeField.setText("");
		loginNamField.setText("");
		loginpwdField.setText("");
		nameField.setText("");
		sexIdField.setText("");
		homephoneField.setText("");
		callphoneField.setText("");
		ofcphoneField.setText("");
		shortphoneField.setText("");
		otherphoneField.setText("");
		faxField.setText("");
		emailField.setText("");
		addrField.setText("");
		titleField.setText("");
		deptIdField.setText("");
		userLevelField.setText("");
		roleIdField.setText("");
		otherphone2Field.setText("");
		zipField.setText("");
		staffNumField.setText("");
		userStateField.setText("");
		notesMailField.setText("");
		birthdayField.setText("");
		desField.setText("");
		websiteField.setText("");
	}

}
