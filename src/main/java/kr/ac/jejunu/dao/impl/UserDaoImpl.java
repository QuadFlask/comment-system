package kr.ac.jejunu.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import kr.ac.jejunu.dao.UserDao;
import kr.ac.jejunu.model.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User findById(String id) {
		return getSqlSession().selectOne("userDao.findById", id);
	}

	@Override
	public void add(User user) {
		getSqlSession().insert("userDao.add", user);
	}

}
