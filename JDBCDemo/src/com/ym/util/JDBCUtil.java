package com.ym.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.PreparedStatement;


public class JDBCUtil {

	
	static String driverClass = null;
	static String url = null;
	static String name = null;
	static String pwd = null;
	
	static {
		
		Properties properties = new Properties();
		InputStream iStream = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			properties.load(iStream);
			driverClass = properties.getProperty("driverClass");
			url = properties.getProperty("url");
			name = properties.getProperty("name");
			pwd = properties.getProperty("pwd");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	// 注册连接
	public static Connection getConn() {
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, name, pwd);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}
	
	// 关闭jdbc
	public static void closeJDBC(Connection con,Statement st,ResultSet rs) {
		
		JDBCUtil.closeConnection(con);
		JDBCUtil.closeStatement(st);
		JDBCUtil.closeResult(rs);
	}
	
	// 关闭jdbc
	public static void closeJDBC_01(Connection con, java.sql.PreparedStatement ps, ResultSet rs) {

		JDBCUtil.closeConnection(con);
		JDBCUtil.closePrepareStatement(ps);
		JDBCUtil.closeResult(rs);
	}
	
	// 重载方法 关闭con 和 statement
	public static void closeConAndState(Connection con,Statement st){
		JDBCUtil.closeConnection(con);
		JDBCUtil.closeStatement(st);
	}
	
	// 关闭结果集
	private static void closeResult(ResultSet rs) {
		
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rs = null;
		}
	}
	
	// 关闭statement
	private static void closeStatement(Statement st) {
		try {
			if (st != null) {
				st.close();
			} 
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			st = null;
		}
	}
	
	// 关闭parpareStatement
	private static void closePrepareStatement(java.sql.PreparedStatement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			st = null;
		}
	}
	
	// 关闭连接
	private static void closeConnection(Connection conn) {
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
		
	}
}
