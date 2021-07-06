package com.myspring.myjeju;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MypageController {
	
	/**
	 * 마이페이지 메인
	 */
	@RequestMapping(value = "/mypage.do", method=RequestMethod.GET)
	public String mypage() {
		return "mypage/mypage";
	}

	/**
	 * 기본정보수정 요청페이지
	 */
	@RequestMapping(value = "/myinfo_request.do", method=RequestMethod.GET)
	public String myinfo_request() {
		return "mypage/myinfo/myinfo_request";
	}
	
	/**
	 * 기본정보수정 메인
	 */
	@RequestMapping(value = "/myinfo.do", method=RequestMethod.GET)
	public String myinfo() {
		return "mypage/myinfo/myinfo";
	}
	
	/**
	 * 비밀번호 변경
	 */
	@RequestMapping(value = "/myinfo_pass.do", method=RequestMethod.GET)
	public String myinfo_pass() {
		return "mypage/myinfo/myinfo_pass";
	}

	/**
	 * 회원탈퇴
	 */
	@RequestMapping(value = "/myinfo_out.do", method=RequestMethod.GET)
	public String myinfo_out() {
		return "mypage/myinfo/myinfo_out";
	}
	
	/**
	 * 주문내역
	 */
	@RequestMapping(value = "/myorder.do", method=RequestMethod.GET)
	public String myorder() {
		return "mypage/mystore/myorder";
	}
	
	/**
	 * 장바구니
	 */
	@RequestMapping(value = "/mybaskit.do", method=RequestMethod.GET)
	public String mybaskit() {
		return "mypage/mystore/mybaskit";
	}
	
	/**
	 * 나의 게시글
	 */
	@RequestMapping(value = "/myboard.do", method=RequestMethod.GET)
	public String myboard() {
		return "mypage/myrecord/myboard";
	}
	
	/**
	 * 나의 후기
	 */
	@RequestMapping(value = "/myreview.do", method=RequestMethod.GET)
	public String myreview() {
		return "mypage/myrecord/myreview";
	}
	
	/**
	 * 나의 좋아요
	 */
	@RequestMapping(value = "/myheart.do", method=RequestMethod.GET)
	public String myheart() {
		return "mypage/myrecord/myheart";
	}
}
