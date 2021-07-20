package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.CafeVO;

public interface CafeService {
	ArrayList<CafeVO> getList();
	ArrayList<CafeVO> getCafeList();
	ArrayList<CafeVO> getCafeList(int startnum, int endnum);
	ArrayList<CafeVO> getCafeList(int startnum, int end, String search, String search_text);
	ArrayList<CafeVO> getCafeListTop3();
	CafeVO getCafeDetail(String caid);
}
