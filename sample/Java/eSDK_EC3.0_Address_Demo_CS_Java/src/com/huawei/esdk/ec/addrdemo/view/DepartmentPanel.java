package com.huawei.esdk.ec.addrdemo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import com.huawei.esdk.ec.addrdemo.bean.Department;
import com.huawei.esdk.ec.addrdemo.bean.DepartmentResponse;
import com.huawei.esdk.ec.addrdemo.constant.UCConstant;
import com.huawei.esdk.ec.addrdemo.js.MyButton;
import com.huawei.esdk.ec.addrdemo.model.RestRequestMessage;
import com.huawei.esdk.ec.addrdemo.model.RestResponse;
import com.huawei.esdk.ec.addrdemo.util.PropertiesUtils;
import com.huawei.esdk.ec.addrdemo.util.RestUtils;
import com.huawei.esdk.ec.addrdemo.util.StringUtils;


public class DepartmentPanel extends JPanel {
	private static final long serialVersionUID = -8285213367222038440L;
	private static final String REST_URL = PropertiesUtils.getValue("rest.url");
	private static String userName;
	private static String password;
	private JLabel requestLabel = new JLabel("请求参数:");
	private JLabel urlLabel = new JLabel("  eSDK URL：");
	private JLabel userLabel = new JLabel("  用 户 名：");
	private JLabel pwdLabel = new JLabel("    密   码：");
	private JLabel userIdLabel = new JLabel("操作用户ID：");
	private JLabel dpIdLabel = new JLabel("  父部门ID:");
	private JLabel dpNameLabel = new JLabel(" 部门名称:");
	private JLabel pagecLabel = new JLabel("每页显示数:");
	private JLabel pagenLabel = new JLabel(" 当前分页:");
	private JLabel resultLabel = new JLabel("返回内容：");
	private JLabel DeptIdLabel = new JLabel("部门ID：");
	private JLabel errInfoLabel = new JLabel();
	private JTextField urlField = new JTextField(26);
	private JTextField userfield = new JTextField(10);
	private JPasswordField pwdField = new JPasswordField(10);
	private JTextField userIdfield = new JTextField(10);
	private JTextField dpIdfield = new JTextField(10);
	private JTextField dpNamefield = new JTextField(10);
	private JTextField pagecfield = new JTextField(10);
	private JTextField pagenfield = new JTextField(10);
	private JTextField DeptIdfield = new JTextField(10);
	private JTextArea retDescArea = new JTextArea(20, 40);
	private JButton adddp = new MyButton("添加部门");
	private JButton modify = new MyButton("修改部门");
	private JButton deletedp = new MyButton("删除部门");
	private JButton serchdp = new MyButton("查询部门");
	private int timerCount = 0;

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

