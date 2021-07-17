package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.MemberVO;

public interface AdminService {
	
	ArrayList<MemberVO> getlist(int startnum,int endnum);
	ArrayList<MemberVO> getlist(int startnum,int endnum,String search,String search_text);
	int targetPage(int pageNumber);
	int targetPage(int pageNumber,String search,String search_text);
	
	//관리자 게시판
	ArrayList<CommunityVO> getBoardList(int startnum,int endnum);
	int BoardPage(int pageNumber);
	int BoardPage(int pageNumber,String search,String search_text);
	ArrayList<CommunityVO> getBoardList(int startnum,int endnum,String search,String search_text);
}
