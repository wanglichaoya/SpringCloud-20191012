package com.wlc.client;


import com.wlc.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @author 王立朝
 * @date 2019/10/28
 */
@Component
public class ProductClientFeignHystrix implements ProductClientFeign {
    @Override
    public List<Product> listProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(0,"产品数据微服务不可用",0));
        return productList;
    }
}
