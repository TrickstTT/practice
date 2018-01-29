package com.hehe.shopping.utils.test;

import com.hehe.shopping.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

public class MybatisUtilTest {
    private SqlSession sqlSession;
    @Before
    public void befor(){
        sqlSession = MybatisUtil.getSqlSession();
    }
    @Test
    public void test(){
        System.out.println(sqlSession);
    }
}
