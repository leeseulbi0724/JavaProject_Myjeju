package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.RoomVO;

public interface ReservationService {
	
	String getCurrentName(String hid);
	ArrayList<RoomVO> searchroom(String start, String end ,String hdid);
}
