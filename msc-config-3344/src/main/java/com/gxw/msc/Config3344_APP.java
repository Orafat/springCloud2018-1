package com.gxw.msc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer // 启用 config server
public class Config3344_APP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Config3344_APP.class, args);
	}

}
