package com.myspring.myjeju;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.service.AdminService;
import com.myjeju.service.CommunityService;
import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.MemberVO;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CommunityService communityService;
	
	@RequestMapping(value="/adminindex.do", method=RequestMethod.GET)
	public String main(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.setAttribute("session_id", "admin");
		
		return "/admin/adminindex";
	}
	@RequestMapping(value="/admember.do",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tomember(String pnum, String search, String search_text) {
		ModelAndView mv = new ModelAndView();
		
		int pageNumber = 1;
		 
		if(pnum != null) {
	  		pageNumber = Integer.parseInt(pnum);
	  	}
		
		int startnum = ((pageNumber-1)*10) +1;
		int endnum = pageNumber*10; 
		int pagenum = (pageNumber -1) * 10;
		int target = 0;
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		if(search_text == null || search_text.equals("") || search_text.equals("null")) {
	  		list = adminService.getlist(startnum,endnum);
	  		target = adminService.targetPage(pagenum);
	  	} else {
	  		list = adminService.getlist(startnum,endnum,search,search_text);
	  		target = adminService.targetPage(pagenum,search,search_text);
	  	}
			
		int targetpage = 0;
		if(pageNumber != 1 ) {
			targetpage = (target-2) / 10 ;
			} else {
			targetpage = (target-1) / 10 ;
			}
		mv.setViewName("admin/admember");
		mv.addObject("list", list);
		mv.addObject("targetpage", String.valueOf(targetpage));
		mv.addObject("pageNumber", String.valueOf(pageNumber));
		mv.addObject("search", search);
		mv.addObject("search_text", search_text);
		
		return mv;
	}
	
	
	// 관리자 게시판
	@RequestMapping(value="/adboard.do",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView toboard(String pnum, String search, String search_text) {
		ModelAndView mv = new ModelAndView();
		
		int pageNumber = 1;
		 
		if(pnum != null) {
	  		pageNumber = Integer.parseInt(pnum);
	  	}
		
		int startnum = ((pageNumber-1)*10) +1;
		int endnum = pageNumber*10; 
		int pagenum = (pageNumber -1) * 10;
		int target = 0;
		ArrayList<CommunityVO> list = new ArrayList<CommunityVO>();
		if(search_text == null || search_text.equals("") || search_text.equals("null")) {
	  		list = adminService.getBoardList(startnum,endnum);
	  		target = adminService.BoardPage(pagenum);
	  	} else {
	  		list = adminService.getBoardList(startnum,endnum,search,search_text);
	  		target = adminService.BoardPage(pagenum,search,search_text);
	  	}
			
		int targetpage = 0;
		if(pageNumber != 1 ) {
			targetpage = (target-2) / 10 ;
			} else {
			targetpage = (target-1) / 10 ;
			}
		mv.setViewName("admin/adboard");
		mv.addObject("list", list);
		mv.addObject("targetpage", String.valueOf(targetpage));
		mv.addObject("pageNumber", String.valueOf(pageNumber));
		mv.addObject("search", search);
		mv.addObject("search_text", search_text);
		
		return mv;
	}
	
	//관리자 게시판 상세보기 
	@RequestMapping(value="/adboard_content.do",method= RequestMethod.GET)
	public ModelAndView adboard_content(String fid) {		
		ModelAndView mv = new ModelAndView();
		
		//게시물 내용
		CommunityVO vo = communityService.getFreeContent(fid);		
		//댓글 정보
		ArrayList<CommunityVO> list = communityService.getFreeComment(fid);		
		
		mv.addObject("vo", vo);
		mv.addObject("list", list);
		mv.setViewName("admin/adboard_content");
		
		return mv;
				
	}
	
	//관리자 게시글 삭제
	@ResponseBody
	@RequestMapping(value = "/admin_board_delete.do", method=RequestMethod.POST)
	public boolean admin_board_delete(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		String fid = request.getParameter("fid");
		
		String old_bsfile = communityService.getFileResult(fid);
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		File old_file = new File(root_path+attach_path+old_bsfile);
		if ( old_file.exists()) {
			old_file.delete();
		}
		
		boolean result = communityService.getFreeBoardDelete(fid);
	
		
		return result;
	}
	
	// 관리자 공지사항
		@RequestMapping(value="/adnotice.do",method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView tonotice(String pnum, String search, String search_text) {
			ModelAndView mv = new ModelAndView();
			
			int pageNumber = 1;
			 
			if(pnum != null) {
		  		pageNumber = Integer.parseInt(pnum);
		  	}
			
			int startnum = ((pageNumber-1)*10) +1;
			int endnum = pageNumber*10; 
			int pagenum = (pageNumber -1) * 10;
			int target = 0;
			/*
			 * ArrayList<MemberVO> list = new ArrayList<MemberVO>(); if(search_text == null
			 * || search_text.equals("") || search_text.equals("null")) { list =
			 * adminService.getlist(startnum,endnum); target =
			 * adminService.targetPage(pagenum); } else { list =
			 * adminService.getlist(startnum,endnum,search,search_text); target =
			 * adminService.targetPage(pagenum,search,search_text); }
			 */
				
			int targetpage = 0;
			if(pageNumber != 1 ) {
				targetpage = (target-2) / 10 ;
				} else {
				targetpage = (target-1) / 10 ;
				}
			mv.setViewName("admin/adnotice");
			/* mv.addObject("list", list); */
			mv.addObject("targetpage", String.valueOf(targetpage));
			mv.addObject("pageNumber", String.valueOf(pageNumber));
			mv.addObject("search", search);
			mv.addObject("search_text", search_text);
			
			return mv;
		}
		
		// 관리자 요청
		@RequestMapping(value="/adrequest.do",method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView torequest(String pnum, String search, String search_text) {
			ModelAndView mv = new ModelAndView();
			
			int pageNumber = 1;
			 
			if(pnum != null) {
		  		pageNumber = Integer.parseInt(pnum);
		  	}
			
			int startnum = ((pageNumber-1)*10) +1;
			int endnum = pageNumber*10; 
			int pagenum = (pageNumber -1) * 10;
			int target = 0;
			/*
			 * ArrayList<MemberVO> list = new ArrayList<MemberVO>(); if(search_text == null
			 * || search_text.equals("") || search_text.equals("null")) { list =
			 * adminService.getlist(startnum,endnum); target =
			 * adminService.targetPage(pagenum); } else { list =
			 * adminService.getlist(startnum,endnum,search,search_text); target =
			 * adminService.targetPage(pagenum,search,search_text); }
			 */
				
			int targetpage = 0;
			if(pageNumber != 1 ) {
				targetpage = (target-2) / 10 ;
				} else {
				targetpage = (target-1) / 10 ;
				}
			mv.setViewName("admin/adrequest");
			/* mv.addObject("list", list); */
			mv.addObject("targetpage", String.valueOf(targetpage));
			mv.addObject("pageNumber", String.valueOf(pageNumber));
			mv.addObject("search", search);
			mv.addObject("search_text", search_text);
			
			return mv;
		}
}
