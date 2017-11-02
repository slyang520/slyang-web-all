package cn.slyang.service.app01;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("sso")  //指定访问服务器
public interface FeignServer {
	@RequestMapping(value ="/testRealRibbon",method= RequestMethod.GET)
	String testRealRibbon(@RequestParam("content") String content);
}
