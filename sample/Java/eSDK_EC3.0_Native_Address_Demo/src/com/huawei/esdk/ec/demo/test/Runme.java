package com.huawei.esdk.ec.demo.test;

import java.awt.*;
import javax.swing.*;

public class Runme extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private JPanel panel1, panel2, panel3;

	public Runme() {
		super("通讯录同步");
		setSize(1450, 900);
		Container c = getContentPane();
		tabbedPane = new JTabbedPane(); // 创建选项卡面板对象
		// 创建面板
		panel1 = new DepartmentPanel();
		panel2 = new AccountPanel();
		panel3 = new SIPPanel();
		// 将标签面板加入到选项卡面板对象上
		tabbedPane.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
		tabbedPane.addTab(" 部门管理 ", null, panel1, "部门管理");
		tabbedPane.addTab(" 账号管理 ", null, panel2, "账号管理");
		tabbedPane.addTab(" SIP号码管理 ", null, panel3, "SIP号码管理 ");
		c.add(tabbedPane);
		c.setBackground(Color.white);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Runme();
	}

}
