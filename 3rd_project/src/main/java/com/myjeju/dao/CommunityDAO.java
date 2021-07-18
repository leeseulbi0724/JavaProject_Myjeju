package com.myjeju.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.NoticeVO;

@Repository
public class CommunityDAO {
	

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static String namespace = "mapper.community";
	
	//�����Խ��� �۾���
	public int getFreeWrite(CommunityVO vo) {
		return sqlSession.insert(namespace+".free_write", vo);
	}
	
	//�����Խ��� �� �Խñ� ��
	public int getFreeTotalCount() {
		return sqlSession.selectOne(namespace+".free_total_count");
	}
	
	//�����Խ��� ����¡ ó��
	public ArrayList<CommunityVO> getFreeList(int start, int end){
		Map<String, String> param = new HashMap<String, String>();
		param.put("start", String.valueOf(start));
		param.put("end", String.valueOf(end));
		List<CommunityVO> list = sqlSession.selectList(namespace+".free_list", param);
		
		return (ArrayList<CommunityVO>)list;
	}	
	
	//�����Խ��� �ش� �� ���� ��������
	public CommunityVO getFreeContent(String fid) {
		return sqlSession.selectOne(namespace+".free_content", fid);
	}
	
	//�����Խ��� ��� �ޱ�
	public int getCommentResult(CommunityVO vo) {		
		return sqlSession.insert(namespace+".comment", vo);
	}
	
	//�����Խ��� ��� ��������
	public ArrayList<CommunityVO> getFreeComment(String fid) {
		List<CommunityVO> list = sqlSession.selectList(namespace+".free_comment", fid);
		
		return (ArrayList<CommunityVO>)list;
	}
	
	//������ ����� ���� ��������
	public String getFileResult(String fid) {
		return sqlSession.selectOne(namespace+".file_result", fid);
	}
	
	//�������� --> ������Ʈ
	public int getFileYesUpdate(CommunityVO vo) {
		return sqlSession.update(namespace+".yes_update", vo);
	}
	
	//���Ϲ����� --> ������Ʈ
	public int getFileNoUpdate(CommunityVO vo) {
		return sqlSession.update(namespace+".no_update", vo);
	}
	
	//�����Խ��� ��� �����ϱ�
	public int getCommentDelete(String cid) {
		return sqlSession.delete(namespace+".comment_delete", cid);
	}
	
	//�����Խ��� �Խñ� �����ϱ�
	public int getFreeBoardDelete(String fid) {
		return sqlSession.delete(namespace+".free_board_delete", fid);
	}
	
	//�����Խ��� ��ȸ��
	public int getHitUp(String fid) {
		return sqlSession.update(namespace+".hit", fid);
	}
	
	///////////////////////////////////////////////////////////////////////
	
	//��û�Խ��� �۾���
	public int getRequestWrite(CommunityVO vo) {
		return sqlSession.insert(namespace+".request_write", vo);
	}
	//��û�Խ��� �� �Խñ� ��
		public int getRequestTotalCount() {
			return sqlSession.selectOne(namespace+".request_total_count");
	}		
	//��û�Խ��� ����¡ ó��
	public ArrayList<CommunityVO> getRequestList(int start, int end){
		Map<String, String> param = new HashMap<String, String>();
		param.put("start", String.valueOf(start));
		param.put("end", String.valueOf(end));
		List<CommunityVO> list = sqlSession.selectList(namespace+".request_list", param);
		
		return (ArrayList<CommunityVO>)list;
	}	
	//��û�Խ��� ��й�ȣ Ȯ��
	public int getBoardPass(String rid, String pass){
		Map<String, String> param = new HashMap<String, String>();
		param.put("rid", rid);
		param.put("pass", pass);
		return sqlSession.selectOne(namespace+".board_pass", param);
	}	
	//��û�Խ��� �󼼺���
	public CommunityVO getRequestContent(String rid) {
		return sqlSession.selectOne(namespace+".request_content", rid);
	}
	
	//�������� ����Ʈ
	public ArrayList<NoticeVO> getNoticeList() {
		List<NoticeVO> list = sqlSession.selectList(namespace+".notice_list");		
		return (ArrayList<NoticeVO>)list;
	}
}
