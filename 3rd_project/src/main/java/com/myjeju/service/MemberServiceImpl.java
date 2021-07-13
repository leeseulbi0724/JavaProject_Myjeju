package com.myjeju.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.MemberDAO;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.SessionVO;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public boolean getJoinResult(MemberVO vo) {
		boolean result = false;
		
		int value = memberDAO.getJoinResult(vo);
		
		if ( value != 0) {
			result = true;
		}
		
		return result;
	}
	
	@Override
	public SessionVO getLoginResult(MemberVO vo) {
		return memberDAO.getLoginResult(vo);
	}
	
	@Override
	public String getIdSearchResult(MemberVO vo) {
		return memberDAO.getIdSearchResult(vo);
	}
	
	@Override
	public String getPassSearchResult(MemberVO vo) {
		return memberDAO.getIdSearchResult(vo);
	}
	
	@Override
	public boolean getPassUpdateResult(MemberVO vo) {
		boolean result = false;
		
		int value = memberDAO.getPassUpdateResult(vo);
		
		if ( value != 0 ) {
			result = true;
		}
		
		return result;
	}
	
	@Override
	public int getIdCheckResult(String id) {
		return memberDAO.getIdCheckResult(id);
	}
	
	

}
