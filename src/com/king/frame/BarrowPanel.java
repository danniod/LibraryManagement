package com.king.frame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BarrowPanel extends JPanel {
	private static JTextField tf_readerNum;
	private static JTextField tf_bookNum;
	private static JTextArea ta_readerInfo;
	private static JTextArea ta_bookInfo;
	private static JButton bt_commit;
	private static JButton bt_getInfo;
	private static JButton bt_clear;

	// 借书的界面编写
	public BarrowPanel() {
		JLabel label_readerNum = new JLabel("借书证号");
		JLabel label_bookNum = new JLabel("图书编号");
		JLabel label_readerInfo = new JLabel("读者信息");
		JLabel label_bookInfo = new JLabel("图书信息");
		JLabel label_tip = new JLabel("提示：输入读者信息和图书信息点击获取，可以查看数据库的信息核对");
		tf_readerNum = new JTextField(13);
		tf_bookNum = new JTextField(15);
		ta_readerInfo = new JTextArea();
		ta_bookInfo = new JTextArea();
		bt_commit = new JButton("提交");
		bt_getInfo = new JButton("获取");
		bt_clear = new JButton("清空");
		JScrollPane jsp1 = new JScrollPane(ta_readerInfo);
		JScrollPane jsp2 = new JScrollPane(ta_bookInfo);
		// 设置布局方式
		this.setLayout(null);
		// 添加标签
		add(label_readerNum);
		add(label_bookNum);
		add(label_readerInfo);
		add(label_bookInfo);
		add(label_tip);
		label_readerNum.setBounds(30, 30, 80, 16);
		label_bookNum.setBounds(426, 30, 80, 16);
		label_readerInfo.setBounds(30, 104, 80, 16);
		label_bookInfo.setBounds(426, 104, 80, 16);
		label_tip.setBounds(30, 444, 410, 16);
		// 添加文本组件
		add(tf_readerNum);
		add(tf_bookNum);
		add(jsp1);
		add(jsp2);
		tf_readerNum.setBounds(30, 65, 330, 25);
		tf_bookNum.setBounds(426, 65, 320, 25);
		jsp1.setBounds(30, 140, 330, 290);
		jsp2.setBounds(426, 140, 320, 290);
		// bt_commit.addActionListener(new ActionManager());
		add(bt_commit);
		// bt_getInfo.addActionListener(new ActionManager());
		add(bt_getInfo);
		// bt_clear.addActionListener(new ActionManager());
		add(bt_clear);
		bt_commit.setBounds(425, 490, 100, 25);
		bt_getInfo.setBounds(535, 490, 100, 25);
		bt_clear.setBounds(645, 490, 100, 25);
	}
}
