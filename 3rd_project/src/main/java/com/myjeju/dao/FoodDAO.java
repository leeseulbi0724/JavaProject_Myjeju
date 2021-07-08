package com.myjeju.dao;

import java.util.ArrayList;

import com.myjeju.vo.FoodVO;


public class FoodDAO extends DBConn {
	
	//Select --> 전체 리스트
	public ArrayList<FoodVO> getList(){
		ArrayList<FoodVO> list = new ArrayList<FoodVO>();
		String sql = " select f_vpoint, f_hpoint, f_name, f_addr, f_hp from myjeju_food ";
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
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
