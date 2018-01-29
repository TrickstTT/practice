package com.hehe.service;

import com.hehe.bean.Goods;

import java.util.LinkedHashMap;
import java.util.List;

public interface GoodsDaoService {
    public void showAll(List<Goods> list);
    public List<Goods> getAll();
    public Goods addToBasket(LinkedHashMap<Goods, Integer> basket, String pickId, List<Goods> goods);
}
