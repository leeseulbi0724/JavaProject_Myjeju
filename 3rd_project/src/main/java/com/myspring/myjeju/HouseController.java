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
	 * house.do : ���� ����������
	 */
	@RequestMapping(value="/house.do", method=RequestMethod.GET)
	public ModelAndView house(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		//�α��� ȸ������ ��������
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
		} else {
			for (int i=0; i<toplist.size(); i++) {
				toplist.get(i).setStatus(0);
			}
		}
		mv.setViewName("house/house");
		mv.addObject("list",list);
		mv.addObject("toplist",toplist);
		
		
		return mv;
	}
	
	/**
	 * house_detail.do : ���� ��������
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
	 * ���ƿ� +
	 */
	@ResponseBody
	@RequestMapping(value = "/heart_plus.do", method=RequestMethod.POST)
	public boolean heart_plus(HttpSession session, HttpServletRequest request) {
		boolean total = false;
		//�α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");
		String hid = request.getParameter("hid");
		HeartVO vo = new HeartVO();
		vo.setId(id);
		vo.setHid(hid);		
		//heart ���̺� �߰�
		total = houseService.getHeartPlus(vo);
		//hous���̺� ��Ʈ+
		if (total) {
			boolean result = houseService.getUpdateHeart(hid);
		}
		return total;
	}

	/**
	 * ���ƿ� -
	 */
	@ResponseBody
	@RequestMapping(value = "/heart_minus.do", method=RequestMethod.POST)
	public boolean heart_minus(HttpSession session, HttpServletRequest request) {
		boolean total = false;
		//�α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");
		String hid = request.getParameter("hid");
		HeartVO vo = new HeartVO();
		vo.setId(id);
		vo.setHid(hid);		
		//heart ���̺� ���� 
		total = houseService.getHeartMinus(vo);
		//hous���̺� ��Ʈ-
		if (total) {
			boolean result = houseService.getUpdateMinusHeart(hid);
		}

		return total;
	}
	
	
}
