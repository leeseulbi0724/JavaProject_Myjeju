package com.myspring.myjeju;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommunityController {
	
	/**
	 * �����Խ��� ����Ʈ
	 */
	@RequestMapping(value = "/free_board.do", method=RequestMethod.GET )
	public String free_board() {
		return "community/free_board";
	}
	
	/**
	 * �����Խ��� �󼼺���
	 */
	@RequestMapping(value = "/free_board_content.do", method=RequestMethod.GET)
	public String free_board_content() {
		return "community/free_board_content";
	}
	
	/**
	 * �����Խ��� �۾���
	 */
	@RequestMapping(value="/free_board_write.do", method=RequestMethod.GET)
	public String free_board_write() {
		return "community/free_board_write";
	}
	
	/**
	 * ��û�Խ��� ����Ʈ
	 */
	@RequestMapping(value = "/request_board.do", method=RequestMethod.GET )
	public String request_board() {
		return "community/request_board";
	}
	
	/**
	 * ��û�Խ��� �󼼺���
	 */
	@RequestMapping(value = "/request_board_content.do", method=RequestMethod.GET)
	public String request_board_content() {
		return "community/request_board_content";
	}
	
	/**
	 * ��û�Խ��� �۾���
	 */
	@RequestMapping(value="/request_board_write.do", method=RequestMethod.GET)
	public String request_board_write() {
		return "community/request_board_write";
	}

}
