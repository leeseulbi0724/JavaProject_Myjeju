package com.myjeju.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.CafeReviewVO;
import com.myjeju.vo.CafeVO;
import com.myjeju.vo.HeartVO;

@Repository
public class CafeDAO extends DBConn {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private static String namespace = "mapper.cafe";
	
	//Select --> ��ü ����Ʈ
	public ArrayList<CafeVO> getList(){
		List<CafeVO> list = sqlSession.selectList(namespace+".map_list");
		return (ArrayList<CafeVO>)list;
	}
	
	//ī�� ��ü ����Ʈ
	public ArrayList<CafeVO> getCafeList(){
		List<CafeVO> list = sqlSession.selectList(namespace+".cafe_list");
		return (ArrayList<CafeVO>)list;
	}
	
	//ī�� ��ü ����Ʈ
	public ArrayList<CafeVO> getCafeList(int startnum, int endnum){
		Map<String,String> param = new HashMap<String,String>();
		
		param.put("start", String.valueOf(startnum));
		param.put("end", String.valueOf(endnum));
		
		List<CafeVO> list = sqlSession.selectList(namespace+".ajax_cafe_list_num",param);
		
		return (ArrayList<CafeVO>)list;
	}
	
	//ī�� ��ü ����Ʈ
	public ArrayList<CafeVO> getCafeList(int startnum, int end, String search, String search_text){
		Map<String,String> param = new HashMap<String,String>();
		
		param.put("start", String.valueOf(startnum));
		param.put("end", String.valueOf(end));
		param.put("search", search);
		param.put("search_text", search_text);
		
		List<CafeVO> list = sqlSession.selectList(namespace+".ajax_cafe_list_search",param);
		
		return (ArrayList<CafeVO>)list;
	}
	
	//ī�� ����3
	public ArrayList<CafeVO> getCafeListTop3(){
		List<CafeVO> list = sqlSession.selectList(namespace+".cafe_top3");
		return (ArrayList<CafeVO>)list;
	}
	
	//ī�� �� ����
	public CafeVO getCafeDetail(String caid) {
		return sqlSession.selectOne(namespace+".cafe_detail", caid);
	}
	
	
	//���� ����
	public boolean getInsertResult(CafeReviewVO vo) {
		boolean result = false;
		
		int value = sqlSession.insert(namespace+".insert_review", vo);
		if(value != 0) result = true;
		
		return result;
	}
	
	//���� ����Ʈ
	public ArrayList<CafeReviewVO> getCafeReview(String caid){
		List<CafeReviewVO> list = sqlSession.selectList(namespace+".review_list", caid);
		return (ArrayList<CafeReviewVO>)list;
	}
	
	//���� ����Ʈ
	public ArrayList<CafeReviewVO> getCafeReview(String caid, int startnum, int endnum){
		Map<String,String> param = new HashMap<String,String>();
		
		param.put("caid", caid);
		param.put("start", String.valueOf(startnum));
		param.put("end", String.valueOf(endnum));
		
		List<CafeReviewVO> list = sqlSession.selectList(namespace+".ajax_review_list",param);
		
		return (ArrayList<CafeReviewVO>)list;
	}
	
	//���� ����
	public int getCafeReviewDelete(String reid) {
		return sqlSession.delete(namespace+".delete_review", reid);
	}
	
	
	//Update ---> ��Ʈ ������Ʈ
	public int getUpdateHeart(String caid) {
		return sqlSession.update(namespace+".updateheart", caid);
	}
	
	//Update ---> ��Ʈ ������Ʈ ���̳ʽ�
	public int getUpdateMinusHeart(String caid) {
		return sqlSession.update(namespace+".updateminusheart", caid);
	}
	
	//��Ʈ ���̺� �߰�
	public int getHeartPlus(HeartVO vo) {
		return sqlSession.insert(namespace+".heart_plus", vo);
	}
	
	//��Ʈ ���̺� ����
	public int getHeartMinus(HeartVO vo) {
		return sqlSession.delete(namespace+".heart_minus", vo);
	}
	
	//��Ʈ������������
	public int getHeartInfoResult(HeartVO vo) {
		return sqlSession.selectOne(namespace+".hearrt_info_result", vo);
	}
}
