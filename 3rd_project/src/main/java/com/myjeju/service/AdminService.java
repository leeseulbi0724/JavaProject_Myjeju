package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.MemberVO;

public interface AdminService {
	
	ArrayList<MemberVO> getlist(int startnum,int endnum);
	ArrayList<MemberVO> getlist(int startnum,int endnum,String search,String search_text);
	int targetPage(int pageNumber);
	int targetPage(int pageNumber,String search,String search_text);
}
