package com.nanyou.web.api;

import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nanyou.common.SecurityUtil;
import com.nanyou.web.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@ApiOperation(value = "获取个人详情")
    @GetMapping("/info")
	public ResponseEntity<?> test() {
		Map map = new HashMap();
		String username = SecurityUtil.userInfo().getUsername();
		map.put("userInfo", userService.loadUserByUsername(username));
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}
	
}
