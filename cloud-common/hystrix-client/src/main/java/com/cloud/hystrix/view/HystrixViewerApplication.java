package com.cloud.hystrix.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ 创建人 贾红平
 * @ 创建时间 2019/1/22
 * @ 功能描述
 */

@SpringBootApplication
@Controller
@EnableHystrixDashboard  //使用dashboard仪表盘查看服务的熔断/降级等情况
public class HystrixViewerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixViewerApplication.class,args);
    }

    /**
     * 指定访问hystrix的默认url
     * @return
     */
    @RequestMapping("/")
    public String home() {
        return "forward:/hystrix";
    }
}
