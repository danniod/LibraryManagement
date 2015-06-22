package com.king.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.king.entry.Stu;
import com.king.util.jdbcUtil;

public class StuDaoImpl implements IDao<Stu> {

	@Override
	public int insert(Stu stu) {

		Connection conn = jdbcUtil.getConnection();
		String sql = "insert into reader values(?,?,?,?,?,?,0)";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, stu.getId());
			ps.setString(2, stu.getName());
			ps.setByte(3, stu.getSex());
			ps.setString(4, stu.getSpec());
			ps.setLong(5, stu.getTel());
			ps.setDate(6, new java.sql.Date(stu.getBirthday().getTime()));

			result = ps.executeUpdate();
		} catch (SQLException e) {
			if (e.getErrorCode() == 1452) {
				System.out.println("//////");
				String sql1 = "insert into user values(?,?,?,3)";
				try {
					PreparedStatement ps1 = conn.prepareStatement(sql1);
					ps1.setInt(1, stu.getId());
					ps1.setString(2, stu.getUserName());
					ps1.setString(3, stu.getPassword());

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
	public int delete(Stu t) {
		return 0;
	}

	@Override
	public int update(Stu t) {
		return 0;
	}

	@Override
	public Stu findById(Integer id) {

		Connection conn = jdbcUtil.getConnection();
		String sql = "select from user,reader  where id =" + id;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Stu t = new Stu();
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
	public List<Stu> findAll(String search) {
		return null;
	}

}
