package com.myjeju.dao;

import java.util.ArrayList;

import com.myjeju.vo.CafeVO;


public class CafeDAO extends DBConn {
	
	//Select --> 전체 리스트
	public ArrayList<CafeVO> getList(){
		ArrayList<CafeVO> list = new ArrayList<CafeVO>();
		String sql = " select ca_vpoint, ca_hpoint, ca_name, ca_addr, ca_hp from myjeju_cafe ";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CafeVO vo = new CafeVO();
				vo.setCa_vpoint(rs.getString(1));
				vo.setCa_hpoint(rs.getString(2));
				vo.setCa_name(rs.getString(3));
				vo.setCa_addr(rs.getString(4));
				vo.setCa_hp(rs.getString(5));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//카페 전체 리스트
	public ArrayList<CafeVO> getCafeList(){
		ArrayList<CafeVO> list = new ArrayList<CafeVO>();
		String sql = " select caid, ca_name, ca_tag, ca_infor, ca_infor2, ca_addr, ca_vpoint, ca_hpoint, ca_hp, ca_like,"
				   + " ca_image1, ca_image2, ca_image3, ca_image4, ca_image5 from myjeju_cafe";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CafeVO vo = new CafeVO();
				vo.setCaid(rs.getString(1));
				vo.setCa_name(rs.getString(2));
				vo.setCa_tag(rs.getString(3));
				vo.setCa_infor(rs.getString(4));
				vo.setCa_infor2(rs.getString(5));
				vo.setCa_addr(rs.getString(6));
				vo.setCa_vpoint(rs.getString(7));
				vo.setCa_hpoint(rs.getString(8));
				vo.setCa_hp(rs.getString(9));
				vo.setCa_like(rs.getInt(10));
				vo.setCa_image1(rs.getString(11));
				vo.setCa_image2(rs.getString(12));
				vo.setCa_image3(rs.getString(13));
				vo.setCa_image4(rs.getString(14));
				vo.setCa_image5(rs.getString(15));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//카페 상위3
	public ArrayList<CafeVO> getCafeListTop3(){
		ArrayList<CafeVO> list = new ArrayList<CafeVO>();
		String sql = "select caid, ca_name, ca_tag, ca_infor, ca_like, ca_image1 from myjeju_cafe where rownum <= 3 order by ca_like desc";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CafeVO vo = new CafeVO();
				vo.setCaid(rs.getString(1));
				vo.setCa_name(rs.getString(2));
				vo.setCa_tag(rs.getString(3));
				vo.setCa_infor(rs.getString(4));
				vo.setCa_like(rs.getInt(5));
				vo.setCa_image1(rs.getString(6));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	//카페 상세 정보
	public CafeVO getCafeDetail(String caid) {
		CafeVO vo = new CafeVO();
		String sql = " select caid, ca_name, ca_tag, ca_infor, ca_infor2, ca_addr, ca_hp, ca_like,"
				   + " ca_image1, ca_image2, ca_image3, ca_image4, ca_image5 from myjeju_cafe where caid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, caid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo.setCaid(rs.getString(1));
				vo.setCa_name(rs.getString(2));
				vo.setCa_tag(rs.getString(3));
				vo.setCa_infor(rs.getString(4));
				vo.setCa_infor2(rs.getString(5));
				vo.setCa_addr(rs.getString(6));
				vo.setCa_hp(rs.getString(7));
				vo.setCa_like(rs.getInt(8));
				vo.setCa_image1(rs.getString(9));
				vo.setCa_image2(rs.getString(10));
				vo.setCa_image3(rs.getString(11));
				vo.setCa_image4(rs.getString(12));
				vo.setCa_image5(rs.getString(13));
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
}
