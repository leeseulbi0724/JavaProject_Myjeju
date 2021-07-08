package com.myspring.myjeju;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.dao.HouseDAO;
import com.myjeju.vo.HouseVO;
import com.myjeju.vo.TravelVO;

@Controller
public class HouseController {

	/**
	 * house.do : 숙소 메인페이지
	 */
	@RequestMapping(value="/house.do", method=RequestMethod.GET)
	public ModelAndView house() {
		ModelAndView mv = new ModelAndView();
		HouseDAO hdao = new HouseDAO();
		ArrayList<HouseVO> list = hdao.getList();
		mv.setViewName("house/house");
		mv.addObject("list",list);
		
		
		return mv;
	}
}
