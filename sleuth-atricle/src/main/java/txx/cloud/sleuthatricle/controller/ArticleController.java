package txx.cloud.sleuthatricle.controller;

import brave.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ArticleController {

	private Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/article/callHello")
	public String callHello() { 		
		logger.info("我是/article/callHello");
	    return restTemplate.getForObject(
			"http://sleuth-user-service/user/hello", String.class); 	
	}
	
}
