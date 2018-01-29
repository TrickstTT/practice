package com.hehe.shopping.dao.test;

import com.hehe.shopping.dao.GoodsCategoryDao;
import com.hehe.shopping.dao.Impl.GoodsCategoryDaoImpl;
import com.hehe.shopping.entity.GoodsCategory;
import com.hehe.shopping.view.GoodsCategoryMenu;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GoodsCategoryTest {
    private GoodsCategoryDao goodsCategoryDao = null;

    @Before
    public void befor(){
        goodsCategoryDao = new GoodsCategoryDaoImpl();
    }

    @Test
    public void testGetAllGoodsCategory(){
        List<GoodsCategory> list = goodsCategoryDao.getAllGoodsCategory();
        for (GoodsCategory goodsCategory : list) {
            System.out.println(goodsCategory.getName());
        }
    }
}
