package com.gxw.msc.service;

import java.util.List;

import com.gxw.msc.entity.Goods;

public interface GoodsService {
	public boolean add(Goods goods);

	public Goods get(Long id);

	public List<Goods> list();

	public boolean delete(Long id);
}
