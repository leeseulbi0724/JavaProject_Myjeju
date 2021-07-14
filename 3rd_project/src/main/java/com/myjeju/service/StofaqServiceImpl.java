package com.myjeju.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.StofaqDAO;
import com.myjeju.vo.StofaqVO;

@Service("stofaqService")
public class StofaqServiceImpl implements StofaqService {

	@Autowired
	private StofaqDAO stofaqDAO;
	
	@Override
	public ArrayList<StofaqVO> getContent(String sid) {
		return stofaqDAO.getContent(sid);
	}

	@Override
	public boolean getInsertResult(StofaqVO vo) {
		return stofaqDAO.getInsertResult(vo);
	}

	@Override
	public StofaqVO getStid(String sid) {
		return stofaqDAO.getStid(sid);
	}

	
	
}
