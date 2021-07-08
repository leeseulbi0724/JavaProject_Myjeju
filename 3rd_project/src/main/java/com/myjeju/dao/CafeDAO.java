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
}
