package com.wlc;

import com.wlc.util.CheckPortAbledUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * describe:
 * @EnableDiscoveryClient
 * @EnableEurekaClient   共同点就是：都是能够让注册中心能够发现，扫描到改服务。
 *
 * 不同点：
 *  @EnableEurekaClient只适用于Eureka作为注册中心，
 *  @EnableDiscoveryClient 可以是其他注册中心。

 *
 * @author 王立朝
 * @date 2019/10/29
 */
@SpringBootApplication
//@EnableZuulProxy :zuul 网关， 用网关来解决微服务 ip 和端口号 容易修改的问题，比如端口号太多，这些，用网关 只需要记住网关的
// 的ip 和端口号即可。
@EnableZuulProxy
//@EnableEurekaClient: 让注册中心可以发现。
@EnableEurekaClient
@EnableDiscoveryClient
public class ProductServiceZuulApplication {

    public static void main(String[] args){
        int port = 8040;
        CheckPortAbledUtil.checkPortAbled(port);
        new SpringApplicationBuilder(ProductServiceZuulApplication.class).properties("server.port="+ port).run(args);

    }
}
