package com.hehe.view;

import com.hehe.bean.User;

public class index {
    public static void main(String[] args) {
        Login login = new Login();
        User user = login.login();
        ShoppingPattern shoppingPattern ;
        if("vip".equals(user.getUserName())){
            shoppingPattern = new VipShopping();
        }else{
            shoppingPattern = new NormalShopping();
        }
        shoppingPattern.shopping(user);
    }
}
