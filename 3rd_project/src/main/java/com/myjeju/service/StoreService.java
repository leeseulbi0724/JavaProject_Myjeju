package com.myjeju.service;

import java.util.ArrayList;

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
}
