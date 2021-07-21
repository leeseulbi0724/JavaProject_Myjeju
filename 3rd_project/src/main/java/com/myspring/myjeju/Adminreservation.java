package com.myspring.myjeju;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.service.AdminService;
import com.myjeju.vo.HDetailVO;

@Controller
public class Adminreservation {

	@Autowired
	private AdminService adminService;
	

	//按角 府胶飘
	@RequestMapping(value="/adhouse_de.do",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tomember(String hid) {
		ModelAndView mv = new ModelAndView();
		ArrayList<HDetailVO> list = adminService.gethousede(hid);
		
		mv.setViewName("admin/adhouse_de");
		mv.addObject("list", list);
		return mv;
	}
	//按角 惑技
	@RequestMapping(value="/adhouse_de_content.do",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tode(String hdid) {
		ModelAndView mv = new ModelAndView();
		HDetailVO vo = adminService.gethousedecontent(hdid);
		
		mv.setViewName("admin/adhouse_de_content");
		mv.addObject("vo", vo);
		mv.addObject("hid", vo.getHid());
		return mv;
	}
}


