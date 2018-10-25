package com.gxw.msc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.gxw.myrelu.MyselfRule;

@SpringBootApplication
@EnableEurekaClient // ribbon 需要先注册eureka 客户端
@RibbonClient(name = "MSC-GOODS", configuration = MyselfRule.class)
public class GoodsConsumer80_APP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(GoodsConsumer80_APP.class, args);
	}

}
