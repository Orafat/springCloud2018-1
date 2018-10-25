package com.gxw.msc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gxw.msc.entity.Goods;
import com.gxw.msc.service.GoodsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class GoodsController {
	@Autowired
	GoodsService goodsService;

	@RequestMapping(value = "/goods/get/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrix_Get") // 熔断方式
	public Goods get(@PathVariable("id") Long id) {
		Goods g = goodsService.get(id);
		if (g == null) {
			throw new RuntimeException("该ID:" + id + " 没有对应信息!");
		}
		return g;
	}

	public Goods processHystrix_Get(@PathVariable("id") Long id) {
		return new Goods().setId(id).setName("该ID:" + id + " 没有对应信息,null--@HystrixCommand")
				.setDb_source("no this database in MySQL");
	}

}
