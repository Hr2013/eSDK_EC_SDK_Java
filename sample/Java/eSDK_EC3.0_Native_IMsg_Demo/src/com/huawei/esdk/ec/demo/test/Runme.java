package com.huawei.esdk.ec.demo.test;

import java.awt.*;
import javax.swing.*;

public class Runme extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private JPanel panel1;

	public Runme() {
		super("发送即时消息");
		setSize(1450, 900);
		Container c = getContentPane();
		tabbedPane = new JTabbedPane(); // 创建选项卡面板对象
		// 创建面板
		panel1 = new SendIMsgPanel();
		// 将标签面板加入到选项卡面板对象上
		tabbedPane.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
		tabbedPane.addTab(" 即时消息 ", null, panel1, "即时消息");
		c.add(tabbedPane);
		c.setBackground(Color.white);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Runme();
	}

}
