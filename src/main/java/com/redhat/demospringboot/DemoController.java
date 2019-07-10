package com.redhat.demospringboot;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {
	Logger log=Logger.getLogger(this.getClass().getName());

			@RequestMapping("/")
    public String index() {
        return "This is Service  1";
    }
		
    @RequestMapping("/greet/{message}")
    public String hello(@PathVariable String message) {
        log.info("in greet "+message);
    	return "This is Service 1 Greet : "+message ;
    }

    @RequestMapping("/secured/{message}")
    public String secured(@PathVariable String message) {
        log.info("in secured "+message);
    	return "This is Service 1 Secured : "+message ;
    }

    @RequestMapping("/facade/{message}")
    public String facade(@PathVariable String message) {
        log.info("in facade "+message);
        final String uri = "http://localhost:8081/";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

    	return "This is Service 1 Facade calling : "+result ;
    }

}
