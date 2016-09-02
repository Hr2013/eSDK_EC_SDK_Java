package com.huawei.esdk.ec.addrdemo.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
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
import com.huawei.esdk.ec.addrdemo.bean.AddSipResponse;
import com.huawei.esdk.ec.addrdemo.bean.SIPAccount;
import com.huawei.esdk.ec.addrdemo.bean.SIPAuth;
import com.huawei.esdk.ec.addrdemo.bean.USMSip;

import com.huawei.esdk.ec.addrdemo.bean.addSipAccountRequest;
import com.huawei.esdk.ec.addrdemo.constant.UCConstant;
import com.huawei.esdk.ec.addrdemo.js.MyButton;
import com.huawei.esdk.ec.addrdemo.model.RestRequestMessage;
import com.huawei.esdk.ec.addrdemo.model.RestResponse;
import com.huawei.esdk.ec.addrdemo.util.PropertiesUtils;
import com.huawei.esdk.ec.addrdemo.util.RestUtils;
import com.huawei.esdk.ec.addrdemo.util.StringUtils;
import com.huawei.esdk.ec.addrdemo.utils.Encrypt;


public class addSipDtlPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = -8285213367222038440L;
	private static final String REST_URL = PropertiesUtils.getValue("rest.url");
	private static String userName;
	private static String password;
	private JLabel urlLabel = new JLabel("  eSDK URL：");
	private JLabel userLabel = new JLabel("  用 户 名：");
	private JLabel pwdLabel = new JLabel("    密   码：");
	private JLabel userIdLabel = new JLabel("操作用户ID：");
	private JLabel numStepLabel = new JLabel("号码步长：");
	private JLabel amountLabel = new JLabel("号码总数：");
	private JLabel ueStepLabel = new JLabel("设备步长：");
	private JLabel requestLabel = new JLabel("SIP号码详情:");
	private JLabel gwIpLabel = new JLabel("网关IP:");
	private JLabel subPbxLabel = new JLabel("虚拟PBX的ID:");
	private JLabel localGwIpLabel = new JLabel("本地网关IP的ID:");
	private JLabel jointLabel = new JLabel("是否联动:");
	private JLabel sipUeLabel = new JLabel("SIP设备标识:");
	private JLabel ueTypeLabel = new JLabel("设备类型:");
	private JLabel numberLabel = new JLabel("SIP号码:");
	private JLabel longNumLabel = new JLabel("长号:");
	private JLabel rightLevelLabel = new JLabel("权限级别:");
	private JLabel addPrefixLabel = new JLabel("自动添加字冠:");
	private JLabel typeLabel = new JLabel("鉴权方式:");
	private JLabel passwordLabel = new JLabel("鉴权密码:");
	private JLabel ipLabel = new JLabel("鉴权IP:");
	private JLabel deltsipLabel = new JLabel("删除SipUe:");
	private JLabel errInfoLabel = new JLabel();
	private JLabel descLabel = new JLabel("批量删除号码:每输入一组删除数据点击一次“批量删除累加”按钮，输入完成后点击“批量删除号码”按钮");
	
	private JLabel boutLabel = new JLabel("基本呼出权限:");
	private JLabel coutLabel = new JLabel("自定义呼出权限:");
	private JLabel stationnameLabel = new JLabel("站点组名称:");
	private JLabel sipserveridLabel = new JLabel("注册服务器ID:");
	private JLabel localgwnameLabel = new JLabel("本地网关名称:");	
	private JLabel issynclocalLabel = new JLabel("同步本地网关:");
	private JLabel sourcecodeLabel = new JLabel("呼叫源码:");
	private JLabel mrgroupnameLabel = new JLabel("媒体资源组名称:");
	private JLabel crgnameLabel = new JLabel("权限组名称:");
	private JLabel domainnameLabel = new JLabel("VoIP域名称:");
	
	private JTextField boutfield = new JTextField(10);
	private JTextField coutField = new JTextField(10);
	private JTextField stationnamefield = new JTextField(10);
	private JTextField sipserveridfield = new JTextField(10);
	private JTextField localgwnamefield = new JTextField(10);
	private JTextField issynclocalfield = new JTextField(10);
	private JTextField sourcecodefield = new JTextField(10);
	private JTextField mrgroupnamefield = new JTextField(10);
	private JTextField crgnamefield = new JTextField(10);
	private JTextField domainnamefield = new JTextField(10);
	
	private JTextField urlField = new JTextField(26);
	private JTextField userfield = new JTextField(10);
	private JPasswordField pwdField = new JPasswordField(10);
	private JTextField userIdfield = new JTextField(10);
	private JTextField numStepfield = new JTextField(10);
	private JTextField amountfield = new JTextField(10);
	private JTextField ueStepfield = new JTextField(10);
	private JTextField gwIpfield = new JTextField(15);
	private JTextField subPbxfield = new JTextField(10);
	private JTextField localGwIpfield = new JTextField(10);
	private JTextField jointfield = new JTextField(10);
	private JTextField sipUefield = new JTextField(10);
	private JTextField ueTypefield = new JTextField(10);
	private JTextField numberfield = new JTextField(10);
	private JTextField longNumfield = new JTextField(10);
	private JTextField rightLevelfield = new JTextField(10);
	private JTextField addPrefixfield = new JTextField(10);
	private JTextField typefield = new JTextField(10);
	private JPasswordField passwordField = new JPasswordField(10);
	private JTextField ipfield = new JTextField(10);
	private JTextField deltsipfield = new JTextField(10);
	private JLabel oldPwdLabel = new JLabel("原鉴权密码:");
	private JPasswordField oldPwdField = new JPasswordField(10);
	private JLabel newPwdLabel = new JLabel("新鉴权密码:");
	private JPasswordField newPwdField = new JPasswordField(10);
	private JLabel oldIpLabel = new JLabel("原鉴权IP:");
	private JTextField oldIpfield = new JTextField(10);
	private JLabel newIpLabel = new JLabel("新鉴权IP:");
	private JTextField newIpfield = new JTextField(10);
	private JTextArea retDescArea = new JTextArea(20, 40);
	private JLabel resultLabel = new JLabel("返回内容：");
	private JButton add = new MyButton("添加SIP号码");
	private JButton batchAdd = new MyButton("  批量添加号码  ");
	private JButton deltSip = new MyButton("删除SIP号码");
	private JButton batchdeltSip = new MyButton("批量删除号码");
	private JButton modifySip = new MyButton("修改SIP号码");
	private JButton modifyPwd = new MyButton("修改SIP密码");
	private JButton deltsipAdd = new MyButton("批量删除累加");
	private JButton cancel = new MyButton("清空");
	private int timerCount = 0;

	addSipDtlPanel() {
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
		buildPanel(panel, gridbag, c, new JComponent[] { urlField }, 1, 1, 10, 20, 5, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userLabel }, 0, 2, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userfield }, 1, 2, 6, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pwdLabel }, 2, 2, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pwdField }, 3, 2, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userIdLabel }, 4, 2, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { userIdfield }, 5, 2, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { numStepLabel }, 0, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { numStepfield }, 1, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { amountLabel }, 2, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { amountfield }, 3, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { ueStepLabel }, 4, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { ueStepfield }, 5, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { gwIpLabel }, 0, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { gwIpfield }, 1, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { subPbxLabel }, 2, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { subPbxfield }, 3, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { localGwIpLabel }, 4, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { localGwIpfield }, 5, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { jointLabel }, 0, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { jointfield }, 1, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { sipUeLabel }, 2, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { sipUefield }, 3, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { ueTypeLabel }, 4, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { ueTypefield }, 5, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { numberLabel }, 0, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { numberfield }, 1, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { longNumLabel }, 2, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { longNumfield }, 3, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { rightLevelLabel }, 4, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { rightLevelfield }, 5, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { addPrefixLabel }, 0, 7, 6, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { addPrefixfield }, 1, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { typeLabel }, 2, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { typefield }, 3, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { passwordLabel }, 4, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { passwordField }, 5, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { ipLabel }, 0, 8, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { ipfield }, 1, 8, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { deltsipLabel }, 2, 8, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { deltsipfield }, 3, 8, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { oldPwdLabel }, 4, 8, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { oldPwdField }, 5, 8, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { newPwdLabel }, 0, 9, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { newPwdField }, 1, 9, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { oldIpLabel }, 2, 9, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { oldIpfield }, 3, 9, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { newIpLabel }, 4, 9, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { newIpfield }, 5, 9, 10, 20, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { boutLabel }, 0, 10, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { boutfield }, 1, 10, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { coutLabel }, 2, 10, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { coutField }, 3, 10, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { stationnameLabel }, 4, 10, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { stationnamefield }, 5, 10, 10, 20, 1, 1);		
		buildPanel(panel, gridbag, c, new JComponent[] { sipserveridLabel }, 0, 11, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { sipserveridfield }, 1, 11, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { localgwnameLabel }, 2, 11, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { localgwnamefield }, 3, 11, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { issynclocalLabel }, 4, 11, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { issynclocalfield }, 5, 11, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { sourcecodeLabel }, 0, 12, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { sourcecodefield }, 1, 12, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { mrgroupnameLabel }, 2, 12, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { mrgroupnamefield }, 3, 12, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { crgnameLabel }, 4, 12, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { crgnamefield }, 5, 12, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { domainnameLabel }, 0, 13, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { domainnamefield }, 1, 13, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { add }, 1, 14, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { batchAdd }, 2, 14, 10, 20, 2, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { modifySip }, 4, 14, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { modifyPwd }, 5, 14, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { deltSip }, 1, 15, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { deltsipAdd }, 2, 15, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { batchdeltSip }, 4, 15, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { cancel }, 5, 15, 10, 20, 1, 1);
		cancel.addActionListener(this);
		buildPanel(panel, gridbag, c, new JComponent[] { resultLabel }, 6, 0, 150, 5, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { errInfoLabel }, 6, 14, 10, 20, 6, 1);
		descLabel.setForeground(Color.BLUE);
		buildPanel(panel, gridbag, c, new JComponent[] { descLabel }, 0, 16, 10, 20, 10, 1);
		urlField.setText(REST_URL);
		userfield.setText(PropertiesUtils.getValue("username"));
		pwdField.setText(PropertiesUtils.getValue("password"));

		// retDescArea.setLineWrap(true);
		retDescArea.setBorder(BorderFactory.createTitledBorder(""));
		retDescArea.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
		buildPanel(panel, gridbag, c, new JComponent[] { jsp }, 6, 1, 70, 200, 1, 14);
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

		// 增加sip，发起POST请求
		this.add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				boolean flag = validateParams(
						new JTextField[] { urlField, userfield, pwdField, userIdfield, gwIpfield,
								jointfield,sipUefield, ueTypefield, numberfield,  rightLevelfield,
								addPrefixfield, typefield },
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "网关IP","是否联动","SIP设备标识",  "设备类型",
								"SIP号码",  "权限级别", "是否自动添加字冠", "鉴权方式" });
				if (!flag) {
					return;
				}
				begin();
				loading();
				new Thread(new Runnable() {
					@Override
					public void run() {
						addSipAll();
					}
				}).start();
				/*
				 * //点击详情确认按钮当前窗口关闭 Component cmp= e.getComponent(); while(!(cmp
				 * instanceof JFrame ) || cmp.getParent() !=null ){ cmp =
				 * cmp.getParent(); } ((JFrame)cmp).dispose();
				 */

			}
		});

		this.batchAdd.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");
				boolean flag = validateParams(
						new JTextField[] { urlField, userfield, pwdField, userIdfield, numStepfield, amountfield,
								ueStepfield, gwIpfield, jointfield, sipUefield, ueTypefield, numberfield,
								rightLevelfield, addPrefixfield, typefield },
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "号码步长", "号码总数", "设备步长", "网关IP", 
								"是否联动", "SIP设备标识", "设备类型", "SIP号码",  "权限级别", "是否自动添加字冠", "是否鉴权" });

				if (!flag) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						batchAddSip();

					}
				}).start();
			}
		});

		this.deltsipAdd.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				boolean flag = validateParams(new JTextField[] { gwIpfield, numberfield, deltsipfield },
						new String[] { "网关IP", "SIP号码",  "删除SipUe" });
				if (!flag) {
					return;
				}

				new Thread(new Runnable() {
					@Override
					public void run() {
						accounts.add(deltSip());
					}
				}).start();

			}
		});

		this.batchdeltSip.addMouseListener(new MouseAdapter() {

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
						batchdeltSip();

					}
				}).start();
			}
		});

		this.deltSip.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				boolean flag = validateParams(
						new JTextField[] { urlField, userfield, pwdField, userIdfield, gwIpfield, numberfield,
								deltsipfield },
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "网关IP", "Sip号码", "删除SipUe" });
				if (!flag) {
					return;
				}
				begin();
				loading();
				new Thread(new Runnable() {
					@Override
					public void run() {
						deltSipAll();
					}
				}).start();

			}
		});

		this.modifySip.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				boolean flag = validateParams(
						new JTextField[] { urlField, userfield, pwdField, userIdfield, gwIpfield, 
								jointfield, sipUefield, ueTypefield, numberfield,rightLevelfield,
								addPrefixfield, typefield },
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "网关IP", "是否联动", "SIP设备标识", "设备类型",
								"SIP号码", "权限级别", "是否自动添加字冠", "是否鉴权" });

				if (!flag) {
					return;
				}
				begin();
				loading();
				new Thread(new Runnable() {
					@Override
					public void run() {
						modifySip();
					}
				}).start();

			}
		});

		this.modifyPwd.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				boolean flag = validateParams(
						new JTextField[] { urlField, userfield, pwdField, userIdfield, gwIpfield,
								sipUefield, typefield },
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "网关IP",  "SIP设备标识", "是否鉴权" });
				if (!flag) {
					return;
				}

				new Thread(new Runnable() {
					@Override
					public void run() {
						modifyPwdAll();
					}
				}).start();

			}
		});

	}

	// 批量添加List<SIPAccount>
	private List<SIPAccount> accounts = new ArrayList<SIPAccount>();

	private SIPAccount account = null;

	private SIPAccount deltAcct = null;

	private SIPAccount modifyPwdTo = null;

	public SIPAccount getModifyPwdTo() {
		return modifyPwdTo;
	}

	public List<SIPAccount> getAccounts() {
		return accounts;
	}

	public SIPAccount getDeltAcct() {
		return deltAcct;
	}

	public SIPAccount getAccount() {
		return account;
	}

	private void addSipAll() {
		AddSipResponse response;
		int resp = com.huawei.esdk.ec.addrdemo.utils.KeyManagerUtils.initTransmissionMode();
        if(0 != resp)
        {
        	retDescArea.setText( String.valueOf(resp));
            return;
        }	
		addSipAccountRequest payload = new addSipAccountRequest();
		payload.setUserId(userIdfield.getText());
		payload.setSip(addSip());
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
		try {
			// 获取发送Rest消息工具类实例，并传入请求参数、添加部门资源路径
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage,"/ec/bmu/sip");
			finish();
			if (null == responsePayload) {
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值
				// 把JSON结果转换成JavaBean
				response = new Gson().fromJson(responsePayload, AddSipResponse.class);
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

	private void batchAddSip() {
		
		AddSipResponse response;
		int resp = com.huawei.esdk.ec.addrdemo.utils.KeyManagerUtils.initTransmissionMode();
        if(0 != resp)
        {
        	retDescArea.setText( String.valueOf(resp));
            return;
        }
		addSipAccountRequest payload = new addSipAccountRequest();
		// 拼装请求参数，发送请求
		payload.setUserId(userIdfield.getText());
		payload.setNumStep(numStepfield.getText());
		payload.setAmount(amountfield.getText());
		payload.setUeStep(ueStepfield.getText());
		payload.setSip(addSip());
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
		try {
			// 获取发送Rest消息工具类实例，并传入请求参数、添加部门资源路径
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage, "/ec/bmu/batch_add_sip");
			finish();
			if (null == responsePayload) {
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值
				// 把JSON结果转换成JavaBean
				response = new Gson().fromJson(responsePayload, AddSipResponse.class);
				if ("0".equals(response.getResultCode())) {
					showErrInfoWithColor("操作成功");
				} else {
					showErrInfoWithColor("操作失败");
				}
			}
			accounts.clear();
		} catch (Exception e) {
			finish();
			showErrInfoWithColor("操作失败");
		}
	}
	//批量删除sip号码
	private void batchdeltSip() {
		// 拼装请求参数，发送请求
		addSipAccountRequest payload = new addSipAccountRequest();
		payload.setUserId(userIdfield.getText());
		payload.setSips(getAccounts());
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);

		try {
			// 获取发送Rest消息工具类实例，并传入请求参数、添加部门资源路径
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage,
					"/ec/bmu/sipcondition/batch_delete_sip");
			finish();
			if (null == responsePayload) {
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值
				// 把JSON结果转换成JavaBean
				AddSipResponse response = new Gson().fromJson(responsePayload, AddSipResponse.class);

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

	private SIPAccount addSip() {
		SIPAccount acct = new SIPAccount();
		acct.setGwIp(gwIpfield.getText());
		acct.setSubPbx(subPbxfield.getText());
		acct.setLocalGwIp(localGwIpfield.getText());
		acct.setJoint(jointfield.getText());
		acct.setSipUe(sipUefield.getText());
		acct.setUeType(ueTypefield.getText());
		acct.setNumber(numberfield.getText());
		acct.setLongNum(longNumfield.getText());
		acct.setRightLevel(rightLevelfield.getText());
		acct.setAddPrefix(addPrefixfield.getText());
		acct.setDeleteSipUe(deltsipfield.getText());
		acct.setbOutgoingRights(boutfield.getText());
		acct.setcOutgoingRights(coutField.getText());
		SIPAuth auth = new SIPAuth();
		auth.setType(typefield.getText());
		try {
			auth.setPassword(Encrypt.getEncryptPwd(String.valueOf(passwordField.getPassword())));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		auth.setIp(ipfield.getText());
		acct.setSipAuth(auth);		
		USMSip usm = new USMSip();
		usm.setStationGroupName(stationnamefield.getText());
		usm.setSipServerId(sipserveridfield.getText());
		usm.setLocalGwName(localgwnamefield.getText());
		usm.setIsSyncLocalGw(issynclocalfield.getText());
		usm.setSourceCode(sourcecodefield.getText());
		usm.setMrGroupName(mrgroupnamefield.getText());
		usm.setCrgName(crgnamefield.getText());
		usm.setDomainName(domainnamefield.getText());
		acct.setUsmSip(usm);

		return acct;
	}
	//删除sip号码
	private void deltSipAll() {
		// 拼装请求参数，发送请求
		addSipAccountRequest payload = new addSipAccountRequest();
		// 拼装请求参数，发送请求
		payload.setUserId(userIdfield.getText());
		payload.setSip(deltSip());
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
		try {
			// 获取发送Rest消息工具类实例，并传入请求参数、添加部门资源路径
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage,
					"/ec/bmu/sipcondition/delete_sip");
			finish();
			if (null == responsePayload) {
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值
				// 把JSON结果转换成JavaBean
				AddSipResponse response = new Gson().fromJson(responsePayload, AddSipResponse.class);

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
//修改sip号码
	private void modifySip() {
		AddSipResponse response;
		int resp = com.huawei.esdk.ec.addrdemo.utils.KeyManagerUtils.initTransmissionMode();
        if(0 != resp)
        {
        	retDescArea.setText( String.valueOf(resp));
            return;
        }
		addSipAccountRequest payload = new addSipAccountRequest();
		// 拼装请求参数，发送请求
		payload.setUserId(userIdfield.getText());
		payload.setSip(addSip());
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_PUT);
		try {
			// 获取发送Rest消息工具类实例，并传入请求参数、添加部门资源路径
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage, "/ec/bmu/sip");
			finish();
			if (null == responsePayload) {
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值
				// 把JSON结果转换成JavaBean
				response = new Gson().fromJson(responsePayload, AddSipResponse.class);

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

	private void modifyPwdAll() {
		AddSipResponse response;
		int resp = com.huawei.esdk.ec.addrdemo.utils.KeyManagerUtils.initTransmissionMode();
        if(0 != resp)
        {
        	retDescArea.setText( String.valueOf(resp));
            return;
        }
		addSipAccountRequest payload = new addSipAccountRequest();
		// 拼装请求参数，发送请求
		payload.setUserId(userIdfield.getText());
		payload.setSip(modifyPwd());
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_PUT);
		try {
			// 获取发送Rest消息工具类实例，并传入请求参数、添加部门资源路径
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage,
					"/ec/bmu/modify_sippassword");
			finish();
			if (null == responsePayload) {
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值
				// 把JSON结果转换成JavaBean
				response = new Gson().fromJson(responsePayload, AddSipResponse.class);

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
	private SIPAccount deltSip() {
		SIPAccount acct = new SIPAccount();
		acct.setGwIp(gwIpfield.getText());
		acct.setNumber(numberfield.getText());		
		acct.setDeleteSipUe(deltsipfield.getText());
		return acct;
	}
	private SIPAccount modifyPwd() {
		SIPAccount acct = new SIPAccount();
		acct.setGwIp(gwIpfield.getText());
		acct.setSubPbx(subPbxfield.getText());
		acct.setSipUe(sipUefield.getText());
		SIPAuth auth = new SIPAuth();
		auth.setType(typefield.getText());		
		try {
			auth.setOldPassword(Encrypt.getEncryptPwd(String.valueOf(oldPwdField.getPassword())));
			auth.setNewPassword(Encrypt.getEncryptPwd(String.valueOf(newPwdField.getPassword())));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		auth.setOldIp(oldIpfield.getText());
		auth.setNewIp(newIpfield.getText());
		System.out.println(auth);
		acct.setSipAuth(auth);
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

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		userIdfield.setText("");
		gwIpfield.setText("");
		ipfield.setText("");
		jointfield.setText("");
		sipUefield.setText("");
		typefield.setText("");
		localGwIpfield.setText("");
		subPbxfield.setText("");
		ueTypefield.setText("");
		numberfield.setText("");
		longNumfield.setText("");
		rightLevelfield.setText("");
		addPrefixfield.setText("");
		passwordField.setText("");
		numStepfield.setText("");
		amountfield.setText("");
		ueStepfield.setText("");
		oldPwdField.setText("");
		newPwdField.setText("");
		oldIpfield.setText("");
		newIpfield.setText("");
		deltsipfield.setText("");
	}

}
