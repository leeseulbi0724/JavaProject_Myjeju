package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.BasketVO;
import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.OrderVO;
import com.myjeju.vo.PointVO;
import com.myjeju.vo.StorevVO;
import com.myjeju.vo.TravelReviewVO;

public interface MypageService {
	
	int getPassCheckResult(MemberVO vo);
	MemberVO getMemberContent(String id);
	boolean getInfoUpdate(MemberVO vo);
	boolean getInfoOut(String id);
	
	boolean getInsertResult(BasketVO vo);
	ArrayList<BasketVO> getBasketContent(String id);
	BasketVO getSid2(String id);
	
	ArrayList<CommunityVO> getFreeBoardResult(String id);
	ArrayList<CommunityVO> getRequestBoardResult(String id);
	ArrayList<CommunityVO> getCommentResult(String id);
	
	boolean getAlready(BasketVO vo);
	boolean getAlreadyCount(BasketVO vo);
	
	boolean getBasketDelete(String sid);
	int getColumn(String id);
	int getPoint(String id);
	
	ArrayList<OrderVO> getOrderList(String id);
	ArrayList<PointVO> getPointList(String id);
	ArrayList<OrderVO> getMReservation(String id);
	OrderVO getHouseName(String hid);
	OrderVO getRommName(String hdid);
	boolean getOrderSequ(BasketVO vo);
	
	
	ArrayList<StorevVO> getStoreReview(String id);
	ArrayList<TravelReviewVO> getTravelReview(String id);
	
}
