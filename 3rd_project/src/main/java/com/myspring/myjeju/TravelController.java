package com.myspring.myjeju;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TravelController {

	/**
	 * travel.do : 여행지 메인페이지
	 */
	@RequestMapping(value="/travel.do", method=RequestMethod.GET)
	public String travel() {
		return "travel/travel";
	}
	/**
	 * photo_spot.do : 포토스팟 메인페이지
	 */
	@RequestMapping(value="/photo_spot.do", method=RequestMethod.GET)
	public String photo_spot() {
		return "travel/photo_spot";
	}
	/**
	 * car_spot.do : 차박스팟 메인페이지
	 */
	@RequestMapping(value="/car_spot.do", method=RequestMethod.GET)
	public String car_spot() {
		return "travel/car_spot";
	}
	/**
	 * travel_detail.do : 여행지 상세페이지
	 */
	@RequestMapping(value="/travel_detail.do", method=RequestMethod.GET)
	public String travel_detail() {
		return "travel/travel_detail";
	}
}
