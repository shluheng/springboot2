package com.luheng.demo.web.message;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class JsonObj {
	
	private String code ;
	private String msg ;
	private Map<String, Object> attrs = new HashMap<String, Object>();
	

	public String toString() {
		// TODO Auto-generated method stub
		//JsonObj j = new JsonObj();
		
		return " code : "+code +", msg : "+msg + ", Map :"+attrs ;
	}
}
