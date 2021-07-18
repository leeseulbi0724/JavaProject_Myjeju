package com.myspring.myjeju;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

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
import com.myjeju.vo.NoticeVO;

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
			ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
			if(search_text == null || search_text.equals("") || search_text.equals("null")) {
		  		list = adminService.getNoticeList(startnum,endnum);
		  		target = adminService.NoticePage(pagenum);
		  	} else {
		  		list = adminService.getNoticeList(startnum,endnum,search,search_text);
		  		target = adminService.NoticePage(pagenum,search,search_text);
		  	}
				
			int targetpage = 0;
			if(pageNumber != 1 ) {
				targetpage = (target-2) / 10 ;
				} else {
				targetpage = (target-1) / 10 ;
				}
			mv.setViewName("admin/adnotice");
			mv.addObject("list", list);
			mv.addObject("targetpage", String.valueOf(targetpage));
			mv.addObject("pageNumber", String.valueOf(pageNumber));
			mv.addObject("search", search);
			mv.addObject("search_text", search_text);
			
			return mv;
		}
		
		//관리자 공지사항 글쓰기
		@RequestMapping(value = "/adnotice_write.do", method=RequestMethod.GET)
		public String adnotice_write() {
			return "admin/adnotice_write";
		}
		
		//관리자 공지사항 글쓰기 DB
		@RequestMapping(value = "/adnotice_write_proc.do", method=RequestMethod.POST)
		public ModelAndView admin_notice_write_process(HttpServletRequest request, NoticeVO vo, HttpSession session) throws Exception {
			ModelAndView mv = new ModelAndView();
			System.out.print(vo.getNtitle());
			System.out.print(vo.getNcontent());
			//파일 존재
			String root_path = request.getSession().getServletContext().getRealPath("/");
			String attach_path = "\\resources\\upload\\";
			
			UUID uuid = UUID.randomUUID();
			//rfname 중복방지 처리			
			System.out.println((vo.getFile1().getOriginalFilename()));
			System.out.println((uuid +"_"+vo.getFile1().getOriginalFilename()));	
			
			if (vo.getFile1().getOriginalFilename() != "") {
				//DB저장
				vo.setNfile(vo.getFile1().getOriginalFilename());
				vo.setNsfile(uuid+ "_"+vo.getFile1().getOriginalFilename());
			}
			
			boolean result = adminService.getNoticeWrite(vo);
			
			//DB저장 완료 후 폴더에 저장하기
			if (result) {
				System.out.println(root_path + attach_path + uuid +"_"+vo.getFile1().getOriginalFilename());
				
				if (vo.getFile1().getOriginalFilename() != "") {
					File file = new File(root_path + attach_path + uuid
							+"_"+vo.getFile1().getOriginalFilename()); vo.getFile1().transferTo(file);
				}
			}			
			
			mv.setViewName("redirect:/adnotice.do");
			return mv;
			
		}
		
		//공지사항 상세보기
		@RequestMapping(value = "/adnotice_content.do", method=RequestMethod.GET)
		public ModelAndView adnotice_content(String nid) {
			ModelAndView mv = new ModelAndView();
			
			NoticeVO vo = adminService.getNoticeContent(nid);
			mv.addObject("vo", vo);
			mv.setViewName("admin/adnotice_content");
			
			return mv;
		}
		
		//공지사항 수정하기
		@RequestMapping(value = "/adnotice_update.do", method=RequestMethod.GET)
		public ModelAndView adnotice_update(String nid) {
			ModelAndView mv = new ModelAndView();
			
			NoticeVO vo = adminService.getNoticeContent(nid);
			mv.addObject("vo", vo);
			mv.setViewName("admin/adnotice_update");
			
			return mv;
		}
		
		//공지사항 수정 DB
		@RequestMapping(value = "/adnotice_update_proc.do", method=RequestMethod.POST)
		public ModelAndView adnotice_update_proc(HttpServletRequest request, NoticeVO vo) throws Exception {
			ModelAndView mv = new ModelAndView();
			String nid=vo.getNid();
			boolean result = false;
			if (vo.getFile1().getOriginalFilename() != "") {
				//파일 존재
				String root_path = request.getSession().getServletContext().getRealPath("/");
				String attach_path = "\\resources\\upload\\";
				System.out.print(root_path);
				
				//rfname 중복방지 처리			
				UUID uuid = UUID.randomUUID();
				System.out.println((vo.getFile1().getOriginalFilename()));
				System.out.println((uuid +"_"+vo.getFile1().getOriginalFilename()));	
					
				//DB저장
				vo.setNfile(vo.getFile1().getOriginalFilename());
				vo.setNsfile(uuid+ "_"+vo.getFile1().getOriginalFilename());
		
				//BoardDAO dao = new BoardDAO();
				String old_bsfile = adminService.getOldFile(vo.getNid());
				result = adminService.getFileYesUpdate(vo);
				
				//DB저장 완료 후 폴더에 저장하기
				if (result) {
					File file = new File(root_path+attach_path+vo.getNsfile());
					vo.getFile1().transferTo(file);
					
					//기존 upload 폴더에 존재하는 파일 삭제
					File old_file = new File(root_path+attach_path+old_bsfile);
					if ( old_file.exists()) {
						old_file.delete();
					}
				}
				
			} else {
				//파일 미포함 업데이트
				result = adminService.getFileNoUpdate(vo);
			}	
			
			
			mv.setViewName("redirect:/adnotice_content.do?nid="+nid);
			return mv;
		
	}
		
	//관리자 공지사항 삭제
	@RequestMapping(value = "/adnotice_delete_proc.do", method=RequestMethod.GET)
	public ModelAndView free_board_delete(HttpServletRequest request, String nid) {
		
		ModelAndView mv = new ModelAndView();
		
		String old_bsfile = adminService.getOldFile(nid);
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		File old_file = new File(root_path+attach_path+old_bsfile);
		if ( old_file.exists()) {
			old_file.delete();
		}
		
		boolean result = adminService.getNoticeDelete(nid);
		
		mv.setViewName("redirect:/adnotice.do");
		
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
		ArrayList<CommunityVO> list = new ArrayList<CommunityVO>();
		if(search_text == null || search_text.equals("") || search_text.equals("null")) {
	  		list = adminService.getRequestList(startnum,endnum);
	  		target = adminService.RequestPage(pagenum);
	  	} else {
	  		list = adminService.getRequestList(startnum,endnum,search,search_text);
	  		target = adminService.RequestPage(pagenum,search,search_text);
	  	}
			
		int targetpage = 0;
		if(pageNumber != 1 ) {
			targetpage = (target-2) / 10 ;
			} else {
			targetpage = (target-1) / 10 ;
			}
		mv.setViewName("admin/adrequest");
		mv.addObject("list", list);
		mv.addObject("targetpage", String.valueOf(targetpage));
		mv.addObject("pageNumber", String.valueOf(pageNumber));
		mv.addObject("search", search);
		mv.addObject("search_text", search_text);
		
		return mv;
	}
	
	//관리자 답변하기
	@RequestMapping (value = "/adrequest_re.do", method=RequestMethod.GET)
	public ModelAndView adrequest_re(String rid) {
		ModelAndView mv = new ModelAndView();
		
		CommunityVO vo = adminService.getRequestContent(rid);
		//답변내용 가져오기
		CommunityVO rvo = adminService.getRequestCommentResult(rid);
		
		mv.addObject("vo", vo);
		mv.addObject("rvo", rvo);
		mv.setViewName("admin/adrequest_re");
		return mv;
	}
	
	//관리자 답변하기
	@ResponseBody
	@RequestMapping(value="/adrequest_comment.do", method=RequestMethod.POST)
	public boolean adrequest_comment(HttpServletRequest request) {
		CommunityVO vo = new CommunityVO();
		vo.setRid(request.getParameter("rid"));
		vo.setRcontent(request.getParameter("textarea"));
		
		boolean result = adminService.getRequestComment(vo);
		
		return result;
		
	}
	
	//관리자 요청삭제하기
	@ResponseBody
	@RequestMapping(value="/admin_request_delete.do", method=RequestMethod.POST)
	public boolean admin_request_delete(HttpServletRequest request) {
		boolean result = adminService.getRequestDelete(request.getParameter("rid"));
		
		String old_bsfile = adminService.getOldFile(request.getParameter("rid"));
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		File old_file = new File(root_path+attach_path+old_bsfile);
		if ( old_file.exists()) {
			old_file.delete();
		}
		
		return result;
	}
}
