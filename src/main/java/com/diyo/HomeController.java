package com.diyo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping(value="/name", method=RequestMethod.GET)
	public String getName() {
		return "my name is bhuwan";
	}

}
