package com.nanyou.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nanyou.common.SecurityUser;
import com.nanyou.mybatis.dao.UserMapper;
import com.nanyou.mybatis.pojo.User;
import com.nanyou.web.BaseService;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService extends BaseService<UserMapper> implements UserDetailsService  {

	@Autowired
    private UserMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = mapper.loadUserByAccount(username);
		return new SecurityUser(user);
	}
	
}