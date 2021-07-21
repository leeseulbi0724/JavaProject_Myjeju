package com.myjeju.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.CafeVO;
import com.myjeju.vo.HeartVO;

@Repository
public class CafeDAO extends DBConn {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private static String namespace = "mapper.cafe";
	
	//Select --> 전체 리스트
	public ArrayList<CafeVO> getList(){
		List<CafeVO> list = sqlSession.selectList(namespace+".maplist");
		return (ArrayList<CafeVO>)list;
	}
	
	//카페 전체 리스트
	public ArrayList<CafeVO> getCafeList(){
		List<CafeVO> list = sqlSession.selectList(namespace+".cafelist");
		return (ArrayList<CafeVO>)list;
	}
	
	//카페 전체 리스트
	public ArrayList<CafeVO> getCafeList(int startnum, int endnum){
		Map<String,String> param = new HashMap<String,String>();
		
		param.put("start", String.valueOf(startnum));
		param.put("end", String.valueOf(endnum));
		
		List<CafeVO> list = sqlSession.selectList(namespace+".ajaxcafelistnum",param);
		
		return (ArrayList<CafeVO>)list;
	}
	
	//카페 전체 리스트
	public ArrayList<CafeVO> getCafeList(int startnum, int end, String search, String search_text){
		Map<String,String> param = new HashMap<String,String>();
		
		param.put("start", String.valueOf(startnum));
		param.put("end", String.valueOf(end));
		param.put("search", search);
		param.put("search_text", search_text);
		
		List<CafeVO> list = sqlSession.selectList(namespace+".ajaxcafelistsearch",param);
		
		return (ArrayList<CafeVO>)list;
	}
	
	//카페 상위3
	public ArrayList<CafeVO> getCafeListTop3(){
		List<CafeVO> list = sqlSession.selectList(namespace+".cafetop3");
		return (ArrayList<CafeVO>)list;
	}
	
	//카페 상세 정보
	public CafeVO getCafeDetail(String caid) {
		return sqlSession.selectOne(namespace+".cafedetail", caid);
	}
	
	//Update ---> 하트 업데이트
	public int getUpdateHeart(String caid) {
		return sqlSession.update(namespace+".updateheart", caid);
	}
	
	//Update ---> 하트 업데이트 마이너스
	public int getUpdateMinusHeart(String caid) {
		return sqlSession.update(namespace+".updateminusheart", caid);
	}
	
	//하트 테이블 추가
	public int getHeartPlus(HeartVO vo) {
		return sqlSession.insert(namespace+".heart_plus", vo);
	}
	
	//하트 테이블 삭제
	public int getHeartMinus(HeartVO vo) {
		return sqlSession.delete(namespace+".heart_minus", vo);
	}
	
	//하트정보가져오기
	public int getHeartInfoResult(HeartVO vo) {
		return sqlSession.selectOne(namespace+".hearrt_info_result", vo);
	}
}
