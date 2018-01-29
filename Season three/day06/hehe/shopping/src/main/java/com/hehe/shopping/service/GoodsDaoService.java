package com.hehe.shopping.service;

import com.hehe.shopping.entity.Goods;
import com.hehe.shopping.entity.GoodsCategory;

import java.util.List;

public interface GoodsDaoService {
    public List<Goods> getGoodsByGoodsCategoty(GoodsCategory goodsCategory);
}
