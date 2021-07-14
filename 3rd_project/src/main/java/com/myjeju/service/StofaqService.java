package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.StofaqVO;

public interface StofaqService {

	ArrayList<StofaqVO> getContent(String sid);
	boolean getInsertResult(StofaqVO vo);
	StofaqVO getStid(String sid);
	
}
