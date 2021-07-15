package com.myjeju.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.TravelDAO;
import com.myjeju.vo.TravelVO;

@Service("travelService")
public class TravelServiceImpl implements TravelService{
	
	@Autowired
	private TravelDAO travelDAO;
	
	@Override
	public ArrayList<TravelVO> getList(){
		return travelDAO.getList();
	}
	
	@Override
	public ArrayList<TravelVO> getTravelList(){
		return travelDAO.getTravelList();
	}
	
	@Override
	public ArrayList<TravelVO> getTravelListTop3(){
		return travelDAO.getTravelListTop3();
	}
	
	@Override
	public TravelVO getTravelDetail(String tid) {
		return travelDAO.getTravelDetail(tid);
	}
}
