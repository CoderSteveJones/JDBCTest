package com.ym.test;

import org.junit.Test;

import com.ym.userDao.UserDao;
import com.ym.userDao.Impl.UserDaoImpl;

public class UserDaoTest {

	@Test
	public void testFindAll() {
	   UserDao dao =  new UserDaoImpl();
	   dao.findAll();
	}
}
