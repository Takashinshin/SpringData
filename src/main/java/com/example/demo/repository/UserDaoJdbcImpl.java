package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository("UserDaoJdbcImpl")
public class UserDaoJdbcImpl implements UserDao {
	
	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public List<User> selectMany() throws DataAccessException {
		
		List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM user");
		
		List<User> userList = new ArrayList<>();
		
		for(Map<String, Object> map : getList) {
			
			User user = new User();
			//map.getでKeyに基づいたValueを取得
			user.setUserId((int) map.get("user_id"));
			user.setUserName((String) map.get("user_name"));
			user.setPassword((String) map.get("password"));
			
			userList.add(user);
		}
		return userList;
	}

}
