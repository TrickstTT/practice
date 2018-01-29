package com.hehe.dao;

import com.hehe.bean.Goods;

import java.util.List;

public interface GoodsDao {
    public List<Goods> getAll();

    void subOne(Goods g, List<Goods> goods);
}