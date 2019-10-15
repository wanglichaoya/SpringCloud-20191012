package com.wlc.service;

import com.wlc.client.ProductClientRibbon;
import com.wlc.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * describe:服务类，数据从 ProductClientRibbon中获取
 *
 * @author 王立朝
 * @date 2019/10/15
 */
@Service
public class ProductService {

    @Autowired
    ProductClientRibbon productClientRibbon;

    public List<Product> listProducts() {
        return productClientRibbon.listProducts();
    }
}
