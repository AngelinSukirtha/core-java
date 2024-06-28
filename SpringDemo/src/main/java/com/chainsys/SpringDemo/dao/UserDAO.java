package com.chainsys.SpringDemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.chainsys.SpringDemo.model.User;

@Repository
public interface UserDAO {
	@Autowired

	public void insertUser(User user);

	public int update(User user);

	public void deleteUser(User user);

	public List<User> listUsers();

	public User findOne(Integer userId);

	public String findById(Integer userId);

	public List<User> search(String searchText);

}
