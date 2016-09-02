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

import com.google.gson.Gson;
import com.huawei.esdk.ec.demo.js.MyButton;
import com.huawei.esdk.ec.demo.util.StringUtils;
import com.huawei.esdk.uc.professional.local.bean.RestResponse;
import com.huawei.esdk.uc.professional.local.bean.south.AddDepartmentResult;
import com.huawei.esdk.uc.professional.local.bean.south.DepartmentRequest;
import com.huawei.esdk.uc.professional.local.factory.ServiceFactoryEx;
import com.huawei.esdk.uc.professional.local.service.UserProfileServiceEx;
import com.huawei.esdk.uc.professional.local.utils.PropertiesUtils;

public class DepartmentPanel extends JPanel {
	private static final long serialVersionUID = -8285213367222038440L;
	private JLabel requestLabel = new JLabel("请求参数:");
	private JLabel urlLabel = new JLabel("  eSDK URL：");
	private JLabel userLabel = new JLabel("  用 户 名：");
	private JLabel pwdLabel = new JLabel("    密   码：");
	private JLabel userIdLabel = new JLabel("操作用户ID：");
	private JLabel dpIdLabel = new JLabel("  父部门ID:");
	private JLabel dpNameLabel = new JLabel(" 部门名称:");
	private JLabel resultLabel = new JLabel("返回内容：");
	private JLabel DeptIdLabel = new JLabel("部门ID：");
	private JLabel errInfoLabel = new JLabel();
	private JTextField urlField = new JTextField(26);
	private JTextField userfield = new JTextField(10);
	private JPasswordField pwdField = new JPasswordField(10);
	private JTextField userIdfield = new JTextField(10);
	private JTextField dpIdfield = new JTextField(10);
	private JTextField dpNamefield = new JTextField(10);
	private JTextField DeptIdfield = new JTextField(10);
	private JTextArea retDescArea = new JTextArea(20, 40);
	private JButton adddp = new MyButton("添加部门");
	private int timerCount = 0;

	// 获取服务句柄 
	private UserProfileServiceEx userProfileServiceEx = ServiceFactoryEx.getService(UserProfileServiceEx.class); 

	
	DepartmentPanel() {
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
		buildPanel(panel, gridbag, c, new JComponent[] { dpIdLabel }, 2, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { dpIdfield }, 3, 3, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { dpNameLabel }, 0, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { dpNamefield }, 1, 4, 10, 20, 1, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { DeptIdLabel }, 2, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { DeptIdfield }, 3, 4, 10, 20, 1, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { adddp }, 0, 5, 100, 30, 4, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { resultLabel }, 4, 0, 150, 5, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { errInfoLabel }, 0, 8, 150, 5, 4, 1);
//		retDescArea.setLineWrap(true);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		retDescArea.setBorder(BorderFactory.createTitledBorder(""));
		retDescArea.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
		buildPanel(panel, gridbag, c, new JComponent[] { jsp }, 4, 1, 150, 200, 1, 7);
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

		this.adddp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");

				boolean flag = validateParams(
						new JTextField[] { userIdfield, dpIdfield, dpNamefield },
						new String[] { "操作用户ID", "父部门ID", "部门名称" });

				if (!flag) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						addDept();
					}
				}).start();
			}
		});
	}

	private void addDept() {

		//入参bean
		DepartmentRequest dept = new DepartmentRequest(); 
		dept.setUserId(userIdfield.getText()); 
		dept.setParentId(dpIdfield.getText()); 
		dept.setDepartmentName(dpNamefield.getText()); 

		//调用userProfileServiceEx服务中的addDept方法
		RestResponse<AddDepartmentResult> reponse = userProfileServiceEx.addDept(dept);
		finish();
		
		retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
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
				DeptIdfield.setText(reponse.getResult().getDepartmentId());
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
