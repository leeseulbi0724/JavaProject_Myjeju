package com.myjeju.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.MemberDAO;
import com.myjeju.vo.MemberVO;

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
	
	

}
