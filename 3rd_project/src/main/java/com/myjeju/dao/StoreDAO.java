package com.myjeju.dao;

import java.util.ArrayList;

import com.myjeju.vo.StoreVO;

public class StoreDAO extends DBConn {

	//SELECT --> 전체리스트
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
	
	//SELECT.BEST --> BEST MENU (베스트 메뉴 상위 세개) [메인화면]
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
	
	//SELECT.EAT --> 카테고리-식품 (상위 세개) [메인화면]
	public ArrayList<StoreVO> getEatList() {
		ArrayList<StoreVO> list = new ArrayList<StoreVO>();
		String sql = " select sid, s_category, s_name, s_price, s_image, s_sfile, s_content, s_ssfile "
					+ " from myjeju_store where rownum <= 3 and s_category = '식품' ";
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
	
	//SELECT.SOUVE --> 카테고리-기념품 (상위 세개) [메인화면]
	public ArrayList<StoreVO> getSouveList() {
		ArrayList<StoreVO> list = new ArrayList<StoreVO>();
		String sql = " select sid, s_category, s_name, s_price, s_image, s_sfile, s_content, s_ssfile "
					+ " from myjeju_store where rownum <= 3 and s_category = '기념품' ";
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
		
	//SELECT.ETC --> 카테고리-잡화 (상위 세개) [메인화면]
	public ArrayList<StoreVO> getEtcList() {
		ArrayList<StoreVO> list = new ArrayList<StoreVO>();
		String sql = " select sid, s_category, s_name, s_price, s_image, s_sfile, s_content, s_ssfile "
					+ " from myjeju_store where rownum <= 3 and s_category = '잡화' ";
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
	
	//SELECT.ETC --> 카테고리-잡화 (상위 세개) [메인화면]
		public ArrayList<StoreVO> getEtcList2() {
			ArrayList<StoreVO> list = new ArrayList<StoreVO>();
			String sql = " select sid, s_category, s_name, s_price, s_image, s_sfile, s_content, s_ssfile "
						+ " from myjeju_store where s_category = '잡화' ";
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
		
	
	//INSERT --> 스토어 상품 등록 (일단 메인 이미지만)
	public boolean getInsertResult(StoreVO vo) {
		boolean result = false;
		String sql = " insert into myjeju_store values('s_'||sequ_myjeju_store.nextval, ?, ?, ?, ?, ?, ?, ?) ";	
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, vo.getS_category());
			pstmt.setString(2, vo.getS_name());
			pstmt.setInt(3, vo.getS_price());
			pstmt.setString(4, vo.getS_image());
			pstmt.setString(5, vo.getS_content());
			pstmt.setString(6, vo.getS_sfile());
			pstmt.setString(7, vo.getS_ssfile());
			
			int value = pstmt.executeUpdate();
			
			if(value != 0) result = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	//SELECT --> 스토어 상품 상세 화면
	public StoreVO getContent(String sid) {
		StoreVO vo = new StoreVO();
		
		String sql = " select sid, s_category, s_name, s_price, s_image, s_content, s_sfile, s_ssfile "
					+ " from myjeju_store where sid = ? ";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);	// 첫번째 물음표, 데이터는 bid
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setSid(rs.getString(1));
				vo.setS_category(rs.getString(2));
				vo.setS_name(rs.getString(3));
				vo.setS_price(rs.getInt(4));
				vo.setS_image(rs.getString(5));
				vo.setS_content(rs.getString(6));
				vo.setS_sfile(rs.getString(7));
				vo.setS_ssfile(rs.getString(8));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
		
	
}
