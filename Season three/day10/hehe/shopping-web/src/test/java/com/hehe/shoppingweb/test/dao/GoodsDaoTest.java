package com.hehe.shoppingweb.test.dao;

import com.hehe.shoppingweb.dao.GoodsDao;
import com.hehe.shoppingweb.entity.Goods;
import com.hehe.shoppingweb.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GoodsDaoTest {
    private SqlSession sqlSession = null;
    private GoodsDao goodsDao = null;

    @Before
    public void before(){
        sqlSession = MybatisUtil.getSqlSession();
        goodsDao = sqlSession.getMapper(GoodsDao.class);
    }

    @Test
    public void testFindById(){
        Goods goods = goodsDao.findById(8L);
        System.out.println(goods.toString());
    }

    @Test
    public void testFindByPid(){
        List<Goods> list = goodsDao.findByPid(3L);
        for (Goods goods : list) {
            System.out.println(goods.toString());
        }
    }

    @Test
    public void testUpdate(){
        goodsDao.update(new Goods(17L,10L,"简爱",47D,5,"1"));
        sqlSession.commit();
    }

    @Test
    public void testInsert(){
        Goods goods = new Goods();
        goods.setPid(10L);
        goods.setName("背影");
        goods.setPrice(33.5);
        goods.setCount(2);
        goods.setPicture("2");
        goodsDao.insert(goods);
        sqlSession.commit();
    }
    @After
    public void after(){
        sqlSession.close();
    }


}
