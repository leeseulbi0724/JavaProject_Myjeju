package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.CommunityVO;

public interface CommunityService {
	
	//�����Խ���
	boolean getFreeWrite(CommunityVO vo);
	int getFreeTotalCount();
	ArrayList<CommunityVO> getFreeList(int start, int end);
	CommunityVO getFreeContent(String fid);
	boolean getCommentResult(CommunityVO vo);
	ArrayList<CommunityVO> getFreeComment(String fid);
	String getFileResult(String fid);
	boolean getFileYesUpdate(CommunityVO vo);
	boolean getFileNoUpdate(CommunityVO vo);
	boolean getCommentDelete(String cid);
	boolean getFreeBoardDelete(String fid);
	 int getHitUp(String fid);
	
	
	
	//��û�Խ���
	boolean getRequestWrite(CommunityVO vo);
	int getRequestTotalCount();
	ArrayList<CommunityVO> getRequestList(int start, int end);
	boolean getBoardPass(String rid, String pass);
	CommunityVO getRequestContent(String rid);

}
