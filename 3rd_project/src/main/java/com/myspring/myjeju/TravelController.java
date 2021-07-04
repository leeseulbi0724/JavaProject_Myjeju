package com.myspring.myjeju;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TravelController {

	/**
	 * travel.do : ������ ����������
	 */
	@RequestMapping(value="/travel.do", method=RequestMethod.GET)
	public String travel() {
		return "travel/travel";
	}
	/**
	 * photo_spot.do : ���佺�� ����������
	 */
	@RequestMapping(value="/photo_spot.do", method=RequestMethod.GET)
	public String photo_spot() {
		return "travel/photo_spot";
	}
	/**
	 * car_spot.do : ���ڽ��� ����������
	 */
	@RequestMapping(value="/car_spot.do", method=RequestMethod.GET)
	public String car_spot() {
		return "travel/car_spot";
	}
}
