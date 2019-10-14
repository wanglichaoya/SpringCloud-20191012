package com.wlc;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String dateStr = "2012-12-12 12:12:12";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);
    }
}
