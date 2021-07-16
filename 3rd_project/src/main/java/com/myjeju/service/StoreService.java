package com.myjeju.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.myjeju.vo.BasketVO;
import com.myjeju.vo.StoreVO;

public interface StoreService {

	ArrayList<StoreVO> getBestList();
	ArrayList<StoreVO> getEatList();
	ArrayList<StoreVO> getEatList2();
	ArrayList<StoreVO> getSouveList();
	ArrayList<StoreVO> getSouveList2();
	ArrayList<StoreVO> getEtcList();
	ArrayList<StoreVO> getEtcList2();
	boolean getInsertResult(StoreVO vo);
	StoreVO getContent(String sid);
	
	ArrayList<List<BasketVO>> getBuyContent(String[] list, String id);
	ArrayList<BasketVO> getBuyContent(String sid, String id);
}
