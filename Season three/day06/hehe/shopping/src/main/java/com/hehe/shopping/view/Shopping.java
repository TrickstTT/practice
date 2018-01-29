package com.hehe.shopping.view;

import com.hehe.shopping.entity.GoodsCategory;
import com.hehe.shopping.entity.User;

import java.util.List;

public class Shopping {
    public  void shopping() {
        User user = new Login().login();
        GoodsCategoryMenu goodsCategoryMenu = new GoodsCategoryMenu();
        List<GoodsCategory> goodsCategories = goodsCategoryMenu.showGoodsCategory();

    }

}
