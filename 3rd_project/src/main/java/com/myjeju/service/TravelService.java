package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.CarSpotVO;
import com.myjeju.vo.HeartVO;
import com.myjeju.vo.PhotoSpotVO;
import com.myjeju.vo.ReviewVO;
import com.myjeju.vo.TravelVO;

public interface TravelService {
	ArrayList<TravelVO> getList();
	ArrayList<TravelVO> getTravelList();
	ArrayList<TravelVO> getTravelList(int startnum, int endnum);
	ArrayList<TravelVO> getTravelList(int startnum, int end, String search, String search_text);
	ArrayList<TravelVO> getTravelListTop3();
	int getHeartInfoResult(HeartVO vo);
	boolean getHeartMinus(HeartVO vo);
	boolean getUpdateHeart(String tid);
	boolean getUpdateMinusHeart(String tid);
	boolean getHeartPlus(HeartVO vo);
	TravelVO getTravelDetail(String tid);
	PhotoSpotVO getPhotoSpot(String tid);
	CarSpotVO getCarSpot(String tid);
	boolean getInsertResult(ReviewVO vo);
	ArrayList<ReviewVO> getTravelReview(String tid);
}
