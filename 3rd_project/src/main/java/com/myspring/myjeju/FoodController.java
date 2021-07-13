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
		ArrayList<FoodVO> list = dao.getFoodList(); 
		ArrayList<FoodVO> toplist = dao.getFoodListTop3();
		
		mv.setViewName("food/food");
		mv.addObject("list",list);
		mv.addObject("toplist",toplist);
		
		return mv;
	}
	/**
	 * cafe.do : 카페 메인페이지
	 */
	@RequestMapping(value="/cafe.do", method=RequestMethod.GET)
	public ModelAndView cafe() {
		ModelAndView mv = new ModelAndView();
		
		CafeDAO dao = new CafeDAO();
		ArrayList<CafeVO> list = dao.getCafeList();
		ArrayList<CafeVO> toplist = dao.getCafeListTop3();
		
		mv.setViewName("food/cafe");
		mv.addObject("list",list);
		mv.addObject("toplist",toplist);
		
		return mv;
	}
	
	/**
	 * food_detail.do : 음식점 상세페이지
	 */
	@RequestMapping(value="/food_detail.do", method=RequestMethod.GET)
	public ModelAndView food_detail(String fid) {
		ModelAndView mv = new ModelAndView();
		
		FoodDAO dao = new FoodDAO();
		FoodVO vo = dao.getFoodDetail(fid);
		String infor2 = vo.getF_infor2().replace("-", "<br>");
		
		mv.setViewName("food/food_detail");
		mv.addObject("vo",vo);
		mv.addObject("infor2",infor2);
		
		return mv;
	}
	
	/**
	 * cafe_detail.do : 카페 상세페이지
	 */
	@RequestMapping(value="/cafe_detail.do", method=RequestMethod.GET)
	public ModelAndView cafe_detail(String caid) {
		ModelAndView mv = new ModelAndView();
		
		CafeDAO dao = new CafeDAO();
		CafeVO vo = dao.getCafeDetail(caid);
		String infor2 = vo.getCa_infor2().replace("-", "<br>");
		
		mv.setViewName("food/cafe_detail");
		mv.addObject("vo",vo);
		mv.addObject("infor2",infor2);
		
		return mv;
	}
}
