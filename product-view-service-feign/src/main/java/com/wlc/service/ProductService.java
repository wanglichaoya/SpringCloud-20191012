package com.wlc.service;

import com.wlc.client.ProductClientFeign;
import com.wlc.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * describe:服务类，数据从 ProductClientFeign中获取
 *
 * @author 王立朝
 * @date 2019/10/16
 */
@Service
public class ProductService {

    @Autowired
    ProductClientFeign productClientFeign;

    public List<Product> listProducts() {
        return productClientFeign.listProducts();
    }
}
