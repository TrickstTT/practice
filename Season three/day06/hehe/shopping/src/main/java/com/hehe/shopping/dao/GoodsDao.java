package com.hehe.shopping.dao;

import com.hehe.shopping.entity.Goods;
import com.hehe.shopping.entity.GoodsCategory;

import java.util.List;

public interface GoodsDao {
    public List<Goods> getGoodsByGoodsCategory(GoodsCategory goodsCategory);
}
