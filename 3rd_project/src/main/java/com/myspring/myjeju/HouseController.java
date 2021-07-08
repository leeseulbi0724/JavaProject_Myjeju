package com.myspring.myjeju;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HouseController {

	/**
	 * house.do : 숙소 메인페이지
	 */
	@RequestMapping(value="/house.do", method=RequestMethod.GET)
	public String house() {
		return "house/house";
	}
}
