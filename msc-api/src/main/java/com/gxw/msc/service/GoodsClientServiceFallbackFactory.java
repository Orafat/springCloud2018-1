package com.gxw.msc.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gxw.msc.entity.Goods;

import feign.hystrix.FallbackFactory;

/**
 * 针对GoodsClientService接口的服务降级 与controller解耦
 * 
 * @author G
 *
 */
@Component // 千万不能忘记在本类上添加@Component注解
public class GoodsClientServiceFallbackFactory implements FallbackFactory<GoodsClientService> {

	@Override
	public GoodsClientService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new GoodsClientService() {

			@Override
			public List<Goods> list() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Goods get(Long id) {
				// TODO Auto-generated method stub
				return new Goods().setId(id).setName("该ID:" + id + " 没有对应信息,Consumer客户端提供的降级信息,此刻服务provider已关闭")
						.setDb_source("no this database in MySQL");
			}

			@Override
			public boolean delete(Long id) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean add(Goods goods) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
