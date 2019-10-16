package com.wlc.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NumberUtil;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * describe: 让 5秒内 输入端口号，如果超过5秒的时候，就用默认的端口号
 *
 * @author 王立朝
 * @date 2019/10/16
 */
public class FutureTimeOutSecondsUtil {

    public static  int futureTimeOutSecond(int timeoutSecond,int defaultPort){
        int port = 0;

        Future<Integer> future = ThreadUtil.execAsync(() ->{
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
        });

        try{
            port=future.get(timeoutSecond, TimeUnit.SECONDS);
        }catch (InterruptedException | ExecutionException | TimeoutException e) {
            port = defaultPort;
        }

        return port;
    }
}
