package com.myjeju.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.CommunityDAO;
import com.myjeju.vo.CommunityVO;

@Service("CommunityService")
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	private CommunityDAO communityDAO;

	@Override
	public boolean getFreeWrite(CommunityVO vo) {
		int val = communityDAO.getFreeWrite(vo);
		
		boolean result = false;
		
		if ( val!=0 ) {
			result = true;
		}
		return result;
	}
	
	@Override
	public int getFreeTotalCount() {
		return communityDAO.getFreeTotalCount();
	}
	
	@Override
	public ArrayList<CommunityVO> getFreeList(int start, int end) {
		return communityDAO.getFreeList(start, end);
	}
	
	@Override
	public  CommunityVO getFreeContent(String fid) {
		return communityDAO.getFreeContent(fid);
	}
	
	@Override
	public boolean getCommentResult(CommunityVO vo) {
		int val = communityDAO.getCommentResult(vo);
		
		boolean result = false;
		
		if ( val != 0 ) {
			result = true;
		}
		
		return result;
	}
	
	@Override
	public ArrayList<CommunityVO> getFreeComment(String fid) {
		return communityDAO.getFreeComment(fid);
	}
	
	@Override
	public String getFileResult(String fid) {
		return communityDAO.getFileResult(fid);
	}
	
	@Override
	public  boolean getFileYesUpdate(CommunityVO vo) {
		int val = communityDAO.getFileYesUpdate(vo);
		
		boolean result = false;
		
		if ( val!= 0) {
			result = true;
		}
		
		return result;
	}
	
	@Override
	public  boolean getFileNoUpdate(CommunityVO vo) {
		int val = communityDAO.getFileNoUpdate(vo);
		
		boolean result = false;
		
		if ( val!= 0) {
			result = true;
		}
		
		return result;
	}
	
	@Override
	public boolean getCommentDelete(String cid) {
		int val = communityDAO.getCommentDelete(cid);

		boolean result = false;
		
		if ( val != 0) {
			result = true;
		}
		
		return result;
	}
	
	@Override
	public boolean getFreeBoardDelete(String fid) {
		int val = communityDAO.getFreeBoardDelete(fid);

		boolean result = false;
		
		if ( val != 0) {
			result = true;
		}
		
		return result;
	}
}
