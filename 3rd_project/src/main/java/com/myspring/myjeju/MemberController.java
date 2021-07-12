package com.myspring.myjeju;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myjeju.service.MemberService;
import com.myjeju.service.MessageService;
import com.myjeju.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private MemberService memberServcice;

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
	
	/**
	 * sms 인증
	 */
	@ResponseBody
    @RequestMapping(value = "/sendSms.do", method = RequestMethod.POST )
     public void sendSms(HttpServletRequest request) throws Exception {
		messageService.sendMessage((String)request.getParameter("to"), (String)request.getParameter("text"));
	}
	
	/**
	 * 회원가입
	 */
	@RequestMapping(value = "/join_proc.do", method=RequestMethod.POST ) 
	public String join_proc(MemberVO vo) {
		System.out.print(vo.getAddr1());
		
		String result = "";
		
		boolean join_result = memberServcice.getJoinResult(vo);
    	
    	if (join_result == true ) {
    		result = "index";
    	} else {
			/* result = "errorPage"; */
    	}
    	return result;
	}
}
