package com.myjeju.dao;

import java.util.ArrayList;
import java.util.List;

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
	
	//Select --> 전체 리스트
	public ArrayList<TravelVO> getList(){
		List<TravelVO> list = sqlSession.selectList(namespace+".maplist");
		return (ArrayList<TravelVO>)list;
	}
		
	//여행지 전체 리스트
	public ArrayList<TravelVO> getTravelList(){
		List<TravelVO> list = sqlSession.selectList(namespace+".travellist");
		return (ArrayList<TravelVO>)list;
	}
		
	//여행지 상위3
	public ArrayList<TravelVO> getTravelListTop3(){
		List<TravelVO> list = sqlSession.selectList(namespace+".traveltop3");
		return (ArrayList<TravelVO>)list;
	}
	
	//여행지 상세 정보
	public TravelVO getTravelDetail(String tid) {
		return sqlSession.selectOne(namespace+".traveldetail", tid);
	}
	
	//포토 스팟 
	public PhotoSpotVO getPhotoSpot(String tid) {
		return sqlSession.selectOne(namespace+".photospot", tid);
	}
	
	//차박 스팟
	public CarSpotVO getCarSpot(String tid) {
		return sqlSession.selectOne(namespace+".carspot", tid);
	}
}
