package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.HDetailVO;
import com.myjeju.vo.HeartVO;
import com.myjeju.vo.HouseVO;

public interface HouseService{
	ArrayList<HouseVO> getHouseList();
	ArrayList<HouseVO> getHouseListTop3();
	HouseVO getHouseDetail(String hid);
	ArrayList<HDetailVO> getHDetail(String hid);
	void getUpdateHeart(String hid);
	boolean getHeartPlus(HeartVO vo);
	boolean getHeartMinus(HeartVO vo);
	boolean getHeartResult(HeartVO vo);
	void getUpdateHeart(HeartVO vo);
}
