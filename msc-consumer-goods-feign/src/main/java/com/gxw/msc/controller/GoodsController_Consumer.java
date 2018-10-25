package com.gxw.msc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gxw.msc.entity.Goods;
import com.gxw.msc.service.GoodsClientService;

@RestController
public class GoodsController_Consumer {
	@Autowired
	GoodsClientService service;

	@RequestMapping(value = "/consumer/goods/add", method = RequestMethod.POST)
	public boolean add(Goods goods) {
		return this.service.add(goods);
	}

	@RequestMapping(value = "/consumer/goods/get/{id}", method = RequestMethod.GET)
	public Goods get(@PathVariable Long id) {
		return this.service.get(id);
	}

	@RequestMapping(value = "/consumer/goods/list", method = RequestMethod.GET)
	public List<Goods> list() {
		return this.service.list();
	}

	@RequestMapping(value = "/consumer/goods/delete/{id}", method = RequestMethod.GET)
	public boolean delete(@PathVariable Long id) {
		return this.service.delete(id);
	}
}
