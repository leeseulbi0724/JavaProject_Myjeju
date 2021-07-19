package com.myjeju.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.CarSpotVO;
import com.myjeju.vo.PhotoSpotVO;
import com.myjeju.vo.TravelVO;

@Repository
public class TravelDAO extends DBConn {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private static String namespace = "mapper.travel";
	
	//Select --> ��ü ����Ʈ
	public ArrayList<TravelVO> getList(){
		List<TravelVO> list = sqlSession.selectList(namespace+".maplist");
		return (ArrayList<TravelVO>)list;
	}
		
	//������ ��ü ����Ʈ
	public ArrayList<TravelVO> getTravelList(int start, int end){
		Map<String,String> param = new HashMap<String,String>();
		
		param.put("start", String.valueOf(start));
		param.put("end", String.valueOf(end));
		
		List<TravelVO> list = sqlSession.selectList(namespace+".travellist",param);
		
		return (ArrayList<TravelVO>)list;
	}
	
	//������ ��ü ����Ʈ
	public ArrayList<TravelVO> getTravelList(String category, String tname){
		Map<String,String> param = new HashMap<String,String>();
		
		param.put("category", category);
		param.put("tname", tname);
		
		List<TravelVO> list = sqlSession.selectList(namespace+".ajaxlist",param);
		
		return (ArrayList<TravelVO>)list;
	}
	
	//ī��Ʈ
	public int execTotalCount() {
		return sqlSession.selectOne(namespace+".travel_count");
	}
	
	//������ ����3
	public ArrayList<TravelVO> getTravelListTop3(){
		List<TravelVO> list = sqlSession.selectList(namespace+".traveltop3");
		return (ArrayList<TravelVO>)list;
	}
	
	//������ �� ����
	public TravelVO getTravelDetail(String tid) {
		return sqlSession.selectOne(namespace+".traveldetail", tid);
	}
	
	//���� ���� 
	public PhotoSpotVO getPhotoSpot(String tid) {
		return sqlSession.selectOne(namespace+".photospot", tid);
	}
	
	//���� ����
	public CarSpotVO getCarSpot(String tid) {
		return sqlSession.selectOne(namespace+".carspot", tid);
	}
}
