package com.myjeju.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.StorepDAO;
import com.myjeju.vo.StorepVO;

@Service("storepService")
public class StorepServiceImpl implements StorepService{
	
	@Autowired
	private StorepDAO storepDAO;
	
	@Override
	public ArrayList<StorepVO> getContent(String sid) {
		return storepDAO.getContent(sid);
	}

	@Override
	public boolean getInsertResult(StorepVO vo) {
		return storepDAO.getInsertResult(vo);
	}

	
	
}
