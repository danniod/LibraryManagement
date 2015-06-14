package com.king.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class BrowserPanel extends JPanel implements ActionListener {
	private JButton brwBtn;
	private JScrollPane jscp;

	BrowserPanel() {
		brwBtn = new JButton("获取数据");
		brwBtn.addActionListener(this);
		this.setLayout(null);
		this.add(brwBtn);
		brwBtn.setBounds(330, 25, 100, 30);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	// @Override
	// public void actionPerformed(ActionEvent arg0) {
	// if (arg0.getSource() == this.brwBtn) {
	// Object[] columName = { "ISBN", "书名", "作者", "价格", "在馆数量", "总量", "简介" };
	// ResultSet rs = BookTableDatabaseCode.queryAllBook();
	// int rownum=0;
	// try {
	// rs.last();//移动数据指针到结尾，读取末尾行数
	// rownum = rs.getRow();
	// rs.beforeFirst();;//移到开头，防止下面读不出数据
	// } catch (SQLException e1) {
	// System.out.println("获取记录行数失败");
	// }
	// Object[][] rowData = new Object[rownum][7];
	// int i = 0;
	// try {
	// while (rs.next()) { // 遍历查询结果
	// rowData[i][0] = rs.getString("isbnnumber"); // 初始化数组内容
	// rowData[i][1] = rs.getString("bookname");
	// rowData[i][2] = rs.getString("author");
	// rowData[i][3] = rs.getString("price");
	// rowData[i][4] = rs.getString("amount");
	// rowData[i][5] = rs.getString("sum");
	// rowData[i][6] = rs.getString("bookinfo");
	// i++;
	// }
	// JTable myTable = new JTable(rowData, columName);
	// jscp=new JScrollPane(myTable);
	// jscp.setBounds(30, 80, 730, 430);
	// this.add(jscp);
	// jscp.setVisible(true);
	// } catch (SQLException e) {
	// System.out.println("构建表格出现错误：" + e.getMessage());
	// }
	// } else {
	// JOptionPane.showConfirmDialog(null, "未知错误", "错误",
	// JOptionPane.ERROR_MESSAGE);
	// }
	// }
}
