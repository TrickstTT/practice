package com.hehe.adapter.impl;

import com.hehe.adapter.Adapter;
import com.hehe.bean.Clothes;

public class ClothesAdapter implements Adapter {

    public void printInfo(Object object) {
        System.out.println(((Clothes) object).toString());
    }

    public boolean isSupport(Object object) {
        if(object instanceof Clothes){
            return true;
        }
        return false;
    }
}
