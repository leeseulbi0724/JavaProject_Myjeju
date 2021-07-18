package com.myjeju.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.StofaqVO;

@Repository
public class StofaqDAO extends DBConn {
	//Store_faq_DAO : ����� ��ǰ���� - ���� DAO
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "mapper.stofaq";
	
	//SELECT --> ����� ��ǰ���� (���Ƕ� �亯 �ҷ�����) ȭ��
	public ArrayList<StofaqVO> getList(String sid) {
		
		List<StofaqVO> list = sqlSession.selectList(namespace + ".faqlist", sid);
		
		return (ArrayList<StofaqVO>) list;
	}
	

	//INSERT --> ����� ��ǰ���� - ""����"" ���
	public boolean getInsertResult(StofaqVO vo) {
		boolean result = false;
		int value = sqlSession.insert(namespace + ".faqinsert", vo);
		if(value != 0) result = true;
		
		return result;
	}
	
	//INSERT --> ����� ��ǰ���� - ""�亯"" ���
	public boolean getReplyResult(StofaqVO vo) {
		boolean result = false;
		int value = sqlSession.update(namespace + ".replylist", vo);
		if(value != 0) result = true;
		
		return result;
	}
	
	
	//SELECT --> st_id �޾ƿ��� ��
	public StofaqVO getStid(String sid) {
		return sqlSession.selectOne(namespace + ".getSt_id", sid);
	}
	
	// ����� ��ǰ���� ����
		public int getFaqDelete(String st_id) {
			return sqlSession.delete(namespace + ".faqDelete", st_id);
		}
	
}
