package com.hehe.shoppingweb.dao;

import com.hehe.shoppingweb.entity.Goods;

import java.util.List;

public interface GoodsDao {
    public Goods findById(Long id);

    public List<Goods> findByPid(Long pid);

    public void update(Goods goods);

    public void insert(Goods goods);
}
