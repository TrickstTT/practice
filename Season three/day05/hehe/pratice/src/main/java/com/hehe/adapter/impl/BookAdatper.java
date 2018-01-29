package com.hehe.adapter.impl;

import com.hehe.adapter.Adapter;
import com.hehe.bean.Book;

public class BookAdatper implements Adapter {
    public void printInfo(Object object) {
        System.out.println(((Book) object).toString());
    }

    public boolean isSupport(Object object) {
        if(object instanceof Book){
            return true;
        }
        return false;
    }
}
