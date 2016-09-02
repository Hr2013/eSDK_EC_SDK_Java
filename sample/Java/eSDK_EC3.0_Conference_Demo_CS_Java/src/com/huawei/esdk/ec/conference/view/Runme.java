package com.huawei.esdk.ec.conference.view;

import java.awt.*;
import javax.swing.*;

public class Runme extends JFrame {
	private JTabbedPane tabbedPane;
	private JPanel panel1;

	public Runme() {

		super("会议管理");
		setSize(1200, 870);
		
		Container c = getContentPane();
		tabbedPane = new JTabbedPane(); // 创建选项卡面板对象

		// 创建面板
		panel1 = new MeetingPanel();
		// 将标签面板加入到选项卡面板对象上
		tabbedPane.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
		tabbedPane.addTab(" 会议管理 ", null, panel1, "fifth panel");

		c.add(tabbedPane);
		c.setBackground(Color.white);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runme runme = new Runme();
	}

}
