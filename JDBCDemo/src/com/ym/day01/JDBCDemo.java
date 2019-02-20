package com.ym.day01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ym.util.JDBCUtil;

public class JDBCDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {

			// 建立连接
			con = JDBCUtil.getConn();
			st = con.createStatement();
			String sql = "select * from student_01";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.println("id=" + id + "name = " + name + "age = " + age);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeJDBC(con, st, rs);
		}

	}

}
