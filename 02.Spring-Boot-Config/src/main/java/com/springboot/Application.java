package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.springboot.bean.ConfigBean;
import com.springboot.bean.TestConfigBean;

@SpringBootApplication
// 使@ConfigurationProperties注解生效
@EnableConfigurationProperties({ConfigBean.class,TestConfigBean.class})
//@ImportResource({"classpath:some-application.xml"})
public class Application {
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		// 是否公开命令行参数
		app.setAddCommandLineProperties(false);
		app.run(args);
	}
}
