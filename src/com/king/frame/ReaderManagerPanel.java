package com.king.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ReaderManagerPanel extends JPanel {

	public ReaderManagerPanel() {
		this.initComponent();
	}

	private void initComponent() {
		this.setLayout(null);
		JTabbedPane tb = new JTabbedPane();
		tb.addTab("修改信息", new UpdateReaderPane());
		if (MainFrame.isMgr) {
			tb.addTab("添加读者", new AddReaderPane());
			tb.addTab("删除读者", new DeleteReaderPane());
		}
		// tb.addTab("借书查询", new QueryReaderPane());
		tb.setVisible(true);
		tb.setBounds(20, 20, 750, 500);
		this.add(tb);
	}
}

class AddReaderPane extends JPanel implements ActionListener {
	private JTextField tf_stuNum;
	private JTextField tf_stuName;
	private JTextField tf_stuSex;
	private JTextField tf_phone;
	private JTextArea ta_other;
	private JButton bt_commit;
	private JButton bt_clear;

	// 构造面板
	AddReaderPane() {
		tf_stuNum = new JTextField(40);
		tf_stuName = new JTextField(15);
		tf_stuSex = new JTextField(30);
		tf_phone = new JTextField(15);
		ta_other = new JTextArea();
		// 滚动条
		JScrollPane scp = new JScrollPane(ta_other);
		// 标签
		JLabel label_stuNum = new JLabel("学号");
		JLabel label_stuName = new JLabel("姓名");
		JLabel label_stuSex = new JLabel("性别");
		JLabel label_phone = new JLabel("电话");
		JLabel label_other = new JLabel("其他");
		// 按钮
		bt_commit = new JButton("提交");
		bt_clear = new JButton("清空");
		// 开始构造窗体
		setLayout(null);
		this.add(label_stuNum);
		label_stuNum.setBounds(230, 20, 60, 16);
		this.add(label_stuName);
		label_stuName.setBounds(230, 90, 60, 16);
		this.add(label_stuSex);
		label_stuSex.setBounds(230, 160, 60, 16);
		this.add(label_phone);
		label_phone.setBounds(230, 230, 60, 16);
		this.add(label_other);
		label_other.setBounds(230, 300, 60, 16);
		// 添加文本框到窗体
		this.add(tf_stuNum);
		tf_stuNum.setBounds(230, 40, 271, 30);
		this.add(tf_stuName);
		tf_stuName.setBounds(230, 110, 271, 30);
		this.add(tf_stuSex);
		tf_stuSex.setBounds(230, 180, 271, 30);
		this.add(tf_phone);
		tf_phone.setBounds(230, 250, 271, 30);
		this.add(scp);
		scp.setBounds(230, 320, 271, 70);
		// 添加两个按钮,侦听器设置到业务逻辑处理
		this.add(bt_commit);
		bt_commit.setBounds(250, 410, 100, 25);
		bt_commit.addActionListener(this);
		this.add(bt_clear);
		bt_clear.setBounds(370, 410, 100, 25);
		bt_clear.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.bt_clear) {
			this.tf_phone.setText("");
			this.tf_stuName.setText("");
			this.tf_stuNum.setText("");
			this.tf_stuSex.setText("");
		} else if (arg0.getSource() == this.bt_commit) {
			String numtmp = "";
			String nametmp = "";
			String sextmp = "";
			String other = "";
			int mltmp = 5;
			int brwtmp = 0;
			int reneguetmp = 0;
			String phonetmp = "";
			numtmp = this.tf_stuNum.getText();
			nametmp = this.tf_stuName.getText();
			sextmp = this.tf_stuSex.getText();
			phonetmp = this.tf_phone.getText();
			other = this.ta_other.getText();
			// Reader rdtmp = new Reader();
			// rdtmp.setBorrowNum(brwtmp);
			// rdtmp.setMaxLend(mltmp);
			// rdtmp.setOther(other);
			// rdtmp.setReaderName(nametmp);
			// rdtmp.setReaderNum(numtmp);
			// rdtmp.setReaderPhone(phonetmp);
			// rdtmp.setReaderSex(sextmp);
			// rdtmp.setRenegue(reneguetmp);
			// boolean flag = ReaderTableDatabaseCode.addReader(rdtmp);
			// if (flag == true) {
			// JOptionPane.showConfirmDialog(null, "添加成功", "提示",
			// JOptionPane.OK_OPTION);
			// } else {
			// JOptionPane.showConfirmDialog(null, "添加失败", "提示",
			// JOptionPane.OK_OPTION);
			// }
		}
	}
}

class DeleteReaderPane extends JPanel implements ActionListener {
	private JButton btTrue;
	private JTextField tf_stuNum;

