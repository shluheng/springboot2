package com.luheng.demo.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luheng.demo.web.model.UserModel;

@Controller
public class TestController {

	@RequestMapping("/index")//HTTP请求O
	public String test(Model model) {
		System.out.println("TestController >>> index >>>is running....return a string");
		model.addAttribute("content", "Hello world !");
		return "/main/login";//返回一个视图（HTML页面）
	}
	
	
	@RequestMapping("/indexMain")//HTTP请求
	public String main(Model model) {
		System.out.println("TestController >>> main >>>is running....return a string");
		UserModel  user = new UserModel();
		user.setUserName("柳涣歌");
		user.setId("11");
		user.setUserBrith("2018-10-10");
		model.addAttribute("code", "SUCCESS");
		model.addAttribute("msg", "all is ok");
		model.addAttribute("user", user);
		
		List<UserModel> users = new ArrayList<UserModel>();
		users.add(user);
		UserModel tmpuser =  null;
		for(int i = 1 ; i< 10 ;i++) {
			tmpuser = new UserModel();
			tmpuser.setId("2"+i);
			tmpuser.setUserName("张小菜"+i);
			tmpuser.setUserBrith("199"+i);

			users.add(tmpuser);
		}
		model.addAttribute("users", users);
		return "/main/main";//返回一个视图（HTML页面）
	}

	@RequestMapping("/json")//HTTP请求
	@ResponseBody
	public UserModel json(Model model) {
		System.out.println("TestController >>> json >>>is running....return a string");
		UserModel  user = new UserModel();
		user.setUserName("柳涣歌");
		user.setId("11");
		user.setUserBrith("2018-10-10");
		return user;//返回json
	}
}
