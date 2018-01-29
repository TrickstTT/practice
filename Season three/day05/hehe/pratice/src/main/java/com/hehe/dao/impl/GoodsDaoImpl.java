package com.hehe.dao.impl;

import com.hehe.bean.Book;
import com.hehe.bean.Clothes;
import com.hehe.bean.Food;
import com.hehe.bean.Goods;
import com.hehe.dao.GoodsDao;

import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {

    private List<Goods> goods;
    //获取所有商品
    public List<Goods> getAll(){
        goods = new ArrayList<Goods>();
        goods = new ArrayList<Goods>();
        goods.add(new Clothes("1","上衣",456.25,7));
        goods.add(new Clothes("2","裤子",222.25,7));
        goods.add(new Clothes("3","外套",788.25,7));
        goods.add(new Food("4","辣条",45.25,7));
        goods.add(new Food("5","酸奶",45.25,7));
        goods.add(new Food("6","嘎嘣脆",45.25,7));
        goods.add(new Book("7","五年高考三年模拟",45.25,7));
        goods.add(new Book("8","思想品德",45.25,7));
        goods.add(new Book("9","高等数学",45.25,7));
        return goods;
    }

    public void subOne(Goods g, List<Goods> goods) {
        g.setCount(g.getCount()-1);
    }
}
