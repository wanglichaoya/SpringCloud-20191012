package com.wlc.service;

import com.wlc.pojo.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 * 服务类提供一个Product集合，
 * 注意： 把端口号放入到了产品信息里面。因为这个数据服务会做成集群，那么访问者为了分辨
 * 到底是从哪个数据微服务中取的数据，就需要提供这个端口号，才能意识到是从不同的微服务中取到的数据
 *
 * @author 王立朝
 * @date 2019/10/14
 */
@Service
public class ProductService {

    @Value("${server.port}")
    String port;

    public List<Product> listProducts(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1,"product a from port"+port,50));
        productList.add(new Product(2,"product a from port"+port,100));
        productList.add(new Product(3,"product a from port"+port,150));
        return productList;
    }

}
