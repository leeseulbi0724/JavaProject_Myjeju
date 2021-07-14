package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.CommunityVO;

public interface CommunityService {
	
	boolean getFreeWrite(CommunityVO vo);
	int getFreeTotalCount();
	ArrayList<CommunityVO> getFreeList(int start, int end);
	CommunityVO getFreeContent(String fid);

}
