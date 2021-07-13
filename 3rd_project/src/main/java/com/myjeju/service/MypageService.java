package com.myjeju.service;

import com.myjeju.vo.MemberVO;

public interface MypageService {
	
	int getPassCheckResult(MemberVO vo);
	MemberVO getMemberContent(String id);
	boolean getInfoUpdate(MemberVO vo);
	boolean getInfoOut(String id);

}
