package com.king.frame;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import com.king.dao.BookDaoImpl;
import com.king.entry.Book;

public class BrowserPanel extends JPanel implements ActionListener {
	private JButton btnSearch;
	private JScrollPane jscp;
	private JTextField searchField;

	BrowserPanel() {
		jscp = new JScrollPane();
		searchField = new JTextField();
		searchField.setText("输入书名/作者/分类信息查找");
		btnSearch = new JButton("查找");
		btnSearch.addActionListener(this);
		this.setLayout(null);
		this.add(searchField);
		searchField.setBounds(50, 25, 500, 30);	
		this.add(btnSearch);
		btnSearch.setBounds(600, 25, 70, 30);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BookDaoImpl daoImpl = new BookDaoImpl();
		List<Book> books = daoImpl.findAll(searchField.getText());
		for (int i = 0; i < books.size(); i++) {
			JLabel book = new JLabel(books.get(i).toString());
			jscp.add(book);
			book.setBounds(10, 10, 700, 30);
		}
		this.add(jscp);
		jscp.setBounds(50, 65, 700, 450);
	}
}
