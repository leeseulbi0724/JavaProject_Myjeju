package com.myjeju.dao;

import java.util.ArrayList;

import com.myjeju.vo.HouseVO;



public class HouseDAO extends DBConn {
	
	//Select --> 전체 리스트
	public ArrayList<HouseVO> getList(){
		ArrayList<HouseVO> list = new ArrayList<HouseVO>();
		String sql = " select jlatitude, jlongitude, jname, jaddr, jtel from myjeju_accomodationlist ";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HouseVO vo = new HouseVO();
				vo.setJlatitude(rs.getString(1));
				vo.setJlongitude(rs.getString(2));
				vo.setJname(rs.getString(3));
				vo.setJaddr(rs.getString(4));
				vo.setJtel(rs.getString(5));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
