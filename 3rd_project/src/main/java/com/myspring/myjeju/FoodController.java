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
	 * 음식점 리스트 ajax 처리
	 */
	@ResponseBody
	@RequestMapping(value="/food_proc.do", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String travel_proc(String pnum, String search, String search_text) {
		ArrayList<FoodVO> list = foodService.getFoodList();
		
		int pageNumber = 1;

		if(!pnum.equals("")) { 
			pageNumber = Integer.parseInt(pnum) +1;
		}
		
		int startnum = ((pageNumber-1)*5) +1;
		int endnum = pageNumber*5; 

		if(search_text == null || search_text.equals("") || search_text.equals("null")) {
			list = foodService.getFoodList(startnum, endnum);
		}else {
			list = foodService.getFoodList(startnum, endnum, search, search_text);
		}
		

		JsonObject jdata = new JsonObject();
		JsonArray jlist = new JsonArray();
		Gson gson = new Gson();
		
		for(FoodVO vo : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("fid", vo.getFid());
			jobj.addProperty("f_name", vo.getF_name());
			jobj.addProperty("f_tag", vo.getF_tag());
			jobj.addProperty("f_infor", vo.getF_infor());
			jobj.addProperty("f_addr", vo.getF_addr());
			jobj.addProperty("f_like", vo.getF_like());
			jobj.addProperty("f_image1", vo.getF_image1());
			jobj.addProperty("pnum", String.valueOf(pageNumber));
			jobj.addProperty("search", search);
			jobj.addProperty("search_text", search_text);
			
			jlist.add(jobj);
		}
		
		jdata.add("jlist", jlist);

		return gson.toJson(jdata);
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
