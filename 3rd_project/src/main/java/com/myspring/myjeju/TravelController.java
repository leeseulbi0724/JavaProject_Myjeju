package com.myspring.myjeju;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.dao.TravelDAO;
import com.myjeju.vo.TravelVO;

@Controller
public class TravelController {

	/**
	 * travel.do : ������ ����������
	 */
	@RequestMapping(value="/travel.do", method=RequestMethod.GET)
	public ModelAndView travel() {
		ModelAndView mv = new ModelAndView();
		TravelDAO tdao = new TravelDAO();
		ArrayList<TravelVO> list = tdao.getList();
		mv.setViewName("travel/travel");
		mv.addObject("list",list);
		
		return mv;
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
	/**
	 * travel_detail.do : ������ ��������
	 */
	@RequestMapping(value="/travel_detail.do", method=RequestMethod.GET)
	public String travel_detail() {
		return "travel/travel_detail";
	}
}
