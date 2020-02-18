package com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableFeignClients : 这个注解表明这个服务是一个Feign服务，能够使用@FeignClient 实现远程调用
 *
 * http://localhost:9001/consumer/date?param=www.codesheep.cn
 * "hello www.codesheep.cn"
 *
 * http://localhost:9001/hello/hi?param=Hello%20World
 * hello Hello World8002(sometimes)
 * hello Hello World8001(sometimes)
 *
 * http://localhost:9001/movie/findById/78
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

    /**
     * 解决RestTemplate找不到的问题，把RestTemplate注册到Spring Boot容器中@Bean
     * 如果使用Rest（RestTemplate）方式以别名进行调用依赖ribbon负载均衡器，所以必须加上@LoadBalanced
     * String url = "http://service-provider/getUser"；
     * @LoadBalanced让RestTemplate在请求时拥有客户端负载均衡的能力
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
