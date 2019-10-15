package com.wlc.client;

import com.wlc.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * describe:Ribbon 客户端， 通过 restTemplate 访问 http://PRODUCT-DATA-SERVICE/products ，
 * 而 product-data-service 既不是域名也不是ip地址，而是 数据服务在 eureka 注册中心的名称。
 *
 * @author 王立朝
 * @date 2019/10/15
 */
@Component
public class ProductClientRibbon {

    @Autowired
    RestTemplate restTemplate;

    public List<Product> listProducts(){
        return restTemplate.getForObject("http://PRODUCT-DATA-SERVICE2/products",List.class);

    }
}
