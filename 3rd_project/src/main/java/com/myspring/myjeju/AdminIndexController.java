package com.myspring.myjeju;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminIndexController {

	/**
	 * main.do : 시작페이지
	 */
	@RequestMapping(value="/adminindex.do", method=RequestMethod.GET)
	public String main() {
		return "/admin/adminindex";
	}
}
