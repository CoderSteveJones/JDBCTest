package com.ym.userDao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ym.userDao.UserDao;
import com.ym.util.JDBCUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public void findAll() {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from t_user";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				System.out.println("username =" + username + "password =" + password);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeJDBC_01(conn, ps, rs);
		}
	}
}
