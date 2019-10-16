package com.wlc;

import brave.sampler.Sampler;
import com.wlc.util.CheckPortAbledUtil;
import com.wlc.util.FutureTimeOutSecondsUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * describe:启动类， 考虑到要做集群。 所以让用户自己输入端口，推荐 8001，8002，8003.
 * 但是每次测试都要输入端口号又很麻烦，所以做了个 Future类，如果5秒不输入，那么就默认使用 8001端口
 *
 * @author 王立朝
 * @date 2019/10/14
 */

/**
 * 启动：数据微服务 product-data-service2 注意事项： 要先启动 服务注册中心eurekaServer ，
 * 不然会找不到 服务错误，切记，因为这个耽误了一个多小时，尴尬……
 * **/
@SpringBootApplication
@EnableEurekaClient
public class ProductDataServiceApplication {
    
    public static void main(String[] args){
      int port = 0;
      int defaultPort = 8001;
       /* Future<Integer> future = ThreadUtil.execAsync(() ->{
          int p = 0;
            System.out.println("请于5秒钟内输入端口号, 推荐  8001 、 8002  或者  8003，超过5秒将默认使用 " + defaultPort);
            Scanner scanner = new Scanner(System.in);
            while(true){
               String strPort = scanner.nextLine();
               if(!NumberUtil.isInteger(strPort)){
                  System.err.println("只能输入数字");
                  continue;
               }
               else{
                   p = Convert.toInt(strPort);
                   scanner.close();
                   break;
               }
            }
            return p;
        });*/
       /* try{
            port=future.get(5, TimeUnit.SECONDS);
        }catch (InterruptedException | ExecutionException |TimeoutException e) {
            port = defaultPort;
        }*/
       /* if(!NetUtil.isUsableLocalPort(port)){
            System.err.printf("端口%d被占用了，无法启动%n",port);
            System.exit(1);
        }*/
        //让 5秒内 输入端口号，如果超过5秒的时候，就用默认的端口号
        port = FutureTimeOutSecondsUtil.futureTimeOutSecond(5,defaultPort);
        //测试端口号是否被占用
        CheckPortAbledUtil.checkPortAbled(port);
        new SpringApplicationBuilder(ProductDataServiceApplication.class).properties("server.port=" + port).run(args);


    }
    /**配置链路追踪器开始**/

    /**
     * 配置Sampler 抽样策略， ALWAYS_SAMPLE: 表示持续抽样
     * **/
    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
    /**配置链路追踪器结束**/
}
