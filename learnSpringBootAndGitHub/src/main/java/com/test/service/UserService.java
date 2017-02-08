package com.test.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
	
	public List<Map> userList(HttpServletRequest request);
	
	public void userAddOrEdit(HttpServletRequest request);
	
	public void userDel(String ids);

}
