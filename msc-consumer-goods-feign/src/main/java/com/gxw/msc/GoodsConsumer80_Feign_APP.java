package com.gxw.msc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient // ribbon 需要先注册eureka 客户端
@EnableFeignClients(basePackages = "com.gxw.msc") // 使用feign
@ComponentScan(value = "com.gxw.msc") // 使用feign
public class GoodsConsumer80_Feign_APP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(GoodsConsumer80_Feign_APP.class, args);
	}

}
