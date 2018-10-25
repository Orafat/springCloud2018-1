package com.gxw.msc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gxw.msc.entity.Goods;

@RestController
public class GoodsController_Consumer {

//	private static final String REST_URL_PREFIX = "http://127.0.0.1:8001/";
	// 使用微服务访问
	private static final String REST_URL_PREFIX = "http://MSC-GOODS/";

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/consumer/goods/add")
	public boolean add(Goods goods) {
		System.out.println();
		return restTemplate.postForObject(REST_URL_PREFIX + "goods/add", goods, Boolean.class);
	}

	@RequestMapping(value = "/consumer/goods/get/{id}")
	public Goods get(@PathVariable Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX + "goods/get/" + id, Goods.class);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/goods/list")
	public List<Goods> list() {
		return restTemplate.getForObject(REST_URL_PREFIX + "goods/list", List.class);
	}

	@RequestMapping(value = "/consumer/goods/delete/{id}")
	public boolean delete(@PathVariable Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX + "goods/delete/" + id, Boolean.class);
	}

	// 服务发现测试
	@RequestMapping(value = "/consumer/goods/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX + "goods/discovery/", Object.class);
	}
}
