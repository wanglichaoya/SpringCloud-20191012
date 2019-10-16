package com.wlc;

import com.wlc.util.CheckPortAbledUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * describe: 服务注册中心
 *
 * @author 王立朝
 * @date 2019/10/12
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    /*@Autowired
    CheckPortAbledUtil checkPortAbledUtil;*/
    public static void main(String[] args) {
        //8761 这个端口是默认的，就不要修改了，后面的子项目，都会访问这个端口。
        int port = 8761;
        /*if(!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }*/
        //测试端口是否被占用了
        CheckPortAbledUtil.checkPortAbled(port);
        new SpringApplicationBuilder(EurekaServerApplication.class).properties("server.port=" + port).run(args);
    }
}
