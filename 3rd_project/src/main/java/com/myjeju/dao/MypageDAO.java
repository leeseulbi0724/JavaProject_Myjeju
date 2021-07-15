package com.myjeju.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.MemberVO;

@Repository
public class MypageDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "mapper.mypage";
	
	/** �н����� üũ **/
	public int getPassCheckResult(MemberVO vo) {
		return sqlSession.selectOne(namespace+".pass_check", vo);
	}
	
	/** ���̵�� ȸ������ �������� **/
	public MemberVO getMemberContent(String id) {
		return sqlSession.selectOne(namespace+".content", id);
	}
	
	/** ȸ������ �����ϱ� **/
	public int getInfoUpdate(MemberVO vo) {
		return sqlSession.update(namespace+".info_update", vo);
	}
	
	/** ȸ��Ż�� **/
	public int getInfoOut(String id) {
		return sqlSession.delete(namespace+".info_out", id);
	}
	
	/** �����Խ��� �Խñ� �ҷ����� **/
	public ArrayList<CommunityVO> getFreeBoardResult(String id) {
		List<CommunityVO> list = sqlSession.selectList(namespace+".user_free_list",id);		
		return (ArrayList<CommunityVO>)list;
	}
	
	/** �����Խ��� �Խñ� �ҷ����� **/
	public ArrayList<CommunityVO> getRequestBoardResult(String id) {
		List<CommunityVO> list = sqlSession.selectList(namespace+".user_request_list",id);		
		return (ArrayList<CommunityVO>)list;
	}
	
	/** �����Խ��� ��� �ҷ����� **/
	public ArrayList<CommunityVO> getCommentResult(String id) {
		List<CommunityVO> list = sqlSession.selectList(namespace+".user_comment_list",id);		
		return (ArrayList<CommunityVO>)list;
	}
	
	
}
