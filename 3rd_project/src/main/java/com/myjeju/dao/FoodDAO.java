package com.myjeju.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	//음식점 전체 리스트
	public ArrayList<FoodVO> getFoodList(int startnum, int endnum){
		Map<String,String> param = new HashMap<String,String>();
		
		param.put("start", String.valueOf(startnum));
		param.put("end", String.valueOf(endnum));
		
		List<FoodVO> list = sqlSession.selectList(namespace+".ajaxfoodlistnum",param);
		
		return (ArrayList<FoodVO>)list;
	}
	
	//음식점 전체 리스트
	public ArrayList<FoodVO> getFoodList(int startnum, int end, String search, String search_text){
		Map<String,String> param = new HashMap<String,String>();
		
		param.put("start", String.valueOf(startnum));
		param.put("end", String.valueOf(end));
		param.put("search", search);
		param.put("search_text", search_text);
		
		List<FoodVO> list = sqlSession.selectList(namespace+".ajaxfoodlistsearch",param);
		
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
