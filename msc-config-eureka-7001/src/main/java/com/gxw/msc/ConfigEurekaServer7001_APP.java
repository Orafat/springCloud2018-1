package com.gxw.msc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // 标注启动的组件为eureka server 用来接受其他服务注册
@SpringBootApplication
public class ConfigEurekaServer7001_APP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ConfigEurekaServer7001_APP.class, args);
	}

}
