package kr.ac.jejunu.dao;

import javax.sql.DataSource;

import kr.ac.jejunu.model.User;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class UserDao {

	private DataSource dataSource;

	public User findById(String id) {
		SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
		return simpleJdbcTemplate.queryForObject("select id,name,password from USER where id=?",
				new BeanPropertyRowMapper<User>(User.class), id);
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void add(User user) {
	}

}
