package com.hehe.utils;

import java.util.List;

public class ListUtils<T> {
    public void showAll(List<T> list){
        for (T t : list) {
            System.out.println(t.toString());
        }
    }
}
