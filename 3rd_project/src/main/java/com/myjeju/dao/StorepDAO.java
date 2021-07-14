package com.myjeju.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.StorepVO;

@Repository
public class StorepDAO extends DBConn {
	//Store_reply_DAO : 스토어 상품문의 - 답변 DAO
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private static String namespace = "mapper.storep";
	
	//SELECT --> 스토어 상품답변 화면
	public ArrayList<StorepVO> getContent(String sid) {
		List<StorepVO> list = sqlSession.selectList(namespace + ".replist", sid);
		
		return (ArrayList<StorepVO>) list;
		/*
		ArrayList<StorepVO> list = new ArrayList<StorepVO>();
		
		String sql = " select id, sid, st_id, str_id, str_content, str_time from myjeju_storep where sid = ? ";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			//pstmt.setString(2, st_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				StorepVO vo = new StorepVO();
				vo.setId(rs.getString(1));
				vo.setSid(rs.getString(2));
				vo.setSt_id(rs.getString(3));
				vo.setStr_id(rs.getString(4));
				vo.setStr_content(rs.getString(5));
				vo.setStr_time(rs.getString(6));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		*/
	}
	
	
	
	
	
	//INSERT --> 스토어 상품문의 - 답변 등록
	public boolean getInsertResult(StorepVO vo) {
		boolean result = false;
		int value = sqlSession.insert(namespace + ".repinsert", vo);
		if(value != 0) result = true;
		
		return result;
		/*
		String sql = " insert into myjeju_storep values(?, ?, ?, 'str_'||sequ_myjeju_store.nextval, ?, sysdate) ";	
		getPreparedStatement(sql);
		try {
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getSid());
			pstmt.setString(3, vo.getSt_id());
			pstmt.setString(4, vo.getStr_content());
			
			int value = pstmt.executeUpdate();
			
			if(value != 0) result = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		*/
	}
}
