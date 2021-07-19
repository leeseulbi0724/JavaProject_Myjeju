package com.myjeju.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.BasketVO;
import com.myjeju.vo.StoreVO;

@Repository
public class StoreDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private static String namespace = "mapper.store";
	
	//SELECT.BEST --> BEST MENU (����Ʈ �޴� ���� ����) [����ȭ��]
	public ArrayList<StoreVO> getBestList() {
		List<StoreVO> list =  sqlSession.selectList(namespace + ".best3list");
		return (ArrayList<StoreVO>) list;
	}
	
	//SELECT.EAT --> ī�װ�-��ǰ (���� ����) [����ȭ��]
	public ArrayList<StoreVO> getEatList() {
		List<StoreVO> list = sqlSession.selectList(namespace + ".eat3list");
		return (ArrayList<StoreVO>) list;
	}
	
	//SELECT.EAT --> ī�װ�-��ǰ [��ǰ ��ȭ��]
	public ArrayList<StoreVO> getEatList2() {
		List<StoreVO> list = sqlSession.selectList(namespace + ".eatlist");
		return (ArrayList<StoreVO>) list;
	}
	
	//SELECT.SOUVE --> ī�װ�-���ǰ (���� ����) [����ȭ��]
	public ArrayList<StoreVO> getSouveList() {
		List<StoreVO> list = sqlSession.selectList(namespace + ".souve3list");
		return (ArrayList<StoreVO>) list;
	}
	
	//SELECT.SOUVE --> ī�װ�-���ǰ [���ǰ ��ȭ��]
	public ArrayList<StoreVO> getSouveList2() {
		List<StoreVO> list = sqlSession.selectList(namespace + ".souvelist");
		return (ArrayList<StoreVO>) list;
	}
		
	//SELECT.ETC --> ī�װ�-��ȭ (���� ����) [����ȭ��]
	public ArrayList<StoreVO> getEtcList() {
		List<StoreVO> list = sqlSession.selectList(namespace + ".etc3list");
		return (ArrayList<StoreVO>) list;
	}
	
	//SELECT.ETC --> ī�װ�-��ȭ [��ȭ ��ȭ��]
	public ArrayList<StoreVO> getEtcList2() {
		List<StoreVO> list = sqlSession.selectList(namespace + ".etclist");
		return (ArrayList<StoreVO>) list;
	}
		
	
	//INSERT --> ����� ��ǰ ���
	public boolean getInsertResult(StoreVO vo) {
		boolean result = false;
		int value = sqlSession.insert(namespace + ".storeInsert", vo);
		if(value != 0) result = true;
		return result;
	}
	
	//SELECT --> ����� ��ǰ �� ȭ��
	public StoreVO getContent(String sid) {
		return sqlSession.selectOne(namespace + ".content", sid);
	}
	
	//�ֹ� ����Ȯ��
	public int getOrderResult(BasketVO vo) {
		return sqlSession.selectOne(namespace+".order_result", vo);
	}
		
	
}
