package com.myspring.myjeju;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.dao.FoodDAO;
import com.myjeju.service.FoodService;
import com.myjeju.vo.FoodVO;

@Controller
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	/**
	 * food.do : 음식점 메인페이지
	 */
	@RequestMapping(value="/food.do", method=RequestMethod.GET)
	public ModelAndView food() {
		ModelAndView mv = new ModelAndView();
		
		ArrayList<FoodVO> list = foodService.getFoodList(); 
		ArrayList<FoodVO> toplist = foodService.getFoodListTop3();
		
		mv.setViewName("food/food");
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
		
		FoodVO vo = foodService.getFoodDetail(fid);
		String infor2 = vo.getF_infor2().replace("-", "<br>");
		
		mv.setViewName("food/food_detail");
		mv.addObject("vo",vo);
		mv.addObject("infor2",infor2);
		
		return mv;
	}
	
}
