package com.wlc;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *  @EnableDiscoveryClient， 表示用于发现eureka 注册中心的微服务。
 */

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ProductViewServiceRibbonApplication {


    public static void main(String[] args) {
       int port = 0;
        int defalutPort = 8010;
        Future<Integer> future = ThreadUtil.execAsync(()->{
           int p = 0;
            System.out.println("请在5秒内输入端口号，推荐 8010，超过5秒将使用：" + defalutPort);
            Scanner scanner = new Scanner(System.in);
            while (true){
                String strPort = scanner.nextLine();
                //判断输入的是否是数字
                if(!NumberUtil.isInteger(strPort)){
                    System.out.println("只能输入数字");
                    continue;
                }else{
                    p= Convert.toInt(strPort);
                    scanner.close();
                    break;
                }
            }
            return p;
        });
        try{
            port = future.get(5, TimeUnit.SECONDS);
        }catch (InterruptedException | ExecutionException | TimeoutException e){
            port = defalutPort;
        }
        if(!NetUtil.isUsableLocalPort(port)){
            System.out.printf("端口%d被占用了，无法启动%n",port);
            System.exit(1);
        }
        new SpringApplicationBuilder(ProductViewServiceRibbonApplication.class).properties("server.port="+port).run(args);
    }

    /**
     * RestTemplate  表示使用RestTemplate 这个工具来做负载均衡的
     * **/
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
