package com.gxw.myrelu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

// 自定义负载均衡 规则
@Configuration
public class MyselfRule {
	@Bean
	public IRule myRule() {
		return new MyRoundRule();
	}
}
