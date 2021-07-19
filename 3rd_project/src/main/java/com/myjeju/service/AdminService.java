package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.NoticeVO;
import com.myjeju.vo.StoreVO;

public interface AdminService {
	//������ ȸ��
	ArrayList<MemberVO> getlist(int startnum,int endnum);
	ArrayList<MemberVO> getlist(int startnum,int endnum,String search,String search_text);
	int targetPage(int pageNumber);
	int targetPage(int pageNumber,String search,String search_text);
	
	//������ �Խ���
	ArrayList<CommunityVO> getBoardList(int startnum,int endnum);
	int BoardPage(int pageNumber);
	int BoardPage(int pageNumber,String search,String search_text);
	ArrayList<CommunityVO> getBoardList(int startnum,int endnum,String search,String search_text);
	
	//������ ��������
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
	
	//������ ��û
	ArrayList<CommunityVO> getRequestList(int startnum,int endnum,String search,String search_text);
	ArrayList<CommunityVO> getRequestList(int startnum, int endnum);
	int RequestPage(int pageNumber);
	int RequestPage(int pageNumber,String search,String search_text);
	CommunityVO getRequestContent(String rid);
	boolean getRequestComment(CommunityVO vo);
	CommunityVO getRequestCommentResult(String rid);
	boolean getRequestDelete(String rid);
	
	
	
	//������ �����
	ArrayList<StoreVO> getStoreList(int startnum, int endnum);
	ArrayList<StoreVO> getStoreList(int startnum, int endnum, String search, String search_text);
	int StorePage(int pageNumber);
	int StorePage(int pageNumber,String search,String search_text);
}
