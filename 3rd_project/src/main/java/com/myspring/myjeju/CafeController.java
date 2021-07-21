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
import com.myjeju.dao.CafeDAO;
import com.myjeju.service.CafeService;
import com.myjeju.vo.CafeVO;
import com.myjeju.vo.HeartVO;

@Controller
public class CafeController {
	
	@Autowired
	private CafeService cafeService;
	
	/**
	 * cafe.do : ī�� ����������
	 */
	@RequestMapping(value="/cafe.do", method=RequestMethod.GET)
	public ModelAndView cafe(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		//�α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");	
		
		
		ArrayList<CafeVO> list = cafeService.getCafeList();
		ArrayList<CafeVO> toplist = cafeService.getCafeListTop3();
		
		if (id != null) {
			for (int i=0; i<toplist.size(); i++) {
				HeartVO vo = new HeartVO();		
				vo.setId(id); vo.setCaid(toplist.get(i).getCaid());
				int status = cafeService.getHeartInfoResult(vo);
				toplist.get(i).setStatus(status);				 
			}
			for (int i=0; i<list.size(); i++) {
				HeartVO vo = new HeartVO();		
				vo.setId(id); vo.setCaid(list.get(i).getCaid());
				int status = cafeService.getHeartInfoResult(vo);
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
		
		mv.setViewName("food/cafe");
		mv.addObject("list",list);
		mv.addObject("toplist",toplist);
		
		return mv;
	}
	
	/**
	 * ī�� ����Ʈ ajax ó��
	 */
	@ResponseBody
	@RequestMapping(value="/cafe_proc.do", produces = "application/text; charset=utf8", method=RequestMethod.GET)
	public String cafe_proc(String pnum, String search, String search_text, HttpSession session) {
		ArrayList<CafeVO> list = cafeService.getCafeList();
		
		//�α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");	
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
		
		if (id != null) {
			for (int i=0; i<list.size(); i++) {
				HeartVO vo = new HeartVO();		
				vo.setId(id); vo.setCaid(list.get(i).getCaid());
				int status = cafeService.getHeartInfoResult(vo);
				list.get(i).setStatus(status);				 
			}
			for (int i=0; i<list.size(); i++) {
				HeartVO vo = new HeartVO();		
				vo.setId(id); vo.setCaid(list.get(i).getCaid());
				int status = cafeService.getHeartInfoResult(vo);
				list.get(i).setStatus(status);				 
			}
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
			jobj.addProperty("status", vo.getStatus());
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
	 * cafe_detail.do : ī�� ��������
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
	
	/**
	 * ���ƿ� +
	 */
	@ResponseBody
	@RequestMapping(value = "/heart_cafe_plus.do", method=RequestMethod.POST)
	public boolean heart_plus(HttpSession session, HttpServletRequest request) {
		boolean total = false;
		//�α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");
		String caid = request.getParameter("caid");
		HeartVO vo = new HeartVO();
		vo.setId(id);
		vo.setCaid(caid);		
		//heart ���̺� �߰�
		total = cafeService.getHeartPlus(vo);
		//hous���̺� ��Ʈ+
		if (total) {
			boolean result = cafeService.getUpdateHeart(caid);
		}
		return total;
	}

	/**
	 * ���ƿ� -
	 */
	@ResponseBody
	@RequestMapping(value = "/heart_cafe_minus.do", method=RequestMethod.POST)
	public boolean heart_minus(HttpSession session, HttpServletRequest request) {
		boolean total = false;
		//�α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");
		String caid = request.getParameter("caid");
		HeartVO vo = new HeartVO();
		vo.setId(id);
		vo.setCaid(caid);		
		//heart ���̺� ���� 
		total = cafeService.getHeartMinus(vo);
		//hous���̺� ��Ʈ-
		if (total) {
			boolean result = cafeService.getUpdateMinusHeart(caid);
		}

		return total;
	}
}
