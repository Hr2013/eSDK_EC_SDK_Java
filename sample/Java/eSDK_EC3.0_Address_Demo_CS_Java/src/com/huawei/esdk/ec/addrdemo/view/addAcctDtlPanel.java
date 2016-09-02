package com.huawei.esdk.ec.addrdemo.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.google.gson.Gson;
import com.huawei.esdk.ec.addrdemo.bean.Account;
import com.huawei.esdk.ec.addrdemo.bean.AddAccountRequest;
import com.huawei.esdk.ec.addrdemo.bean.addAccountResponse;
import com.huawei.esdk.ec.addrdemo.constant.UCConstant;
import com.huawei.esdk.ec.addrdemo.js.MyButton;
import com.huawei.esdk.ec.addrdemo.model.RestRequestMessage;
import com.huawei.esdk.ec.addrdemo.model.RestResponse;
import com.huawei.esdk.ec.addrdemo.util.PropertiesUtils;
import com.huawei.esdk.ec.addrdemo.util.RestUtils;
import com.huawei.esdk.ec.addrdemo.util.StringUtils;
import com.huawei.esdk.ec.addrdemo.utils.Encrypt;




public class addAcctDtlPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = -8285213367222038440L;
	private static final String REST_URL = PropertiesUtils.getValue("rest.url");
	private static String userName;
	private static String password;
	private JLabel urlLabel = new JLabel("  eSDK URL：");
	private JLabel userLabel = new JLabel("  用 户 名：");
	private JLabel pwdLabel = new JLabel("    密   码：");
	private JLabel userIdLabel = new JLabel("操作用户ID：");
	private JLabel requestLabel = new JLabel("请求参数:");
	private JLabel actTypeLabel = new JLabel("帐号类型:");
	private JLabel actIdLabel = new JLabel("帐号ID:");
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
	private JLabel oldPwdLabel = new JLabel("旧密码:");
	private JLabel newPwdLabel = new JLabel("新密码:");
	private JLabel errInfoLabel = new JLabel();
	private JLabel otherphone2Label = new JLabel("其他电话2:");
	private JLabel zipLabel = new JLabel("邮编号码:");
	private JLabel staffNumLabel = new JLabel("员工工号:");
	private JLabel foreignLabel = new JLabel("外文姓名:");
	private JLabel userstateLabel = new JLabel("用户状态:");
	private JLabel notesmailLabel = new JLabel("Notes邮箱:");
	private JLabel birthdayLabel = new JLabel("生日:");
	private JLabel desLabel = new JLabel("备注:");
	private JLabel websiteLabel = new JLabel("个人主页:");
	private JLabel qPinyinLabel = new JLabel("拼音全拼:");
	private JLabel jPinyinLabel = new JLabel("拼音简拼:");
	private JLabel descLabel = new JLabel("批量添加账号:每输入一组添加数据点击一次“账号累加”按钮，输入完成后点击“批量添加账号”按钮");
	
	
	private JTextField otherphone2field = new JTextField(10);
	private JTextField zipfield = new JTextField(10);
	private JTextField staffNumfield = new JTextField(10);
	private JTextField foreignfield = new JTextField(10);
	private JTextField userstatefield = new JTextField(10);
	private JTextField notesmailfield = new JTextField(10);
	private JTextField birthdayfield = new JTextField(10);
	private JTextField desfield = new JTextField(10);
	private JTextField websitefield = new JTextField(10);
	private JTextField qPinyinfield = new JTextField(10);
	private JTextField jPinyinfield = new JTextField(10);

	private JTextField urlField = new JTextField(26);
	private JTextField userfield = new JTextField(10);
	private JPasswordField pwdField = new JPasswordField(10);
	private JTextField userIdfield = new JTextField(10);
	private JTextField actTypeField = new JTextField(10);
	private JTextField loginNamField = new JTextField(10);
	private JPasswordField loginpwdField = new JPasswordField(10);
	private JTextField namefield = new JTextField(10);
	private JTextField sexIdfield = new JTextField(10);
	private JTextField homephonefield = new JTextField(10);
	private JTextField callphonefield = new JTextField(10);
	private JTextField ofcphonefield = new JTextField(10);
	private JTextField shortphonefield = new JTextField(10);
	private JTextField otherphonefield = new JTextField(10);
	private JTextField faxfield = new JTextField(10);
	private JTextField emailfield = new JTextField(10);
	private JTextField addrfield = new JTextField(10);
	private JTextField titlefield = new JTextField(10);
	private JTextField deptIdfield = new JTextField(10);
	private JTextField userLevelfield = new JTextField(10);
	private JTextField roleIdfield = new JTextField(10);
	private JTextField actIdfield = new JTextField(10);
	private JPasswordField oldPwdField = new JPasswordField(10);
	private JPasswordField newPwdField = new JPasswordField(10);
	private JLabel resultLabel = new JLabel("返回内容：");
	private JButton add = new MyButton("添加账号");
	private JButton addcont = new MyButton("账号累加");
	private JButton batchAddTo = new MyButton("批量添加账号");
	private JButton modifyAcctTo = new MyButton("修改账号");
	private JButton modifyPwdTo = new MyButton("修改密码");
	private JButton cancel = new MyButton("清空");
	private JTextArea retDescArea = new JTextArea(20, 40);
	private int timerCount = 0;
	private JPanel jl;

	addAcctDtlPanel() {
		add(getPanels());
		init();
	}

	private JPanel getPanels() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		JPanel panel = new JPanel(gridbag);
		JScrollPane jsp = new JScrollPane(retDescArea);
		buildPanel(panel, gridbag, c, new JComponent[] { requestLabel }, 0, 0, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { urlLabel }, 0, 1, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { urlField }, 1, 1, 10, 20, 3, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userLabel }, 0, 2, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userfield }, 1, 2, 6, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pwdLabel }, 2, 2, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pwdField }, 3, 2, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userIdLabel }, 4, 2, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userIdfield }, 5, 2, 10, 20, 1, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { actTypeLabel }, 0, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { actTypeField }, 1, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { loginNamLabel }, 2, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { loginNamField }, 3, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pwsLabel }, 4, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { loginpwdField }, 5, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { nameLabel }, 0, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { namefield }, 1, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { sexLabel }, 2, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { sexIdfield }, 3, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { homephoneLabel }, 4, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { homephonefield }, 5, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { callphoneLabel }, 0, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { callphonefield }, 1, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { ofcphoneLabel }, 2, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { ofcphonefield }, 3, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { shortphoneLabel }, 4, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { shortphonefield }, 5, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { otherphoneLabel }, 0, 6, 6, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { otherphonefield }, 1, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { faxLabel }, 2, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { faxfield }, 3, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { emailLabel }, 4, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { emailfield }, 5, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { addrLabel }, 0, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { addrfield }, 1, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { titleLabel }, 2, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { titlefield }, 3, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { deptIdLabel }, 4, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { deptIdfield }, 5, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userLevelLabel }, 0, 8, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userLevelfield }, 1, 8, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { roleIdLabel }, 2, 8, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { roleIdfield }, 3, 8, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { actIdLabel }, 4, 8, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { actIdfield }, 5, 8, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { oldPwdLabel }, 0, 9, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { oldPwdField }, 1, 9, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { newPwdLabel }, 2, 9, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { newPwdField }, 3, 9, 10, 20, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { otherphone2Label }, 4, 9, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { otherphone2field }, 5, 9, 10, 20, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { zipLabel }, 0, 10, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { zipfield }, 1, 10, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { staffNumLabel }, 2, 10, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { staffNumfield }, 3, 10, 10, 20, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { foreignLabel }, 4, 10, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { foreignfield }, 5, 10, 10, 20, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { userstateLabel }, 0, 11, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userstatefield }, 1, 11, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { notesmailLabel }, 2, 11, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { notesmailfield }, 3, 11, 10, 20, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { birthdayLabel }, 4, 11, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { birthdayfield }, 5, 11, 10, 20, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { desLabel }, 0, 12, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { desfield }, 1, 12, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { websiteLabel }, 2, 12, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { websitefield }, 3, 12, 10, 20, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { qPinyinLabel }, 4, 12, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { qPinyinfield }, 5, 12, 10, 20, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { jPinyinLabel }, 0, 13, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { jPinyinfield }, 1, 13, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { add }, 0, 14, 10, 20, 2, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { addcont }, 2, 14, 10, 20, 2, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { batchAddTo }, 4, 14, 10, 20, 2, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { modifyAcctTo }, 0, 15, 10, 20, 2, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { modifyPwdTo }, 2, 15, 10, 20, 2, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { cancel }, 4, 15, 10, 20, 2, 1);
		cancel.addActionListener(this);
		buildPanel(panel, gridbag, c, new JComponent[] { resultLabel }, 6, 0, 150, 5, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { errInfoLabel }, 6, 14, 10, 20, 5, 1);
		descLabel.setForeground(Color.blue);
		buildPanel(panel, gridbag, c, new JComponent[] { descLabel }, 0, 16, 10, 20, 10, 1);
		// panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new
		// Color(220, 220, 220), 15),
		// "添加账号详情", TitledBorder.CENTER, TitledBorder.TOP, new
		// java.awt.Font("宋体", Font.BOLD, 20)));
		urlField.setText(REST_URL);
		userfield.setText(PropertiesUtils.getValue("username"));
		pwdField.setText(PropertiesUtils.getValue("password"));
		// retDescArea.setLineWrap(true);
		retDescArea.setBorder(BorderFactory.createTitledBorder(""));
		retDescArea.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
		buildPanel(panel, gridbag, c, new JComponent[] { jsp }, 6, 1, 100, 200, 1, 13);
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

		// 增加部门，发起POST请求
		this.add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");
				boolean flag = validateParams(
						new JTextField[] { urlField, userfield, pwdField, userIdfield, actTypeField, loginNamField,
								loginpwdField, namefield, deptIdfield, userLevelfield, roleIdfield },
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "帐号类型", "登录名", "登录密码", "用户姓名", "归属部门ID",
								"帐号级别ID", "帐号角色ID" });

				if (!flag) {
					return;
				}
				begin();
				loading();
				new Thread(new Runnable() {
					@Override
					public void run() {
						// accounts.add(addAcct());
						addAccount();
					}

				}).start();
				/*
				 * Component cmp = e.getComponent(); while (!(cmp instanceof
				 * JFrame) || cmp.getParent() != null) { cmp = cmp.getParent();
				 * } ((JFrame) cmp).dispose();
				 */
			}
		});

		this.addcont.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				boolean flag = validateParams(
						new JTextField[] { actTypeField, loginNamField, loginpwdField, namefield, deptIdfield,
								userLevelfield, roleIdfield },
						new String[] { "帐号类型", "登录名", "登录密码", "用户姓名", "归属部门ID", "帐号级别ID", "帐号角色ID" });

				if (!flag) {
					return;
				}

				new Thread(new Runnable() {
					@Override
					public void run() {
						accounts.add(addAcct());
					}
				}).start();
			}
		});

		this.batchAddTo.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");

				boolean flag = validateParams(new JTextField[] { urlField, userfield, pwdField, userIdfield },
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID" });

				if (!flag) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						batchAddAcct();

					}
				}).start();

			}
		});

		this.modifyPwdTo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				boolean flag = validateParams(
						new JTextField[] { urlField, userfield, pwdField, userIdfield, actIdfield, loginNamField,
								oldPwdField, newPwdField },
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "账号ID", "登录名", "旧密码", "新密码" });

				if (!flag) {
					return;
				}
				begin();
				loading();
				new Thread(new Runnable() {
					@Override
					public void run() {
						modifyPwd();
					}
				}).start();

			}
		});

		this.modifyAcctTo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				boolean flag = validateParams(
						new JTextField[] { urlField, userfield, pwdField, userIdfield, actTypeField, namefield,
								deptIdfield, actIdfield, userLevelfield, roleIdfield },
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "帐号类型", "用户姓名", "归属部门ID", "账号ID", "帐号级别ID",
								"帐号角色ID" });

				if (!flag) {
					return;
				}
				begin();
				loading();
				new Thread(new Runnable() {
					@Override
					public void run() {
						// accounts.add(addAcct());
						modifyAcct();
					}
				}).start();
			}
		});
	}

	// 批量添加List<Account>
	private List<Account> accounts = new ArrayList<Account>();

	private Account account = null;

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account getAccount() {
		return account;
	}
	//添加账号
	private void addAccount() {
		addAccountResponse response;
		 int resp = com.huawei.esdk.ec.addrdemo.utils.KeyManagerUtils.initTransmissionMode();
	        if(0 != resp)
	        {
//	            RestResponse<String> res = new RestResponse<String>();
//	            res.setResult(String.valueOf(resp));
//	            return res;
	        	retDescArea.setText( String.valueOf(resp));
	            return;
	        }		
		AddAccountRequest payload = new AddAccountRequest();
		payload.setUserId(userIdfield.getText());
		payload.setAccount(addAcct());
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);

		try {
			// 获取发送Rest消息工具类实例，并传入请求参数、添加部门资源路径
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage, "/ec/bmu/account");
			finish();
			if (null == responsePayload) {
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值
				// 把JSON结果转换成JavaBean
				response = new Gson().fromJson(responsePayload, addAccountResponse.class);
				actIdfield.setText((String) response.getResult());
				if ("0".equals(response.getResultCode())) {
					showErrInfoWithColor("操作成功");
				} else {
					showErrInfoWithColor("操作失败");
				}
			}
		} catch (Exception e) {
			finish();
			showErrInfoWithColor("操作失败");
		}
	}
	//批量添加账号
	private void batchAddAcct() {
		addAccountResponse response;
		 int resp = com.huawei.esdk.ec.addrdemo.utils.KeyManagerUtils.initTransmissionMode();
	        if(0 != resp)
	        {
	        	retDescArea.setText( String.valueOf(resp));
	            return;
	        }	
		AddAccountRequest payload = new AddAccountRequest();
		payload.setUserId(userIdfield.getText());
		payload.setAccounts(getAccounts());
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
		try {
			// 获取发送Rest消息工具类实例，并传入请求参数、添加部门资源路径
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage,
					"/ec/bmu/batch_add_account");
			finish();
			if (null == responsePayload) {
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值
				// 把JSON结果转换成JavaBean
				response = new Gson().fromJson(responsePayload, addAccountResponse.class);
				if ("0".equals(response.getResultCode())) {
					showErrInfoWithColor("操作成功");
				} else {
					showErrInfoWithColor("操作失败");
				}
			}
			accounts.clear();
			actionPerformed(null);
		} catch (Exception e) {
			finish();
			showErrInfoWithColor("操作失败");
		}
	
	}
	//修改密码
	private void modifyPwd() {
		addAccountResponse response;
		 int resp = com.huawei.esdk.ec.addrdemo.utils.KeyManagerUtils.initTransmissionMode();
	        if(0 != resp)
	        {
	        	retDescArea.setText( String.valueOf(resp));
	            return;
	        }	
		AddAccountRequest payload = new AddAccountRequest();
		payload.setUserId(userIdfield.getText());
		payload.setAccount(addAcct());
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_PUT);
		try {
			// 获取发送Rest消息工具类实例，并传入请求参数、添加部门资源路径
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage,
					"/ec/bmu/modify_accountpassword");
			finish();
			if (null == responsePayload) {
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值
				// 把JSON结果转换成JavaBean
				response = new Gson().fromJson(responsePayload, addAccountResponse.class);
				// acctIdfield.setText((String) response.getResult());

				if ("0".equals(response.getResultCode())) {
					showErrInfoWithColor("操作成功");
				} else {
					showErrInfoWithColor("操作失败");
				}
			}
		} catch (Exception e) {
			finish();
			showErrInfoWithColor("操作失败");
		}
	}
	//修改账号
	private void modifyAcct() {
		addAccountResponse response;
		AddAccountRequest payload = new AddAccountRequest();
		payload.setUserId(userIdfield.getText());
		payload.setAccount(addAcct());
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_PUT);
		try {
			// 获取发送Rest消息工具类实例，并传入请求参数、添加部门资源路径
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage, "/ec/bmu/account");
			finish();
			if (null == responsePayload) {
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值
				// 把JSON结果转换成JavaBean
				response = new Gson().fromJson(responsePayload, addAccountResponse.class);
				// acctIdfield.setText((String) response.getResult());
				if ("0".equals(response.getResultCode())) {
					showErrInfoWithColor("操作成功");
				} else {
					showErrInfoWithColor("操作失败");
				}
			}
			jl = null;
		} catch (Exception e) {
			finish();
			showErrInfoWithColor("操作失败");
		}
	}

	private Account addAcct() {
		
		Account acct = new Account();
		acct.setAccountType(actTypeField.getText());
		acct.setAccountId(actIdfield.getText());
		acct.setLoginName(loginNamField.getText());
		try {
			acct.setPassword(Encrypt.getEncryptPwd(String.valueOf(loginpwdField.getPassword())));
			acct.setOldPassword(Encrypt.getEncryptPwd(String.valueOf(oldPwdField.getPassword())));
			acct.setNewPassword(Encrypt.getEncryptPwd((String.valueOf(newPwdField.getPassword()))));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		acct.setName(namefield.getText());
		acct.setSex(sexIdfield.getText());
		acct.setHomePhone(homephonefield.getText());
		acct.setCellPhone(callphonefield.getText());
		acct.setOfficePhone(ofcphonefield.getText());
		acct.setShortPhone(shortphonefield.getText());
		acct.setOtherPhone(otherphonefield.getText());
		acct.setFax(faxfield.getText());
		acct.setEmail(emailfield.getText());
		acct.setAddr(addrfield.getText());
		acct.setTitle(titlefield.getText());
		acct.setDepartmentId(deptIdfield.getText());
		acct.setUserLevel(userLevelfield.getText());
		acct.setRoleId(roleIdfield.getText());
		acct.setOtherphone2(otherphone2field.getText());
		acct.setZip(zipfield.getText());
		acct.setStaffNum(staffNumfield.getText());
		acct.setForeignName(foreignfield.getText());
		acct.setUserState(userstatefield.getText());
		acct.setNotesMail(notesmailfield.getText());
		acct.setBirthday(birthdayfield.getText());
		acct.setDes(desfield.getText());
		acct.setWebsite(websitefield.getText());
		acct.setqPinyin(qPinyinfield.getText());
		acct.setjPinyin(jPinyinfield.getText());
/*		acct.setOldPassword(String.valueOf(oldPwdField.getPassword()));
		acct.setNewPassword(String.valueOf(newPwdField.getPassword()));*/
		return acct;
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
		System.out.println("22222222222222222");
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		userIdfield.setText("");
		actTypeField.setText("");
		loginNamField.setText("");
		loginpwdField.setText("");
		namefield.setText("");
		sexIdfield.setText("");
		homephonefield.setText("");
		callphonefield.setText("");
		ofcphonefield.setText("");
		shortphonefield.setText("");
		otherphonefield.setText("");
		faxfield.setText("");
		emailfield.setText("");
		addrfield.setText("");
		titlefield.setText("");
		deptIdfield.setText("");
		userLevelfield.setText("");
		roleIdfield.setText("");
		actIdfield.setText("");
		oldPwdField.setText("");
		newPwdField.setText("");		
		otherphone2field.setText("");
		zipfield.setText("");
		staffNumfield.setText("");
		foreignfield.setText("");
		userstatefield.setText("");
		notesmailfield.setText("");
		birthdayfield.setText("");
		desfield.setText("");
		websitefield.setText("");
		qPinyinfield.setText("");
		jPinyinfield.setText("");

	}

}
