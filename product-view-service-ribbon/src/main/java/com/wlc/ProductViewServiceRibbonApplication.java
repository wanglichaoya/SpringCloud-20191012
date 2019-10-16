package com.wlc;

import com.wlc.util.CheckPortAbledUtil;
import com.wlc.util.FutureTimeOutSecondsUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableDiscoveryClient， 表示用于发现eureka 注册中心的微服务。
 */

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ProductViewServiceRibbonApplication {


    public static void main(String[] args) {
        int defaultPort = 8010;
        //让 5秒内 输入端口号，如果超过5秒的时候，就用默认的端口号
        int port = FutureTimeOutSecondsUtil.futureTimeOutSecond(5, defaultPort);
        //检测端口号是否被占用
        CheckPortAbledUtil.checkPortAbled(port);
        new SpringApplicationBuilder(ProductViewServiceRibbonApplication.class).properties("server.port=" + port).run(args);
    }

    /**
     * RestTemplate  表示使用RestTemplate 这个工具来做负载均衡的
     **/
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
