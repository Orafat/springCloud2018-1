package com.gxw.msc.dao;
//!!!!

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gxw.msc.entity.Goods;

@Mapper
public interface GoodsDao {
	public boolean addGoods(Goods goods);

	public Goods findById(Long id);

	public List<Goods> findAll();

	public boolean deleteGoods(Long id);
}
