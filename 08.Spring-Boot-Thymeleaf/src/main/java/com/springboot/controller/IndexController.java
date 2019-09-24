package com.springboot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.bean.Account;
import com.springboot.bean.Product;

@Controller
public class IndexController {

	@RequestMapping("/account")
	public String index(Model m) throws ParseException {
		List<Account> list = new ArrayList<Account>();
		list.add(new Account("KangKang", "康康", "e10adc3949ba59abbe56e", "超级管理员", "17777777777"));
		list.add(new Account("Mike", "麦克", "e10adc3949ba59abbe56e", "管理员", "13444444444"));
		list.add(new Account("Jane","简","e10adc3949ba59abbe56e","运维人员","18666666666"));
		list.add(new Account("Maria", "玛利亚", "e10adc3949ba59abbe56e", "清算人员", "19999999999"));
		m.addAttribute("accountList",list);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Product product = new Product("", 32.5, sdf.parse("2019-09-24"));
		m.addAttribute("product",product);

		String html =  "Welcome to our <b>fantastic</b> grocery store!";
		m.addAttribute("html", html);
		return "account";
	}
}
