package com.king.frame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 * 图书管理系统 实现主窗体
 * 
 * @author lendoon
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	MainFrame() {
		this.initComponent();
	}

	private void initComponent() {

		JTabbedPane mainPane = new JTabbedPane();
		mainPane.addTab("借书", new BarrowPanel());
		// mainPane.addTab("续借", new BarrowPanel());
		mainPane.addTab("还书", new ReturnPanel());
		mainPane.addTab("入库", new AddInLibPanel());
		mainPane.addTab("浏览图书", new BrowserPanel());
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

	public static void main(String[] args) {
		new MainFrame();
	}
}