	DeleteReaderPane() {
		btTrue = new JButton("删除读者");
		tf_stuNum = new JTextField(20);
		this.add(btTrue);
		this.add(tf_stuNum);
		this.setLayout(null);
		btTrue.setBounds(420, 210, 100, 25);
		tf_stuNum.setBounds(215, 210, 200, 25);
		btTrue.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String rdnum = this.tf_stuNum.getText();
		boolean flag = false;
		// try{
		// flag=ReaderTableDatabaseCode.delReader(rdnum);
		// }catch(Exception e){
		// JOptionPane.showConfirmDialog(null,
		// "删除失败，请检查是否存在此用户","提示",JOptionPane.OK_OPTION);
		// }finally{
		// if(flag==true){
		// JOptionPane.showConfirmDialog(null,
		// "删除成功","提示",JOptionPane.OK_OPTION);
		// }
		// }
	}
}

class UpdateReaderPane extends JPanel {

	UpdateReaderPane() {
		this.initgetComponent();
	}

	private void initgetComponent() {

		tf_stuNum = new JTextField(40);
		tf_stuName = new JTextField(15);
		tf_stuSex = new JTextField(30);
		tf_phone = new JTextField(15);
		ta_other = new JTextArea();
		// 滚动条
		JScrollPane scp = new JScrollPane(ta_other);
		// 标签
		JLabel label_stuNum = new JLabel("学号");
		JLabel label_stuName = new JLabel("姓名");
		JLabel label_stuSex = new JLabel("性别");
		JLabel label_phone = new JLabel("电话");
		JLabel label_other = new JLabel("其他");
		// 按钮
		bt_commit = new JButton("提交");
		// 开始构造窗体
		setLayout(null);
		this.add(label_stuNum);
		label_stuNum.setBounds(230, 20, 60, 16);
		this.add(label_stuName);
		label_stuName.setBounds(230, 90, 60, 16);
		this.add(label_stuSex);
		label_stuSex.setBounds(230, 160, 60, 16);
		this.add(label_phone);
		label_phone.setBounds(230, 230, 60, 16);
		this.add(label_other);
		label_other.setBounds(230, 300, 60, 16);
		// 添加文本框到窗体
		this.add(tf_stuNum);
		tf_stuNum.setBounds(230, 40, 271, 30);
		this.add(tf_stuName);
		tf_stuName.setBounds(230, 110, 271, 30);
		this.add(tf_stuSex);
		tf_stuSex.setBounds(230, 180, 271, 30);
		this.add(tf_phone);
		tf_phone.setBounds(230, 250, 271, 30);
		this.add(scp);
		scp.setBounds(230, 320, 271, 70);
		// 添加两个按钮,侦听器设置到业务逻辑处理
		this.add(bt_commit);
		bt_commit.setBounds(400, 410, 100, 25);
		bt_commit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	private JTextField tf_stuNum;
	private JTextField tf_stuName;
	private JTextField tf_stuSex;
	private JTextField tf_phone;
	private JTextArea ta_other;
	private JButton bt_commit;
	private String a = "";
	private String b = "";
	private String c = "";
	private String d = "";
	private String e = "";

	// @Override
	// public void actionPerformed(ActionEvent arg0){
	// if (arg0.getSource() == this.bt_get) {
	// ResultSet
	// rs=ReaderTableDatabaseCode.queryReader(this.tf_stuNum.getText());
	// try{
	//
	// while(rs.next()){
	// a=rs.getString("readerphone");
	// b=rs.getString("readername");
	// c=rs.getString("readernum");
	// d=rs.getString("readersex");
	// e=rs.getString("other");
	// }
	// this.tf_phone.setText(a);
	// this.tf_stuName.setText(b);
	// this.tf_stuNum.setText(c);
	// this.tf_stuSex.setText(d);
	// this.ta_other.setText(e);
	// }catch(SQLException e){
	// System.out.println(e.getMessage());
	// JOptionPane.showConfirmDialog(null,
	// "获取信息出错","提示",JOptionPane.ERROR_MESSAGE);
	// }
	// } else if (arg0.getSource() == this.bt_commit) {
	// boolean t1=false,t2=false,t3=false,t4=false;
	// try{
	// t1=ReaderTableDatabaseCode.updateReader(this.tf_stuNum.getText(),
	// "readername", this.tf_stuName.getText());
	// t2=ReaderTableDatabaseCode.updateReader(this.tf_stuNum.getText(),
	// "readersex", this.tf_stuSex.getText());
	// t3=ReaderTableDatabaseCode.updateReader(this.tf_stuNum.getText(),
	// "readerphone", this.tf_phone.getText());
	// t4=ReaderTableDatabaseCode.updateReader(this.tf_stuNum.getText(),
	// "other", this.ta_other.getText());
	// }catch(Exception e2){
	// JOptionPane.showConfirmDialog(null,
	// "修改出错","提示",JOptionPane.CLOSED_OPTION);
	// }finally{
	// if(t1==true&&t2==true&&t3==true&&t4==true){
	// JOptionPane.showConfirmDialog(null,
	// "修改成功","提示",JOptionPane.CLOSED_OPTION);
	// }
	// }
	// }
	// }

}
