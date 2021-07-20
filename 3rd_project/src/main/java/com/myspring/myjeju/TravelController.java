package com.myspring.myjeju;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.myjeju.service.TravelService;
import com.myjeju.vo.CarSpotVO;
import com.myjeju.vo.PhotoSpotVO;
import com.myjeju.vo.TravelVO;

@Controller
public class TravelController {
	
	@Autowired
	private TravelService travelService;
	
	/**
	 * travel.do : 여행지 메인페이지
	 */
	@RequestMapping(value="/travel.do", method=RequestMethod.GET)
	public ModelAndView travel() {
		ModelAndView mv = new ModelAndView();
		
		ArrayList<TravelVO> list = travelService.getTravelList(1, 5);
		ArrayList<TravelVO> toplist = travelService.getTravelListTop3();
		
		mv.setViewName("travel/travel");
		mv.addObject("list",list);
		mv.addObject("toplist",toplist);
		
		return mv;
	}
	
	/**
	 * 여행지 리스트 ajax 처리
	 */
	@ResponseBody
	@RequestMapping(value="/travel_proc.do", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String travel_proc(String pnum, String search, String search_text) {
		ArrayList<TravelVO> list = travelService.getTravelList();
		//ArrayList<TravelVO> list = new ArrayList<TravelVO>();
		
		int pageNumber = 1;

		if(!pnum.equals("")) { 
			pageNumber = Integer.parseInt(pnum) +1;
		}
		
		int startnum = ((pageNumber-1)*5) +1;
		int endnum = pageNumber*5; 
		//int pagenum = (pageNumber -1) * 5;

		if(search_text == null || search_text.equals("") || search_text.equals("null")) {
			list = travelService.getTravelList(startnum, endnum);
		}else {
			list = travelService.getTravelList(startnum, endnum, search, search_text);
		}
		

		JsonObject jdata = new JsonObject();
		JsonArray jlist = new JsonArray();
		Gson gson = new Gson();
		
		for(TravelVO vo : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("tid", vo.getTid());
			jobj.addProperty("t_name", vo.getT_name());
			jobj.addProperty("t_tag", vo.getT_tag());
			jobj.addProperty("t_infor", vo.getT_infor());
			jobj.addProperty("t_addr", vo.getT_addr());
			jobj.addProperty("t_like", vo.getT_like());
			jobj.addProperty("t_image1", vo.getT_image1());
			jobj.addProperty("pnum", String.valueOf(pageNumber));
			jobj.addProperty("search", search);
			jobj.addProperty("search_text", search_text);
			
			jlist.add(jobj);
		}
		
		jdata.add("jlist", jlist);

		return gson.toJson(jdata);
	}
	
	/**
	 * 여행지 리스트 추가분 ajax 처리
	 */
	@ResponseBody
	@RequestMapping(value="/travel_proc_add.do", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String travel_proc(String pnum) {
		
		int pageNumber = 1;
		
		if(!pnum.equals("")) { 
			pageNumber = Integer.parseInt(pnum) +1;
		}
		
		int startnum = ((pageNumber-1)*5) +1;
		int endnum = pageNumber*5; 
		
		
		ArrayList<TravelVO> list = travelService.getTravelList(startnum, endnum);
		
		JsonObject jdata = new JsonObject();
		JsonArray jlist = new JsonArray();
		Gson gson = new Gson();
		
		for(TravelVO vo : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("tid", vo.getTid());
			jobj.addProperty("t_name", vo.getT_name());
			jobj.addProperty("t_addr", vo.getT_addr());
			jobj.addProperty("t_hp", vo.getT_hp());
			jobj.addProperty("t_image", vo.getT_image1());
			jobj.addProperty("t_vpoint", vo.getT_vpoint());
			jobj.addProperty("t_hpoint", vo.getT_hpoint());
			
			jlist.add(jobj);
		}
		
		jdata.add("jlist", jlist);

		return gson.toJson(jdata);
		
		
		//return "{\"title\":\"이호테우 해변\",\"addr\":\"제주특별자치도 제주시 도리로 20\",\"tel\":\"(+82) 064-728-3993\",\"img\":\"이호테우.jpg\",\"idx\":\"5\",\"latlng\":{\"La\":126.45318694807267,\"Ma\":33.49796826011083}}";
	}
	
	/**
	 * travel_detail.do : 여행지 상세페이지
	 */
	@RequestMapping(value="/travel_detail.do", method=RequestMethod.GET)
	public ModelAndView travel_detail(String tid) {
		ModelAndView mv = new ModelAndView();
		
		TravelVO vo = travelService.getTravelDetail(tid);
		PhotoSpotVO photovo = travelService.getPhotoSpot(tid);
		CarSpotVO carvo = travelService.getCarSpot(tid); 
		String infor2 = vo.getT_infor2().replace("\r\n", "<br>");
		
		mv.setViewName("travel/travel_detail");
		mv.addObject("vo",vo);
		mv.addObject("photovo",photovo);
		mv.addObject("carvo",carvo);
		mv.addObject("infor2",infor2);
		return mv;
	}
}
