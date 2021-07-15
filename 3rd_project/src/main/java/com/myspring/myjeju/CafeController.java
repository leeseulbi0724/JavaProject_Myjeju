package com.myspring.myjeju;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.dao.CafeDAO;
import com.myjeju.service.CafeService;
import com.myjeju.vo.CafeVO;

@Controller
public class CafeController {
	
	@Autowired
	private CafeService cafeService;
	
	/**
	 * cafe.do : 카페 메인페이지
	 */
	@RequestMapping(value="/cafe.do", method=RequestMethod.GET)
	public ModelAndView cafe() {
		ModelAndView mv = new ModelAndView();
		
		ArrayList<CafeVO> list = cafeService.getCafeList();
		ArrayList<CafeVO> toplist = cafeService.getCafeListTop3();
		
		mv.setViewName("food/cafe");
		mv.addObject("list",list);
		mv.addObject("toplist",toplist);
		
		return mv;
	}
	
	/**
	 * cafe_detail.do : 카페 상세페이지
	 */
	@RequestMapping(value="/cafe_detail.do", method=RequestMethod.GET)
	public ModelAndView cafe_detail(String caid) {
		ModelAndView mv = new ModelAndView();
		
		CafeVO vo = cafeService.getCafeDetail(caid);
		String infor2 = vo.getCa_infor2().replace("-", "<br>");
		
		mv.setViewName("food/cafe_detail");
		mv.addObject("vo",vo);
		mv.addObject("infor2",infor2);
		
		return mv;
	}
}
