package com.gxw.msc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gxw.msc.entity.Goods;
import com.gxw.msc.service.GoodsService;

@RestController
public class GoodsController {
	@Autowired
	GoodsService goodsService;

	// 服务发现
	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "/goods/discovery", method = RequestMethod.GET)
	public Object discovery() {
		List<String> list = discoveryClient.getServices();
		System.out.println("*********" + list);

		List<ServiceInstance> srvList = discoveryClient.getInstances("MSC-GOODS");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.discoveryClient;
	}
	// 服务发现

	@RequestMapping(value = "/goods/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Goods goods) {
		System.out.println();
		return goodsService.add(goods);
	}

	@RequestMapping(value = "/goods/get/{id}", method = RequestMethod.GET)
	public Goods get(@PathVariable Long id) {
		return goodsService.get(id);
	}

	@RequestMapping(value = "/goods/list", method = RequestMethod.GET)
	public List<Goods> list() {
		return goodsService.list();
	}

	@RequestMapping(value = "/goods/delete/{id}", method = RequestMethod.GET)
	public boolean delete(@PathVariable Long id) {
		return goodsService.delete(id);
	}
}
