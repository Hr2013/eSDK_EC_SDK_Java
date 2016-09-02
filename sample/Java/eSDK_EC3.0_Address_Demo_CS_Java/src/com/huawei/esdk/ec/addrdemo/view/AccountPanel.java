package com.huawei.esdk.ec.addrdemo.view;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.border.TitledBorder;

import com.google.gson.Gson;
import com.huawei.esdk.ec.addrdemo.bean.Account;
import com.huawei.esdk.ec.addrdemo.bean.AddAccountRequest;
import com.huawei.esdk.ec.addrdemo.bean.Department;
import com.huawei.esdk.ec.addrdemo.bean.DepartmentResponse;
import com.huawei.esdk.ec.addrdemo.bean.addAccountResponse;
import com.huawei.esdk.ec.addrdemo.constant.UCConstant;
import com.huawei.esdk.ec.addrdemo.js.MyButton;
import com.huawei.esdk.ec.addrdemo.model.RestRequestMessage;
import com.huawei.esdk.ec.addrdemo.model.RestResponse;
import com.huawei.esdk.ec.addrdemo.util.PropertiesUtils;
import com.huawei.esdk.ec.addrdemo.util.RestUtils;
import com.huawei.esdk.ec.addrdemo.util.StringUtils;


public class AccountPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = -8285213367222038440L;
	private static final String REST_URL = PropertiesUtils.getValue("rest.url");
	private static String userName;
	private static String password;
	private JLabel requestLabel = new JLabel("请求参数:");
	private JLabel urlLabel = new JLabel("  eSDK URL：");
	private JLabel userLabel = new JLabel("  用 户 名：");
	private JLabel pwdLabel = new JLabel("    密   码：");
	private JLabel userIdLabel = new JLabel("操作用户ID：");
	private JLabel accountIdLabel = new JLabel("帐号ID：");
	private JLabel searchLabel = new JLabel("是否精确查询：");
	private JLabel conditionLabel = new JLabel("查询条件：");
	private JLabel pageCountLabel = new JLabel("每页显示数：");
	private JLabel pageNumLabel = new JLabel("当前分页：");
	private JLabel binNumLabel = new JLabel("绑定的号码：");
	private JLabel resultLabel = new JLabel("返回内容：");

	private JLabel errInfoLabel = new JLabel();
	private JTextField urlField = new JTextField(26);
	private JTextField userfield = new JTextField(10);
	private JPasswordField pwdField = new JPasswordField(10);
	private JTextField userIdfield = new JTextField(10);
	private JTextField acctIdfield = new JTextField(10);
	private JTextField exactSecfield = new JTextField(10);
	private JTextField conditionfield = new JTextField(10);
	private JTextField pageCountfield = new JTextField(10);
	private JTextField pageNumfield = new JTextField(10);
	private JTextField binNumfield = new JTextField(10);

	private JTextArea retDescArea = new JTextArea(20, 40);

	// private JButton addAccount = new MyButton("添 加 账 号 ");
	private JButton AccountDtl = new MyButton("添 加 账 号 ");
	private JButton bindNum = new MyButton("绑 定 号 码 ");
	// private JButton batchAdd = new MyButton("批量添加账号");
	private JButton batchAddDtl = new MyButton("批量添加账号");
	private JButton searchAcct = new MyButton("查 询 账 号 ");
	private JButton deltAcct = new MyButton(" 删 除 账 号");
	private JButton batchdeltAcct = new MyButton("批量删除账号 ");
	private JButton modifyAcct = new MyButton("修 改 账 号 ");
	private JButton modifyPw = new MyButton("修 改 密 码 ");

	private int timerCount = 0;
	private JPanel jl;

	AccountPanel() {
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
		buildPanel(panel, gridbag, c, new JComponent[] { accountIdLabel }, 2, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { acctIdfield }, 3, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { searchLabel }, 0, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { exactSecfield }, 1, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { conditionLabel }, 2, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { conditionfield }, 3, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pageCountLabel }, 0, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pageCountfield }, 1, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pageNumLabel }, 2, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pageNumfield }, 3, 5, 10, 20, 1, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { binNumLabel }, 0, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { binNumfield }, 1, 6, 10, 20, 1, 1);

		// buildPanel(panel, gridbag, c, new JComponent[] { addAccount }, 0, 7,
		// 10, 20, 2, 1);
		// buildPanel(panel, gridbag, c, new JComponent[] { batchAdd }, 2, 7,
		// 10, 20, 2, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { AccountDtl }, 0, 8, 10, 20, 2, 1);
		AccountDtl.addActionListener(this);
		buildPanel(panel, gridbag, c, new JComponent[] { batchAddDtl }, 2, 8, 10, 20, 2, 1);
		batchAddDtl.addActionListener(this);
		buildPanel(panel, gridbag, c, new JComponent[] { bindNum }, 0, 9, 10, 20, 2, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { searchAcct }, 2, 9, 10, 20, 2, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { deltAcct }, 0, 10, 10, 20, 2, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { batchdeltAcct }, 2, 10, 10, 20, 2, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { modifyAcct }, 0, 11, 10, 20, 2, 1);
		modifyAcct.addActionListener(this);
		buildPanel(panel, gridbag, c, new JComponent[] { modifyPw }, 2, 11, 10, 20, 2, 1);
		modifyPw.addActionListener(this);
		buildPanel(panel, gridbag, c, new JComponent[] { resultLabel }, 4, 0, 150, 5, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { errInfoLabel }, 0, 12, 100, 5, 4, 1);
		// retDescArea.setLineWrap(true);
		retDescArea.setBorder(BorderFactory.createTitledBorder(""));
		retDescArea.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
		buildPanel(panel, gridbag, c, new JComponent[] { jsp }, 4, 1, 150, 250, 1, 11);
		/*
		 * panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.
		 * createLineBorder(new Color(220, 220, 220), 15), "账号管理",
		 * TitledBorder.CENTER, TitledBorder.TOP, new java.awt.Font("宋体",
		 * Font.BOLD, 20)));
		 */
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
		urlField.setText(REST_URL);
		userfield.setText(PropertiesUtils.getValue("username"));
		pwdField.setText(PropertiesUtils.getValue("password"));
		// 添加账号，发起POST请求

		this.bindNum.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");
				boolean flag = validateParams(
						new JTextField[] { urlField, userfield, pwdField, userIdfield, acctIdfield, binNumfield },
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "帐号ID", "绑定的号码" });

				if (!flag) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						bindNum();

					}
				}).start();
			}
		});

		this.searchAcct.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");

				boolean flag = validateParams(
						new JTextField[] { urlField, userfield, pwdField, userIdfield, exactSecfield, conditionfield,
								pageCountfield, pageNumfield },
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "是否精确查询", "查询条件", "每页显示数", "当前分页" });

				if (!flag) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						searchAccount();

					}
				}).start();
			}
		});

		this.deltAcct.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");

				boolean flag = validateParams(
						new JTextField[] { urlField, userfield, pwdField, userIdfield, acctIdfield },
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "帐号ID" });

				if (!flag) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						deltAccount();

					}
				}).start();
			}
		});

		this.batchdeltAcct.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");

				boolean flag = validateParams(
						new JTextField[] { urlField, userfield, pwdField, userIdfield, acctIdfield },
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "帐号ID" });

				if (!flag) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						batchDeltAcct();

					}
				}).start();
			}
		});

	}

	private void batchDeltAcct() {

		AddAccountRequest payload = new AddAccountRequest();
		// 拼装请求参数，发送请求
		List<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(acctIdfield.getText(), ",");
		while (st.hasMoreTokens()) {
			list.add("" + st.nextToken());
		}
		payload.setUserId(userIdfield.getText());
		payload.setAccountIds(list);
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
		try {
			// 获取发送Rest消息工具类实例，并传入请求参数、添加部门资源路径
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage,
					"/ec/bmu/batch_delete_account");
			finish();
			if (null == responsePayload) {
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值
				// 把JSON结果转换成JavaBean
				addAccountResponse response = new Gson().fromJson(responsePayload, addAccountResponse.class);
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

	private void bindNum() {
		AddAccountRequest payload = new AddAccountRequest();
		Account s = addAcct();
		payload.setUserId(userIdfield.getText());
		payload.setAccount(s);
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
		try {
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage, "/ec/bmu/bind_num");
			finish();
			if (null == responsePayload) {
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值

				addAccountResponse response = new Gson().fromJson(responsePayload, addAccountResponse.class);
				//acctIdfield.setText((String) response.getResult());
				if ("0".equals(response.getResultCode())) {
					showErrInfoWithColor("操作成功");
				} else {
					showErrInfoWithColor("操作失败");
				}
			}
			payload = null;
		} catch (Exception e) {
			finish();
			showErrInfoWithColor("操作失败");
		}

	}

	private void searchAccount() {
		// 拼装请求参数，发送请求
		Map<String, String> m = new HashMap<String, String>();
		m.put("userId", userIdfield.getText());
		m.put("exactSearch", exactSecfield.getText());
		m.put("condition", conditionfield.getText());
		m.put("pageCount", pageCountfield.getText());
		m.put("pageNum", pageNumfield.getText());
		System.out.print(m);
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setParameters(m);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_GET);
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
				addAccountResponse response = new Gson().fromJson(responsePayload, addAccountResponse.class);
				System.out.println(response.getResultCode());
				if ("0".equals(response.getResultCode())) {
					showErrInfoWithColor("操作成功");
				} else {
					showErrInfoWithColor("操作失败");
				}
			}
			m = null;
		} catch (Exception e) {
			finish();
			showErrInfoWithColor("操作失败");
		}
	}

	private void deltAccount() {
		// 拼装请求参数，发送请求
		Map<String, String> m = new HashMap<String, String>();
		m.put("userId", userIdfield.getText());
		m.put("accountId", acctIdfield.getText());
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setParameters(m);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_DELETE);
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
				addAccountResponse response = new Gson().fromJson(responsePayload, addAccountResponse.class);

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

	private Account addAcct() {
		Account acct = new Account();
		acct.setAccountId(acctIdfield.getText());
		acct.setBindNum(binNumfield.getText());
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("添加账号详情");// 构造一个新的JFrame，作为新窗口。
		frame.setBounds(// 让新窗口与原窗口示例错开50像素。
				new Rectangle((int) this.getBounds().getX() + 10, (int) this.getBounds().getY() + 10,
						(int) this.getBounds().getWidth(), (int) this.getBounds().getHeight()));
		jl = new addAcctDtlPanel();
		frame.getContentPane().add(jl);
		frame.setVisible(true);
	}

}
