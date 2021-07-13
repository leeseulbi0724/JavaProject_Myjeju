package com.myjeju.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.MemberVO;
import com.myjeju.vo.SessionVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "mapper.member";
	
	//ȸ������
	public int getJoinResult(MemberVO vo) {
		return sqlSession.insert(namespace+".join", vo);
	}
	
	//�α���
	public  SessionVO getLoginResult(MemberVO vo) {
		return sqlSession.selectOne(namespace+".login", vo);
	}
	
	//���̵� ã��
	public String getIdSearchResult(MemberVO vo) {
		return sqlSession.selectOne(namespace+".id_search", vo);
	}
	
	//�н����� ã��
	public String getPassSearchResult(MemberVO vo) {
		return sqlSession.selectOne(namespace+".pass_search", vo);
	}
	
	//�н����� ����
	public int getPassUpdateResult(MemberVO vo) {
		return sqlSession.update(namespace+".pass_update", vo);
	}
	
	//���̵� �ߺ�Ȯ��
	public int getIdCheckResult(String id) {
		return sqlSession.selectOne(namespace+".id_check", id);
	}
}
