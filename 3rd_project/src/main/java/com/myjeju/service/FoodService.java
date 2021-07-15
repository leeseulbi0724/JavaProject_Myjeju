package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.FoodVO;

public interface FoodService {
	ArrayList<FoodVO> getList();
	ArrayList<FoodVO> getFoodList();
	ArrayList<FoodVO> getFoodListTop3();
	FoodVO getFoodDetail(String fid);
}
