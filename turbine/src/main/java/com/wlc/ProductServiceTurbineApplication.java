package com.wlc;

import com.wlc.util.CheckPortAbledUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * describe:@EnableTurbine： 断路器聚合监控用的
 *
 * @author 王立朝
 * @date 2019/10/29
 */
@SpringBootApplication
@EnableTurbine
public class ProductServiceTurbineApplication {


    public static void main(String[] args) {
        int port = 8021;
        CheckPortAbledUtil.checkPortAbled(port);

        new SpringApplicationBuilder(ProductServiceTurbineApplication.class).properties("server.port" + port).run(args);

    }

}
