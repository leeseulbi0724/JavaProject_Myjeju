package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.BasketVO;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.StoreVO;

public interface MypageService {
	
	int getPassCheckResult(MemberVO vo);
	MemberVO getMemberContent(String id);
	boolean getInfoUpdate(MemberVO vo);
	boolean getInfoOut(String id);
	
	boolean getInsertResult(BasketVO vo);
	ArrayList<BasketVO> getSid(String id);
	BasketVO getSid2(String id);
	ArrayList<StoreVO> getBcontent(String sid);

}
