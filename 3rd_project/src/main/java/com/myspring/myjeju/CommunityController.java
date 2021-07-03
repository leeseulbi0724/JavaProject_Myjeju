package com.myspring.myjeju;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommunityController {
	
	/**
	 * 자유게시판 리스트
	 */
	@RequestMapping(value = "/free_board.do", method=RequestMethod.GET )
	public String free_board() {
		return "community/free_board";
	}
	
	/**
	 * 자유게시판 상세보기
	 */
	@RequestMapping(value = "/free_board_content.do", method=RequestMethod.GET)
	public String free_board_content() {
		return "community/free_board_content";
	}
	
	/**
	 * 자유게시판 글쓰기
	 */
	@RequestMapping(value="/free_board_write.do", method=RequestMethod.GET)
	public String free_board_write() {
		return "community/free_board_write";
	}
	
	/**
	 * 요청게시판 리스트
	 */
	@RequestMapping(value = "/request_board.do", method=RequestMethod.GET )
	public String request_board() {
		return "community/request_board";
	}
	
	/**
	 * 요청게시판 상세보기
	 */
	@RequestMapping(value = "/request_board_content.do", method=RequestMethod.GET)
	public String request_board_content() {
		return "community/request_board_content";
	}
	
	/**
	 * 요청게시판 글쓰기
	 */
	@RequestMapping(value="/request_board_write.do", method=RequestMethod.GET)
	public String request_board_write() {
		return "community/request_board_write";
	}

}
