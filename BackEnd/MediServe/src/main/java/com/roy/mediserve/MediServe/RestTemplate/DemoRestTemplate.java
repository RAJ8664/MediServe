package com.roy.mediserve.MediServe.RestTemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.roy.mediserve.MediServe.Model.Medicine;

@RestController
public class DemoRestTemplate {
	
	RestTemplate restTemplate = new RestTemplate();

	/* Can be used to get the medicines --> just an example */
	@GetMapping("/restMedicine")
	public Medicine[] simpleCall() {
		Medicine[] ans = restTemplate.getForObject("http://localhost:8080/medicine", Medicine[].class);
		return ans;
	}
}
