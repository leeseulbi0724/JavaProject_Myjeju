package com.myspring.myjeju;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PayController {
	
	
	/**
	 * ���� ī�����
	 */
	@RequestMapping(value = "/payment.do", method=RequestMethod.GET)
	public String payment() {
		return "pay/payment";
		
	}
	
	/**
	 * īī������ ����
	 */
	@RequestMapping(value="/kakaopay.do", method=RequestMethod.GET)
	public String kakaopay() {
		return "pay/kakaopay";
	
	}

}
