package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.CarSpotVO;
import com.myjeju.vo.PhotoSpotVO;
import com.myjeju.vo.TravelVO;

public interface TravelService {
	ArrayList<TravelVO> getList();
	ArrayList<TravelVO> getTravelList();
	ArrayList<TravelVO> getTravelList(int startnum, int endnum);
	ArrayList<TravelVO> getTravelList(int startnum, int end, String search, String search_text);
	ArrayList<TravelVO> getTravelListTop3();
	TravelVO getTravelDetail(String tid);
	PhotoSpotVO getPhotoSpot(String tid);
	CarSpotVO getCarSpot(String tid);
	int execTotalCount();
}
