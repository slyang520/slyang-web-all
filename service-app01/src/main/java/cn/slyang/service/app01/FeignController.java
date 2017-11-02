package cn.slyang.service.app01;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FeignController {

	@Autowired
	FeignServer feignServer;

	@RequestMapping(value = "/testFeign", method = RequestMethod.GET)
	@ResponseBody
	public String testFeign(@RequestParam("content") String content) {
		String ribbonStr = feignServer.testRealRibbon("test aaa");
		return ribbonStr;
	}

}
