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
	
	//Select --> ��ü ����Ʈ
	public ArrayList<FoodVO> getList(){
		List<FoodVO> list = sqlSession.selectList(namespace+".maplist");
		return (ArrayList<FoodVO>)list;
	}
	
	//������ ��ü ����Ʈ
	public ArrayList<FoodVO> getFoodList(){
		List<FoodVO> list = sqlSession.selectList(namespace+".foodlist");
		return (ArrayList<FoodVO>)list;
	}
	
	//������ ����3
	public ArrayList<FoodVO> getFoodListTop3(){
		List<FoodVO> list = sqlSession.selectList(namespace+".foodtop3");
		return (ArrayList<FoodVO>)list;
	}

	//������ �� ����
	public FoodVO getFoodDetail(String fid) {
		return sqlSession.selectOne(namespace+".fooddetail", fid);
	}
}
