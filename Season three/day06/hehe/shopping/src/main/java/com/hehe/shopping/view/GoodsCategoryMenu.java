package com.hehe.shopping.view;

import com.hehe.shopping.entity.GoodsCategory;
import com.hehe.shopping.service.GoodsCategoryService;
import com.hehe.shopping.service.impl.GoodsCategoryServiceImpl;
import com.hehe.shopping.utils.StringUtil;

import java.util.List;
import java.util.Scanner;

public class GoodsCategoryMenu {
    public List<GoodsCategory> showGoodsCategory(){
        StringUtil.printHr("商品类型表");
        GoodsCategoryService goodsCategoryService = new GoodsCategoryServiceImpl();
        List<GoodsCategory> allGoodsCategory = goodsCategoryService.getAllGoodsCategory();
        System.out.println("ID       商品类型");
        for (GoodsCategory goodsCategory : allGoodsCategory) {
            System.out.println(String.format("%s       %s",goodsCategory.getId(),goodsCategory.getName()));
        }
        System.out.println("exit       退出");
        StringUtil.printHr();
        chooseGoodsCategory(allGoodsCategory);
        return allGoodsCategory;
    }

    public void chooseGoodsCategory(List<GoodsCategory> allGoodsCategory){
        System.out.print("请按商品类型ID选择商品种类（exit退出登录）：");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        if("exit".equals(id)){
            System.out.println("已退出");
            new Login().login();
        }
        boolean flag = false;
        for (GoodsCategory goodsCategory : allGoodsCategory) {
            if(goodsCategory.getId().equals(id)){
                new GoodsMenu().showGoods(goodsCategory);
                flag = true;
            }
        }
        if(flag == false){
            System.out.println("所选商品不存在");
            chooseGoodsCategory(allGoodsCategory);
        }
    }

}
