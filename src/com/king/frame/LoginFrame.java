package com.king.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame {

	public LoginFrame() {
		this.initComponent();
	}

	private void initComponent() {

		this.setLayout(null);

		labUsername.setBounds(10, 10, 100, 30);
		this.add(labUsername);

		labPassword.setBounds(10, 40, 100, 30);
		this.add(labPassword);

		tfUsername.setBounds(50, 15, 130, 20);
		this.add(tfUsername);

		pfPassword.setBounds(50, 45, 130, 20);
		this.add(pfPassword);

		btnLogin.setBounds(10, 75, 170, 40);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		this.add(btnLogin);

		this.setTitle("用户登录");
		this.setBounds(550, 300, 200, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void login() {
		if (userName.equals(tfUsername.getText())
				&& passwrod.equals(String.valueOf(pfPassword.getPassword()))) {
			JOptionPane.showMessageDialog(null, "Login Success", "Tip",
					JOptionPane.INFORMATION_MESSAGE);
			new MainFrame();
		} else {
			JOptionPane.showMessageDialog(null, "Login Error", "Tip",
					JOptionPane.ERROR_MESSAGE);
			tfUsername.setText("");
			pfPassword.setText("");
		}
	}

	public static void main(String[] args) {
		new LoginFrame();
	}

	private JLabel labUsername = new JLabel("用户名");
	private JLabel labPassword = new JLabel("密码");
	private JTextField tfUsername = new JTextField();
	private JPasswordField pfPassword = new JPasswordField();
	private JButton btnLogin = new JButton("登录");
//TODO
	final String userName = "123";
	final String passwrod = "123";

}
