package com.hehe.mybatis.dao.test;

import com.hehe.mybatis.dao.CountryDao;
import com.hehe.mybatis.entity.Country;
import com.hehe.mybatis.entity.Province;
import com.hehe.mybatis.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class CountryDaoTest {
    private SqlSession sqlSession = null;
    private CountryDao countryDao = null;

    @Before
    public void befor(){
        sqlSession = MybatisUtil.getSqlSession();
        countryDao = sqlSession.getMapper(CountryDao.class);
    }

    @Test
    public void testSelectCountryById(){
        Country country = countryDao.selectCountryById(1L);
        System.out.println(country.getName());
        Set<Province> provinces = country.getProvinces();
        for (Province province : provinces) {
            System.out.println(province.getName());
        }
    }
}
