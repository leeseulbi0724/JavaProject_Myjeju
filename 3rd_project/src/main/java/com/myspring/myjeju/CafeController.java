package com.myspring.myjeju;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
	 * 카페 리스트 ajax 처리
	 */
	@ResponseBody
	@RequestMapping(value="/cafe_proc.do", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String cafe_proc(String pnum, String search, String search_text) {
		ArrayList<CafeVO> list = cafeService.getCafeList();
		
		int pageNumber = 1;

		if(!pnum.equals("")) { 
			pageNumber = Integer.parseInt(pnum) +1;
		}
		
		int startnum = ((pageNumber-1)*5) +1;
		int endnum = pageNumber*5; 

		if(search_text == null || search_text.equals("") || search_text.equals("null")) {
			list = cafeService.getCafeList(startnum, endnum);
		}else {
			list = cafeService.getCafeList(startnum, endnum, search, search_text);
		}
		

		JsonObject jdata = new JsonObject();
		JsonArray jlist = new JsonArray();
		Gson gson = new Gson();
		
		for(CafeVO vo : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("caid", vo.getCaid());
			jobj.addProperty("ca_name", vo.getCa_name());
			jobj.addProperty("ca_tag", vo.getCa_tag());
			jobj.addProperty("ca_infor", vo.getCa_infor());
			jobj.addProperty("ca_addr", vo.getCa_addr());
			jobj.addProperty("ca_like", vo.getCa_like());
			jobj.addProperty("ca_image1", vo.getCa_image1());
			jobj.addProperty("pnum", String.valueOf(pageNumber));
			jobj.addProperty("search", search);
			jobj.addProperty("search_text", search_text);
			
			jlist.add(jobj);
		}
		
		jdata.add("jlist", jlist);

		return gson.toJson(jdata);
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
