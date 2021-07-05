package com.myspring.myjeju;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FoodController {

	/**
	 * food.do : ������ ����������
	 */
	@RequestMapping(value="/food.do", method=RequestMethod.GET)
	public String food() {
		return "food/food";
	}
	/**
	 * cafe.do : ī�� ����������
	 */
	@RequestMapping(value="/cafe.do", method=RequestMethod.GET)
	public String cafe() {
		return "food/cafe";
	}
	
}
