package com.myjeju.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.HDetailVO;
import com.myjeju.vo.HeartVO;
import com.myjeju.vo.HouseVO;


@Repository
public class HouseDAO extends DBConn {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private static String namespace = "mapper.house";
	
	//숙소 전체리스트
	public ArrayList<HouseVO> getHouseList(){
		List<HouseVO> list = sqlSession.selectList(namespace+".houselist");
		return (ArrayList<HouseVO>)list;
	}
	
	//숙소 상위3개
	public ArrayList<HouseVO> getHouseListTop3(){
		List<HouseVO> list = sqlSession.selectList(namespace+".housetop3");
		return (ArrayList<HouseVO>)list;
	}
	
	//숙소 상세 정보
	public HouseVO getHouseDetail(String hid) {
		return sqlSession.selectOne(namespace+".housedetail", hid);
	}
	
	//숙소 객실 정보
	public ArrayList<HDetailVO> getHDetail(String hid){
		List<HDetailVO> list = sqlSession.selectList(namespace+".roomdetail",hid);
		return (ArrayList<HDetailVO>)list;
	}
	
	//Update ---> 하트 업데이트
	public void getUpdateHeart(HeartVO vo) {
		sqlSession.update(namespace+".updateheart");
	}
	
	//하트 테이블 추가
	public int getHeartPlus(HeartVO vo) {
		return sqlSession.insert(namespace+".heart_plus", vo);
	}
	
	//하트 테이블 삭제
	public int getHeartMinus(HeartVO vo) {
		return sqlSession.delete(namespace+".heart_minus", vo);
	}
	
}
