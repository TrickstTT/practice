package com.hehe.view;

import com.hehe.bean.User;
import com.hehe.service.UserDaoService;
import com.hehe.service.impl.UserDaoServiceImpl;

import java.util.Scanner;

public class NormalShopping extends ShoppingPattern{
    @Override
    double getActualPrice(double totalPrice) {
        return totalPrice;
    }
}
