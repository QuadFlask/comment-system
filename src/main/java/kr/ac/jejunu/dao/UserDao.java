package kr.ac.jejunu.dao;

import kr.ac.jejunu.model.User;

public interface UserDao {

	public abstract User findById(String id);

	public abstract void add(User user);

}