package com.hehe.shopping.service.impl;

import com.hehe.shopping.dao.Impl.GoodsDaoImpl;
import com.hehe.shopping.entity.Goods;
import com.hehe.shopping.entity.GoodsCategory;
import com.hehe.shopping.service.GoodsDaoService;

import java.util.List;

public class GoodsDaoServiceImpl implements GoodsDaoService {
    @Override
    public List<Goods> getGoodsByGoodsCategoty(GoodsCategory goodsCategory) {
        return new GoodsDaoImpl().getGoodsByGoodsCategory(goodsCategory);
    }
}
