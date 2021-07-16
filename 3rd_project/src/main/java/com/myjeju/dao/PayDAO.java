package com.myjeju.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.BasketVO;

@Repository
public class PayDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "mapper.pay";
	
	public int getOrderResult(BasketVO vo) {
		return sqlSession.insert(namespace+".order_result", vo);
	}
}
