package com.myjeju.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.StofaqVO;

@Repository
public class StofaqDAO extends DBConn {
	//Store_faq_DAO : 스토어 상품문의 - 문의 DAO
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private static String namespace = "mapper.stofaq";
	
	//SELECT --> 스토어 상품문의 화면
	public ArrayList<StofaqVO> getContent(String sid) {
		
		List<StofaqVO> list = sqlSession.selectList(namespace + ".faqlist", sid);
		
		return (ArrayList<StofaqVO>) list;
		
		/*
		ArrayList<StofaqVO> list = new ArrayList<StofaqVO>();
		
		String sql = " select id, sid, st_id, st_content, to_char(st_time, 'yy-mm-dd hh:mm:ss') st_time from myjeju_stofaq where sid = ? ";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				StofaqVO vo = new StofaqVO();
				vo.setId(rs.getString(1));
				vo.setSid(rs.getString(2));
				vo.setSt_id(rs.getString(3));
				vo.setSt_content(rs.getString(4));
				vo.setSt_time(rs.getString(5));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		*/
	}
	

	//INSERT --> 스토어 상품문의 - 문의 등록
	public boolean getInsertResult(StofaqVO vo) {
		boolean result = false;
		int value = sqlSession.insert(namespace + ".faqinsert", vo);
		if(value != 0) result = true;
		
		return result;
		/*
		String sql = " insert into myjeju_stofaq values(?, ?, 'st_'||sequ_myjeju_store.nextval, ?, sysdate) ";	
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getSid());
			pstmt.setString(3, vo.getSt_content());
			
			//pstmt.setString(1, vo.getSid());
			//pstmt.setString(2, vo.getSt_content());
			
			int value = pstmt.executeUpdate();
			
			if(value != 0) result = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		*/
	}
	
	
	//SELECT --> st_id 받아오는 법
	public StofaqVO getStid(String sid) {
		return sqlSession.selectOne(namespace + ".getSt_id", sid);
		
		/*
		StofaqVO vo = new StofaqVO();
		
		String sql = " select id, sid, st_id, st_content from myjeju_stofaq where sid = ? ";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setId(rs.getString(1));
				vo.setSid(rs.getString(2));
				vo.setSt_id(rs.getString(3));
				vo.setSt_content(rs.getString(4));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
		*/
	}
	
	
}