		buildPanel(panel, gridbag, c, new JComponent[] { pagecLabel }, 2, 4, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pagecfield }, 3, 4, 10, 20, 1, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { pagenLabel }, 0, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { pagenfield }, 1, 5, 10, 20, 1, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { DeptIdLabel }, 2, 5, 10, 20, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { DeptIdfield }, 3, 5, 10, 20, 1, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { adddp }, 0, 6, 100, 30, 2, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { modify }, 2, 6, 100, 30, 2, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { deletedp }, 0, 7, 100, 40, 2, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { serchdp }, 2, 7, 100, 40, 2, 1);

		buildPanel(panel, gridbag, c, new JComponent[] { resultLabel }, 4, 0, 150, 5, 1, 1);
		buildPanel(panel, gridbag, c, new JComponent[] { errInfoLabel }, 0, 8, 100, 5, 4, 1);
		// retDescArea.setLineWrap(true);
		retDescArea.setBorder(BorderFactory.createTitledBorder(""));
		retDescArea.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
		buildPanel(panel, gridbag, c, new JComponent[] { jsp }, 4, 1, 150, 200, 1, 7);
		/*
		 * panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.
		 * createLineBorder(new Color(220, 220, 220), 15), "部门管理",
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

		this.adddp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");

				boolean flag = validateParams(
						new JTextField[] { urlField, userfield, pwdField, userIdfield, dpIdfield, dpNamefield },
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "父部门ID", "部门名称" });

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

		// 修改部门，发起PUT请求
		this.modify.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");

				boolean flag = validateParams(
						new JTextField[] { urlField, userfield, pwdField, userIdfield, dpIdfield,dpNamefield, DeptIdfield },
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "父部门ID","部门名称", "部门ID" });

				if (!flag) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						modifyDept();
					}
				}).start();
			}
		});

		// 删除部门，发起DELET请求
		this.deletedp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");

				boolean flag = validateParams(
						new JTextField[] { urlField, userfield, pwdField, userIdfield, DeptIdfield },
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "部门ID" });

				if (!flag) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						deleteDept();
					}
				}).start();
			}
		});
		//查询部门，发起GET请求
		this.serchdp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showErrInfoWithColor("");
				retDescArea.setText("");

				boolean flag = validateParams(
						new JTextField[] { urlField, userfield, pwdField, userIdfield, dpIdfield, pagecfield,
								pagenfield },
						new String[] { "eSDK URL", "用户名", "密码", "操作用户ID", "父部门ID", "每页显示数名称", "当前分页" });

				if (!flag) {
					return;
				}
				begin();
				loading();

				new Thread(new Runnable() {
					@Override
					public void run() {
						serchDept();
					}
				}).start();
			}
		});
	}
	//添加部门
	private void addDept() {

		// 拼装请求参数，发送请求
		Department payload = new Department();
		payload.setUserId(userIdfield.getText());
		payload.setParentId(dpIdfield.getText());
		payload.setDepartmentName(dpNamefield.getText());
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_POST);
		try {
			// 获取发送Rest消息工具类实例，并传入请求参数、添加部门资源路径
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage, "/ec/bmu/department");
			finish();
			if (null == responsePayload) {
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值
				DepartmentResponse response = new Gson().fromJson(responsePayload, DepartmentResponse.class);
				DeptIdfield.setText(response.getDepartmentId());

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
	//修改部门
	private void modifyDept() {
		// 拼装请求参数，发送请求
		Department payload = new Department();
		payload.setUserId(userIdfield.getText());
		payload.setParentId(dpIdfield.getText());
		payload.setDepartmentName(dpNamefield.getText());
		payload.setDepartmentId(DeptIdfield.getText());
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setPayload(payload);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_PUT);
		try {
			// 获取发送Rest消息工具类实例，并传入请求参数、添加部门资源路径
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage, "/ec/bmu/department");
			finish();
			if (null == responsePayload) {
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值
				// 把JSON结果转换成JavaBean
				DepartmentResponse response = new Gson().fromJson(responsePayload, DepartmentResponse.class);
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
	//查询部门
	private void serchDept() {
		// 拼装请求参数，发送请求
		Map<String, String> m = new HashMap<String, String>();
		m.put("userId", userIdfield.getText());
		m.put("parentId", dpIdfield.getText());
		m.put("pageCount", pagecfield.getText());
		m.put("pageNum", pagenfield.getText());
		System.out.print(m);
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setParameters(m);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_GET);
		try {
			// 获取发送Rest消息工具类实例，并传入请求参数、添加部门资源路径
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage, "/ec/bmu/department");
			finish();
			if (null == responsePayload) {
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值
				// 把JSON结果转换成JavaBean
				DepartmentResponse response = new Gson().fromJson(responsePayload, DepartmentResponse.class);
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
	//删除部门
	private void deleteDept() {
		// 拼装请求参数，发送请求
		Map<String, String> m = new HashMap<String, String>();
		m.put("userId", userIdfield.getText());
		m.put("departmentId", DeptIdfield.getText());
		RestResponse reponse = new RestResponse();
		RestRequestMessage restRequestMessage = new RestRequestMessage();
		restRequestMessage.setParameters(m);
		restRequestMessage.setHttpMethod(UCConstant.HTTP_METHOD_DELETE);
		try {
			// 获取发送Rest消息工具类实例，并传入请求参数、添加部门资源路径
			String responsePayload = RestUtils.getInstance().sendMessage(restRequestMessage, "/ec/bmu/department");
			finish();
			if (null == responsePayload) {
				reponse.setResultCode(1l);
				reponse.setResultContext("操作失败");
				retDescArea.setText(StringUtils.formatJson(new Gson().toJson(reponse)));
				showErrInfoWithColor("操作失败");
			} else {
				retDescArea.setText(StringUtils.formatJson(responsePayload));// 输入reponseMap中所有json值
				// retDescArea.setText(reponseMap.toString());
				// 把JSON结果转换成JavaBean
				DepartmentResponse response = new Gson().fromJson(responsePayload, DepartmentResponse.class);
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
