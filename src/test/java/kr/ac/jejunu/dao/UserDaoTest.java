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
	public void get_findById() {
		User user = userDao.findById("pop2331");
		assertThat(user.getId(), is("pop2331"));
		assertThat(user.getName(), is("flask"));
		assertThat(user.getPassword(), is("1"));
	}
	
	@Test
	public void add() {
		User user = new User("pop9310", "성의현", "2");
		userDao.add(user);
		
		User addedUser = userDao.findById("pop9310");
		assertNotNull(addedUser);
		assertThat(addedUser.getId(), is(user.getId()));
		assertThat(addedUser.getName(), is(user.getName()));
		assertThat(addedUser.getPassword(), is(user.getPassword()));
	}
	
}
