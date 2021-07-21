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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.myjeju.service.HouseService;
import com.myjeju.vo.HDetailVO;
import com.myjeju.vo.HeartVO;
import com.myjeju.vo.HouseReviewVO;
import com.myjeju.vo.HouseVO;

@Controller
public class HouseController {
	
	@Autowired
	private HouseService houseService;
	/**
	 * house.do : 숙소 메인페이지
	 */
	@RequestMapping(value="/house.do", method=RequestMethod.GET)
	public ModelAndView house(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		//로그인 회원정보 가져오기
		String id = (String) session.getAttribute("session_id");	

		
		ArrayList<HouseVO> list = houseService.getHouseList();		
		ArrayList<HouseVO> toplist = houseService.getHouseListTop3();
		
		if (id != null) {
			for (int i=0; i<toplist.size(); i++) {
				HeartVO vo = new HeartVO();		
				vo.setId(id); vo.setHid(toplist.get(i).getHid());
				int status = houseService.getHeartInfoResult(vo);
				toplist.get(i).setStatus(status);				 
			}
			for (int i=0; i<list.size(); i++) {
				HeartVO vo = new HeartVO();		
				vo.setId(id); vo.setHid(list.get(i).getHid());
				int status = houseService.getHeartInfoResult(vo);
				list.get(i).setStatus(status);				 
			}
		} else {
			for (int i=0; i<toplist.size(); i++) {
				toplist.get(i).setStatus(0);
			}
			for (int i=0; i<list.size(); i++) {
				list.get(i).setStatus(0);
			}
		}
		
		
		mv.setViewName("house/house");
		mv.addObject("list",list);
		mv.addObject("toplist",toplist);
		
		
		return mv;
	}
	
	
	
