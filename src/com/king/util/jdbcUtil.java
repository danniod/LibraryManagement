package com.king.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcUtil {

	private static String username = "mysql";
	private static String passward = "mysql";
	private static String url = "jdbc:mysql://192.168.8.22:3306/mysql";
	private static String driver = "com.mysql.jdbc.Driver";

	/**
	 * 获取单例 mysql连接
	 * @return Connection
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// 加载驱动
			Class.forName(driver);
			// 连接Mysql
			conn = DriverManager.getConnection(url, username, passward);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 释放连接
	 * @param conn
	 * @param sm
	 * @param rs
	 */
	public static void freeAll(Connection conn, Statement sm, ResultSet rs) {
			try {
				if (conn != null) {
				conn.close();
				}
				if (sm != null) {
					sm.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * 释放连接
	 * @param conn
	 * @param sm
	 */
	public static void freeAll(Connection conn, Statement sm) {
		freeAll(conn, sm, null);
	}

	public static void main(String[] args) {
		Connection connection = jdbcUtil.getConnection();
		System.out.println(connection);
	}
	
}
