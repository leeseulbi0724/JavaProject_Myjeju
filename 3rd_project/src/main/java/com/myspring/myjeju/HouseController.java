package com.myspring.myjeju;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.dao.HouseDAO;
import com.myjeju.dao.TravelDAO;
import com.myjeju.vo.HDetailVO;
import com.myjeju.vo.HouseVO;
import com.myjeju.vo.RoomImgVO;
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
		ArrayList<HouseVO> list = hdao.getHouseList();
		ArrayList<HouseVO> toplist = hdao.getHouseListTop3();
		mv.setViewName("house/house");
		mv.addObject("list",list);
		mv.addObject("toplist",toplist);
		
		
		return mv;
	}
	
	/**
	 * house_detail.do : 숙소 상세페이지
	 */
	@RequestMapping(value="/house_detail.do", method=RequestMethod.GET)
	public ModelAndView house_detail(String hid) {
		ModelAndView mv = new ModelAndView();
		
		HouseDAO dao = new HouseDAO();
		HouseVO vo = dao.getHouseDetail(hid);
		String infor2 = vo.getH_infor2().replace("\r\n", "<br>");
		ArrayList<HDetailVO> list = dao.getHDetail(hid);
		
		
		mv.setViewName("house/house_detail");
		mv.addObject("vo",vo);
		mv.addObject("infor2",infor2);
		mv.addObject("list",list);
		
		return mv;
	}
}
