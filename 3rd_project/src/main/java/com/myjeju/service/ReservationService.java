package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.HDetailVO;
import com.myjeju.vo.HouseVO;
import com.myjeju.vo.RoomVO;

public interface ReservationService {
	
	String getCurrentName(String hid);
	ArrayList<RoomVO> searchroom(String start, String end ,String hdid);
	HouseVO gethouse(String hid);
	HDetailVO getdetail(String hdid);
}
