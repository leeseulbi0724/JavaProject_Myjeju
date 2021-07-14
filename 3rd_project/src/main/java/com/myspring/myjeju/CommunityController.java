package com.myspring.myjeju;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.commons.Commons;
import com.myjeju.service.CommunityService;
import com.myjeju.vo.CommunityVO;

@Controller
public class CommunityController {
	
	@Autowired
	private CommunityService communityService;
	
	/**
	 * 자유게시판 리스트
	 */
	@RequestMapping(value = "/free_board.do", method=RequestMethod.GET )
	public ModelAndView free_board(String rpage) {
		ModelAndView mv = new ModelAndView();
		
		Commons commons = new Commons();
		HashMap map = commons.getPage(rpage, communityService, "Community");
		int start = (Integer)map.get("start");
		int end = (Integer)map.get("end");
		ArrayList<CommunityVO> list = communityService.getFreeList(start, end);
		
		mv.setViewName("community/free_board");
		mv.addObject("list", list);	
		mv.addObject("dbcount", map.get("dbCount"));
		mv.addObject("rpage", map.get("rpage"));
		mv.addObject("pagesize", map.get("pageSize"));		
		
		return mv;
	}
	
	/**
	 * 자유게시판 상세보기
	 */
	@RequestMapping(value = "/free_board_content.do", method=RequestMethod.GET)
	public ModelAndView free_board_content(String fid) {
		ModelAndView mv = new ModelAndView();
		
		CommunityVO vo = communityService.getFreeContent(fid);
		
		mv.addObject("vo", vo);
		mv.setViewName("community/free_board_content");
		
		return mv;
	}
	
	/**
	 * 자유게시판 글쓰기
	 */
	@RequestMapping(value="/free_board_write.do", method=RequestMethod.GET)
	public String free_board_write() {
		return "community/free_board_write";
	}
	
	/**
	 * 요청게시판 리스트
	 */
	@RequestMapping(value = "/request_board.do", method=RequestMethod.GET )
	public String request_board() {
		return "community/request_board";
	}
	
	/**
	 * 요청게시판 상세보기
	 */
	@RequestMapping(value = "/request_board_content.do", method=RequestMethod.GET)
	public String request_board_content() {
		return "community/request_board_content";
	}
	
	/**
	 * 요청게시판 글쓰기
	 */
	@RequestMapping(value="/request_board_write.do", method=RequestMethod.GET)
	public String request_board_write() {
		return "community/request_board_write";
	}
	
	/**
	 * 자유게시판 글쓰기 DB
	 */
	@RequestMapping(value = "/free_write_proc.do", method=RequestMethod.POST)
	public ModelAndView free_write_proc(HttpServletRequest request, CommunityVO vo, HttpSession session) throws Exception {
			ModelAndView mv = new ModelAndView();
			//파일 존재
			String root_path = request.getSession().getServletContext().getRealPath("/");
			String attach_path = "\\resources\\upload\\";
				
			//rfname 중복방지 처리			
			UUID uuid = UUID.randomUUID();
			System.out.println((vo.getFile1().getOriginalFilename()));
			System.out.println((uuid +"_"+vo.getFile1().getOriginalFilename()));	
				
			if (vo.getFile1().getOriginalFilename() != "") {
				//DB저장
				vo.setFfile(vo.getFile1().getOriginalFilename());
				vo.setFsfile(uuid+ "_"+vo.getFile1().getOriginalFilename());
			}
	
			//로그인 회원정보 가져오기
			String id = (String) session.getAttribute("session_id");
			vo.setId(id);
			//BoardDAO dao = new BoardDAO();
			boolean result = communityService.getFreeWrite(vo);
			
			//DB저장 완료 후 폴더에 저장하기
			if (result) {
				System.out.println(root_path + attach_path + uuid +"_"+vo.getFile1().getOriginalFilename());
				
				if (vo.getFile1().getOriginalFilename() != "") {
					 File file = new File(root_path + attach_path + uuid
					 +"_"+vo.getFile1().getOriginalFilename()); vo.getFile1().transferTo(file);
				}
			}			
	
		mv.setViewName("redirect:/free_board.do");
		return mv;
		
	}
	

}
