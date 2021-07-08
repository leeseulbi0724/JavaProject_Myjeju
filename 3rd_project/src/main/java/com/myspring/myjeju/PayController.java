package com.myspring.myjeju;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PayController {
	
	@RequestMapping(value = "/payment.do", method=RequestMethod.GET)
	public String payment() {
		return "pay/payment";
		
	}

}
