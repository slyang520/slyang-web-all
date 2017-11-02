package cn.slyang.service.configcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableConfigServer    // 配置中心服务
@EnableEurekaClient    // 配置注册到 Eureka
@SpringBootApplication
public class ConfigcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigcenterApplication.class, args);
	}
}
