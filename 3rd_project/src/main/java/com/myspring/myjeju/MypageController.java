package com.myspring.myjeju;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MypageController {
	
	/**
	 * ���������� ����
	 */
	@RequestMapping(value = "/mypage.do", method=RequestMethod.GET)
	public String mypage() {
		return "mypage/mypage";
	}

	/**
	 * �⺻�������� ��û������
	 */
	@RequestMapping(value = "/myinfo_request.do", method=RequestMethod.GET)
	public String myinfo_request() {
		return "mypage/myinfo/myinfo_request";
	}
	
	/**
	 * �⺻�������� ����
	 */
	@RequestMapping(value = "/myinfo.do", method=RequestMethod.GET)
	public String myinfo() {
		return "mypage/myinfo/myinfo";
	}
	
	/**
	 * ��й�ȣ ����
	 */
	@RequestMapping(value = "/myinfo_pass.do", method=RequestMethod.GET)
	public String myinfo_pass() {
		return "mypage/myinfo/myinfo_pass";
	}

	/**
	 * ȸ��Ż��
	 */
	@RequestMapping(value = "/myinfo_out.do", method=RequestMethod.GET)
	public String myinfo_out() {
		return "mypage/myinfo/myinfo_out";
	}
}
