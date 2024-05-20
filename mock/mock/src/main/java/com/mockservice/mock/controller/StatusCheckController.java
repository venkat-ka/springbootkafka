package com.mockservice.mock.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/response")
public class StatusCheckController {
	
	@GetMapping("/200")
	ResponseEntity<String> response200(){
		return  ResponseEntity.ok().body("200");
	}
	
	@GetMapping("/500")
	ResponseEntity<String> response500(){
		return  ResponseEntity.internalServerError().build();
	}
}
