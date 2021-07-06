package com.myspring.myjeju;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.myjeju.dao.AccomodationDAO;
import com.myjeju.vo.AccomodationVO;

@Controller
public class AccomodationController {
	/**
	 * accomodation.do ---> 숙소 리스트 출력
	 */
	@RequestMapping(value="/accomodation.do", method=RequestMethod.GET)
	public ModelAndView accomodation() {
		ModelAndView mv = new ModelAndView();
		
		AccomodationDAO dao = new AccomodationDAO();
		
		
		ArrayList<AccomodationVO> list = dao.getList(); 
		
		mv.setViewName("accomodation");
		mv.addObject("list",list);
		
		return mv;
	}

}
