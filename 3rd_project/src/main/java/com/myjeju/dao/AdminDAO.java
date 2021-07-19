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
import com.myjeju.vo.NoticeVO;
import com.myjeju.vo.StoreVO;

@Repository
public class AdminDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "mapper.admin";
	
	//����Ʈ ��������
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
	
	
	//������ �Խ��� ����Ʈ
	public ArrayList<CommunityVO> getBoardList(int startnum, int endnum) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(endnum));
		
		List<CommunityVO> list = sqlSession.selectList(namespace+".board_list",se);
		return (ArrayList<CommunityVO>)list;
	}
	//�Խ��� �� ����
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
	
	//������ �������� �۾���
	public int getNoticeWrite(NoticeVO vo) {
		return sqlSession.insert(namespace+".notice_write", vo);
	}
	//������ ����Ʈ
	public ArrayList<NoticeVO> getNoticeList(int startnum, int endnum) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(endnum));
		
		List<NoticeVO> list = sqlSession.selectList(namespace+".notice_list",se);
		return (ArrayList<NoticeVO>)list;
	}
	//�������� �� ����
	public int getNoticePage(int pageNumber) {
		return sqlSession.selectOne(namespace+".notice_count", pageNumber);
	}
	public ArrayList<NoticeVO> getNoticeList(int startnum, int end, String search, String search_text) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(end));
		se.put("search", search);
		se.put("search_text", search_text);
		
		List<NoticeVO> list = sqlSession.selectList(namespace+".notice_search",se);
		return (ArrayList<NoticeVO>)list;
	}
	public int getNoticePage(int pageNumber,String search,String search_text) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("pageNumber", String.valueOf(pageNumber));
		se.put("search", search);
		se.put("search_text", search_text);
		return sqlSession.selectOne(namespace+".notice_searchpage", se);
	}
	//�������� �󼼺���
	public NoticeVO getNoticeContent(String nid) {
		return sqlSession.selectOne(namespace+".notice_content", nid);
	}
	//�������� --> ������Ʈ
	public int getFileYesUpdate(NoticeVO vo) {
		return sqlSession.update(namespace+".yes_update", vo);
	}	
	//���Ϲ����� --> ������Ʈ
	public int getFileNoUpdate(NoticeVO vo) {
		return sqlSession.update(namespace+".no_update", vo);
	}
	//�������� �̹��� ã��
	public String getOldFile(String nid) {
		return sqlSession.selectOne(namespace+".oldfile", nid);
	}
	//�������� ����
	public int getNoticeDelete(String nid) {
		return sqlSession.delete(namespace+".notice_delete", nid);
	}
	
	//������ ��û ����Ʈ
	public ArrayList<CommunityVO> getRequestList(int startnum, int endnum) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(endnum));
		
		List<CommunityVO> list = sqlSession.selectList(namespace+".request_list",se);
		return (ArrayList<CommunityVO>)list;
	}
	//��û �� ����
	public int getRequestPage(int pageNumber) {
		return sqlSession.selectOne(namespace+".request_count", pageNumber);
	}
	public ArrayList<CommunityVO> getRequestList(int startnum, int end, String search, String search_text) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(end));
		se.put("search", search);
		se.put("search_text", search_text);
		
		List<CommunityVO> list = sqlSession.selectList(namespace+".request_search",se);
		return (ArrayList<CommunityVO>)list;
	}
	public int getRequestPage(int pageNumber,String search,String search_text) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("pageNumber", String.valueOf(pageNumber));
		se.put("search", search);
		se.put("search_text", search_text);
		return sqlSession.selectOne(namespace+".request_searchpage", se);
	}
	//�󼼺���
	public CommunityVO getRequestContent(String rid) {
		return sqlSession.selectOne(namespace+".request_content", rid);
	}
	//��۴ޱ�
	public int getRequestComment(CommunityVO vo) {
		return sqlSession.insert(namespace+".request_comment", vo);
	}
	//�亯���� ��������
	public CommunityVO getRequestCommentResult(String rid) {
		return sqlSession.selectOne(namespace+".request_comment_result", rid);
	}
	//�����ϱ�
	public int getRequestDelete(String rid) {
		return sqlSession.delete(namespace+".request_delete", rid);
	}
	
	
	//������ �����
	//������ - ����� ��ǰ ��ü ����Ʈ
	public ArrayList<StoreVO> getStoreList(int startnum, int endnum) {
		Map<String, String> se = new HashMap<String, String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(endnum));
		
		List<StoreVO> list = sqlSession.selectList(namespace + ".store_list", se);
		return (ArrayList<StoreVO>) list;
	}
	
	//������ - ����� ��ǰ ��ü ����Ʈ
	public ArrayList<StoreVO> getStoreList(int startnum, int end, String search, String search_text) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(end));
		se.put("search", search);
		se.put("search_text", search_text);
		
		List<StoreVO> list = sqlSession.selectList(namespace+".store_search",se);
		return (ArrayList<StoreVO>) list;
	}
	
	//������ - ����� �� ����
	public int getStorePage(int pageNumber) {
		return sqlSession.selectOne(namespace+".store_count", pageNumber);
	}
	public int getStorePage(int pageNumber,String search,String search_text) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("pageNumber", String.valueOf(pageNumber));
		se.put("search", search);
		se.put("search_text", search_text);
		return sqlSession.selectOne(namespace+".store_searchpage", se);
	}
	
	
	
}
