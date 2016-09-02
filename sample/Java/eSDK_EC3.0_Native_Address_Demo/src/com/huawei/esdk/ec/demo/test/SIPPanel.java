package com.huawei.esdk.ec.demo.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

import com.huawei.esdk.ec.demo.js.MyButton;
import com.huawei.esdk.uc.professional.local.bean.south.SipAccount;
import com.huawei.esdk.uc.professional.local.bean.south.SipAuth;
import com.huawei.esdk.uc.professional.local.bean.south.SipRequest;
import com.huawei.esdk.uc.professional.local.factory.ServiceFactoryEx;
import com.huawei.esdk.uc.professional.local.service.UserProfileServiceEx;
import com.huawei.esdk.uc.professional.local.utils.PropertiesUtils;

public class SIPPanel extends JPanel{
	private static final long serialVersionUID = -8285213367222038440L;
	private JLabel requestLabel = new JLabel("请求参数:");
	private JLabel urlLabel = new JLabel("  eSDK URL：");
	private JLabel userLabel = new JLabel("  用 户 名：");
	private JLabel pwdLabel = new JLabel("    密   码：");
	private JLabel userIdLabel = new JLabel("操作用户ID：");
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
	private JLabel typeLabel = new JLabel("是否鉴权:");
	private JLabel passwordLabel = new JLabel("鉴权密码:");
	private JLabel ipLabel = new JLabel("鉴权IP:");
	private JLabel bOutgoingRightsLabel = new JLabel("基本呼出权限:");
	private JLabel cOutgoingRightsLabel = new JLabel("自定义呼出权限:");
	private JLabel resultLabel = new JLabel("返回内容：");
	private JLabel errInfoLabel = new JLabel();

	private JTextArea retDescArea = new JTextArea(20, 40);
	private JTextField urlField = new JTextField(26);
	private JTextField userfield = new JTextField(10);
	private JPasswordField pwdField = new JPasswordField(10);
	private JTextField userIdfield = new JTextField(10);
	private JTextField gwIpfield = new JTextField(10);
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
	private JTextField bOutgoingRightsfield = new JTextField(10);
	private JTextField cOutgoingRightsfield = new JTextField(10);
	
	private JButton addSip = new MyButton("添加SIP号码");	
	private int timerCount = 0;

	// 获取服务句柄
	private UserProfileServiceEx userProfileServiceEx = ServiceFactoryEx.getService(UserProfileServiceEx.class);
		
	SIPPanel() {
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
		buildPanel(panel, gridbag, c, new JComponent[] { gwIpLabel }, 2, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { gwIpfield }, 3, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { subPbxLabel }, 4, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { subPbxfield }, 5, 3, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { localGwIpLabel }, 0, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { localGwIpfield }, 1, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { jointLabel }, 2, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { jointfield }, 3, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { sipUeLabel }, 4, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { sipUefield }, 5, 4, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { ueTypeLabel }, 0, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { ueTypefield }, 1, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { numberLabel }, 2, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { numberfield }, 3, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { longNumLabel }, 4, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { longNumfield }, 5, 5, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { rightLevelLabel }, 0, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { rightLevelfield }, 1, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { addPrefixLabel }, 2, 6, 6, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { addPrefixfield }, 3, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { typeLabel }, 4, 6, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { typefield }, 5, 6, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { passwordLabel }, 0, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { passwordField }, 1, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { ipLabel }, 2, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { ipfield }, 3, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { bOutgoingRightsLabel }, 4, 7, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { bOutgoingRightsfield }, 5, 7, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { cOutgoingRightsLabel }, 0, 8, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { cOutgoingRightsfield }, 1, 8, 10, 20, 1, 1);
		
		buildPanel(panel, gridbag, c, new JComponent[] { addSip }, 2, 9, 10, 20, 2, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { errInfoLabel }, 2, 11, 10, 20, 5, 6);
		buildPanel(panel, gridbag, c, new JComponent[] { resultLabel }, 7, 0, 150, 5, 1, 1);
//		retDescArea.setLineWrap(true);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		retDescArea.setBorder(BorderFactory.createTitledBorder(""));
		retDescArea.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
		buildPanel(panel, gridbag, c, new JComponent[] { jsp }, 7, 1, 150, 200, 1, 11);
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
		
		// 添加sip号码，发起POST请求
		this.addSip.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");

				boolean flag = validateParams(
						new JTextField[] { userIdfield,gwIpfield, subPbxfield, jointfield, ueTypefield,
								rightLevelfield,addPrefixfield,typefield},
						new String[] { "操作用户ID","网关IP", "虚拟PBX的ID", "是否联动", "设备类型","权限级别" ,"是否自动添加字冠","是否鉴权"});
				
				if (!flag) {
					return;
				}
				
				boolean flag1 = true;
				if("1".equals(jointfield.getText())){
					flag1 = validateParams(
							new JTextField[] { numberfield},
							new String[] { "SIP号码"});
				}else{
					flag1 = validateParams(
							new JTextField[] { sipUefield},
							new String[] { "SIP设备标识"});
				}
				if (!flag1) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						addSip();

					}
				}).start();
			}
		});

	}

	private void addSip() {
		SipRequest numberInfo = new SipRequest();
		numberInfo.setUserId(userIdfield.getText());
		numberInfo.setSip(new SipAccount());
		numberInfo.getSip().setGwIp(gwIpfield.getText());
		numberInfo.getSip().setSubPbx(subPbxfield.getText());
		numberInfo.getSip().setLocalGwIp(localGwIpfield.getText());
		numberInfo.getSip().setJoint(jointfield.getText());
		numberInfo.getSip().setSipUe(sipUefield.getText());
		numberInfo.getSip().setUeType(ueTypefield.getText());
		numberInfo.getSip().setNumber(numberfield.getText());
		numberInfo.getSip().setLongNum(longNumfield.getText());
		numberInfo.getSip().setRightLevel(rightLevelfield.getText());
		numberInfo.getSip().setAddPrefix(addPrefixfield.getText());
		numberInfo.getSip().setbOutgoingRights(bOutgoingRightsfield.getText());
		numberInfo.getSip().setcOutgoingRights(cOutgoingRightsfield.getText());
		numberInfo.getSip().setSipAuth(new SipAuth());
		numberInfo.getSip().getSipAuth().setType(typefield.getText());
		numberInfo.getSip().getSipAuth().setPassword(String.valueOf(passwordField.getPassword()));
		numberInfo.getSip().getSipAuth().setIp(ipfield.getText());

		//调用userProfileServiceEx服务中的addAccount方法，返回错误码
		Integer resultCode = userProfileServiceEx.addNumber(numberInfo);
		finish();
   	 
   	 	retDescArea.setText("resultCode:"+resultCode);
   	 	if(401 == resultCode)
		{
			//鉴权失败
			showErrInfoWithColor("操作失败");
		}
		else if(1 == resultCode)
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

}
