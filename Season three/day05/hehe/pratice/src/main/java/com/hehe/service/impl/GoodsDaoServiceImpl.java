package com.hehe.service.impl;

import com.hehe.adapter.Adapter;
import com.hehe.bean.Goods;
import com.hehe.dao.GoodsDao;
import com.hehe.dao.impl.GoodsDaoImpl;
import com.hehe.service.GoodsDaoService;
import com.hehe.utils.AdapterUtil;

import java.util.LinkedHashMap;
import java.util.List;

public class GoodsDaoServiceImpl implements GoodsDaoService {
    //获取所有商品
    public List<Goods> getAll(){
        GoodsDaoImpl goodsDao = new GoodsDaoImpl();
        return goodsDao.getAll();
    }

    //将物品放入购物车
    public Goods addToBasket(LinkedHashMap<Goods, Integer> basket, String pickId, List<Goods> goods) {
        GoodsDao goodsDao = new GoodsDaoImpl();
        for (Goods g : goods) {
            if(g.getId().equals(pickId)){
                if(g.getCount()>0){
                    g.setCount(g.getCount()-1);
                    if(basket.containsKey(g)){
                        basket.put(g,basket.get(g)+1);
                    }else{
                        basket.put(g,1);
                    }
                    return g;
                }
            }
        }
        return null;
    }

    //展示商品
    public void showAll(List<Goods> goods){
        AdapterUtil adapterUtil = new AdapterUtil();
        for (Goods g : goods) {
            Adapter adapter = adapterUtil.getAdapter(g);
            adapter.printInfo(g);
        }
    }
}
