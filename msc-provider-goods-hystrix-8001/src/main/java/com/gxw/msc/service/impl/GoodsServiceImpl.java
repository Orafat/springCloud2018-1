package com.gxw.msc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxw.msc.dao.GoodsDao;
import com.gxw.msc.entity.Goods;
import com.gxw.msc.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsDao goodsDao;

	@Override
	public boolean add(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.addGoods(goods);
	}

	@Override
	public Goods get(Long id) {
		// TODO Auto-generated method stub
		return goodsDao.findById(id);
	}

	@Override
	public List<Goods> list() {
		// TODO Auto-generated method stub
		return goodsDao.findAll();
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return goodsDao.deleteGoods(id);
	}
}
