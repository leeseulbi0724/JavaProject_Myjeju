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

	/*
	 *
	 */
	/*
	 *   boolean
	 * getHeartResult(HeartVO vo);
	 */
	int getHeartInfoResult(HeartVO vo);
	boolean getHeartMinus(HeartVO vo);
	boolean getUpdateHeart(String hid);
	boolean getUpdateMinusHeart(String hid);
	boolean getHeartPlus(HeartVO vo);
}
