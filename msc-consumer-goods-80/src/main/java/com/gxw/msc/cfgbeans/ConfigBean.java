package com.gxw.msc.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
	@Bean
	@LoadBalanced // 给rest客户端增加负载均衡功能ribbon
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
