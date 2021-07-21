package com.myjeju.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.TravelDAO;
import com.myjeju.vo.CarSpotVO;
import com.myjeju.vo.HeartVO;
import com.myjeju.vo.PhotoSpotVO;
import com.myjeju.vo.ReviewVO;
import com.myjeju.vo.TravelVO;

@Service("travelService")
public class TravelServiceImpl implements TravelService{
	
	@Autowired
	private TravelDAO travelDAO;
	
	@Override
	public ArrayList<TravelVO> getList(){
		return travelDAO.getList();
	}
	
	@Override
	public ArrayList<TravelVO> getTravelList(){
		return travelDAO.getTravelList();
	}
	
	@Override
	public ArrayList<TravelVO> getTravelList(int startnum, int endnum){
		return travelDAO.getTravelList(startnum, endnum);
	}
	
	@Override
	public ArrayList<TravelVO> getTravelList(int startnum, int end, String search, String search_text){
		return travelDAO.getTravelList(startnum, end, search, search_text);
	}
	
	@Override
	public ArrayList<TravelVO> getTravelListTop3(){
		return travelDAO.getTravelListTop3();
	}
	
	@Override
	public TravelVO getTravelDetail(String tid) {
		return travelDAO.getTravelDetail(tid);
	}
	
	@Override
	public PhotoSpotVO getPhotoSpot(String tid) {
		return travelDAO.getPhotoSpot(tid);
	}

	@Override
	public CarSpotVO getCarSpot(String tid) {
		return travelDAO.getCarSpot(tid);
	}
	
	@Override
	public boolean getInsertResult(ReviewVO vo) {
		return travelDAO.getInsertResult(vo);
	}
	
	@Override
	public ArrayList<ReviewVO> getTravelReview(String tid){
		return travelDAO.getTravelReview(tid);
	}
	
	@Override
	public boolean getUpdateHeart(String tid) {
		int val = travelDAO.getUpdateHeart(tid);
		boolean result = false;
		if ( val!= 0) {
			result = true;
		}
		return result;
	}
	
	@Override
	public boolean getUpdateMinusHeart(String tid) {
		int val = travelDAO.getUpdateMinusHeart(tid);
		boolean result = false;
		if ( val!= 0) {
			result = true;
		}
		return result;
	}
	
	@Override
	public int getHeartInfoResult(HeartVO vo) {
		return travelDAO.getHeartInfoResult(vo);
	}
	
	@Override
	public boolean getHeartMinus(HeartVO vo) {
		int val = travelDAO.getHeartMinus(vo);
		boolean result = false;
		if ( val!= 0) {
			result = true;
		}
		return result;
	}
	
	@Override
	public boolean getHeartPlus(HeartVO vo) {
		int val = travelDAO.getHeartPlus(vo);
		boolean result = false;
		if ( val!= 0) {
			result = true;
		}
		return result;
	}
}