	/**
	 * 숙소 리스트 ajax 처리
	 */
	@ResponseBody
	@RequestMapping(value="/house_proc.do", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String house_proc(String pnum, String search, String search_text, HttpSession session) {
		ArrayList<HouseVO> list = houseService.getHouseList();
		
		//로그인 회원정보 가져오기
		String id = (String) session.getAttribute("session_id");
		int pageNumber = 1;

		if(!pnum.equals("")) { 
			pageNumber = Integer.parseInt(pnum) +1;
		}
		
		int startnum = ((pageNumber-1)*5) +1;
		int endnum = pageNumber*5; 

		if(search_text == null || search_text.equals("") || search_text.equals("null")) {
			list = houseService.getHouseList(startnum, endnum);
		}else {
			list = houseService.getHouseList(startnum, endnum, search, search_text);
		}
		
		if (id != null) {
			for (int i=0; i<list.size(); i++) {
				HeartVO vo = new HeartVO();		
				vo.setId(id); vo.setHid(list.get(i).getHid());
				int status = houseService.getHeartInfoResult(vo);
				list.get(i).setStatus(status);				 
			}
			for (int i=0; i<list.size(); i++) {
				HeartVO vo = new HeartVO();		
				vo.setId(id); vo.setHid(list.get(i).getHid());
				int status = houseService.getHeartInfoResult(vo);
				list.get(i).setStatus(status);				 
			}
		} 		
		

		JsonObject jdata = new JsonObject();
		JsonArray jlist = new JsonArray();
		Gson gson = new Gson();
		
		for(HouseVO vo : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("hid", vo.getHid());
			jobj.addProperty("h_name", vo.getH_name());
			jobj.addProperty("h_tag", vo.getH_tag());
			jobj.addProperty("h_infor", vo.getH_infor());
			jobj.addProperty("h_addr", vo.getH_addr());
			jobj.addProperty("h_like", vo.getH_like());
			jobj.addProperty("status", vo.getStatus());
			jobj.addProperty("h_img", vo.getH_img());
			jobj.addProperty("pnum", String.valueOf(pageNumber));
			jobj.addProperty("search", search);
			jobj.addProperty("search_text", search_text);
			
			jlist.add(jobj);
		}
		
		jdata.add("jlist", jlist);

		return gson.toJson(jdata);
	}
	
	/**
	 * 숙소 리스트 추가분 ajax 처리
	 */
	@ResponseBody
	@RequestMapping(value="/house_proc_add.do", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String house_proc(String pnum) {
		
		int pageNumber = 1;
		
		if(!pnum.equals("")) { 
			pageNumber = Integer.parseInt(pnum) +1;
		}
		
		int startnum = ((pageNumber-1)*5) +1;
		int endnum = pageNumber*5; 
		
		
		ArrayList<HouseVO> list = houseService.getHouseList(startnum, endnum);
		
		JsonObject jdata = new JsonObject();
		JsonArray jlist = new JsonArray();
		Gson gson = new Gson();
		
		for(HouseVO vo : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("hid", vo.getHid());
			jobj.addProperty("h_name", vo.getH_name());
			jobj.addProperty("h_addr", vo.getH_addr());
			jobj.addProperty("h_hp", vo.getH_hp());
			jobj.addProperty("h_img", vo.getH_img());
			jobj.addProperty("h_vpoint", vo.getH_vpoint());
			jobj.addProperty("h_hpoint", vo.getH_hpoint());
			
			jlist.add(jobj);
		}
		
		jdata.add("jlist", jlist);

		return gson.toJson(jdata);
	}
	
	/**
	 * house_detail.do : 숙소 상세페이지
	 */
	@RequestMapping(value="/house_detail.do", method=RequestMethod.GET)
	public ModelAndView house_detail(HttpSession session, String hid) {
		//로그인 회원정보 가져오기
		String id = (String) session.getAttribute("session_id");	

		ModelAndView mv = new ModelAndView();
		
		HouseVO vo = houseService.getHouseDetail(hid);
		if (id!= null) {
			HeartVO hvo = new HeartVO();
			hvo.setId(id);  hvo.setHid(hid);
			int status = houseService.getHeartInfoResult(hvo);		
			vo.setStatus(status);
		} else {
			vo.setStatus(0);
		}
		
		String infor2 = vo.getH_infor2().replace("\r\n", "<br>");
		
		ArrayList<HDetailVO> list = houseService.getHDetail(hid);
		ArrayList<HouseReviewVO> hvo = houseService.getTravelReview(hid);
		
		mv.setViewName("house/house_detail");
		mv.addObject("vo",vo);
		mv.addObject("infor2",infor2);
		mv.addObject("list",list);
		mv.addObject("hvo",hvo);
		mv.addObject("id",id);
		
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
		total = houseService.getHeartPlus(vo);
		//hous테이블 하트+
		if (total) {
			boolean result = houseService.getUpdateHeart(hid);
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
		String hid = request.getParameter("hid");
		HeartVO vo = new HeartVO();
		vo.setId(id);
		vo.setHid(hid);		
		//heart 테이블 삭제 
		total = houseService.getHeartMinus(vo);
		//hous테이블 하트-
		if (total) {
			boolean result = houseService.getUpdateMinusHeart(hid);
		}

		return total;
	}
	
	/**
	 * house_review_proc.do : 숙소 리뷰 등록 처리
	 */
	@RequestMapping(value="/house_review_proc.do", method=RequestMethod.POST)
	public ModelAndView travel_review_proc(HouseReviewVO vo, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		String user_id = (String) session.getAttribute("session_id");
		vo.setId(user_id);

		boolean result = houseService.getInsertResult(vo);
		
		if(result) {
			mv.setViewName("redirect:/house_detail.do");
			mv.addObject("reid", vo.getReid());
			mv.addObject("id", vo.getId());
			mv.addObject("hid", vo.getHid());
			mv.addObject("h_review", vo.getH_review());
			mv.addObject("h_star", vo.getH_star());
			mv.addObject("h_time", vo.getH_time());
		}
		return mv;
	}
}
