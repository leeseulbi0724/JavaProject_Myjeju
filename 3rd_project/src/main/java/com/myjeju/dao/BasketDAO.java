package com.myjeju.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.BasketVO;
import com.myjeju.vo.StoreVO;

@Repository
public class BasketDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "mapper.mypage";
	
	// ��ǰ ��ٱ��Ͽ� �߰�
	public boolean getInsertResult(BasketVO vo) {
		boolean result = false;
		int value = sqlSession.insert(namespace + ".basket", vo);
		if(value != 0) result = true;
		return result;
	}
	
	// id ���ؼ� ��ǰ ���� �ҷ�����
	public ArrayList<BasketVO> getBasketContent(String id) {
		List<BasketVO> list = sqlSession.selectList(namespace + ".getsid" , id);
		return (ArrayList<BasketVO>) list;
	}
	
	public BasketVO getSid2(String id) {
		return sqlSession.selectOne(namespace + ".getVOsid" , id);
	}
	
	//��ǰ�� �̹� ����� �Ǿ��ִ� ������ Ȯ���ϱ�
	public int getAlready(BasketVO vo) {
		return sqlSession.selectOne(namespace+".already", vo);
	}
	
	//��ǰ�� ������ -> ���� ������Ʈ
	public int getAlreadyCount(BasketVO vo) {
		return sqlSession.update(namespace+".already_count", vo);
	}
	
	//��ٱ��� ��ü����
	public int getTotalCount(String id) {
		return sqlSession.selectOne(namespace+".total_count", id);
	}
	
	//��ٱ��� ����
	public int getBasketDelete(String sid) {
		return sqlSession.delete(namespace+".basket_delete", sid);
	}
	
	//��ٱ��� �÷���
	public int getColumn(String id) {
		return sqlSession.selectOne(namespace+".column", id);
	}

}

