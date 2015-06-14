package com.king.frame;

import javax.swing.*;

//import com.dovewi.bookmgrcode.servicelogic.ActionManager;

public class ReturnPanel extends JPanel {

	public ReturnPanel() {
		this.initComponent();
	}

	//初始化面板
	private void initComponent() {

		JLabel readerID = new JLabel("读者");
		JLabel bookID = new JLabel("图书编号");
		JLabel label3 = new JLabel("借书清单");

		btnTurn = new JButton("还书");
		btnClear = new JButton("清空");
		btnGet = new JButton("获取清单");

		tfReaderNum = new JTextField(15);
		tfBookNum = new JTextField(15);
		taBookList = new JTextArea();

		this.setLayout(null);
		// 标签位置
		readerID.setBounds(30, 30, 150, 16);
		this.add(readerID);
		bookID.setBounds(420, 30, 213, 16);
		this.add(bookID);
		label3.setBounds(30, 130, 105, 16);
		this.add(label3);

		// 按钮位置
		this.add(btnTurn);
		this.add(btnClear);
		this.add(btnGet);
		btnGet.setBounds(30, 480, 100, 25);
		// btnGet.addActionListener(new ActionManager());
		btnClear.setBounds(160, 480, 100, 25);
		// btnClear.addActionListener(new ActionManager());
		btnTurn.setBounds(270, 480, 100, 25);
		// btnTrue.addActionListener(new ActionManager());

		// 文本框
		this.add(tfReaderNum);
		this.add(tfBookNum);
		this.add(taBookList);
		tfReaderNum.setBounds(30, 70, 320, 25);
		tfBookNum.setBounds(420, 70, 320, 25);
		taBookList.setBounds(30, 160, 710, 280);

	}

	public static JButton btnTurn;
	public static JButton btnClear;
	public static JButton btnGet;
	public static JTextField tfReaderNum;
	public static JTextField tfBookNum;
	public static JTextArea taBookList;
}
