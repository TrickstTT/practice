package com.hehe.shoppingweb.entity;

public class Goods {
    private Long id;
    private Long pid;
    private String name;
    private Double price;
    private Integer count;
    private String picture;

    public Goods() {

    }

    public Goods(Long id, Long pid, String name, Double price, Integer count, String picture) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.count = count;
        this.picture = picture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", picture='" + picture + '\'' +
                '}';
    }
}
