package kr.ac.jejunu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejunu.dao.UserDao;
import kr.ac.jejunu.model.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public boolean login(User user) {
		User findById = userDao.findById(user.getId());
		if (findById != null) {
			user.setName(findById.getName());
			user.setExplanation(findById.getExplanation());
			return findById.getPassword().equals(user.getPassword());
		}
		return false;
	}

}
