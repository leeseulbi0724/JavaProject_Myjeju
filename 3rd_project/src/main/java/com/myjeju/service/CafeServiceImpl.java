package com.myjeju.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.CafeDAO;
import com.myjeju.vo.CafeVO;

@Service("cafeService")
public class CafeServiceImpl implements CafeService{
	
	@Autowired
	private CafeDAO cafeDAO;
	
	@Override
	public ArrayList<CafeVO> getList(){
		return cafeDAO.getList();
	}
	
	@Override
	public ArrayList<CafeVO> getCafeList(){
		return cafeDAO.getCafeList();
	}

	@Override
	public ArrayList<CafeVO> getCafeList(int startnum, int endnum){
		return cafeDAO.getCafeList(startnum, endnum);
	}
	
	@Override
	public ArrayList<CafeVO> getCafeList(int startnum, int end, String search, String search_text){
		return cafeDAO.getCafeList(startnum, end, search, search_text);
	}
	
	@Override
	public ArrayList<CafeVO> getCafeListTop3(){
		return cafeDAO.getCafeListTop3();
	}
	
	@Override
	public CafeVO getCafeDetail(String caid) {
		return cafeDAO.getCafeDetail(caid);
	}
	
}
