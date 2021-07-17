package com.myjeju.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.AdminDAO;
import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.MemberVO;

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

}
