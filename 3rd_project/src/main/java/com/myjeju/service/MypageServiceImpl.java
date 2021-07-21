package com.myjeju.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.BasketDAO;
import com.myjeju.dao.MypageDAO;
import com.myjeju.vo.BasketVO;
import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.OrderVO;
import com.myjeju.vo.PointVO;
import com.myjeju.vo.StorevVO;
import com.myjeju.vo.TravelReviewVO;

@Service("MypageService")
public class MypageServiceImpl implements MypageService {
	@Autowired
	private MypageDAO mypageDAO;
	
	@Autowired
	private BasketDAO basketDAO;
	
	
	@Override
	public int getPassCheckResult(MemberVO vo) {
		return mypageDAO.getPassCheckResult(vo);
	}
	
	@Override
	public MemberVO getMemberContent(String id) {
		return mypageDAO.getMemberContent(id);
	}
	
	@Override
	public boolean getInfoUpdate(MemberVO vo) {
		int value = mypageDAO.getInfoUpdate(vo);
		boolean result = false;
		if ( value != 0 ) {
			result = true;
		}
		return result;
	}
	
	@Override
	public boolean getInfoOut(String id) {
		int value = mypageDAO.getInfoOut(id);
		boolean result = false;
		if ( value != 0 ) {
			result = true;
		}
		return result;
	}
	
	@Override
	public int getPoint(String id) {
		return mypageDAO.getPoint(id);
	}

	//장바구니 연동
	@Override
	public boolean getInsertResult(BasketVO vo) {
		return basketDAO.getInsertResult(vo);
	}

	@Override
	public ArrayList<BasketVO> getBasketContent(String id) {
		return basketDAO.getBasketContent(id);
	}

	@Override
	public BasketVO getSid2(String id) {
		return basketDAO.getSid2(id);
	}
	
	@Override
	public boolean getAlready(BasketVO vo) {
		int val = basketDAO.getAlready(vo);
		boolean result = false;
		if ( val == 0 ) {
			result = true;
		}
		return result;
	}
	
	@Override
	public boolean getAlreadyCount(BasketVO vo) {
		int val = basketDAO.getAlreadyCount(vo);
		boolean result = false;
		if ( val != 0 ) {
			result = true;
		}
		return result;
	}
		
	@Override
	public  boolean getBasketDelete(String sid) {
		int val = basketDAO.getBasketDelete(sid);
		boolean result = false;
		if ( val != 0 ) {
			result = true;
		}
		return result;
	}
	
	@Override
	public int getColumn(String id) {
		return basketDAO.getColumn(id);
	}


	
	@Override
	public ArrayList<CommunityVO> getFreeBoardResult(String id) {
		return mypageDAO.getFreeBoardResult(id);
	}
	
	@Override
	public ArrayList<CommunityVO> getRequestBoardResult(String id) {
		return mypageDAO.getRequestBoardResult(id);
	}
	
	@Override
	public ArrayList<CommunityVO> getCommentResult(String id) {
		return mypageDAO.getCommentResult(id);
	}
	
	
	
	@Override
	public ArrayList<OrderVO> getOrderList(String id) {
		return mypageDAO.getOrderList(id);
	}
	
	@Override
	public  ArrayList<PointVO> getPointList(String id) {
		return mypageDAO.getPointList(id);
	}
	
	
	@Override
	public  ArrayList<OrderVO> getMReservation(String id) {
		return mypageDAO.getMReservation(id);
	}
	
	@Override
	public OrderVO getHouseName(String hid) {
		return mypageDAO.getHouseName(hid);
	}
	
	@Override
	public OrderVO getRommName(String hdid) {
		return mypageDAO.getRommName(hdid);
	}
	
	@Override
	public boolean getOrderSequ(BasketVO vo) {
		int val = mypageDAO.getOrderSequ(vo);
		boolean result = false;
		if ( val!=0) {
			result = true;
		}
		return result;
	}

	@Override
	public ArrayList<StorevVO> getStoreReview(String id) {
		return mypageDAO.getStoreReview(id);
	}

	@Override
	public ArrayList<TravelReviewVO> getTravelReview(String id) {
		return mypageDAO.getTravelReview(id);
	}
	
	
	
	
	

}
