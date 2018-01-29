package com.hehe.bean;

public class User {
    private String userName;
    private String password;
    private double moneyOne;
    private double moneyTwo;

    public User(String userName, String password, double moneyOne, double moneyTwo) {
        this.userName = userName;
        this.password = password;
        this.moneyOne = moneyOne;
        this.moneyTwo = moneyTwo;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public double getMoneyOne() {
        return moneyOne;
    }

    public void setMoneyOne(double moneyOne) {
        this.moneyOne = moneyOne;
    }

    public double getMoneyTwo() {
        return moneyTwo;
    }

    public void setMoneyTwo(double moneyTwo) {
        this.moneyTwo = moneyTwo;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "用户名："+userName+
                "，支付宝：" + moneyOne +
                ", 微信：" + moneyTwo ;
    }
}
