package com.myspring.myjeju;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccomodationController {
	/**
	 * accomodation.do : 숙소 페이지 구현
	 */
	@RequestMapping(value="/accomodation.do", method=RequestMethod.GET)
	public String accomodation() {
		return "accomodation";
	}
	

}
