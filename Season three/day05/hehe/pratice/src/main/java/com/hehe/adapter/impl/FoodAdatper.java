package com.hehe.adapter.impl;

import com.hehe.adapter.Adapter;
import com.hehe.bean.Food;

public class FoodAdatper implements Adapter {
    public void printInfo(Object object) {
        System.out.println(((Food) object).toString());
    }

    public boolean isSupport(Object object) {
        if(object instanceof Food){
            return true;
        }
        return false;
    }
}
