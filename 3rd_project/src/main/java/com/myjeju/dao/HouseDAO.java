package com.myjeju.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.HDetailVO;
import com.myjeju.vo.HeartVO;
import com.myjeju.vo.HouseVO;
import com.myjeju.vo.HouseReviewVO;


@Repository
public class HouseDAO extends DBConn {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private static String namespace = "mapper.house";
	
	//���� ��ü����Ʈ
	public ArrayList<HouseVO> getHouseList(){
		List<HouseVO> list = sqlSession.selectList(namespace+".house_list");
		return (ArrayList<HouseVO>)list;
	}
	
	//���� ��ü ����Ʈ
	public ArrayList<HouseVO> getHouseList(int startnum, int endnum){
		Map<String,String> param = new HashMap<String,String>();
		
		param.put("start", String.valueOf(startnum));
		param.put("end", String.valueOf(endnum));
		
		List<HouseVO> list = sqlSession.selectList(namespace+".ajax_house_list_num",param);
		
		return (ArrayList<HouseVO>)list;
	}
	
	//���� ��ü ����Ʈ
	public ArrayList<HouseVO> getHouseList(int startnum, int end, String search, String search_text){
		Map<String,String> param = new HashMap<String,String>();
		
		param.put("start", String.valueOf(startnum));
		param.put("end", String.valueOf(end));
		param.put("search", search);
		param.put("search_text", search_text);
		
		List<HouseVO> list = sqlSession.selectList(namespace+".ajax_house_list_search",param);
		
		return (ArrayList<HouseVO>)list;
	}
	
	//���� ����3��
	public ArrayList<HouseVO> getHouseListTop3(){
		List<HouseVO> list = sqlSession.selectList(namespace+".house_top3");
		return (ArrayList<HouseVO>)list;
	}
	
	//���� �� ����
	public HouseVO getHouseDetail(String hid) {
		return sqlSession.selectOne(namespace+".house_detail", hid);
	}
	
	//���� ���� ����
	public ArrayList<HDetailVO> getHDetail(String hid){
		List<HDetailVO> list = sqlSession.selectList(namespace+".room_detail",hid);
		return (ArrayList<HDetailVO>)list;
	}
	
	//Update ---> ��Ʈ ������Ʈ
	public int getUpdateHeart(String hid) {
		return sqlSession.update(namespace+".updateheart", hid);
	}
	
	//Update ---> ��Ʈ ������Ʈ ���̳ʽ�
	public int getUpdateMinusHeart(String hid) {
		return sqlSession.update(namespace+".updateminusheart", hid);
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
	
	//���� ����
	public boolean getInsertResult(HouseReviewVO vo) {
		boolean result = false;
		
		int value = sqlSession.insert(namespace+".insert_review", vo);
		if(value != 0) result = true;
		
		return result;
	}
	
	//���� ����Ʈ
	public ArrayList<HouseReviewVO> getHouseReview(String hid){
		List<HouseReviewVO> list = sqlSession.selectList(namespace+".review_list", hid);
		return (ArrayList<HouseReviewVO>)list;
	}
	
	
	//���� ����Ʈ
	public ArrayList<HouseReviewVO> getHouseReview(String hid, int startnum, int endnum){
		Map<String,String> param = new HashMap<String,String>();
		
		param.put("hid", hid);
		param.put("start", String.valueOf(startnum));
		param.put("end", String.valueOf(endnum));
		
		List<HouseReviewVO> list = sqlSession.selectList(namespace+".ajax_review_list",param);
		
		return (ArrayList<HouseReviewVO>)list;
	}
	
	
	//���� ����
	public int getHouseReviewDelete(String reid) {
		return sqlSession.delete(namespace+".delete_review", reid);
	}
	
	//���� ��� ������Ʈ
	public boolean getStarAvgUpdate(String hid) {
		boolean result = false;
		int value = sqlSession.update(namespace+".star_avg_update", hid);
		if(value != 0) result = true;
		return result;
	}
	
	//���� ī��Ʈ ������Ʈ
	public boolean getReviewCountUpdate(String hid) {
		boolean result =false;
		int value = sqlSession.update(namespace+".review_count_update", hid);
		if(value != 0) result =true;
		return result;
	}
	
}
