package test;

import org.springframework.beans.factory.annotation.Autowired;

import com.gxw.msc.dao.GoodsDao;

public class Test {
	@Autowired
	GoodsDao goodsDao;

	@org.junit.Test
	public void test() {
		System.out.println(goodsDao.findAll());
	}

}
