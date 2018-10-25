package com.gxw.msc.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gxw.msc.entity.Goods;

//@FeignClient(value = "MSC-GOODS") // feign 注解
@FeignClient(value = "MSC-GOODS", fallbackFactory = GoodsClientServiceFallbackFactory.class) // 服务降级
public interface GoodsClientService {
	@RequestMapping(value = "/goods/add")
	public boolean add(Goods goods);

	@RequestMapping(value = "/goods/get/{id}")
	// 注意 若有@PathVariable 使用在FeignClient中,必须指明@PathVariable(value = "id")
	public Goods get(@PathVariable(value = "id") Long id);

	@RequestMapping(value = "/goods/list")
	public List<Goods> list();

	@RequestMapping(value = "/goods/delete/{id}")
	public boolean delete(@PathVariable(value = "id") Long id);
}
