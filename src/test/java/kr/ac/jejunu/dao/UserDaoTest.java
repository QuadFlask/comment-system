package kr.ac.jejunu.dao;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import kr.ac.jejunu.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/java/test-context.xml")
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
