package com.myjeju.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.MemberVO;

@Repository
public class MypageDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "mapper.mypage";
	
	/** 패스워드 체크 **/
	public int getPassCheckResult(MemberVO vo) {
		return sqlSession.selectOne(namespace+".pass_check", vo);
	}
	
	/** 아이디로 회원정보 가져오기 **/
	public MemberVO getMemberContent(String id) {
		return sqlSession.selectOne(namespace+".content", id);
	}
	
	/** 회원정보 수정하기 **/
	public int getInfoUpdate(MemberVO vo) {
		return sqlSession.update(namespace+".info_update", vo);
	}
	
	/** 회원탈퇴 **/
	public int getInfoOut(String id) {
		return sqlSession.delete(namespace+".info_out", id);
	}
	
	
}
