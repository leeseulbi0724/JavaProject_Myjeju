package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.FoodVO;
import com.myjeju.vo.HDetailVO;
import com.myjeju.vo.HouseVO;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.NoticeVO;
import com.myjeju.vo.StoreVO;
import com.myjeju.vo.TravelVO;

public interface AdminService {
	//관리자 회원
	ArrayList<MemberVO> getlist(int startnum,int endnum);
	ArrayList<MemberVO> getlist(int startnum,int endnum,String search,String search_text);
	int targetPage(int pageNumber);
	int targetPage(int pageNumber,String search,String search_text);
	
	//관리자 숙소
	HouseVO gethouse(String hid);
	ArrayList<HouseVO> getlisthouse(int startnum,int endnum);
	ArrayList<HouseVO> getlisthouse(int startnum,int endnum,String search,String search_text);
	int targethousePage(int pageNumber);
	int targethousePage(int pageNumber,String search,String search_text);
	
	//관리자 객실
	ArrayList<HDetailVO> gethousede(String hid);
	HDetailVO gethousedecontent(String hdid);
	
	//관리자 맛집
	ArrayList<FoodVO> getlistfood(int startnum,int endnum);
	ArrayList<FoodVO> getlistfood(int startnum,int endnum,String search,String search_text);
	int targetfoodPage(int pageNumber);
	int targetfoodPage(int pageNumber,String search,String search_text);
	
	//관리자 여행지
	ArrayList<TravelVO> getlisttravel(int startnum,int endnum);
	ArrayList<TravelVO> getlisttravel(int startnum,int endnum,String search,String search_text);
	int targettravelPage(int pageNumber);
	int targettravelPage(int pageNumber,String search,String search_text);
	
	
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
	
	//관리자 요청
	ArrayList<CommunityVO> getRequestList(int startnum,int endnum,String search,String search_text);
	ArrayList<CommunityVO> getRequestList(int startnum, int endnum);
	int RequestPage(int pageNumber);
	int RequestPage(int pageNumber,String search,String search_text);
	CommunityVO getRequestContent(String rid);
	boolean getRequestComment(CommunityVO vo);
	CommunityVO getRequestCommentResult(String rid);
	boolean getRequestDelete(String rid);
	
	
	
	//관리자 스토어
	ArrayList<StoreVO> getStoreList(int startnum, int endnum);
	ArrayList<StoreVO> getStoreList(int startnum, int endnum, String search, String search_text);
	int StorePage(int pageNumber);
	int StorePage(int pageNumber,String search,String search_text);
	StoreVO getStoreContent(String sid);
	boolean getStoreUpdateFile(StoreVO vo);
	boolean getStoreUpdateNoFile(StoreVO vo);
	String getStoreOldFile(String sid);
	boolean getStoreInsertResult(StoreVO vo);
	boolean getStoreDelete(String sid);
}
