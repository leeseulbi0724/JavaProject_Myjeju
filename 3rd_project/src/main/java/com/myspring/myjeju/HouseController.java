package com.myspring.myjeju;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.service.HouseService;
import com.myjeju.vo.HDetailVO;
import com.myjeju.vo.HeartVO;
import com.myjeju.vo.HouseVO;

@Controller
public class HouseController {
	
	@Autowired
	private HouseService houseService;
	/**
	 * house.do : 숙소 메인페이지
	 */
	@RequestMapping(value="/house.do", method=RequestMethod.GET)
	public ModelAndView house() {
		ModelAndView mv = new ModelAndView();
		
		HeartVO vo = new HeartVO();
		vo.setId(id);
		vo.setHid(hid);
		boolean h_result = houseService.getHeartResult(vo);
		
		ArrayList<HouseVO> list = houseService.getHouseList();
		ArrayList<HouseVO> toplist = houseService.getHouseListTop3();
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
		
		HouseVO vo = houseService.getHouseDetail(hid);
		String infor2 = vo.getH_infor2().replace("\r\n", "<br>");
		ArrayList<HDetailVO> list = houseService.getHDetail(hid);
		
		
		mv.setViewName("house/house_detail");
		mv.addObject("vo",vo);
		mv.addObject("infor2",infor2);
		mv.addObject("list",list);
		
		return mv;
	}
	
	/**
	 * 좋아요 +
	 */
	@ResponseBody
	@RequestMapping(value = "/heart_plus.do", method=RequestMethod.POST)
	public boolean heart_plus(HttpSession session, HttpServletRequest request) {
		boolean total = false;
		//로그인 회원정보 가져오기
		String id = (String) session.getAttribute("session_id");
		String hid = request.getParameter("hid");
		HeartVO vo = new HeartVO();
		vo.setId(id);
		vo.setHid(hid);		

		//heart 테이블 추가
		if (result) {
			total = houseService.getHeartPlus(vo);
		}
	
		return total;
	}

	/**
	 * 좋아요 -
	 */
	@ResponseBody
	@RequestMapping(value = "/heart_minus.do", method=RequestMethod.POST)
	public boolean heart_minus(HttpSession session, HttpServletRequest request) {
		boolean total = false;
		//로그인 회원정보 가져오기
		String id = (String) session.getAttribute("session_id");
		String hid = request.getParameter("bhd");
		HeartVO vo = new HeartVO();
		vo.setId(id);
		vo.setHid(hid);

		//heart 테이블 삭제
		if (result) {
			total = houseService.getHeartMinus(vo);
		}

		return total;
	}
	
	
}
