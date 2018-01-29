package com.hehe.shopping.entity;

public class User {
    private Long id;
    private String username;
    private String password;
    private Integer isVip;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    public User(Long id, String username, String password, Integer isVip) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.isVip = isVip;
    }
}
