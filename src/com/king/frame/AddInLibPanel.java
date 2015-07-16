package com.king.frame;

/*
 * @图书入库标签ui布局
 * 
 * @两个按钮的事件侦听在com.dovewi.bookmgrcode.servicelogic包中
 * 
 * @2013.11.16
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

import com.king.dao.BookDaoImpl;
import com.king.entry.Book;

//import com.dovewi.bookmgrcode.servicelogic.ActionManager;

public class AddInLibPanel extends JPanel {

	// 构造界面
	AddInLibPanel() {
		this.initComponent();
	}

	private void initComponent() {
		// 标签
		JLabel label_bookName = new JLabel("书名");
		JLabel label_bookISBN = new JLabel("ISBN");
		JLabel label_bookAuthor = new JLabel("作者");
		JLabel label_bookPrice = new JLabel("标价");
		JLabel label_bookSum = new JLabel("数量");
		JLabel label_bookInfo = new JLabel("图书简介");
		// 增加滚动条面板并添加ta_bookinfo
		JScrollPane jspl = new JScrollPane(ta_bookInfo);
		// 按钮
		bt_commit = new JButton("提交");
		bt_clear = new JButton("清空");
		// 开始构造窗体
		setLayout(null);
		this.add(label_bookISBN);
		label_bookISBN.setBounds(40, 40, 60, 16);
		this.add(label_bookName);
		label_bookName.setBounds(40, 130, 60, 16);
		this.add(label_bookAuthor);
		label_bookAuthor.setBounds(40, 223, 60, 16);
		this.add(label_bookPrice);
		label_bookPrice.setBounds(40, 314, 60, 16);
		this.add(label_bookSum);
		label_bookSum.setBounds(40, 394, 60, 16);
		this.add(label_bookInfo);
		label_bookInfo.setBounds(340, 40, 60, 16);
		// 添加文本框到窗体
		this.add(tf_bookISBN);
		tf_bookISBN.setBounds(40, 70, 271, 30);
		this.add(tf_bookName);
		tf_bookName.setBounds(40, 155, 271, 30);
		this.add(tf_bookAuthor);
		tf_bookAuthor.setBounds(40, 249, 271, 30);
		this.add(tf_bookPrice);
		tf_bookPrice.setBounds(40, 338, 271, 30);
		this.add(tf_bookSum);
		tf_bookSum.setBounds(40, 420, 271, 30);
		this.add(jspl);
		jspl.setBounds(340, 70, 400, 380);// 添加的滚动条面板
		// 添加两个按钮,侦听器设置到业务逻辑处理
		this.add(bt_commit);
		bt_commit.setBounds(530, 470, 100, 25);
		bt_commit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Book book = new Book(tf_bookISBN.getText(), tf_bookName
						.getText(), tf_bookAuthor.getText(), "", new Date(),
						Integer.parseInt(tf_bookSum.getText()), Float
								.parseFloat(tf_bookPrice.getText()), 0, 0, 0,
						new Date(), ta_bookInfo.getText(), null);
				BookDaoImpl impl = new BookDaoImpl();
				impl.insert(book);
			}
		});
		this.add(bt_clear);
		bt_clear.setBounds(640, 470, 100, 25);
		bt_clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initComponent();
			}
		});
	}

	public static JTextField tf_bookName = new JTextField(40);
	public static JTextField tf_bookISBN = new JTextField(15);
	public static JTextField tf_bookAuthor = new JTextField(30);
	public static JTextField tf_bookPrice = new JTextField(5);
	public static JTextField tf_bookSum = new JTextField(6);
	public static JTextArea ta_bookInfo = new JTextArea();
	public static JButton bt_commit;
	public static JButton bt_clear;

}
