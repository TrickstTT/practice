package com.hehe.mybatis.dao;

import com.hehe.mybatis.entity.Country;

public interface CountryDao {
    public Country selectCountryById(Long id);
}
