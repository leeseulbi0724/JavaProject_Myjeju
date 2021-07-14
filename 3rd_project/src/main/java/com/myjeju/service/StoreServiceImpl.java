package com.myjeju.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.StoreDAO;
import com.myjeju.vo.StoreVO;

@Service("storeService")
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreDAO storeDAO;
	
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

	
	
}
