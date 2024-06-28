package com.chainsys.SpringDemo.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
		String read = "SELECT user_id, user_name, user_password, phone_number, email FROM Users where status=true";
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
		String delete = "update Users set status=? where user_id=?";
		Object[] params = { user.getStatus(), user.getUserId() };
		jdbcTemplate.update(delete, params);

	}

	@Override
	public void insertUser(User user) {
		String save = "INSERT INTO Users (user_name,user_password,phone_number,email,status) VALUES (?, ?, ?, ?,?)";
		Object[] params = { user.getUserName(), user.getUserPassword(), user.getPhoneNumber(), user.getEmail(), true };
		jdbcTemplate.update(save, params);

	}

	@Override
	public int update(User user) {
		String update = "UPDATE Users SET user_name=?,user_password=?,phone_number=? where email=?";
		Object[] params = { user.getUserName(), user.getUserPassword(), user.getPhoneNumber(), user.getEmail() };
		int rows = jdbcTemplate.update(update, params);
		return rows;
	}

	public List<User> search(String searchText) {
		String search = "SELECT user_id, user_name, user_password, phone_number, email " + "FROM Users "
				+ "WHERE user_id = ? OR user_name LIKE ? OR phone_number LIKE ? OR email LIKE ?";
		Object[] params = { "%" + searchText + "%", "%" + searchText + "%", "%" + searchText + "%",
				"%" + searchText + "%" };

		List<User> userList = jdbcTemplate.query(search, new UserMapper(), params);
		return userList;
	}

}
