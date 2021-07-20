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
	
	//���� ��ü����Ʈ
	public ArrayList<HouseVO> getHouseList(){
		List<HouseVO> list = sqlSession.selectList(namespace+".houselist");
		return (ArrayList<HouseVO>)list;
	}
	
	//���� ����3��
	public ArrayList<HouseVO> getHouseListTop3(){
		List<HouseVO> list = sqlSession.selectList(namespace+".housetop3");
		return (ArrayList<HouseVO>)list;
	}
	
	//���� �� ����
	public HouseVO getHouseDetail(String hid) {
		return sqlSession.selectOne(namespace+".housedetail", hid);
	}
	
	//���� ���� ����
	public ArrayList<HDetailVO> getHDetail(String hid){
		List<HDetailVO> list = sqlSession.selectList(namespace+".roomdetail",hid);
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
	
}
