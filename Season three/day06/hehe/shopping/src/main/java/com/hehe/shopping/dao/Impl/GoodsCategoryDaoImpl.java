package com.hehe.shopping.dao.Impl;

import com.hehe.shopping.dao.GoodsCategoryDao;
import com.hehe.shopping.entity.GoodsCategory;
import com.hehe.shopping.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class GoodsCategoryDaoImpl implements GoodsCategoryDao {
    @Override
    public List<GoodsCategory> getAllGoodsCategory() {
        List<GoodsCategory> list = new ArrayList<>();
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //TODO  未设置映射
        list = sqlSession.selectList("getAllGoodsCategory");
        sqlSession.commit();
        sqlSession.close();
        return list;
    }
}
