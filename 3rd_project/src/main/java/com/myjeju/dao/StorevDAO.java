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
	
	//스토어 상품평 쓰기
	public boolean getInsertResult(StorevVO vo) {
		boolean result = false;
		int value = sqlSession.insert(namespace + ".storeReviewInsert", vo);
		if(value != 0) result = true;
		return result;
	}
	
	//스토어 상품평 가져오기
	public ArrayList<StorevVO> getStoreReview(String sid) {
		List<StorevVO> list = sqlSession.selectList(namespace + ".StoreReviewList", sid);
		return (ArrayList<StorevVO>) list;
	}
}
