package kr.ac.jejunu.dao;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import kr.ac.jejunu.model.User;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest {

	@Autowired
	UserDao userDao;
	
	@Test
	public void get() {
		User user = userDao.findById("pop2331");
		assertThat(user.getId(), is("pop2331"));
		assertThat(user.getName(), is("flask"));
		assertThat(user.getPassword(), is("1"));
	}
}
