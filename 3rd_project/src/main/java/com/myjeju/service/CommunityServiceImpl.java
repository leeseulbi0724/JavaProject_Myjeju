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

	//�����Խ��� �۾���
	@Override
	public boolean getFreeWrite(CommunityVO vo) {
		int val = communityDAO.getFreeWrite(vo);
		
		boolean result = false;
		
		if ( val!=0 ) {
			result = true;
		}
		return result;
	}
	//�����Խ��� �� ����
	@Override
	public int getFreeTotalCount() {
		return communityDAO.getFreeTotalCount();
	}
	//�����Խ��� ����Ʈ
	@Override
	public ArrayList<CommunityVO> getFreeList(int start, int end) {
		return communityDAO.getFreeList(start, end);
	}
	//�����Խ��� �󼼺���
	@Override
	public  CommunityVO getFreeContent(String fid) {
		return communityDAO.getFreeContent(fid);
	}
	//�����Խ��� ���
	@Override
	public boolean getCommentResult(CommunityVO vo) {
		int val = communityDAO.getCommentResult(vo);
		
		boolean result = false;
		
		if ( val != 0 ) {
			result = true;
		}
		
		return result;
	}
	//�����Խ��� ��� ��������
	@Override
	public ArrayList<CommunityVO> getFreeComment(String fid) {
		return communityDAO.getFreeComment(fid);
	}
	//�����Խ��� �����̸���������
	@Override
	public String getFileResult(String fid) {
		return communityDAO.getFileResult(fid);
	}
	//�����Խ��� ����o ������Ʈ
	@Override
	public  boolean getFileYesUpdate(CommunityVO vo) {
		int val = communityDAO.getFileYesUpdate(vo);
		
		boolean result = false;
		
		if ( val!= 0) {
			result = true;
		}
		
		return result;
	}
	//�����Խ��� ����x ������Ʈ
	@Override
	public  boolean getFileNoUpdate(CommunityVO vo) {
		int val = communityDAO.getFileNoUpdate(vo);
		
		boolean result = false;
		
		if ( val!= 0) {
			result = true;
		}
		
		return result;
	}
	//�����Խ��� ��ۻ���
	@Override
	public boolean getCommentDelete(String cid) {
		int val = communityDAO.getCommentDelete(cid);

		boolean result = false;
		
		if ( val != 0) {
			result = true;
		}
		
		return result;
	}
	//�����Խ��� ����
	@Override
	public boolean getFreeBoardDelete(String fid) {
		int val = communityDAO.getFreeBoardDelete(fid);

		boolean result = false;
		
		if ( val != 0) {
			result = true;
		}
		
		return result;
	}
	
	
	
	
	//��û�Խ��� �۾���
	@Override
	public boolean getRequestWrite(CommunityVO vo) {
		int val = communityDAO.getRequestWrite(vo);

		boolean result = false;
		
		if ( val != 0) {
			result = true;
		}
		
		return result;
	}
	//��û�Խ��� �� ����
	@Override
	public int getRequestTotalCount() {
		return communityDAO.getRequestTotalCount();
	}
	//��û�Խ��� ����Ʈ
	@Override
	public ArrayList<CommunityVO> getRequestList(int start, int end) {
		return communityDAO.getRequestList(start, end);
	}
	//��û�Խ��� ��й�ȣȮ��
	@Override
	public boolean getBoardPass(String rid, String pass) {
		int val = communityDAO.getBoardPass(rid, pass);

		boolean result = false;
		
		if ( val != 0) {
			result = true;
		}
		
		return result;
	}
	//��û�Խ��� �󼼺���
	@Override
	public  CommunityVO getRequestContent(String rid) {
		return communityDAO.getRequestContent(rid);
	}

}
