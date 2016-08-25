/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * husheng@yiji.com 2016-04-30 16:22 创建
 *
 */
package com.yiji.openapimock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author husheng@yiji.com
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.setProperty("yiji.appName","openapimock");
        System.setProperty("spring.profiles.active","local");
        SpringApplication.run(Main.class, args);
    }
}
