package com.myjeju.dao;

import java.util.ArrayList;

import com.myjeju.vo.StoreVO;

public class StoreDAO extends DBConn {

	//SELECT --> ��ü����Ʈ
	public ArrayList<StoreVO> getList() {
		ArrayList<StoreVO> list = new ArrayList<StoreVO>();
		String sql = " select * from myjeju_store ";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StoreVO vo = new StoreVO();
				vo.setSid(rs.getString(1));
				vo.setS_category(rs.getString(2));
				vo.setS_name(rs.getString(3));
				vo.setS_price(rs.getInt(4));
				vo.setS_image(rs.getString(5));
				vo.setS_sfile(rs.getString(6));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//SELECT.BEST --> BEST MENU (����Ʈ �޴� ���� ����)
	public ArrayList<StoreVO> getBestList() {
		ArrayList<StoreVO> list = new ArrayList<StoreVO>();
		String sql = " select sid, s_category, s_name, s_price, s_image, s_sfile, s_content, s_ssfile "
					+ " from myjeju_store where rownum <= 3 order by sid ";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StoreVO vo = new StoreVO();
				vo.setSid(rs.getString(1));
				vo.setS_category(rs.getString(2));
				vo.setS_name(rs.getString(3));
				vo.setS_price(rs.getInt(4));
				vo.setS_image(rs.getString(5));
				vo.setS_sfile(rs.getString(6));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//SELECT.EAT --> ī�װ�-��ǰ (���� ����)
	public ArrayList<StoreVO> getEatList() {
		ArrayList<StoreVO> list = new ArrayList<StoreVO>();
		String sql = " select sid, s_category, s_name, s_price, s_image, s_sfile, s_content, s_ssfile "
					+ " from myjeju_store where rownum <= 3 and s_category = '��ǰ' ";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StoreVO vo = new StoreVO();
				vo.setSid(rs.getString(1));
				vo.setS_category(rs.getString(2));
				vo.setS_name(rs.getString(3));
				vo.setS_price(rs.getInt(4));
				vo.setS_image(rs.getString(5));
				vo.setS_sfile(rs.getString(6));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//SELECT.SOUVE --> ī�װ�-���ǰ (���� ����)
	public ArrayList<StoreVO> getSouveList() {
		ArrayList<StoreVO> list = new ArrayList<StoreVO>();
		String sql = " select sid, s_category, s_name, s_price, s_image, s_sfile, s_content, s_ssfile "
					+ " from myjeju_store where rownum <= 3 and s_category = '���ǰ' ";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StoreVO vo = new StoreVO();
				vo.setSid(rs.getString(1));
				vo.setS_category(rs.getString(2));
				vo.setS_name(rs.getString(3));
				vo.setS_price(rs.getInt(4));
				vo.setS_image(rs.getString(5));
				vo.setS_sfile(rs.getString(6));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
		
	//SELECT.ETC --> ī�װ�-��ȭ (���� ����)
	public ArrayList<StoreVO> getEtcList() {
		ArrayList<StoreVO> list = new ArrayList<StoreVO>();
		String sql = " select sid, s_category, s_name, s_price, s_image, s_sfile, s_content, s_ssfile "
					+ " from myjeju_store where rownum <= 3 and s_category = '��ȭ' ";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StoreVO vo = new StoreVO();
				vo.setSid(rs.getString(1));
				vo.setS_category(rs.getString(2));
				vo.setS_name(rs.getString(3));
				vo.setS_price(rs.getInt(4));
				vo.setS_image(rs.getString(5));
				vo.setS_sfile(rs.getString(6));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
		
	
	//INSERT --> ����� ��ǰ ��� (�ϴ� ���� �̹�����)
	public boolean getInsertResult(StoreVO vo) {
		boolean result = false;
		String sql = " insert into myjeju_store values('s_'||sequ_myjeju_store.nextval, ?, ?, ?, ?, ?, ?, ?) ";	
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, vo.getS_category());
			pstmt.setString(2, vo.getS_name());
			pstmt.setInt(3, vo.getS_price());
			pstmt.setString(4, vo.getS_image());
			pstmt.setString(5, vo.getS_sfile());
			pstmt.setString(6, vo.getS_content());
			pstmt.setString(7, vo.getS_ssfile());
			
			int value = pstmt.executeUpdate();
			
			if(value != 0) result = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
		
	
}
