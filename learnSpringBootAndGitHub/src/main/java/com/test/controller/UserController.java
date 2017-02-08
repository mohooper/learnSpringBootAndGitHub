package com.test.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.service.UserService;
//import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/", method = { RequestMethod.POST, RequestMethod.GET })
    public String index(HttpServletRequest request){
		try {
			
	        return  "/userIndex";
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return "/userIndex";
		
    }
	
	@RequestMapping(value = "/user/list", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
    public String userList(HttpServletRequest request){//Map<String,Object> model
		try {
	        List<Map> data = userService.userList(request);
	        
	        JsonConfig j = new JsonConfig();
	        JSONArray jsonArray = JSONArray.fromObject(data, j);
	        return "{\"isSuc\":\"1\",\"rows\":"+jsonArray.toString()+"}";
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return "{\"isSuc\":\"0\"}";
		
    }
	
	@RequestMapping(value = "/user/save", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
    public String userSave(HttpServletRequest request){//Map<String,Object> model
		try {
	       
			userService.userAddOrEdit(request);
			
	        return "{\"isSuc\":\"1\"}";
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return "{\"isSuc\":\"0\"}";
		
    }
	
	@RequestMapping(value = "/user/del", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
    public String userDel(HttpServletRequest request){//Map<String,Object> model
		try {
	       
			userService.userDel(request.getParameter("ids"));
			
	        return "{\"isSuc\":\"1\"}";
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return "{\"isSuc\":\"0\"}";
		
    }
	
	 
	 
}
