package com.myjeju.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.AdminDAO;
import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.FoodVO;
import com.myjeju.vo.HouseVO;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.NoticeVO;
import com.myjeju.vo.StoreVO;
import com.myjeju.vo.TravelVO;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO adminDAO;
	//������ ���
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
	//������ ����
	@Override
	public ArrayList<HouseVO> getlisthouse(int startnum,int endnum){
		return adminDAO.getlisthouse(startnum,endnum);
	}
	@Override
	public ArrayList<HouseVO> getlisthouse(int startnum,int endnum,String search,String search_text){
		return adminDAO.getlisthouse(startnum,endnum,search,search_text);
	}
	@Override
	public int targethousePage(int pageNumber){
		return adminDAO.targethousePage(pageNumber);
	}
	@Override
	public int targethousePage(int pageNumber,String search,String search_text){
		return adminDAO.targethousePage(pageNumber,search,search_text);
	}
	@Override
	public HouseVO gethouse(String hid){
		return adminDAO.gethouse(hid);
	}
	//������ ����
	@Override
	public ArrayList<FoodVO> getlistfood(int startnum,int endnum){
		return adminDAO.getlistfood(startnum,endnum);
	}
	@Override
	public ArrayList<FoodVO> getlistfood(int startnum,int endnum,String search,String search_text){
		return adminDAO.getlistfood(startnum,endnum,search,search_text);
	}
	@Override
	public int targetfoodPage(int pageNumber){
		return adminDAO.targetfoodPage(pageNumber);
	}
	@Override
	public int targetfoodPage(int pageNumber,String search,String search_text){
		return adminDAO.targetfoodPage(pageNumber,search,search_text);
	}
	//������ ������
	@Override
	public ArrayList<TravelVO> getlisttravel(int startnum,int endnum){
		return adminDAO.getlisttravel(startnum,endnum);
	}
	@Override
	public ArrayList<TravelVO> getlisttravel(int startnum,int endnum,String search,String search_text){
		return adminDAO.getlisttravel(startnum,endnum,search,search_text);
	}
	@Override
	public int targettravelPage(int pageNumber){
		return adminDAO.targettravelPage(pageNumber);
	}
	@Override
	public int targettravelPage(int pageNumber,String search,String search_text){
		return adminDAO.targettravelPage(pageNumber,search,search_text);
	}
	
	//������ �Խ���
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
	
	//������ ��������
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
	
	//������ ��û
	@Override
	public ArrayList<CommunityVO> getRequestList(int startnum,int endnum) {
		return adminDAO.getRequestList(startnum, endnum);
	}
	@Override
	public int RequestPage(int pageNumber) {
		return adminDAO.getRequestPage(pageNumber);
	}
	@Override
	public int RequestPage(int pageNumber,String search,String search_text){
		return adminDAO.getRequestPage(pageNumber,search,search_text);
	}
	@Override
	public ArrayList<CommunityVO> getRequestList(int startnum,int endnum,String search,String search_text){
		return adminDAO.getRequestList(startnum,endnum,search,search_text);
	}
	@Override
	public CommunityVO getRequestContent(String rid) {
		return adminDAO.getRequestContent(rid);
	}
	@Override
	public boolean getRequestComment(CommunityVO vo) {
		int val = adminDAO.getRequestComment(vo);
		boolean result = false;
		if (val!=0) {
			result = true;
		}
		return result;
	}
	@Override
	public CommunityVO getRequestCommentResult(String rid) {
		return adminDAO.getRequestCommentResult(rid);
	}
	@Override
	public boolean getRequestDelete(String rid) {
		int val = adminDAO.getRequestDelete(rid);
		boolean result = false;
		if (val!=0) {
			result = true;
		}
		return result;
	}
	
	
	
	//������ - �����
	@Override
	public ArrayList<StoreVO> getStoreList(int startnum, int endnum) {
		return adminDAO.getStoreList(startnum, endnum);
	}
	@Override
	public ArrayList<StoreVO> getStoreList(int startnum, int endnum, String search, String search_text) {
		return adminDAO.getStoreList(startnum, endnum, search, search_text);
	}
	@Override
	public int StorePage(int pageNumber) {
		return adminDAO.getStorePage(pageNumber);
	}
	@Override
	public int StorePage(int pageNumber, String search, String search_text) {
		return adminDAO.getStorePage(pageNumber, search, search_text);
	}
	@Override
	public StoreVO getStoreContent(String sid) {
		return adminDAO.getStoreContent(sid);
	}
	@Override
	public boolean getStoreUpdateFile(StoreVO vo) {
		boolean result = false;
		int value = adminDAO.getStoreUpdateFile(vo);
		if (value != 0) {
			result = true;
		}
		return result;
	}
	@Override
	public boolean getStoreUpdateNoFile(StoreVO vo) {
		boolean result = false;
		int value = adminDAO.getStoreUpdateNoFile(vo);
		if (value != 0) {
			result = true;
		}
		return result;
	}
	@Override
	public String getStoreOldFile(String sid) {
		return adminDAO.getStoreOldFile(sid);
	}
	@Override
	public boolean getStoreInsertResult(StoreVO vo) {
		return adminDAO.getStoreInsertResult(vo);
	}
	@Override
	public boolean getStoreDelete(String sid) {
		return adminDAO.getStoreDelete(sid);
	}
	

}
