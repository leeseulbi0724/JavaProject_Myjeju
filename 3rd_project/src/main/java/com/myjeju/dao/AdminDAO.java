package com.myjeju.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.FoodVO;
import com.myjeju.vo.HDetailVO;
import com.myjeju.vo.HouseVO;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.NoticeVO;
import com.myjeju.vo.StoreVO;
import com.myjeju.vo.TravelVO;

@Repository
public class AdminDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "mapper.admin";
	
	//멤버 리스트 가져오기
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
		return sqlSession.selectOne(namespace+".searchtarget1", se);
	}
	//숙소 리스트 가져오기
	public ArrayList<HouseVO> getlisthouse(int startnum, int endnum) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(endnum));
		
		List<HouseVO> list = sqlSession.selectList(namespace+".listnumhouse",se);
		return (ArrayList<HouseVO>)list;
	}
	public ArrayList<HouseVO> getlisthouse(int startnum, int end, String search, String search_text) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(end));
		se.put("search", search);
		se.put("search_text", search_text);
		
		List<HouseVO> list = sqlSession.selectList(namespace+".listsearchhouse",se);
		return (ArrayList<HouseVO>)list;
	}
	public int targethousePage(int pageNumber) {
		return sqlSession.selectOne(namespace+".targethouse", pageNumber);
	}
	public int targethousePage(int pageNumber,String search,String search_text) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("pageNumber", String.valueOf(pageNumber));
		se.put("search", search);
		se.put("search_text", search_text);
		return sqlSession.selectOne(namespace+".searchtargethouse", se);
	}
	public HouseVO gethouse(String hid) {
		return sqlSession.selectOne(namespace+".gethouse", hid);
	}
	//숙소 객실 리스트 가져오기
	public ArrayList<HDetailVO> gethousede(String hid) {
		List<HDetailVO> list = sqlSession.selectList(namespace+".listdehouse",hid);
		return (ArrayList<HDetailVO>)list;
	}
	public HDetailVO gethousedecontent(String hdid) {
		return sqlSession.selectOne(namespace+".getdehousecontent", hdid);
	}
	//숙소 -- 객실추가
	public int getHdetailUpload(HDetailVO vo) {
		return sqlSession.insert(namespace+".hdetail_upload", vo);
	}
	
	//맛집 리스트 가져오기
	public ArrayList<FoodVO> getlistfood(int startnum, int endnum) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(endnum));
		
		List<FoodVO> list = sqlSession.selectList(namespace+".listnumfood",se);
		return (ArrayList<FoodVO>)list;
	}
	public ArrayList<FoodVO> getlistfood(int startnum, int end, String search, String search_text) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(end));
		se.put("search", search);
		se.put("search_text", search_text);
		
		List<FoodVO> list = sqlSession.selectList(namespace+".listsearchfood",se);
		return (ArrayList<FoodVO>)list;
	}
	public int targetfoodPage(int pageNumber) {
		return sqlSession.selectOne(namespace+".targetfood", pageNumber);
	}
	public int targetfoodPage(int pageNumber,String search,String search_text) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("pageNumber", String.valueOf(pageNumber));
		se.put("search", search);
		se.put("search_text", search_text);
		return sqlSession.selectOne(namespace+".searchtargetfood", se);
	}
	//여행지 리스트 가져오기
	public ArrayList<TravelVO> getlisttravel(int startnum, int endnum) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(endnum));
		
		List<TravelVO> list = sqlSession.selectList(namespace+".listnumtravel",se);
		return (ArrayList<TravelVO>)list;
	}
	public ArrayList<TravelVO> getlisttravel(int startnum, int end, String search, String search_text) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(end));
		se.put("search", search);
		se.put("search_text", search_text);
		
		List<TravelVO> list = sqlSession.selectList(namespace+".listsearchtravel",se);
		return (ArrayList<TravelVO>)list;
	}
	public int targettravelPage(int pageNumber) {
		return sqlSession.selectOne(namespace+".targettravel", pageNumber);
	}
	public int targettravelPage(int pageNumber,String search,String search_text) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("pageNumber", String.valueOf(pageNumber));
		se.put("search", search);
		se.put("search_text", search_text);
		return sqlSession.selectOne(namespace+".searchtargettravel", se);
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
	
	//관리자 공지사항 글쓰기
	public int getNoticeWrite(NoticeVO vo) {
		return sqlSession.insert(namespace+".notice_write", vo);
	}
	//관리자 리스트
	public ArrayList<NoticeVO> getNoticeList(int startnum, int endnum) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(endnum));
		
		List<NoticeVO> list = sqlSession.selectList(namespace+".notice_list",se);
		return (ArrayList<NoticeVO>)list;
	}
	//공지사항 총 갯수
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
	//공지사항 상세보기
	public NoticeVO getNoticeContent(String nid) {
		return sqlSession.selectOne(namespace+".notice_content", nid);
	}
	//파일포함 --> 업데이트
	public int getFileYesUpdate(NoticeVO vo) {
		return sqlSession.update(namespace+".yes_update", vo);
	}	
	//파일미포함 --> 업데이트
	public int getFileNoUpdate(NoticeVO vo) {
		return sqlSession.update(namespace+".no_update", vo);
	}
	//공지사항 이미지 찾기
	public String getOldFile(String nid) {
		return sqlSession.selectOne(namespace+".oldfile", nid);
	}
	//공지사항 삭제
	public int getNoticeDelete(String nid) {
		return sqlSession.delete(namespace+".notice_delete", nid);
	}
	
	//관리자 요청 리스트
	public ArrayList<CommunityVO> getRequestList(int startnum, int endnum) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(endnum));
		
		List<CommunityVO> list = sqlSession.selectList(namespace+".request_list",se);
		return (ArrayList<CommunityVO>)list;
	}
	//요청 총 갯수
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
	//상세보기
	public CommunityVO getRequestContent(String rid) {
		return sqlSession.selectOne(namespace+".request_content", rid);
	}
	//댓글달기
	public int getRequestComment(CommunityVO vo) {
		return sqlSession.insert(namespace+".request_comment", vo);
	}
	//답변내용 가져오기
	public CommunityVO getRequestCommentResult(String rid) {
		return sqlSession.selectOne(namespace+".request_comment_result", rid);
	}
	//삭제하기
	public int getRequestDelete(String rid) {
		return sqlSession.delete(namespace+".request_delete", rid);
	}
	
	
	//관리자 스토어
	//관리자 - 스토어 상품 전체 리스트
	public ArrayList<StoreVO> getStoreList(int startnum, int endnum) {
		Map<String, String> se = new HashMap<String, String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(endnum));
		
		List<StoreVO> list = sqlSession.selectList(namespace + ".store_list", se);
		return (ArrayList<StoreVO>) list;
	}
	
	//관리자 - 스토어 상품 전체 리스트
	public ArrayList<StoreVO> getStoreList(int startnum, int end, String search, String search_text) {
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", String.valueOf(startnum));
		se.put("end", String.valueOf(end));
		se.put("search", search);
		se.put("search_text", search_text);
		
		List<StoreVO> list = sqlSession.selectList(namespace+".store_search",se);
		return (ArrayList<StoreVO>) list;
	}
	
	//관리자 - 스토어 총 개수
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
	
	//SELECT --> 스토어 상품 상세 화면
	public StoreVO getStoreContent(String sid) {
		return sqlSession.selectOne(namespace + ".store_content", sid);
	}
	
	//관리자 - 스토어 UPDATE 파일 포함
	public int getStoreUpdateFile(StoreVO vo) {
		return sqlSession.update(namespace + ".store_update_file", vo);
	}	
	
	//관리자 - 스토어 UPDATE 파일 미 포함
	public int getStoreUpdateNoFile(StoreVO vo) {
		return sqlSession.update(namespace + ".store_update_no_file", vo);
	}
	
	//관리자 - 스토어 오래된 이미지 찾기
	public String getStoreOldFile(String sid) {
		return sqlSession.selectOne(namespace+".store_oldfile", sid);
	}
	
	//INSERT --> 스토어 상품 등록
	public boolean getStoreInsertResult(StoreVO vo) {
		boolean result = false;
		int value = sqlSession.insert(namespace + ".storeInsert", vo);
		if(value != 0) result = true;
		return result;
	}
	
	//스토어 상품 삭제
	public boolean getStoreDelete(String sid) {
		boolean result = false;
		int value = sqlSession.delete(namespace+".store_delete", sid);
		if(value != 0) result = true;
		return result;
	}
	
	
	


}
