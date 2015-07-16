package com.king.frame;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.king.dao.BookDaoImpl;
import com.king.dao.StuDaoImpl;
import com.king.dao.TeacherDaoImpl;
import com.king.dao.UserDaoImpl;
import com.king.entry.Book;
import com.king.entry.Reader;
import com.king.entry.User;
import com.king.util.ReaderMgr;

public class BarrowPanel extends JPanel {
	private static JTextField tf_readerId;
	private static JTextField tf_bookId;
	private static JTextArea ta_readerInfo;
	private static JTextArea ta_bookInfo;
	private static JButton bt_commit;
	private static JButton bt_clear;

	// 借书的界面编写
	public BarrowPanel() {
		JLabel label_readerNum = new JLabel("借书证号");
		JLabel label_bookNum = new JLabel("图书编号");
		JLabel label_readerInfo = new JLabel("读者信息");
		JLabel label_bookInfo = new JLabel("图书信息");
		JLabel label_tip = new JLabel("提示：输入读者信息和图书信息点击获取，可以查看数据库的信息核对");
		tf_readerId = new JTextField(13);
		tf_bookId = new JTextField(15);
		ta_readerInfo = new JTextArea();
		ta_bookInfo = new JTextArea();
		bt_commit = new JButton("提交");
		bt_clear = new JButton("清空");
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
		if (MainFrame.isMgr) {
			tf_readerId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if (e.equals(KeyEvent.VK_ENTER)) {
						UserDaoImpl impl = new UserDaoImpl();
						User u = impl.findById(Integer.valueOf(tf_readerId.getText()));
						if (u != null) {
							Reader reader;
							if (u.getRole()==2) {
								TeacherDaoImpl tImpl= new TeacherDaoImpl();
								reader = tImpl.findById(u.getId());
							}else {
								StuDaoImpl sImpl = new StuDaoImpl();
								reader = sImpl.findById(u.getId());
							}
							if (!ReaderMgr.isEmpty()) {
								ReaderMgr.clean();
							}
							ReaderMgr.addReader(1, reader);
							ta_readerInfo.setText(ReaderMgr.getReader(1).toString());
						} else {
							JOptionPane.showConfirmDialog(null, "查找失败", "提示",
									 JOptionPane.OK_OPTION);
						}
					}
				}

			});
		} else {
			tf_readerId.setText(String.valueOf(ReaderMgr.getReader(1).getId()));
			tf_readerId.setEditable(false);
		}
		this.add(tf_readerId);
		tf_readerId.setBounds(30, 65, 330, 25);
		tf_bookId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.equals(KeyEvent.VK_ENTER)) {
					BookDaoImpl bImpl = new BookDaoImpl();
					Book b = bImpl.findById(Integer.valueOf(tf_bookId.getText()));
					ta_bookInfo.setText(b.toString());
				} else {
					JOptionPane.showConfirmDialog(null, "查找失败", "提示",
							 JOptionPane.OK_OPTION);
				}
			}
		});
		this.add(tf_bookId);
		tf_bookId.setBounds(426, 65, 320, 25);
		
		if (!ReaderMgr.isEmpty()) {
			ta_readerInfo.setText(ReaderMgr.getReader(1).toString());
		}
		ta_readerInfo.setEditable(false);
		JScrollPane jsp1= new JScrollPane(ta_readerInfo);
		jsp1.setBounds(30, 140, 330, 290);
		this.add(jsp1);
		JScrollPane jsp2= new JScrollPane(ta_bookInfo);
		jsp2.setBounds(426, 140, 320, 290);
		this.add(jsp2);
		bt_commit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.add(bt_commit);
		bt_clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new BarrowPanel();
			}
		});
		this.add(bt_clear);
		bt_commit.setBounds(645, 490, 100, 25);
		bt_clear.setBounds(535, 490, 100, 25);

	}
}
