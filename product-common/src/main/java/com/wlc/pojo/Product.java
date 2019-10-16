package com.wlc.pojo;

/**
 * describe:微服务公共的实体类
 *
 * @author 王立朝
 * @date 2019/10/16
 */
public class Product {

    private int id ;
    private String name ;
    private int price ;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
