package com.king.frame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.king.dao.StuDaoImpl;
import com.king.dao.TeacherDaoImpl;
import com.king.entry.Reader;
import com.king.util.ReaderMgr;

/**
 * 图书管理系统 实现主窗体
 * 
 * @author lendoon
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	public static boolean isMgr;
	MainFrame() {
		this.initComponent();
	}

	public MainFrame(int role,int id) {
		if (role>1) {
			isMgr = false;
			Reader reader = null;
			if (role == 2) {
				reader = new TeacherDaoImpl().findById(id);
			} else {
				reader = new StuDaoImpl().findById(id);
			}
			ReaderMgr.addReader(1, reader);
		}else {
			isMgr = true;
		}
		this.initComponent();
	}

	private void initComponent() {

		JTabbedPane mainPane = new JTabbedPane();
		if (!isMgr) {
			mainPane.addTab("浏览图书", new BrowserPanel());
		}
		mainPane.addTab("借书", new BarrowPanel());
		mainPane.addTab("还书", new ReturnPanel());
		if (isMgr) {
			mainPane.addTab("入库", new AddInLibPanel());
		}
		mainPane.addTab("读者管理", new ReaderManagerPanel());
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.getContentPane().add(mainPane);
		this.validate();
		this.setSize(800, 600);
		this.setTitle("图书管理系统");
		this.setVisible(true);
		this.setResizable(false);

	}

}
