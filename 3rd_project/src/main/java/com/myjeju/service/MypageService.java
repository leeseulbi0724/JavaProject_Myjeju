package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.BasketVO;
import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.StoreVO;

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
	
	int getTotalCount(String id);
	 int getBasketDelete(String sid);
	 int getColumn(String id);
}
