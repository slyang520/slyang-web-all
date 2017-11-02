package cn.slyang.service.app01;

import cn.slyang.framwork.mail.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class App01ApplicationTests {

	@Autowired
	EmailService emailService;

	@Test
	public void contextLoads() {
		emailService.sendSimpleMail("183102617@qq.com", "测试", "这是一个测试");
	}

}
