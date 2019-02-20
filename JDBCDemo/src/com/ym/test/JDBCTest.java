package com.ym.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.ym.util.JDBCUtil;

public class JDBCTest {

	// 增
	@Test
	public void testAdd() {
		
		Connection con = null;
		Statement st = null;
		try {
			con = JDBCUtil.getConn();
		    st = con.createStatement();
		    String sql = "insert into student_01 values (null, 'xiaomi', 10);";
		    int resutl = st.executeUpdate(sql);
		    if (resutl > 0) {
		    	System.err.println("添加成功");
			} else {
				System.err.println("添加失败");
			}
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConAndState(con, st);
		}
	}
	
	// 删
	@Test
	public void testDelete() {

		Connection con = null;
		Statement st = null;
		try {
			con = JDBCUtil.getConn();
			st = con.createStatement();
			String sql = "delete from student_01 where name = 'xiaomi'";
			int resutl = st.executeUpdate(sql);
			if (resutl > 0) {
				System.err.println("删除成功");
			} else {
				System.err.println("删除失败");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConAndState(con, st);
		}
	}
	
	// 改
	@Test
	public void testUpdate() {

		Connection con = null;
		Statement st = null;
		try {
			con = JDBCUtil.getConn();
			st = con.createStatement();
			String sql = "update student_01 set name = 'xiaohoong' where name = '张三'";
			int resutl = st.executeUpdate(sql);
			if (resutl > 0) {
				System.err.println("修改成功");
			} else {
				System.err.println("修改失败");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConAndState(con, st);
		}
	}
	
	
	// 查
		@Test
		public void testQuery() {
			
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			try {
				con = JDBCUtil.getConn();
			    st = con.createStatement();
			    String sql = "select * from student_01";
			    rs = st.executeQuery(sql);
			    while (rs.next()) {
					String name = rs.getString("name");
					int age = rs.getInt("age");
					System.out.println("name = " + name + "age = " + age);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.closeJDBC(con, st, rs);
			}
		}
}
