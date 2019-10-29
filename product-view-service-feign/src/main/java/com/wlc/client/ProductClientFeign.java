package com.wlc.client;

import com.wlc.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Feign 客户端， 通过 注解方式 访问 访问PRODUCT-DATA-SERVICE服务的 products路径，
 * product-data-service 既不是域名也不是ip地址，而是 数据服务在 eureka 注册中心的名称。
 *
 * 注意看，这里只是指定了要访问的 微服务名称，但是并没有指定端口号到底是 8001, 还是 8002.
 * **/

/*注解由原来的
@FeignClient(value = "PRODUCT-DATA-SERVICE2")
修改为
@FeignClient(value = "PRODUCT-DATA-SERVICE2",fallback = ProductClientFeignHystrix.class)*/
/*@FeignClient(value = "PRODUCT-DATA-SERVICE2")*/
@FeignClient(value = "PRODUCT-DATA-SERVICE2",fallback = ProductClientFeignHystrix.class)
public interface ProductClientFeign {


    @GetMapping("/products")
    List<Product> listProducts();
}
