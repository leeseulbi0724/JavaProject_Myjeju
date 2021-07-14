package com.myjeju.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.CommunityVO;

@Repository
public class CommunityDAO {
	

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "mapper.community";
	
	//자유게시판 글쓰기
	public int getFreeWrite(CommunityVO vo) {
		return sqlSession.insert(namespace+".free_write", vo);
	}
	
	//자유게시판 총 게시글 수
	public int getFreeTotalCount() {
		return sqlSession.selectOne(namespace+".free_total_count");
	}
	
	//자유게시판 페이징 처리
	public ArrayList<CommunityVO> getFreeList(int start, int end){
		Map<String, String> param = new HashMap<String, String>();
		param.put("start", String.valueOf(start));
		param.put("end", String.valueOf(end));
		List<CommunityVO> list = sqlSession.selectList(namespace+".free_list", param);
		
		return (ArrayList<CommunityVO>)list;
	}	
	
	//자유게시판 해당 글 내용 가져오기
	public CommunityVO getFreeContent(String fid) {
		return sqlSession.selectOne(namespace+".free_content", fid);
	}

}
