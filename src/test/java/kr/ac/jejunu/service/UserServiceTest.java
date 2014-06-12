package kr.ac.jejunu.service;

import static org.junit.Assert.*;
import kr.ac.jejunu.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/java/test-context.xml")
public class UserServiceTest {

	@Autowired
	UserService userService;

	@Test
	public void login() {
		User user = new User("pop2331", null, "1", null);
		assertTrue(userService.login(user));
	}
}
