package com.myspring.myjeju;

import java.util.ArrayList;

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
import com.myjeju.vo.BasketVO;
import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.StoreVO;

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
	public ModelAndView mybaskit(BasketVO vo, HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		String id = (String) session.getAttribute("session_id");
		String sid = request.getParameter("sid");
		System.out.println(sid);
		System.out.println(id);

		//BasketVO vo = MypageService.getSid2(user_id);			//sid, b_count
		//StoreVO svo = MypageService.getBcontent(vo.getSid());		//s_name, s_price, s_sfile
		
		vo.setId(id);
		
		ArrayList<BasketVO> blist = MypageService.getSid(id);				//sid�� b_count ��������
		ArrayList<StoreVO> slist = MypageService.getBcontent(vo.getSid());		//s_name, s_price, s_sfile ��������
		
		//System.out.println(vo.getSid());
		//System.out.println(svo.getS_name());
		//System.out.println(svo.getS_price());
		//System.out.println(vo.getB_count());
		
		mv.setViewName("mypage/mystore/mybasket");
		
		mv.addObject("blist", blist);
		mv.addObject("slist", slist);
		
		return mv;
	}

	/* ��ٱ��� �߰� ó�� */
	@RequestMapping(value = "/mybasket_proc.do", method=RequestMethod.GET)
	public ModelAndView mybasket_proc(BasketVO vo, HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		String name = request.getParameter("s_name");
		String count = request.getParameter("b_count");
		if(count == null) {
			count = "0";
		}
		int b_count = Integer.parseInt(count);
		String id = (String) session.getAttribute("session_id");
		String sid = request.getParameter("sid");
		
		vo.setId(id);
		vo.setSid(sid);
		vo.setB_count(b_count);
		
		boolean result = MypageService.getInsertResult(vo);
		
		if(result) {
			mv.setViewName("redirect:/store_content.do");
			mv.addObject("sid", sid);
		}

		return mv;
	}
	
	/**
	 * ���� �Խñ�
	 */
	@RequestMapping(value = "/myboard.do", method=RequestMethod.GET)
	public ModelAndView myboard(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		ArrayList<CommunityVO> list1 = MypageService.getFreeBoardResult((String)session.getAttribute("session_id"));
		ArrayList<CommunityVO> list2 = MypageService.getRequestBoardResult((String)session.getAttribute("session_id"));
		ArrayList<CommunityVO> list3 = MypageService.getCommentResult((String)session.getAttribute("session_id"));
		
		mv.addObject("list1", list1);
		mv.addObject("list2", list2);
		mv.addObject("list3", list3);
		mv.setViewName("mypage/myrecord/myboard");
		
		return mv;
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
