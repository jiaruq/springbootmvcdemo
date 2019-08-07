package com.neusoft.busmis.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;

//用户的控制类
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService us=null;
	
	@RequestMapping("/tolist")
	public String tolist(Model model) throws Exception{
		System.out.println("to list");
		List<UserModel> userList=us.getListByAll();
		model.addAttribute("userList",  userList);
		return "user/list";
		
	}
	
	@RequestMapping("/toregister")
	public String toregister() throws Exception{
		System.out.println("toregister");
		return "user/register";
		
	}
	//用户的注册处理
	@RequestMapping("/register")
	public String register(String name) throws Exception{
		System.out.println(name);
		System.out.println("注册处理");
		return "user/list";
		
	}
	
	

}
