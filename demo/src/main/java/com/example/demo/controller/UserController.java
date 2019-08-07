package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserController {
	@RequestMapping(value="/add")
	public String add() throws Exception{
		return "111增加成功";
	}
}