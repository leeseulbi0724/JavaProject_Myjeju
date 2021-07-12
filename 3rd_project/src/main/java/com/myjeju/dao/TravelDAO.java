package com.myjeju.dao;

import java.util.ArrayList;

import com.myjeju.vo.TravelVO;


public class TravelDAO extends DBConn {

	//Select --> 전체 리스트
		public ArrayList<TravelVO> getList(){
			ArrayList<TravelVO> list = new ArrayList<TravelVO>();
			String sql = " select t_vpoint, t_hpoint, t_name, t_addr, t_hp, t_image1 from myjeju_travel ";
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
					vo.setT_image1(rs.getString(6));
					list.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
		
		//여행지 전체 리스트
		public ArrayList<TravelVO> getTravelList(){
			ArrayList<TravelVO> list = new ArrayList<TravelVO>();
			String sql = "select tid, t_name, t_tag, t_infor, t_infor2, t_addr, t_vpoint, t_hpoint, t_hp, t_like,"
					   + " t_image1, t_image2, t_image3, t_image4, t_image5 from myjeju_travel";
			getPreparedStatement(sql);
			
			try {
				rs = pstmt.executeQuery();
				while(rs.next()) {
					TravelVO vo = new TravelVO();
					vo.setTid(rs.getString(1));
					vo.setT_name(rs.getString(2));
					vo.setT_tag(rs.getString(3));
					vo.setT_infor(rs.getString(4));
					vo.setT_infor2(rs.getString(5));
					vo.setT_addr(rs.getString(6));
					vo.setT_vpoint(rs.getString(7));
					vo.setT_hpoint(rs.getString(8));
					vo.setT_hp(rs.getString(9));
					vo.setT_like(rs.getInt(10));
					vo.setT_image1(rs.getString(11));
					vo.setT_image2(rs.getString(12));
					vo.setT_image3(rs.getString(13));
					vo.setT_image4(rs.getString(14));
					vo.setT_image5(rs.getString(15));
					list.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
		
		//여행지 상위3
		public ArrayList<TravelVO> getTravelListTop3(){
			ArrayList<TravelVO> list = new ArrayList<TravelVO>();
			String sql = "select tid, t_name, t_tag, t_infor, t_like, t_image1 from myjeju_travel where rownum <= 3 order by t_like";
			getPreparedStatement(sql);
			
			try {
				rs = pstmt.executeQuery();
				while(rs.next()) {
					TravelVO vo = new TravelVO();
					vo.setTid(rs.getString(1));
					vo.setT_name(rs.getString(2));
					vo.setT_tag(rs.getString(3));
					vo.setT_infor(rs.getString(4));
					vo.setT_like(rs.getInt(5));
					vo.setT_image1(rs.getString(6));
					list.add(vo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
		//여행지 상세 정보
		public TravelVO getTravelDetail(String tid) {
			TravelVO vo = new TravelVO();
			String sql = "select tid, t_name, t_tag, t_infor, t_infor2, t_addr, t_hp, t_like,"
					   + " t_image1, t_image2, t_image3, t_image4, t_image5 from myjeju_travel where tid=?";
			getPreparedStatement(sql);
			
			try {
				pstmt.setString(1, tid);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					vo.setTid(rs.getString(1));
					vo.setT_name(rs.getString(2));
					vo.setT_tag(rs.getString(3));
					vo.setT_infor(rs.getString(4));
					vo.setT_infor2(rs.getString(5));
					vo.setT_addr(rs.getString(6));
					vo.setT_hp(rs.getString(7));
					vo.setT_like(rs.getInt(8));
					vo.setT_image1(rs.getString(9));
					vo.setT_image2(rs.getString(10));
					vo.setT_image3(rs.getString(11));
					vo.setT_image4(rs.getString(12));
					vo.setT_image5(rs.getString(13));
				}
						
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return vo;
		}
}
