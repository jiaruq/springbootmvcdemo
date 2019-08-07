package com.neusoft.busmis.security.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;

@RestController //@Controller + @ResponseBody
@RequestMapping("/api/user")
//@CrossOrigin
public class UserAPIController {
	
	@Autowired
	private IUserService us=null;
	
	@PostMapping(value="add01")
	public String add(String userid,String password,String name,int age,Date joinDate) throws Exception {
		
		return "OK";
	}
	
	@PostMapping(value="add02")
	public String add(@RequestBody UserModel um) throws Exception {
		System.out.println(um.getName());
		System.out.println(um.getJoinDate());
		return "OK";
	}
	
	@RequestMapping("/get")	
	public UserModel getUser(String userid) throws Exception{
		return us.getById(userid);
	}
	
	@RequestMapping(path="/get02",method= {RequestMethod.POST,RequestMethod.GET})	
	public UserModel getUser02(@PathVariable String userid) throws Exception{
		return us.getById(userid);
	}
	
	@RequestMapping(path="/get01/{userid}",method= {RequestMethod.POST,RequestMethod.GET})	
	public UserModel getUser01(@PathVariable String userid) throws Exception{
		return us.getById(userid);
	}
	
	@RequestMapping("/list")	
	public List<UserModel> getUserList() throws Exception{
		return us.getListByAll();
	}

}

