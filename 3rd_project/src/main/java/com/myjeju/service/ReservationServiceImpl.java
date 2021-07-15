package com.myjeju.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.ReservationDAO;
import com.myjeju.vo.RoomVO;

@Service("ReservationService")
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationDAO reservationDAO;
	
	@Override
	public String getCurrentName(String hid) {
		return reservationDAO.getCurrentName(hid); 
	}
	@Override
	public ArrayList<RoomVO> searchroom(String start, String end,String hdid){
		return reservationDAO.searchroom(start,end,hdid); 
	}
}
