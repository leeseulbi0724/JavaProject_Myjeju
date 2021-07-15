package com.myjeju.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.BasketVO;
import com.myjeju.vo.StoreVO;

@Repository
public class BasketDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "mapper.mypage";
	
	// 상품 장바구니에 추가
	public boolean getInsertResult(BasketVO vo) {
		boolean result = false;
		int value = sqlSession.insert(namespace + ".basket", vo);
		if(value != 0) result = true;
		return result;
	}
	
	// id 비교해서 상품 정보 불러오기
	public ArrayList<BasketVO> getBasketContent(String id) {
		List<BasketVO> list = sqlSession.selectList(namespace + ".getsid" , id);
		return (ArrayList<BasketVO>) list;
	}
	
	public BasketVO getSid2(String id) {
		return sqlSession.selectOne(namespace + ".getVOsid" , id);
	}

}

