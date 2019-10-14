package com.wlc.controller;

import com.wlc.pojo.Product;
import com.wlc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * describe:控制类，把 Product 集合转换成 json 数组。
 *
 * @author 王立朝
 * @date 2019/10/14
 */
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public Object products(){
        List<Product> productList = productService.listProducts();
        return productList;
    }
}
