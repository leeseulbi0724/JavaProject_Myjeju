package com.myjeju.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.HouseDAO;
import com.myjeju.vo.HDetailVO;
import com.myjeju.vo.HeartVO;
import com.myjeju.vo.HouseVO;

@Service("houseService")
public class HouseServiceImpl implements HouseService {
	
	@Autowired
	private HouseDAO houseDAO;
	
	@Override
	public ArrayList<HouseVO> getHouseList(){
		return houseDAO.getHouseList();
	}
	
	@Override
	public ArrayList<HouseVO> getHouseListTop3(){
		return houseDAO.getHouseListTop3();
	}
	
	@Override
	public HouseVO getHouseDetail(String hid) {
		return houseDAO.getHouseDetail(hid);
	}
	
	@Override
	public ArrayList<HDetailVO> getHDetail(String hid){
		return houseDAO.getHDetail(hid);
	}
	
	@Override
	public boolean getUpdateHeart(String hid) {
		int val = houseDAO.getUpdateHeart(hid);
		boolean result = false;
		if ( val!= 0) {
			result = true;
		}
		return result;
	}
	
	@Override
	public boolean getUpdateMinusHeart(String hid) {
		int val = houseDAO.getUpdateMinusHeart(hid);
		boolean result = false;
		if ( val!= 0) {
			result = true;
		}
		return result;
	}
	
	@Override
	public int getHeartInfoResult(HeartVO vo) {
		return houseDAO.getHeartInfoResult(vo);
	}
	
	@Override
	public boolean getHeartMinus(HeartVO vo) {
		int val = houseDAO.getHeartMinus(vo);
		boolean result = false;
		if ( val!= 0) {
			result = true;
		}
		return result;
	}
	
	@Override
	public boolean getHeartPlus(HeartVO vo) {
		int val = houseDAO.getHeartPlus(vo);
		boolean result = false;
		if ( val!= 0) {
			result = true;
		}
		return result;
	}
	
	
	
	
}
