package com.king.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.king.util.jdbcUtil;

public class RecordDao {
	
	public int insert(int readerId, int bookId) {

		Connection conn = jdbcUtil.getConnection();
		String sql = "insert into book values(?,?)";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, readerId);
			ps.setInt(2, bookId);
			ps.setDate(5, new java.sql.Date(new Date().getTime()));
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.freeAll(conn, ps);
		}
		return result;
	}
}
