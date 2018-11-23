package com.example.carrental;

import com.example.carrental.model.Sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class SampleClient {
	
	private static final Logger log = LoggerFactory.getLogger(SampleClient.class);

	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		Sample hello = new Sample();
		hello.setName("hello");
		HttpEntity<Sample> request = new HttpEntity<>(hello);
		restTemplate.postForObject("http://localhost:8080/samples", request, Sample.class);
		
        List samples = restTemplate.getForObject("http://localhost:8080/samples", List.class);
        log.info(samples.toString());
        
	}

}