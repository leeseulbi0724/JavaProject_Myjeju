package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.NoticeVO;

public interface AdminService {
	//관리자 회원
	ArrayList<MemberVO> getlist(int startnum,int endnum);
	ArrayList<MemberVO> getlist(int startnum,int endnum,String search,String search_text);
	int targetPage(int pageNumber);
	int targetPage(int pageNumber,String search,String search_text);
	
	//관리자 게시판
	ArrayList<CommunityVO> getBoardList(int startnum,int endnum);
	int BoardPage(int pageNumber);
	int BoardPage(int pageNumber,String search,String search_text);
	ArrayList<CommunityVO> getBoardList(int startnum,int endnum,String search,String search_text);
	
	//관리자 공지사항
	boolean getNoticeWrite(NoticeVO vo);
	ArrayList<NoticeVO> getNoticeList(int startnum, int endnum);
	int NoticePage(int pageNumber);
	int NoticePage(int pageNumber,String search,String search_text);
	ArrayList<NoticeVO> getNoticeList(int startnum,int endnum,String search,String search_text);
	NoticeVO getNoticeContent(String nid);
	boolean getFileYesUpdate(NoticeVO vo);	
	boolean getFileNoUpdate(NoticeVO vo);
	String getOldFile(String nid);
	boolean getNoticeDelete(String nid);
}
