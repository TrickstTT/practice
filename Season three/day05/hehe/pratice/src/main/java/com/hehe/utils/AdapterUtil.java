package com.hehe.utils;

import com.hehe.adapter.Adapter;
import com.hehe.adapter.impl.BookAdatper;
import com.hehe.adapter.impl.ClothesAdapter;
import com.hehe.adapter.impl.FoodAdatper;

import java.util.ArrayList;
import java.util.List;

public class AdapterUtil {
    public Adapter getAdapter(Object object){
        List<Adapter> adapters = new ArrayList<Adapter>();
        adapters.add(new ClothesAdapter());
        adapters.add(new FoodAdatper());
        adapters.add(new BookAdatper());
        for (Adapter adapter : adapters) {
            if(adapter.isSupport(object)){
                return adapter;
            }
        }
        return null;
    }
}
