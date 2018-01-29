package com.hehe.shopping.view;

import com.hehe.shopping.entity.Goods;
import com.hehe.shopping.entity.GoodsCategory;
import com.hehe.shopping.service.GoodsDaoService;
import com.hehe.shopping.service.impl.GoodsDaoServiceImpl;
import com.hehe.shopping.utils.StringUtil;

import java.util.List;

public class GoodsMenu {
    public void showGoods(GoodsCategory goodsCategory){
        GoodsDaoService goodsDaoService = new GoodsDaoServiceImpl();
        List<Goods> goodsList = goodsDaoService.getGoodsByGoodsCategoty(goodsCategory);
        StringUtil.printHr("商品表");
        System.out.println("ID       商品名       价格       库存");
        for (Goods goods : goodsList) {
            System.out.println(String.format("%s       %s       %s       %s",
                    goods.getId(),goods.getName(),goods.getPrice(),goods.getCount()));
        }
        System.out.println("exit      退出");
        StringUtil.printHr();
    }

}
