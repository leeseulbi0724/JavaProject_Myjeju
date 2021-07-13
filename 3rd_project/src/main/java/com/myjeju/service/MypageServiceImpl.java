package com.myjeju.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.MypageDAO;
import com.myjeju.vo.MemberVO;

@Service("MypageService")
public class MypageServiceImpl implements MypageService {
	@Autowired
	private MypageDAO mypageDAO;
	
	@Override
	public int getPassCheckResult(MemberVO vo) {
		return mypageDAO.getPassCheckResult(vo);
	}
	
	@Override
	public MemberVO getMemberContent(String id) {
		return mypageDAO.getMemberContent(id);
	}
	
	@Override
	public boolean getInfoUpdate(MemberVO vo) {
		int value = mypageDAO.getInfoUpdate(vo);
		boolean result = false;
		if ( value != 0 ) {
			result = true;
		}
		return result;
	}
	
	@Override
	public boolean getInfoOut(String id) {
		int value = mypageDAO.getInfoOut(id);
		boolean result = false;
		if ( value != 0 ) {
			result = true;
		}
		return result;
	}
	

}
