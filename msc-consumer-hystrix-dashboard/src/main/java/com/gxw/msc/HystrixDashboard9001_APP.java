package com.gxw.msc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard // 启动dashboard
public class HystrixDashboard9001_APP {
	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboard9001_APP.class, args);
	}
}
