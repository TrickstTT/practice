package com.hehe.shopping.service.impl;

import com.hehe.shopping.dao.GoodsCategoryDao;
import com.hehe.shopping.dao.Impl.GoodsCategoryDaoImpl;
import com.hehe.shopping.entity.GoodsCategory;
import com.hehe.shopping.service.GoodsCategoryService;

import java.util.List;

public class GoodsCategoryServiceImpl implements GoodsCategoryService {
    @Override
    public List<GoodsCategory> getAllGoodsCategory() {
        GoodsCategoryDao goodsCategoryDao = new GoodsCategoryDaoImpl();
        return goodsCategoryDao.getAllGoodsCategory();
    }
}
