package com.myspring.myjeju;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.service.MemberService;
import com.myjeju.service.MypageService;
import com.myjeju.vo.MemberVO;

@Controller
public class MypageController {
	
	@Autowired
	private MypageService MypageService;
	
	@Autowired
	private MemberService memberService;
	
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
	public ModelAndView myinfo(HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		//�α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");
		
		MemberVO vo = MypageService.getMemberContent(id);
		
		String email[] = vo.getEmail().split("@");
		vo.setEmail1(email[0]);
		vo.setEmail2(email[1]);
		
		String hp[] = vo.getHp().split("-");
		vo.setHp1(hp[0]);
		vo.setHp2(hp[1]);
		vo.setHp3(hp[2]);
		
		mv.addObject("vo", vo);
		mv.setViewName("mypage/myinfo/myinfo");
		
		return mv;
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
	
	/**
	 * �ֹ�����
	 */
	@RequestMapping(value = "/myorder.do", method=RequestMethod.GET)
	public String myorder() {
		return "mypage/mystore/myorder";
	}
	
	/**
	 * ��ٱ���
	 */
	@RequestMapping(value = "/mybasket.do", method=RequestMethod.GET)
	public String mybaskit() {
		return "mypage/mystore/mybasket";
	}
	
	/**
	 * ���� �Խñ�
	 */
	@RequestMapping(value = "/myboard.do", method=RequestMethod.GET)
	public String myboard() {
		return "mypage/myrecord/myboard";
	}
	
	/**
	 * ���� �ı�
	 */
	@RequestMapping(value = "/myreview.do", method=RequestMethod.GET)
	public String myreview() {
		return "mypage/myrecord/myreview";
	}
	
	/**
	 * ���� ���ƿ�
	 */
	@RequestMapping(value = "/myheart.do", method=RequestMethod.GET)
	public String myheart() {
		return "mypage/myrecord/myheart";
	}
	
	/**
	 * ���� ����Ʈ
	 */
	@RequestMapping(value = "/mypoint.do", method=RequestMethod.GET)
	public String mypoint() {
		return "mypage/mypoint";
	}
	
	/**
	 * �������� �� �н����� üũ
	 */
	@ResponseBody
	@RequestMapping(value = "/pass_check.do", method=RequestMethod.POST)
	public boolean pass_check(HttpSession session, HttpServletRequest request) {
		// �α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");
		
		boolean result = false;
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPass(request.getParameter("pass"));
		
		int value = MypageService.getPassCheckResult(vo);
		
		if ( value != 0) {
			result = true;
		}
		
		
		return result;
		
	}
	
	/**
	 * �������� DB
	 */
	@ResponseBody
	@RequestMapping(value = "/info_update.do", method=RequestMethod.POST) 
	public boolean info_update(HttpSession session,HttpServletRequest request) {
			// �α��� ȸ������ ��������
			String id = (String) session.getAttribute("session_id");
			
			MemberVO vo = new MemberVO();
			vo.setAddr1(request.getParameter("addr1"));
			vo.setAddr2(request.getParameter("addr2"));
			vo.setHp1(request.getParameter("hp1"));
			vo.setHp2(request.getParameter("hp2"));
			vo.setHp3(request.getParameter("hp3"));
			vo.setEmail1(request.getParameter("email1"));
			vo.setEmail2(request.getParameter("email2"));			
			vo.setId(id);			
			
			boolean result = MypageService.getInfoUpdate(vo);			
		
			
			return result;
	}
	
	/**
	 * ��й�ȣ ����
	 */
	@ResponseBody
	@RequestMapping(value = "/mypass_update_proc.do", method=RequestMethod.POST)
	public boolean pass_update_proc2(HttpSession session, HttpServletRequest request) {
		// �α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");
		MemberVO vo = new MemberVO();
		
		vo.setId(id);
		vo.setPass(request.getParameter("pass"));
		
		boolean result = memberService.getPassUpdateResult(vo);
		
		return result;
	
	}
	
	/**
	 * ȸ��Ż��
	 */
		@ResponseBody
		@RequestMapping(value = "/info_out.do", method=RequestMethod.POST)
		public boolean info_out (HttpSession session) {
			// �α��� ȸ������ ��������
			String id = (String) session.getAttribute("session_id");
		
			
			boolean result = MypageService.getInfoOut(id);
			
			return result;
		
		}
}
