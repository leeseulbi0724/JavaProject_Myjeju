package com.myjeju.dao;

import java.util.ArrayList;

import com.myjeju.vo.AccomodationVO;



public class AccomodationDAO extends DBConn {
	
	//Select --> 전체 리스트
	public ArrayList<AccomodationVO> getList(){
		ArrayList<AccomodationVO> list = new ArrayList<AccomodationVO>();
		String sql = " select jlatitude, jlongitude, jtel from myjeju_accomodationlist ";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AccomodationVO vo = new AccomodationVO();
				vo.setJlatitude(rs.getString(1));
				vo.setJlongitude(rs.getString(2));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
