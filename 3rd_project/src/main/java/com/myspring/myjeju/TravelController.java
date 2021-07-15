package com.myspring.myjeju;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.service.TravelService;
import com.myjeju.vo.CarSpotVO;
import com.myjeju.vo.PhotoSpotVO;
import com.myjeju.vo.TravelVO;

@Controller
public class TravelController {
	
	@Autowired
	private TravelService travelService;
	
	
	/**
	 * travel.do : 여행지 메인페이지
	 */
	/*
	@RequestMapping(value="/travel.do", method=RequestMethod.GET)
	public ModelAndView travel() {
		ModelAndView mv = new ModelAndView();
		
		ArrayList<TravelVO> list = travelService.getList();
		
		mv.setViewName("travel/travel");
		mv.addObject("list",list);
		
		return mv;
	}
	*/
	
	/**
	 * travel.do : 여행지 메인페이지
	 */
	@RequestMapping(value="/travel.do", method=RequestMethod.GET)
	public ModelAndView travel() {
		ModelAndView mv = new ModelAndView();
		
		ArrayList<TravelVO> list = travelService.getTravelList();
		ArrayList<TravelVO> toplist = travelService.getTravelListTop3();
		
		mv.setViewName("travel/travel");
		mv.addObject("list",list);
		mv.addObject("toplist",toplist);
		
		return mv;
	}
	
	/**
	 * travel_detail.do : 여행지 상세페이지
	 */
	@RequestMapping(value="/travel_detail.do", method=RequestMethod.GET)
	public ModelAndView travel_detail(String tid) {
		ModelAndView mv = new ModelAndView();
		
		TravelVO vo = travelService.getTravelDetail(tid);
		PhotoSpotVO photovo = travelService.getPhotoSpot(tid);
		CarSpotVO carvo = travelService.getCarSpot(tid); 
		String infor2 = vo.getT_infor2().replace("\r\n", "<br>");
		
		mv.setViewName("travel/travel_detail");
		mv.addObject("vo",vo);
		mv.addObject("photovo",photovo);
		mv.addObject("carvo",carvo);
		mv.addObject("infor2",infor2);
		
		return mv;
	}
}
