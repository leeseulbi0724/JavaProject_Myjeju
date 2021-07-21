package com.myspring.myjeju;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.service.AdminService;
import com.myjeju.service.CommunityService;
import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.FoodVO;
import com.myjeju.vo.HDetailVO;
import com.myjeju.vo.HouseVO;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.NoticeVO;
import com.myjeju.vo.StoreVO;
import com.myjeju.vo.TravelVO;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CommunityService communityService;

	//메인 화면 가기
	@RequestMapping(value="/adminindex.do", method=RequestMethod.GET)
	public String main(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.setAttribute("session_id", "admin");
		
		return "/admin/adminindex";
	}
	//회원관리 리스트
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
	//숙소관리 리스트
		@RequestMapping(value="/adhouse.do",method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView tohouse(String pnum, String search, String search_text) {
			ModelAndView mv = new ModelAndView();
			
			int pageNumber = 1;
			 
			if(pnum != null) {
		  		pageNumber = Integer.parseInt(pnum);
		  	}
			
			int startnum = ((pageNumber-1)*10) +1;
			int endnum = pageNumber*10; 
			int pagenum = (pageNumber -1) * 10;
			int target = 0;
			ArrayList<HouseVO> list = new ArrayList<HouseVO>();
			if(search_text == null || search_text.equals("") || search_text.equals("null")) {
		  		list = adminService.getlisthouse(startnum,endnum);
		  		target = adminService.targethousePage(pagenum);
		  	} else {
		  		list = adminService.getlisthouse(startnum,endnum,search,search_text);
		  		target = adminService.targethousePage(pagenum,search,search_text);
		  	}
				
			int targetpage = 0;
			if(pageNumber != 1 ) {
				targetpage = (target-2) / 10 ;
				} else {
				targetpage = (target-1) / 10 ;
				}
			mv.setViewName("admin/adhouse");
			mv.addObject("list", list);
			mv.addObject("targetpage", String.valueOf(targetpage));
			mv.addObject("pageNumber", String.valueOf(pageNumber));
			mv.addObject("search", search);
			mv.addObject("search_text", search_text);
			
			return mv;
		}
		//숙소관리 상세페이지
		@RequestMapping(value="/adhouse_content.do",method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView tohouse(String hid) {
			ModelAndView mv = new ModelAndView();
			
			HouseVO vo = new HouseVO();
			vo = adminService.gethouse(hid);
			mv.setViewName("admin/adhouse_content");
			mv.addObject("vo", vo);
			mv.addObject("hid", hid);
			return mv;
		}
		
		//숙소 -> 객실 등록하기
		@RequestMapping(value="/adhouse_de_write.do", method=RequestMethod.GET)
		public ModelAndView adhouse_de_write(String hid) {
			ModelAndView mv = new ModelAndView();
			
			mv.addObject("hid", hid);
			mv.setViewName("admin/adhouse_de_write");
			
			return mv;
		}
		
		//숙소 --> 객실 등록 DB
		@RequestMapping(value = "/adhouse_de_write_proc.do", method=RequestMethod.POST)
		public ModelAndView adhouse_de_write(MultipartHttpServletRequest request, @RequestParam("file") MultipartFile[] file) throws Exception {
			ModelAndView mv = new ModelAndView();			
			
			String root_path = request.getSession().getServletContext().getRealPath("/");
			System.out.print(root_path);
			String attach_path = "\\resources\\upload\\";
			String fileOriginName = ""; 
			String fileMultiName = "";
			String fileMultiUplodaName= "";
			
			UUID uuid = UUID.randomUUID();
			for(int i=0; i<file.length; i++) { 
				fileOriginName = file[i].getOriginalFilename(); 
				System.out.println("기존 파일명 : "+fileOriginName); 
				File f = new File(root_path + attach_path + uuid +"_"+ fileOriginName); 
				file[i].transferTo(f);
				if(i==0) { 
					fileMultiName += fileOriginName; 
					fileMultiUplodaName += uuid +"_"+fileOriginName;
				} else { 
					fileMultiName += ","+fileOriginName; 
					fileMultiUplodaName += "," + uuid +"_"+fileOriginName;
					} 
			}
			HDetailVO vo = new HDetailVO();
			vo.setHd_img(fileMultiName);
			vo.setHd_file(fileMultiUplodaName);
			vo.setHid(request.getParameter("hid"));
			vo.setHd_name(request.getParameter("hd_name"));
			vo.setHd_price(Integer.parseInt(request.getParameter("hd_price")));
			vo.setHd_people(Integer.parseInt(request.getParameter("hd_people")));
			
			boolean result = adminService.getHdetailUpload(vo);
			
			mv.setViewName("redirect:/adhouse_de.do?hid="+request.getParameter("hid"));
			return mv;
			
		}
		
		
		//맛집관리 리스트
		@RequestMapping(value="/adfood.do",method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView tofood(String pnum, String search, String search_text) {
			ModelAndView mv = new ModelAndView();
			
			int pageNumber = 1;
			 
			if(pnum != null) {
		  		pageNumber = Integer.parseInt(pnum);
		  	}
			
			int startnum = ((pageNumber-1)*10) +1;
			int endnum = pageNumber*10; 
			int pagenum = (pageNumber -1) * 10;
			int target = 0;
			ArrayList<FoodVO> list = new ArrayList<FoodVO>();
			if(search_text == null || search_text.equals("") || search_text.equals("null")) {
		  		list = adminService.getlistfood(startnum,endnum);
		  		target = adminService.targetfoodPage(pagenum);
		  	} else {
		  		list = adminService.getlistfood(startnum,endnum,search,search_text);
		  		target = adminService.targetfoodPage(pagenum,search,search_text);
		  	}
				
			int targetpage = 0;
			if(pageNumber != 1 ) {
				targetpage = (target-2) / 10 ;
				} else {
				targetpage = (target-1) / 10 ;
				}
			mv.setViewName("admin/adfood");
			mv.addObject("list", list);
			mv.addObject("targetpage", String.valueOf(targetpage));
			mv.addObject("pageNumber", String.valueOf(pageNumber));
			mv.addObject("search", search);
			mv.addObject("search_text", search_text);
			
			return mv;
		}
		//여행지관리 리스트
		@RequestMapping(value="/adtravel.do",method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView totravel(String pnum, String search, String search_text) {
			ModelAndView mv = new ModelAndView();
			
			int pageNumber = 1;
			 
			if(pnum != null) {
		  		pageNumber = Integer.parseInt(pnum);
		  	}
			
			int startnum = ((pageNumber-1)*10) +1;
			int endnum = pageNumber*10; 
			int pagenum = (pageNumber -1) * 10;
			int target = 0;
			ArrayList<TravelVO> list = new ArrayList<TravelVO>();
			if(search_text == null || search_text.equals("") || search_text.equals("null")) {
		  		list = adminService.getlisttravel(startnum,endnum);
		  		target = adminService.targettravelPage(pagenum);
		  	} else {
		  		list = adminService.getlisttravel(startnum,endnum,search,search_text);
		  		target = adminService.targettravelPage(pagenum,search,search_text);
		  	}
				
			int targetpage = 0;
			if(pageNumber != 1 ) {
				targetpage = (target-2) / 10 ;
				} else {
				targetpage = (target-1) / 10 ;
				}
			mv.setViewName("admin/adtravel");
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
	
	// 스토어 스토어 스토어
	
	// 관리자 스토어창
	@RequestMapping(value="/adstore.do",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tostore(String pnum, String search, String search_text) {
		ModelAndView mv = new ModelAndView();
		
		int pageNumber = 1;
		 
		if(pnum != null) {
	  		pageNumber = Integer.parseInt(pnum);
	  	}
		int startnum = ((pageNumber-1)*10) +1;
		int endnum = pageNumber*10; 
		int pagenum = (pageNumber -1) * 10;
		int target = 0;
		ArrayList<StoreVO> list = new ArrayList<StoreVO>();
		if(search_text == null || search_text.equals("") || search_text.equals("null")) {
	  		list = adminService.getStoreList(startnum, endnum);
	  		target = adminService.StorePage(pagenum);
	  	} else {
	  		list = adminService.getStoreList(startnum,endnum,search,search_text);
	  		target = adminService.StorePage(pagenum,search,search_text);
	  	}
			
		int targetpage = 0;
		if(pageNumber != 1 ) {
			targetpage = (target-2) / 10 ;
			} else {
			targetpage = (target-1) / 10 ;
			}
		mv.setViewName("admin/adstore");
		mv.addObject("list", list);
		mv.addObject("targetpage", String.valueOf(targetpage));
		mv.addObject("pageNumber", String.valueOf(pageNumber));
		mv.addObject("search", search);
		mv.addObject("search_text", search_text);
		
		return mv;
	}
	
	//스토어 상세보기
	@RequestMapping(value = "/adstore_content.do", method=RequestMethod.GET)
	public ModelAndView adstore_content(String sid) {
		ModelAndView mv = new ModelAndView();
		
		StoreVO vo = adminService.getStoreContent(sid);
		
		mv.setViewName("admin/adstore_content");
		mv.addObject("vo", vo);
		
		return mv;
	}
	
	//스토어 수정 화면
	@RequestMapping(value = "/adstore_update.do", method=RequestMethod.GET)
	public ModelAndView adstore_update(String sid) {
		ModelAndView mv = new ModelAndView();
		
		StoreVO vo = adminService.getStoreContent(sid);
		
		mv.addObject("vo", vo);
		mv.setViewName("admin/adstore_update");
		
		return mv;
	}
	
	//스토어 수정 처리
	@RequestMapping(value = "/adstore_update_proc.do", method=RequestMethod.POST)
	public ModelAndView adstore_update_proc(HttpServletRequest request, StoreVO vo) throws Exception {
		ModelAndView mv = new ModelAndView();
		String sid = vo.getSid();
		
		boolean result = false;
		
		if (vo.getSfile1().getOriginalFilename() != "") {
			//파일 존재
			String root_path = request.getSession().getServletContext().getRealPath("/");
			String attach_path = "\\resources\\upload\\";
			//System.out.print(root_path);
			
			//rfname 중복방지 처리			
			UUID uuid = UUID.randomUUID();
			//System.out.println((vo.getSfile1().getOriginalFilename()));
			//System.out.println((uuid +"_"+vo.getSfile1().getOriginalFilename()));	
				
			//DB저장
			vo.setS_image(vo.getSfile1().getOriginalFilename());
			vo.setS_sfile(uuid + "_" + vo.getSfile1().getOriginalFilename());
			
			vo.setS_content(vo.getSfile2().getOriginalFilename());
			vo.setS_ssfile(uuid + "_" + vo.getSfile2().getOriginalFilename());
	
			//BoardDAO dao = new BoardDAO();
			//String old_bsfile = adminService.getOldFile(vo.getSid());
			String old_sfile1 = adminService.getStoreOldFile(vo.getSid());
			
			result = adminService.getStoreUpdateFile(vo);
			
			//DB저장 완료 후 폴더에 저장하기
			if (result) {
				File file1 = new File(root_path + attach_path + vo.getS_sfile());
				vo.getSfile1().transferTo(file1);
				
				File file2 = new File(root_path + attach_path + vo.getS_ssfile());
				vo.getSfile2().transferTo(file2);
				
				//기존 upload 폴더에 존재하는 파일 삭제
				File old_file = new File(root_path + attach_path + old_sfile1);
				if ( old_file.exists()) {
					old_file.delete();
				}
			}
			
		} else {
			//파일 미포함 업데이트
			result = adminService.getStoreUpdateNoFile(vo);
		}
		mv.setViewName("redirect:/adstore_content.do?sid=" + sid);
		return mv;
	}
	
	

	//스토어 상품등록 화면
	@RequestMapping(value = "/adstore_write.do", method = RequestMethod.GET)
	public String adstore_write() {
		return "admin/adstore_write";
	}
	

	//store_write_proc.do : 스토어 상품 등록 처리
	@RequestMapping(value = "/adstore_write_proc.do", method = RequestMethod.POST)
	public ModelAndView adstore_write_proc(StoreVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		String root_path = "";
		String attach_path = "";
		
		if(vo.getSfile1().getSize() != 0) {
			// 1. 파일 저장 위치
			root_path = request.getSession().getServletContext().getRealPath("/");
			attach_path = "\\resources\\upload\\";
			
			// 2. 파일 이름 --> vo에 저장
			//rfname 중복방지 처리
			UUID uuid = UUID.randomUUID();
			
			//DB저장
			vo.setS_image(vo.getSfile1().getOriginalFilename());
			vo.setS_sfile(uuid + "_" + vo.getSfile1().getOriginalFilename());
			
			vo.setS_content(vo.getSfile2().getOriginalFilename());
			vo.setS_ssfile(uuid + "_" + vo.getSfile2().getOriginalFilename());
		
		}
			
		// 3. DB연동
		boolean result = adminService.getStoreInsertResult(vo);
		
		if(result) {
			
			// 4. DB 연동 성공 --> upload 폴더에 저장			//DB저장 완료 후 폴더에 저장하기
			File file = new File(root_path + attach_path + vo.getS_sfile());
			vo.getSfile1().transferTo(file);
			
			File file2 = new File(root_path + attach_path + vo.getS_ssfile());
			vo.getSfile2().transferTo(file2);
			
			mv.setViewName("redirect:/adstore.do");
		}
			
		return mv;
	}
	
	
	//관리자 상품 삭제
	@RequestMapping(value = "/adstore_delete_proc.do", method=RequestMethod.GET)
	public ModelAndView adstore_delete_proc(HttpServletRequest request, String sid) {
		ModelAndView mv = new ModelAndView();
		
		//String old_bsfile = adminService.getOldFile(nid);
		String old_sfile = adminService.getStoreOldFile(sid);
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		File old_file = new File(root_path + attach_path + old_sfile);
		
		if ( old_file.exists()) {
			old_file.delete();
		}
		
		//boolean result = adminService.getNoticeDelete(nid);
		boolean result = adminService.getStoreDelete(sid);
		
		if(result) {
			mv.setViewName("redirect:/adstore.do");
		}
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
}


