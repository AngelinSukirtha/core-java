package com.chainsys.SpringDemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.SpringDemo.mapper.UserMapper;
import com.chainsys.SpringDemo.model.User;

@Repository
public class UserImpl implements UserDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<User> listUsers() {
		String read = "SELECT user_id, user_name, user_password, phone_number, email FROM Users";
		List<User> users = jdbcTemplate.query(read, new UserMapper());
		return users;
	}

	@Override
	public User findOne(Integer userId) {
		String read = "SELECT user_name FROM Users WHERE user_id=?";
		User oneRecord = jdbcTemplate.queryForObject(read, new UserMapper(), userId);
		return oneRecord;
	}

	public void deleteUser(User user) {
		String delete = "DELETE FROM Users WHERE user_id=?";
		Object[] params = { user.getUserId() };
		jdbcTemplate.update(delete, params);

	}

	@Override
	public String findById(Integer userId) {
		String read = "SELECT user_name From Users WHERE user_id=?";
		System.out.println("User ID passed" + userId);
		String queryForObject = null;
		try {
			queryForObject = jdbcTemplate.queryForObject(read, String.class, userId);
			System.out.println(queryForObject);
		} catch (EmptyResultDataAccessException e) {

		}
		return queryForObject;
	}

	@Override
	public void insertUser(User user) {
		String save = "INSERT INTO Users (user_name,user_password,phone_number,email) VALUES (?, ?, ?, ?)";
		Object[] params = { user.getUserName(), user.getUserPassword(), user.getPhoneNumber(), user.getEmail() };
		jdbcTemplate.update(save, params);

	}

	@Override
	public int update(User user) {
		String update = "UPDATE Users SET user_name=?,user_password=?,phone_number=? where email=?";
		Object[] params = { user.getUserName(), user.getUserPassword(), user.getPhoneNumber(), user.getEmail() };
		int rows = jdbcTemplate.update(update, params);
		return rows;
	}

}
