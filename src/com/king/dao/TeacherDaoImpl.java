package com.king.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.king.entry.Teacher;
import com.king.util.jdbcUtil;

public class TeacherDaoImpl implements IDao<Teacher>{

	@Override
	public int insert(Teacher t) {

		Connection conn = jdbcUtil.getConnection();
		String sql = "insert into reader values(?,?,?,?,?,?,0)";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, t.getId());
			ps.setString(2, t.getName());
			ps.setByte(3, t.getSex());
			ps.setString(4, t.getSpec());
			ps.setLong(5, t.getTel());
			ps.setDate(6, new java.sql.Date(t.getBirthday().getTime()));

			result = ps.executeUpdate();
		} catch (SQLException e) {
			if (e.getErrorCode() == 1452) {
				String sql1 = "insert into user values(?,?,?,3)";
				try {
					PreparedStatement ps1 = conn.prepareStatement(sql1);
					ps1.setInt(1, t.getId());
					ps1.setString(2, t.getUserName());
					ps1.setString(3, t.getPassword());

					ps1.executeUpdate();
				} catch (SQLException e1) {
					System.err.println("user表未插入");
				} finally {
					try {
						result = ps.executeUpdate();
					} catch (SQLException e1) {
						System.err.println("reader表未插入");
					}
				}
			} else {
				e.printStackTrace();
			}
		} finally {
			jdbcUtil.freeAll(conn, ps);
		}
		return result;
	}

	@Override
	public int delete(Teacher t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Teacher t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Teacher findById(Integer id) {

		Connection conn = jdbcUtil.getConnection();
		String sql = "select from user,reader  where id =" + id;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Teacher t = new Teacher();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				t.setId(rs.getInt(1));
				t.setUserName(rs.getString(2));
				t.setPassword(rs.getString(3));
				t.setName(rs.getString(6));
				t.setGender(rs.getByte(7));
				t.setSpec(rs.getString(8));
				t.setTel(rs.getLong(9));
				t.setBirthday(rs.getDate(10));
				t.setCount(rs.getInt(11));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.freeAll(conn, ps, rs);
		}
		return t;
	}

	@Override
	public List<Teacher> findAll(String search) {
		// TODO Auto-generated method stub
		return null;
	}

}
