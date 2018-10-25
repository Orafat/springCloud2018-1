package com.gxw.msc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy // zuul 代理注解
public class Zuul9527_APP {
	public static void main(String[] args) {
		SpringApplication.run(Zuul9527_APP.class, args);
	}
}
