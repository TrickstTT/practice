package com.hehe.view;

import com.hehe.bean.Goods;
import com.hehe.bean.User;
import com.hehe.service.GoodsDaoService;
import com.hehe.service.UserDaoService;
import com.hehe.service.impl.GoodsDaoServiceImpl;
import com.hehe.service.impl.UserDaoServiceImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public abstract class ShoppingPattern {
    //声明购物车集合
    private LinkedHashMap<Goods,Integer> basket;
    //获取所有商品（初始化商品）
    private List<Goods> goods;
    public ShoppingPattern(){
        basket = new LinkedHashMap<Goods,Integer>();
        goods =  new GoodsDaoServiceImpl().getAll();
    }
    //购物流程
    public final void shopping(User user){
        GoodsDaoService goodsDaoService = new GoodsDaoServiceImpl();
        Scanner sc = new Scanner(System.in);
        //展示商品
        showAllGoods(goods);
        //购物流程
        while(true){
            System.out.print("请输入id号选择商品加入购物车(“check”查看购物车,“exit”退出)：");
            String pickId = sc.next();
            if("check".equals(pickId)){
                check(user,sc);
                continue;
            }
            if("exit".equals(pickId)){
                System.out.println("退出成功");
                break;
            }
            //将商品放入购物车
            Goods result = goodsDaoService.addToBasket(basket,pickId,goods);
            if(result!=null){
                System.out.println("添加购物车成功");
            }else{
                System.out.println("商品库存不足");
            }
            System.out.println("================================");
        }
    }
    //支付
    public void pay(double totalPrice,double actualPrice, User user, Scanner sc) {
        UserDaoService userDaoService = new UserDaoServiceImpl();
        System.out.println(user.toString());
        double money1 = user.getMoneyOne();
        double money2 = user.getMoneyTwo();
        while(true){
            System.out.println("请选择支付方式（1.支付宝，2.微信,其他输入退出）");
            String input = sc.next();
            if("1".equals(input)){
                if(money1<totalPrice){
                    System.out.println("支付宝余额不足");
                }else{
                    userDaoService.pay(actualPrice,user,"1");
                    System.out.println("支付成功：总计"+totalPrice+"元，实付"+actualPrice+"元");
                    break;
                }
            }else if("2".equals(input)){
                if(money2<totalPrice){
                    System.out.println("微信余额不足");
                }else{
                    userDaoService.pay(actualPrice,user, "2");
                    System.out.println("支付成功：总计"+totalPrice+"元，实付"+actualPrice+"元");
                    break;
                }
            }else{
                break;
            }
        }
    }

    //查看购物车
    private final void check(User user, Scanner sc) {
        System.out.println("==========购物车============");
        double totalPrice = 0.0;
        if(basket!=null&&basket.size()!=0){
            basket.forEach((k,v)->{
                System.out.println("商品："+k.getName()+"，价格："+k.getPrice()+"，件数："+v);
            });
            Set<Goods> set = basket.keySet();
            for (Goods goods : set) {
                totalPrice += goods.getPrice()*basket.get(goods);
            }
            System.out.println("总价格："+totalPrice);
            System.out.println("输入1结算，其他输入不结算");
            String input = sc.next();
            if("1".equals(input)){
                pay(totalPrice,getActualPrice(totalPrice),user,sc);
            }
        }else{
            System.out.println("购物车为空");
        }
        System.out.println("=============================");
        showAllGoods(goods);
    }

    abstract double getActualPrice(double totalPrice);

    //展示所有商品
    private final void showAllGoods(List<Goods> list){
        System.out.println("===============商品信息==================");
        GoodsDaoService goodsDaoService = new GoodsDaoServiceImpl();
        goodsDaoService.showAll(list);
        System.out.println("========================================");
    }

}
