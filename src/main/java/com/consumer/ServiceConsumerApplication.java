package com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @EnableFeignClients : 这个注解表明这个服务是一个Feign服务，能够使用@FeignClient 实现远程调用
 *
 * http://localhost:9001/consumer/date?param=www.codesheep.cn
 * return "hello www.codesheep.cn" in page
 *
 * http://localhost:7001/
 * Application	AMIs	Availability Zones	Status
 * SERVICE-CONSUMER	n/a (1)	(1)	UP (1) - 192.168.11.38:service-consumer:9001
 * SERVICE_PROVIDER	n/a (1)	(1)	UP (1) - 192.168.11.38:service_provider:8001
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApplication.class, args);
    }
}
