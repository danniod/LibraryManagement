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

public class StuDaoImpl implements UserDao<Stu> {

	@Override
	public int insert(Stu stu) {

		Connection conn = jdbcUtil.getConnection();
		String sql = "insert into user values(?,?,?,3);" +
				"insert into reader values(?,?,?,?,?,?,0)";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, stu.getId());
			ps.setString(2, stu.getUserName());
			ps.setString(3, stu.getPassword());
			ps.setInt(4, stu.getId());
			ps.setString(5, stu.getName());
			ps.setByte(6, stu.getSex());
			ps.setString(7, stu.getSpec());
			ps.setLong(8, stu.getTel());
			ps.setDate(9, new java.sql.Date(stu.getBirthday().getTime()));
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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
		String sql = "select * from user,reader  where id ="+id;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Stu t= new Stu();
		try {
			ps= conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				//TODO 未完成
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Stu> findAll() {
		return null;
	}

	
	
	
//	public static void main(String[] args) {
//		Stu s = new Stu(13013001,"zhangsan","123456","张三",(byte) 1,"信息学院",new Date(94,9,1) , 13915317191L);
//		StuDaoImpl dao = new StuDaoImpl();
//		dao.insert(s);
//		SimpleDateFormat simple = new SimpleDateFormat("yyyy年MM月dd日");
//		System.out.println(simple.format(s.getBirthday()));
//	}
}
