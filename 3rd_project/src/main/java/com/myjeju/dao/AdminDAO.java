package com.myjeju.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.MemberVO;

@Repository
public class AdminDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "mapper.admin";
	
	//리스트 가져오기
	public ArrayList<MemberVO> getlist(int startnum, int endnum) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(endnum));
		
		List<MemberVO> list = sqlSession.selectList(namespace+".listnum",se);
		return (ArrayList<MemberVO>)list;
	}
	public ArrayList<MemberVO> getlist(int startnum, int end, String search, String search_text) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(end));
		se.put("search", search);
		se.put("search_text", search_text);
		
		List<MemberVO> list = sqlSession.selectList(namespace+".listsearch",se);
		return (ArrayList<MemberVO>)list;
	}
	public int targetPage(int pageNumber) {
		return sqlSession.selectOne(namespace+".target", pageNumber);
	}
	public int targetPage(int pageNumber,String search,String search_text) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("pageNumber", String.valueOf(pageNumber));
		se.put("search", search);
		se.put("search_text", search_text);
		return sqlSession.selectOne(namespace+".searchtarget", se);
	}
	
	
	//관리자 게시판 리스트
	public ArrayList<CommunityVO> getBoardList(int startnum, int endnum) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(endnum));
		
		List<CommunityVO> list = sqlSession.selectList(namespace+".board_list",se);
		return (ArrayList<CommunityVO>)list;
	}
	//게시판 총 갯수
	public int getBoardPage(int pageNumber) {
		return sqlSession.selectOne(namespace+".board_count", pageNumber);
	}
	//
	public ArrayList<CommunityVO> getBoardList(int startnum, int end, String search, String search_text) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(end));
		se.put("search", search);
		se.put("search_text", search_text);
		
		List<CommunityVO> list = sqlSession.selectList(namespace+".board_search",se);
		return (ArrayList<CommunityVO>)list;
	}
	public int getBoardPage(int pageNumber,String search,String search_text) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("pageNumber", String.valueOf(pageNumber));
		se.put("search", search);
		se.put("search_text", search_text);
		return sqlSession.selectOne(namespace+".board_searchpage", se);
	}
}
