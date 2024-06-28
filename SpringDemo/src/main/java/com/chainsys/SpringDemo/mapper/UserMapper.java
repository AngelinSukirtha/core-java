package com.chainsys.SpringDemo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.chainsys.SpringDemo.model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		int userId = rs.getInt("user_id");
		String userName = rs.getString("user_name");
		String userPassword = rs.getString("user_password");
		String phoneNumber = rs.getString("phone_number");
		String email = rs.getString("email");
		user.setUserId(userId);
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		return user;
	}

}
