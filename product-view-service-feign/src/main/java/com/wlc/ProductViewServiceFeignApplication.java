package com.wlc;

import brave.sampler.Sampler;
import cn.hutool.core.util.NetUtil;
import com.wlc.util.CheckPortAbledUtil;
import com.wlc.util.FutureTimeOutSecondsUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @EnableFeignClients :表示使用 feign
 * @EnableDiscoveryClient： 表示用于发现注册中心微服务
 * @EnableEurekaClient:
 *
 * @EnableCircuitBreaker: 信息共享给监控中心。
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class ProductViewServiceFeignApplication {
    public static void main(String[] args) {

        int defaultPort = 8012;
       /* Future<Integer> future = ThreadUtil.execAsync(() -> {
            int p = 0;
            System.out.println("请于5秒钟内输入端口号, 推荐  8012 、 8013  或者  8014，超过5秒将默认使用" + defaultPort);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String strPort = scanner.nextLine();
                if (!NumberUtil.isInteger(strPort)) {
                    System.err.println("只能是数字");
                    continue;
                } else {
                    p = Convert.toInt(strPort);
                    scanner.close();
                    break;
                }
            }
            return p;
        });
        try {
            port = future.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            port = defaultPort;
        }*/
        /*if (!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port);
            System.exit(1);
        }*/
        //让 5秒内 输入端口号，如果超过5秒的时候，就用默认的端口号
        int port = FutureTimeOutSecondsUtil.futureTimeOutSecond(5, defaultPort);
        //测试RabbitMq 是否被占用
       /* int rabbitMQPort = 5672;
        if(NetUtil.isUsableLocalPort(port)){
            System.err.printf("未在端口%d 发现 rabbitMQ服务，请检查rabbitMQ 是否启动", rabbitMQPort );
            System.exit(1);
        }*/
        //测试端口号是否被占用了
        CheckPortAbledUtil.checkPortAbled(port);
        new SpringApplicationBuilder(ProductViewServiceFeignApplication.class).properties("server.port=" + port).run(args);
    }

    /**配置链路追踪器开始**/

    /**
     * 配置Sampler 抽样策略， ALWAYS_SAMPLE: 表示持续抽样
     **/
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
    /**配置链路追踪器结束**/
}
