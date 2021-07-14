package com.myjeju.dao;

import java.util.ArrayList;

import com.myjeju.vo.HDetailVO;
import com.myjeju.vo.HouseVO;
import com.myjeju.vo.RoomImgVO;
import com.myjeju.vo.TravelVO;



public class HouseDAO extends DBConn {
	
	//Select --> 전체 리스트
	public ArrayList<HouseVO> getList(){
		ArrayList<HouseVO> list = new ArrayList<HouseVO>();
		String sql = " select h_vpoint, h_hpoint, h_name, h_addr, h_hp, h_img from myjeju_house ";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HouseVO vo = new HouseVO();
				vo.setH_vpoint(rs.getString(1));
				vo.setH_hpoint(rs.getString(2));
				vo.setH_name(rs.getString(3));
				vo.setH_addr(rs.getString(4));
				vo.setH_hp(rs.getString(5));
				vo.setH_img(rs.getString(6));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//숙소 전체리스트
	public ArrayList<HouseVO> getHouseList(){
		ArrayList<HouseVO> list = new ArrayList<HouseVO>();
		String sql = " select hid, h_name, h_infor, h_infor2, h_tag, h_addr, h_vpoint, h_hpoint, h_hp, h_like, h_img from myjeju_house ";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HouseVO vo = new HouseVO();
				vo.setHid(rs.getString(1));
				vo.setH_name(rs.getString(2));
				vo.setH_infor(rs.getString(3));
				vo.setH_infor2(rs.getString(4));
				vo.setH_tag(rs.getString(5));
				vo.setH_addr(rs.getString(6));
				vo.setH_vpoint(rs.getString(7));
				vo.setH_hpoint(rs.getString(8));
				vo.setH_hp(rs.getString(9));
				vo.setH_like(rs.getInt(10));
				vo.setH_img(rs.getString(11));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//숙소 상위3개
	public ArrayList<HouseVO> getHouseListTop3(){
		ArrayList<HouseVO> list = new ArrayList<HouseVO>();
		String sql = "select hid, h_name, h_tag, h_infor, h_like, h_img from myjeju_house where rownum <= 3 order by h_like desc";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HouseVO vo = new HouseVO();
				vo.setHid(rs.getString(1));
				vo.setH_name(rs.getString(2));
				vo.setH_tag(rs.getString(3));
				vo.setH_infor(rs.getString(4));
				vo.setH_like(rs.getInt(5));
				vo.setH_img(rs.getString(6));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	//숙소 상세 정보
	public HouseVO getHouseDetail(String hid) {
		HouseVO vo = new HouseVO();
		String sql = "select hid, h_name, h_tag, h_infor, h_infor2, h_addr, h_hp, h_like, h_img from myjeju_house where hid = ? ";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, hid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo.setHid(rs.getString(1));
				vo.setH_name(rs.getString(2));
				vo.setH_tag(rs.getString(3));
				vo.setH_infor(rs.getString(4));
				vo.setH_infor2(rs.getString(5));
				vo.setH_addr(rs.getString(6));
				vo.setH_hp(rs.getString(7));
				vo.setH_like(rs.getInt(8));
				vo.setH_img(rs.getString(9));
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	//숙소 객실 정보
	public ArrayList<HDetailVO> getHDetail(String hid){
		ArrayList<HDetailVO> list = new ArrayList<HDetailVO>();
		String sql = "select hd_name, hd_price, hd_people, hd_img, hdid from myjeju_hdetail where hid = ? ";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, hid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				HDetailVO hvo = new HDetailVO();
				hvo.setHd_name(rs.getString(1));
				hvo.setHd_price(rs.getString(2));
				hvo.setHd_people(rs.getInt(3));
				hvo.setHd_img(rs.getString(4));
				hvo.setHdid(rs.getString(5));
				list.add(hvo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//숙소 객실 이미지
	public ArrayList<RoomImgVO> getRoomImg(String hdid){
		ArrayList<RoomImgVO> list = new ArrayList<RoomImgVO>();
		String sql = "select hd_img from myjeju_rimg where hdid = ? ";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, hdid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RoomImgVO rvo = new RoomImgVO();
				rvo.setHd_img(rs.getString(1));
				list.add(rvo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
