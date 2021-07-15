package com.myjeju.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.BasketDAO;
import com.myjeju.dao.MypageDAO;
import com.myjeju.vo.BasketVO;
import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.StoreVO;

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

	//��ٱ��� ����
	@Override
	public boolean getInsertResult(BasketVO vo) {
		return basketDAO.getInsertResult(vo);
	}

	@Override
	public ArrayList<BasketVO> getSid(String id) {
		return basketDAO.getSid(id);
	}

	@Override
	public BasketVO getSid2(String id) {
		return basketDAO.getSid2(id);
	}

	@Override
	public ArrayList<StoreVO> getBcontent(String sid) {
		return basketDAO.getBcontent(sid);
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
	
	
	
	
	

}
