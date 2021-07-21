package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.FoodVO;
import com.myjeju.vo.HeartVO;

public interface FoodService {
	ArrayList<FoodVO> getList();
	ArrayList<FoodVO> getFoodList();
	ArrayList<FoodVO> getFoodList(int startnum, int endnum);
	ArrayList<FoodVO> getFoodList(int startnum, int end, String search, String search_text);
	ArrayList<FoodVO> getFoodListTop3();
	FoodVO getFoodDetail(String fid);
	
	int getHeartInfoResult(HeartVO vo);
	boolean getHeartMinus(HeartVO vo);
	boolean getUpdateHeart(String fid);
	boolean getUpdateMinusHeart(String fid);
	boolean getHeartPlus(HeartVO vo);
}
