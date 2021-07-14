package com.myjeju.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.myjeju.dao.ReservationDAO;
import com.myjeju.vo.RoomVO;

public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationDAO reservationDAO;
	
	public String getCurrentName(String hid) {
		return reservationDAO.getCurrentName(hid); 
	}
	public ArrayList<RoomVO> searchroom(String start, String end,String hdid){
		return reservationDAO.searchroom(start,end,hdid); 
	}
}
