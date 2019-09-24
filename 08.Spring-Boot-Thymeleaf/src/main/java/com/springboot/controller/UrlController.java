package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UrlController {
	
	@RequestMapping("/url")
	public String getUrlPage() {
		return "url";
	}

}
