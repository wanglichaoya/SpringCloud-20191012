package com.wlc.util;

import cn.hutool.core.util.NetUtil;

/**
 * describe:检测端口号是否被占用
 *
 * @author 王立朝
 * @date 2019/10/16
 */
public  class CheckPortAbledUtil {

    public  static boolean checkPortAbled(int port){

        /*if (!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port);
            System.exit(1);
            return false;
        }*/
        boolean flag = NetUtil.isUsableLocalPort(port);
        if(flag == true){
            //说明端口没有被占用
            return true;
        }else{
            //端口被占用
            System.err.printf("端口%d被占用了，无法启动%n", port);
            System.exit(1);
            return true;
        }


    }
}
