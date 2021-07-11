package com.myspring.myjeju;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.dao.CafeDAO;
import com.myjeju.dao.FoodDAO;
import com.myjeju.vo.CafeVO;
import com.myjeju.vo.FoodVO;

@Controller
public class FoodController {

	/**
	 * food.do : 음식점 메인페이지
	 */
	@RequestMapping(value="/food.do", method=RequestMethod.GET)
	public ModelAndView food() {
		ModelAndView mv = new ModelAndView();
		FoodDAO dao = new FoodDAO();
		ArrayList<FoodVO> list = dao.getList(); 
		mv.setViewName("food/food");
		mv.addObject("list",list);
		
		return mv;
	}
	/**
	 * cafe.do : 카페 메인페이지
	 */
	@RequestMapping(value="/cafe.do", method=RequestMethod.GET)
	public ModelAndView cafe() {
		ModelAndView mv = new ModelAndView();
		CafeDAO cadao = new CafeDAO();
		ArrayList<CafeVO> list = cadao.getList();
		mv.setViewName("food/cafe");
		mv.addObject("list",list);
		
		return mv;
	}
	
	/**
	 * food_detail.do : 맛집 상세페이지
	 */
	@RequestMapping(value="/food_detail.do", method=RequestMethod.GET)
	public String travel_detail() {
		return "food/food_detail";
	}
}
