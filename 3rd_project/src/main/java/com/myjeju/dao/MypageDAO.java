package com.myjeju.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.MReservationVO;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.OrderVO;
import com.myjeju.vo.PointVO;

@Repository
public class MypageDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "mapper.mypage";
	private static String namespace2 = "mapper.member";
	
	/** 패스워드 체크 **/
	public int getPassCheckResult(MemberVO vo) {
		return sqlSession.selectOne(namespace+".pass_check", vo);
	}
	
	/** 아이디로 회원정보 가져오기 **/
	public MemberVO getMemberContent(String id) {
		return sqlSession.selectOne(namespace+".content", id);
	}
	
	/** 회원정보 수정하기 **/
	public int getInfoUpdate(MemberVO vo) {
		return sqlSession.update(namespace+".info_update", vo);
	}
	
	/** 회원탈퇴 **/
	public int getInfoOut(String id) {
		return sqlSession.delete(namespace+".info_out", id);
	}
	
	/** 자유게시판 게시글 불러오기 **/
	public ArrayList<CommunityVO> getFreeBoardResult(String id) {
		List<CommunityVO> list = sqlSession.selectList(namespace+".user_free_list",id);		
		return (ArrayList<CommunityVO>)list;
	}
	
	/** 자유게시판 게시글 불러오기 **/
	public ArrayList<CommunityVO> getRequestBoardResult(String id) {
		List<CommunityVO> list = sqlSession.selectList(namespace+".user_request_list",id);		
		return (ArrayList<CommunityVO>)list;
	}
	
	/** 자유게시판 댓글 불러오기 **/
	public ArrayList<CommunityVO> getCommentResult(String id) {
		List<CommunityVO> list = sqlSession.selectList(namespace+".user_comment_list",id);		
		return (ArrayList<CommunityVO>)list;
	}
	
	/** 포인트 **/
	public int getPoint(String id) {
		return sqlSession.selectOne(namespace2+".point", id);
	}
	
	/** 주문내역 가져오기 **/
	public ArrayList<OrderVO> getOrderList(String id) {
		List<OrderVO> list = sqlSession.selectList(namespace+".order_list",id);		
		return (ArrayList<OrderVO>)list;
	}
	
	/** 포인트 내역 **/
	public ArrayList<PointVO> getPointList(String id) {
		List<PointVO> list = sqlSession.selectList(namespace+".point_list",id);		
		return (ArrayList<PointVO>)list;
	}
	
	/** 숙소예약내역 - 시퀀테이블 **/
	public ArrayList<OrderVO> getMReservation(String id) {
		List<OrderVO> list = sqlSession.selectList(namespace+".mreservation_list",id);		
		return (ArrayList<OrderVO>)list;
	}
	
	/** 숙소이름 + 이미지 가져오기 **/
	public OrderVO getHouseName(String hid) {
		return sqlSession.selectOne(namespace+".housename", hid);
	}
	
	/**방이름 가져오기 **/
	public OrderVO getRommName(String hdid) {
		return sqlSession.selectOne(namespace+".roomname", hdid);
	}
	
	
}
