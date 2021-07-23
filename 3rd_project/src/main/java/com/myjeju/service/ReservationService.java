package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.HDetailVO;
import com.myjeju.vo.HouseVO;
import com.myjeju.vo.MReservationVO;
import com.myjeju.vo.RoomImgVO;
import com.myjeju.vo.RoomVO;

public interface ReservationService {
	
	String getCurrentName(String hid);
	ArrayList<RoomVO> searchroom(String start, String end ,String hdid);
	ArrayList<RoomVO> notavails(String start, String end ,String hdid);
	HouseVO gethouse(String hid);
	HDetailVO getdetail(String hdid);
	ArrayList<RoomImgVO> gethimg(String hdid);
	boolean setreservation(MReservationVO vo);
	boolean updateavail(String roomid,String f_dated,String s_dated);
}
