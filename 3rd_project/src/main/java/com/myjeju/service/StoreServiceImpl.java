package com.myjeju.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.BasketDAO;
import com.myjeju.dao.StoreDAO;
import com.myjeju.dao.StorevDAO;
import com.myjeju.vo.BasketVO;
import com.myjeju.vo.StoreVO;
import com.myjeju.vo.StorevVO;

@Service("storeService")
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreDAO storeDAO;
	
	@Autowired
	private StorevDAO storevDAO;
	
	@Autowired
	private BasketDAO BasketDAO;
	
	@Override
	public ArrayList<StoreVO> getBestList() {
		return storeDAO.getBestList();
	}

	@Override
	public ArrayList<StoreVO> getEatList() {
		return storeDAO.getEatList();
	}

	@Override
	public ArrayList<StoreVO> getEatList2() {
		return storeDAO.getEatList2();
	}

	@Override
	public ArrayList<StoreVO> getSouveList() {
		return storeDAO.getSouveList();
	}

	@Override
	public ArrayList<StoreVO> getSouveList2() {
		return storeDAO.getSouveList2();
	}

	@Override
	public ArrayList<StoreVO> getEtcList() {
		return storeDAO.getEtcList();
	}

	@Override
	public ArrayList<StoreVO> getEtcList2() {
		return storeDAO.getEtcList2();
	}

	@Override
	public boolean getInsertResult(StoreVO vo) {
		return storeDAO.getInsertResult(vo);
	}

	@Override
	public StoreVO getContent(String sid) {
		return storeDAO.getContent(sid);
	}
	
	@Override
	public ArrayList<List<BasketVO>> getBuyContent(String[] list, String id) {
		return BasketDAO.getBuyContent(list, id);
	}
	
	@Override
	public ArrayList<BasketVO> getBuyContent(String sid, String id) {
		return BasketDAO.getBuyContent(sid, id);
	}

	
	//ªÛ«∞∆Ú
	@Override
	public boolean getInsertResult(StorevVO vo) {
		return storevDAO.getInsertResult(vo);
	}

	@Override
	public ArrayList<StorevVO> getStoreReview(String sid) {
		return storevDAO.getStoreReview(sid);
	}

	@Override
	public boolean getReviewDelete(String srid) {
		int value = storevDAO.getReviewDelete(srid);
		
		boolean result = false;
		if(value != 0) result = true;
		
		return result;
	}

	/*
	 * @Override public StorevVO getStoreReviewOne(String srid) { return
	 * storevDAO.getStoreReviewOne(srid); }
	 * 
	 * @Override public boolean getStoreReviewUpdate(StorevVO vo) { return
	 * storevDAO.getStoreReviewUpdate(vo); }
	 */
	
	
}
