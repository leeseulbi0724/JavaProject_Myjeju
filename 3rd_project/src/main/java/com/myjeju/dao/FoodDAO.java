package com.myjeju.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.FoodVO;

@Repository
public class FoodDAO extends DBConn {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private static String namespace = "mapper.food";
	
	//Select --> 전체 리스트
	public ArrayList<FoodVO> getList(){
		List<FoodVO> list = sqlSession.selectList(namespace+".maplist");
		return (ArrayList<FoodVO>)list;
	}
	
	//음식점 전체 리스트
	public ArrayList<FoodVO> getFoodList(){
		List<FoodVO> list = sqlSession.selectList(namespace+".foodlist");
		return (ArrayList<FoodVO>)list;
	}
	
	//음식점 상위3
	public ArrayList<FoodVO> getFoodListTop3(){
		List<FoodVO> list = sqlSession.selectList(namespace+".foodtop3");
		return (ArrayList<FoodVO>)list;
	}

	//음식점 상세 정보
	public FoodVO getFoodDetail(String fid) {
		return sqlSession.selectOne(namespace+".fooddetail", fid);
	}
}
