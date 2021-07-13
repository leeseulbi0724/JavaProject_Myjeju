package com.myjeju.dao;

import java.util.ArrayList;

import com.myjeju.vo.FoodVO;


public class FoodDAO extends DBConn {
	
	//Select --> 전체 리스트
	public ArrayList<FoodVO> getList(){
		ArrayList<FoodVO> list = new ArrayList<FoodVO>();
		String sql = " select f_vpoint, f_hpoint, f_name, f_addr, f_hp , f_image1 from myjeju_food ";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FoodVO vo = new FoodVO();
				vo.setF_vpoint(rs.getString(1));
				vo.setF_hpoint(rs.getString(2));
				vo.setF_name(rs.getString(3));
				vo.setF_addr(rs.getString(4));
				vo.setF_hp(rs.getString(5));
				vo.setF_image1(rs.getString(6));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//음식점 전체 리스트
	public ArrayList<FoodVO> getFoodList(){
		ArrayList<FoodVO> list = new ArrayList<FoodVO>();
		String sql = "select fid, f_name, f_tag, f_infor, f_infor2, f_addr, f_vpoint, f_hpoint, f_hp, f_like,"
				   + " f_image1, f_image2, f_image3, f_image4, f_image5 from myjeju_food";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FoodVO vo = new FoodVO();
				vo.setFid(rs.getString(1));
				vo.setF_name(rs.getString(2));
				vo.setF_tag(rs.getString(3));
				vo.setF_infor(rs.getString(4));
				vo.setF_infor2(rs.getString(5));
				vo.setF_addr(rs.getString(6));
				vo.setF_vpoint(rs.getString(7));
				vo.setF_hpoint(rs.getString(8));
				vo.setF_hp(rs.getString(9));
				vo.setF_like(rs.getInt(10));
				vo.setF_image1(rs.getString(11));
				vo.setF_image2(rs.getString(12));
				vo.setF_image3(rs.getString(13));
				vo.setF_image4(rs.getString(14));
				vo.setF_image5(rs.getString(15));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//음식점 상위3
	public ArrayList<FoodVO> getFoodListTop3(){
		ArrayList<FoodVO> list = new ArrayList<FoodVO>();
		String sql = "select fid, f_name, f_tag, f_infor, f_like, f_image1 from myjeju_food where rownum <= 3 order by f_like desc";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FoodVO vo = new FoodVO();
				vo.setFid(rs.getString(1));
				vo.setF_name(rs.getString(2));
				vo.setF_tag(rs.getString(3));
				vo.setF_infor(rs.getString(4));
				vo.setF_like(rs.getInt(5));
				vo.setF_image1(rs.getString(6));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	//음식점 상세 정보
	public FoodVO getFoodDetail(String fid) {
		FoodVO vo = new FoodVO();
		String sql = " select fid, f_name, f_tag, f_infor, f_infor2, f_addr, f_hp, f_like,"
				   + " f_image1, f_image2, f_image3, f_image4, f_image5 from myjeju_food where fid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, fid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo.setFid(rs.getString(1));
				vo.setF_name(rs.getString(2));
				vo.setF_tag(rs.getString(3));
				vo.setF_infor(rs.getString(4));
				vo.setF_infor2(rs.getString(5));
				vo.setF_addr(rs.getString(6));
				vo.setF_hp(rs.getString(7));
				vo.setF_like(rs.getInt(8));
				vo.setF_image1(rs.getString(9));
				vo.setF_image2(rs.getString(10));
				vo.setF_image3(rs.getString(11));
				vo.setF_image4(rs.getString(12));
				vo.setF_image5(rs.getString(13));
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
}
