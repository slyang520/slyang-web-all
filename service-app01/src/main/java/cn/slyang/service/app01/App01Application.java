package cn.slyang.service.app01;

import cn.slyang.framwork.mail.EmailService;
import cn.slyang.framwork.mail.FrameworkMailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient  //服务注册中心
@EnableDiscoveryClient   //配置中心
@EnableFeignClients   //rpc
@SpringBootApplication
@RestController
@RefreshScope
@Import({FrameworkMailConfig.class})
public class App01Application {

	public static void main(String[] args) {
		SpringApplication.run(App01Application.class, args);
	}

	@Value("${username}")
	String name;

	@Autowired
	EmailService emailService;

	@RequestMapping("/")
	public String home() {
		emailService.sendSimpleMail("183102617@qq.com", "测试", "这是一个测试");
		return "Hello " + name;
	}

}
