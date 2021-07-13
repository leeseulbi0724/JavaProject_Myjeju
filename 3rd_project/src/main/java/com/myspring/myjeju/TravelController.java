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
	 * travel.do : 여행지 메인페이지
	 */
	/*
	@RequestMapping(value="/travel.do", method=RequestMethod.GET)
	public ModelAndView travel() {
		ModelAndView mv = new ModelAndView();
		
		TravelDAO tdao = new TravelDAO();
		ArrayList<TravelVO> list = tdao.getList();
		
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
		
		TravelDAO dao = new TravelDAO();
		ArrayList<TravelVO> list = dao.getTravelList();
		ArrayList<TravelVO> toplist = dao.getTravelListTop3();
		
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
		
		TravelDAO dao = new TravelDAO();
		TravelVO vo = dao.getTravelDetail(tid);
		String infor2 = vo.getT_infor2().replace("\r\n", "<br>");
		
		mv.setViewName("travel/travel_detail");
		mv.addObject("vo",vo);
		mv.addObject("infor2",infor2);
		
		return mv;
	}
}
