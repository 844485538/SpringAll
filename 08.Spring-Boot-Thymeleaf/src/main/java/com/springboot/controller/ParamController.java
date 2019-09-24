package com.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.User;

@RestController
public class ParamController {
	
	/**
	 * GET
	 * 不使用注解，需URL参数名与方法参数名一一对应
	 *  localhost:8080/web/noAnnoation?name=peter&password=hello
	 * @param name
	 * @param password
	 * @return
	 */
	@GetMapping("/noAnnoation")
	public String getParam(String name,String password) {
		return "noAnnoation ：name : " +name+ "、password : " + password;
	}
	
	/**
	 * GET
	 * 通过HttpServletRequest获取对象
	 *  localhost:8080/web/httpServletRequest?name=peter&password=hello
	 * @param request
	 * @return
	 */
	@GetMapping("/httpServletRequest")
	public String test2( HttpServletRequest request ) {
	     String name = request.getParameter("name");
	     String password = request.getParameter("password");
	     return "httpServletRequest :name : " +name+ "、password : " + password; 
	}
	
	/**
	 * GET
	 * URL后的参数与实体类自动匹配
	 * 	localhost:8080/web/entity?name=peter&password=hello
	 * @param user
	 * @return
	 */
	@GetMapping("/entity")
	public String test2( User user ) {
	     return "User entity : name : " +user.getName()+ "、password : " + user.getPassword(); 
	}
	
	/**
	 * GET
	 * 通过占位符形式
	 * 	localhost:8080/web/placeholder/peter/hello
	 * @param name
	 * @param password
	 * @return
	 */
	@GetMapping(value = "/placeholder/{name}/{pass}")
	public String test4( @PathVariable String name, @PathVariable("pass") String password ){
	    return "@PathVariable :name : " +name+ "、password : " + password; 
	}
	
	
	/**
	 * GET
	 * 不使用注解，需URL参数名与方法参数名一一对应
	 *  localhost:8080/web/noAnnoation?name=peter&password=hello
	 * @param name
	 * @param password
	 * @return
	 */
	@GetMapping("/noAnnoation")
	public String test5(@RequestParam String name,@RequestParam String password) {
		return "noAnnoation ：name : " +name+ "、password : " + password;
	}
	
	/**
	 * POST 参数放在body中
	 * @RequestBody 注释对象，可解entity，map。。。
	 * @param user
	 * @return
	 */
	public String test6(@RequestBody User user) {
		return "User entity : name : " +user.getName()+ "、password : " + user.getPassword(); 
	}

}
