package com.myspring.myjeju;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	/**
	 * main.do : 시작페이지
	 */
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		return "member/join";
	}
	@RequestMapping(value="/idsearch.do", method=RequestMethod.GET)
	public String idsearch() {
		return "member/idsearch";
	}
	@RequestMapping(value="/passsearch.do", method=RequestMethod.GET)
	public String passsearch() {
		return "member/passsearch";
	}
}
