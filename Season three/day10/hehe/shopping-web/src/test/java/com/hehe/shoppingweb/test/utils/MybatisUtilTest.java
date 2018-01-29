package com.hehe.shoppingweb.test.utils;

import com.hehe.shoppingweb.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MybatisUtilTest {
    private MybatisUtil mybatisUtil = null;
    private SqlSession sqlSession = null;

    @Before
    public void before(){
        mybatisUtil = new MybatisUtil();
    }

    @Test
    public void testGetSqlSession(){
        sqlSession = mybatisUtil.getSqlSession();
        System.out.println(sqlSession);
    }

    @After
    public void after(){
        sqlSession.close();
    }
}
