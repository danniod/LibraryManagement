package com.king.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.king.entry.User;
import com.king.util.jdbcUtil;

public class UserDaoImpl implements IDao<User> {

	@Override
	public int insert(User t) {
		return 0;
	}

	@Override
	public int delete(User t) {
		return 0;
	}

	@Override
	public int update(User t) {
		return 0;
	}

	@Override
	public User findById(Integer id){
		Connection conn = jdbcUtil.getConnection();
		String sql = "select * from user where username =" + id;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = new User();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getInt(4));
			}
			System.out.println(user.toString());
		} catch (SQLException e) {
			return null;
		} finally {
			jdbcUtil.freeAll(conn, ps, rs);
		}
		return user;
		
	}
			
	public User findByUserName(String userName) {
		Connection conn = jdbcUtil.getConnection();
		String sql = "select * from user where username =\"" + userName+"\"";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = new User();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getInt(4));
			}
			System.out.println(user.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.freeAll(conn, ps, rs);
		}
		return user;
	}

	@Override
	public List<User> findAll(String search) {
		// TODO Auto-generated method stub
		return null;
	}

}
