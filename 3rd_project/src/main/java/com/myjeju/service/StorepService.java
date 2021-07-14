package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.StorepVO;

public interface StorepService {

	ArrayList<StorepVO> getContent(String sid);
	boolean getInsertResult(StorepVO vo);
}
