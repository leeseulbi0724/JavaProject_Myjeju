package com.myjeju.dao;

import java.util.ArrayList;

import com.myjeju.vo.TravelVO;


public class TravelDAO extends DBConn {

	//Select --> 전체 리스트
		public ArrayList<TravelVO> getList(){
			ArrayList<TravelVO> list = new ArrayList<TravelVO>();
			String sql = " select t_vpoint, t_hpoint, t_name, t_addr, t_hp, t_tfile from myjeju_travel ";
			getPreparedStatement(sql);
			
			try {
				rs = pstmt.executeQuery();
				while(rs.next()) {
					TravelVO vo = new TravelVO();
					vo.setT_vpoint(rs.getString(1));
					vo.setT_hpoint(rs.getString(2));
					vo.setT_name(rs.getString(3));
					vo.setT_addr(rs.getString(4));
					vo.setT_hp(rs.getString(5));
					vo.setT_tfile(rs.getString(6));
					list.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
}
