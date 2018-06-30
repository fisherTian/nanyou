package com.nanyou.mybatis.dao;

import com.nanyou.mybatis.CustomMapper;
import com.nanyou.mybatis.pojo.User;

public interface UserMapper extends CustomMapper<User> {
	
	User loadUserByAccount(String account);

}