package com.myspring.myjeju;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.service.MemberService;
import com.myjeju.service.MessageService;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.SessionVO;

@Controller
public class MemberController {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private MemberService memberService;

	/**
	 * main.do : ����������
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
	 * sms ����
	 */
	@ResponseBody
    @RequestMapping(value = "/sendSms.do", method = RequestMethod.POST )
     public void sendSms(HttpServletRequest request) throws Exception {
		messageService.sendMessage((String)request.getParameter("to"), (String)request.getParameter("text"));
	}
	
	/**
	 * ȸ������
	 */
	@RequestMapping(value = "/join_proc.do", method=RequestMethod.POST ) 
	public String join_proc(MemberVO vo) {
		
		String result = "";
		
		boolean join_result = memberService.getJoinResult(vo);
    	
    	if (join_result == true ) {
    		result = "index";
    	} else {
			/* result = "errorPage"; */
    	}
    	return result;
	}
	
	/**
	 * �α���
	 */
	@RequestMapping(value = "/login_proc.do", method=RequestMethod.POST ) 
	public String login_proc (HttpServletRequest request, MemberVO vo) {
		HttpSession session = request.getSession();
		String result = "";  	
		SessionVO svo = memberService.getLoginResult(vo);
		
		session.setAttribute("session_id", svo.getId());
		session.setAttribute("session_name", svo.getName());
	
		//�α��� ó��
		if (svo != null) {
			/* svo.setId(vo.getId()); */				
			result = "index";
		} 
		return result;
	}
	
	 /**
	  * �α׾ƿ� ���� ����
	  */
		
		 @RequestMapping(value = "/logout.do", method=RequestMethod.GET) 
		 public String logout(HttpServletRequest request) { 
			 HttpSession session = request.getSession(); session.invalidate();		 
		 return "index";
		 
	}

	
	/**
	 * ���̵� ã��
	 */
	@RequestMapping(value = "/id_search_proc.do", method=RequestMethod.POST ) 
	public ModelAndView id_search_proc (MemberVO vo) {
		ModelAndView mv = new ModelAndView();
		
		System.out.print(vo.getName());
		System.out.print(vo.getHp());
		System.out.print(vo.getEmail());
		
		String id = memberService.getIdSearchResult(vo);  	
		
		mv.setViewName("member/search_success");
		mv.addObject("type", "id");
		mv.addObject("id", id);
		
		return mv;
	}
	
	/**
	 * ��й�ȣ ã��
	 */
	@RequestMapping(value = "/pass_search_proc.do", method=RequestMethod.POST ) 
	public ModelAndView pass_search_proc (MemberVO vo) {
		ModelAndView mv = new ModelAndView();
		
		System.out.print(vo.getName());
		System.out.print(vo.getHp());
		System.out.print(vo.getEmail());
		
		String id = memberService.getPassSearchResult(vo);  	
		
		mv.setViewName("member/search_success");
		mv.addObject("type", "pass");
		mv.addObject("id", id);
		
		return mv;
	}
			
	/**
	 * ��й�ȣ ����
	 */
	@RequestMapping(value = "/pass_update_proc.do", method=RequestMethod.POST)
	public ModelAndView pass_update_proc(MemberVO vo) {
		ModelAndView mv = new ModelAndView();
		
		boolean result = memberService.getPassUpdateResult(vo);
		
		if ( result ) {
			mv.setViewName("member/pass_success");
		}
		
		return mv;
	}
	
	/**
	 * ���̵� �ߺ�Ȯ��
	 */
	@RequestMapping(value = "/id_check_proc.do", method=RequestMethod.POST)
	@ResponseBody
	public boolean id_check(HttpServletRequest request) throws Exception {
		System.out.print(request.getParameter("id"));
		int count = memberService.getIdCheckResult(request.getParameter("id"));
		
		boolean result = false;
		
		if ( count == 0 ) {
			result = true;
		} 
		
		return result;
	}
}
