package com.hehe.shoppingweb.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSession sqlSession = null;

    public static SqlSession getSqlSession(){
        if(sqlSession == null){
            try {
                InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                SqlSessionFactory sqlsessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                sqlSession = sqlsessionFactory.openSession();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSession;
    }

}
