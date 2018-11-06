package com.luheng.demo.web.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
public class UserModel {

	private String id ;
	private String userName;
	private String userBrith;


	@Override
	public String toString() {
		return "UserModel [id=" + id + ", userName=" + userName + ", userBrith=" + userBrith + "]";
	}
	
	
	
	
	public static void main(String[] args) {
		UserModel userModel = new UserModel();
		userModel.setUserName("zzz");
		log.info(userModel.toString());
	}


}
