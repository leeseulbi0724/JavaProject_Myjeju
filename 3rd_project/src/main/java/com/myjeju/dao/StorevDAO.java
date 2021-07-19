package com.myjeju.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.StorevVO;

@Repository
public class StorevDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private static String namespace = "mapper.store";
	
	//����� ��ǰ�� ����
	public boolean getInsertResult(StorevVO vo) {
		boolean result = false;
		int value = sqlSession.insert(namespace + ".storeReviewInsert", vo);
		if(value != 0) result = true;
		return result;
	}
	
	//����� ��ǰ�򸮽�Ʈ ��������
	public ArrayList<StorevVO> getStoreReview(String sid) {
		List<StorevVO> list = sqlSession.selectList(namespace + ".StoreReviewList", sid);
		return (ArrayList<StorevVO>) list;
	}

	// ����� ��ǰ�� �ϳ��� �������� 
	public StorevVO getStoreReviewOne(String srid) {
		return sqlSession.selectOne(namespace + ".reviewOne", srid);
	}
	
	// ����� ��ǰ�� ����
	public int getReviewDelete(String srid) {
		return sqlSession.delete(namespace + ".reviewDelete", srid);
	}
	
	// ����� ��ǰ�� ����
	public int getReviewUpdate(StorevVO vo) {
		return sqlSession.update(namespace + ".reviewUpdate", vo);
	}
	
	// ����� ��ǰ�� �ϳ���
	public int getReviewCount(String sid) {
		return sqlSession.selectOne(namespace + ".reviewCount", sid);
	}
	
	// ����� ��ǰ�� ���� ���
	public int getReviewAvg(String sid) {
		return sqlSession.selectOne(namespace + ".reviewAvg", sid);
	}
}
