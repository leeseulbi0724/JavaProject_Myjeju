package com.myjeju.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.AdminDAO;
import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.NoticeVO;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	public ArrayList<MemberVO> getlist(int startnum,int endnum){
		return adminDAO.getlist(startnum,endnum);
	}
	@Override
	public ArrayList<MemberVO> getlist(int startnum,int endnum,String search,String search_text){
		return adminDAO.getlist(startnum,endnum,search,search_text);
	}
	@Override
	public int targetPage(int pageNumber){
		return adminDAO.targetPage(pageNumber);
	}
	@Override
	public int targetPage(int pageNumber,String search,String search_text){
		return adminDAO.targetPage(pageNumber,search,search_text);
	}
	
	//관리자 게시판
	@Override
	public ArrayList<CommunityVO> getBoardList(int startnum,int endnum) {
		return adminDAO.getBoardList(startnum, endnum);
	}
	@Override
	public int BoardPage(int pageNumber) {
		return adminDAO.getBoardPage(pageNumber);
	}
	@Override
	public int BoardPage(int pageNumber,String search,String search_text){
		return adminDAO.getBoardPage(pageNumber,search,search_text);
	}
	@Override
	public ArrayList<CommunityVO> getBoardList(int startnum,int endnum,String search,String search_text){
		return adminDAO.getBoardList(startnum,endnum,search,search_text);
	}
	
	//관리자 공지사항
	@Override
	public boolean getNoticeWrite(NoticeVO vo) {
		boolean result = false;
		int val = adminDAO.getNoticeWrite(vo);
		if (val != 0) {
			result = true;
		}
		return result;
	}
	@Override
	public  ArrayList<NoticeVO> getNoticeList(int startnum, int endnum) {
		return adminDAO.getNoticeList(startnum, endnum);
	}
	@Override
	public int NoticePage(int pageNumber) {
		return adminDAO.getNoticePage(pageNumber);
	}
	@Override
	public int NoticePage(int pageNumber,String search,String search_text) {
		return adminDAO.getNoticePage(pageNumber, search, search_text);
	}
	@Override
	public	ArrayList<NoticeVO> getNoticeList(int startnum,int endnum,String search,String search_text) {
		return adminDAO.getNoticeList(startnum, endnum, search, search_text);
	}
	@Override
	public  NoticeVO getNoticeContent(String nid) {
		return adminDAO.getNoticeContent(nid);
	}
	@Override
	public boolean getFileYesUpdate(NoticeVO vo) {
		int val = adminDAO.getFileYesUpdate(vo);
		boolean result = false;
		if ( val !=0) {
			result =true;
		}
		return result;
	}
	@Override
	public boolean getFileNoUpdate(NoticeVO vo) {
		int val = adminDAO.getFileNoUpdate(vo);
		boolean result = false;
		if ( val !=0) {
			result =true;
		}
		return result;
	}
	@Override
	public  String getOldFile(String nid) {
		return adminDAO.getOldFile(nid);
	}
	@Override
	public boolean getNoticeDelete(String nid) {
		int val = adminDAO.getNoticeDelete(nid);
		boolean result = false;
		if ( val !=0) {
			result =true;
		}
		return result;
	}

}
