package com.hehe.shopping.dao.Impl;

import com.hehe.shopping.dao.GoodsDao;
import com.hehe.shopping.entity.Goods;
import com.hehe.shopping.entity.GoodsCategory;
import com.hehe.shopping.utils.MybatisUtil;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public List<Goods> getGoodsByGoodsCategory(GoodsCategory goodsCategory) {
        List<Goods> list = new ArrayList<>();
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //TODO  未设置映射
        sqlSession.selectList("getGoodsByGoodsCategory",goodsCategory);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }
}
