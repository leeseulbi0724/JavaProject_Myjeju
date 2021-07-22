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
	

	//���� ȭ�� ����
	@RequestMapping(value="/adminindex.do", method=RequestMethod.GET)
	public String main(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.setAttribute("session_id", "admin");
		
		return "/admin/adminindex";
	}
	//ȸ������ ����Ʈ
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
	//���Ұ��� ����Ʈ
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
		//���Ұ��� ��������
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
		
		//���� -> ���� ����ϱ�
		@RequestMapping(value="/adhouse_de_write.do", method=RequestMethod.GET)
		public ModelAndView adhouse_de_write(String hid) {
			ModelAndView mv = new ModelAndView();
			
			mv.addObject("hid", hid);
			mv.setViewName("admin/adhouse_de_write");
			
			return mv;
		}
		
		//���� --> ���� ��� DB
		@RequestMapping(value = "/adhouse_de_write_proc.do", method=RequestMethod.POST)
		public ModelAndView adhouse_de_write(MultipartHttpServletRequest request, @RequestParam("file") MultipartFile[] file) throws Exception {
			ModelAndView mv = new ModelAndView();			
			
			String root_path = request.getSession().getServletContext().getRealPath("/");
			System.out.print(root_path);
			String attach_path = "\\resources\\images\\house\\house_detail\\";
			String fileOriginName = ""; 
			String fileMultiName = "";
			String fileMultiUplodaName= "";
			
			UUID uuid = UUID.randomUUID();
			for(int i=0; i<file.length; i++) { 
				fileOriginName = file[i].getOriginalFilename(); 
				System.out.println("���� ���ϸ� : "+fileOriginName); 
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
		
		//���� -> ���� �����ϱ�
		@RequestMapping(value="/adhouse_de_update.do", method=RequestMethod.GET)
		public ModelAndView adhouse_de_update(String hdid) {
			ModelAndView mv = new ModelAndView();
			HDetailVO vo = adminService.gethousedecontent(hdid);				
			String img[] = vo.getHd_img().split(",");	
			String file[] = vo.getHd_file().split(",");
			ArrayList<HDetailVO> list = new ArrayList<HDetailVO>();
			for (int i=0; i<img.length; i++) {
				HDetailVO hvo = new HDetailVO();
				hvo.setHd_img(img[i]);
				hvo.setHd_file(file[i]);
				
				list.add(hvo);
				
			}
			
			mv.setViewName("admin/adhouse_de_update");
			mv.addObject("vo", vo);
			mv.addObject("list", list);
			return mv;
		}
		
		//���� --> ���� �����ϱ� DB
		@RequestMapping(value="/adhouse_de_update_proc.do", method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView adhouse_de_update_proc(MultipartHttpServletRequest request, @RequestParam("file") MultipartFile[] file) throws Exception {
			ModelAndView mv = new ModelAndView();
			
			System.out.println("�����̸�" + request.getParameter("hd_img"));
			System.out.print("���ϰ��" + request.getParameter("hd_file"));
			
			String fileOldName=request.getParameter("hd_img");
			String fileOldRoot = request.getParameter("hd_file");
			
			String root_path = request.getSession().getServletContext().getRealPath("/");
			System.out.print(root_path);
			String attach_path = "\\resources\\images\\house\\house_detail\\";
			String fileOriginName = ""; 
			String fileMultiName = "";
			String fileMultiUplodaName= "";
			
			UUID uuid = UUID.randomUUID();
			
			System.out.print(file.length);

			for(int i=0; i<file.length; i++) { 
				fileOriginName = file[i].getOriginalFilename(); 
				System.out.println("���� ���ϸ� : "+fileOriginName); 
				File f = new File(root_path + attach_path + uuid +"_"+ fileOriginName); 
				file[i].transferTo(f);
				if (fileOriginName != "") {
					if(i==0) { 
						fileMultiName += fileOriginName; 
						fileMultiUplodaName += uuid +"_"+fileOriginName;
					} else { 
						fileMultiName += ","+fileOriginName; 
						fileMultiUplodaName += "," + uuid +"_"+fileOriginName;
					} 
				}
			}
			
			String old_name = request.getParameter("old_name");
			String old[] = old_name.split(",");
			for (int i=0; i<old.length; i++) {
				File old_file = new File(root_path+attach_path+old[i]);
				if ( old_file.exists()) {
					old_file.delete();
				}
			}

			HDetailVO vo = new HDetailVO();
			vo.setHd_img(fileOldName+fileMultiName);
			vo.setHd_file(fileOldRoot+fileMultiUplodaName);
			vo.setHid(request.getParameter("hid"));
			vo.setHdid(request.getParameter("hdid"));
			vo.setHd_name(request.getParameter("hd_name"));
			vo.setHd_price(Integer.parseInt(request.getParameter("hd_price")));
			vo.setHd_people(Integer.parseInt(request.getParameter("hd_people")));
			
			boolean result = adminService.getHdetailUpdate(vo);
			
			mv.setViewName("redirect:/adhouse_de_content.do?hdid="+vo.getHdid());
			return mv;
		}
		
		//���� ����
		@ResponseBody
		@RequestMapping(value = "/adhouse_de_delete.do", method=RequestMethod.POST)
		public boolean adhous_de_delete(HttpServletRequest request) {
			String hdid = request.getParameter("hdid");			
			String root_path = request.getSession().getServletContext().getRealPath("/");
			String attach_path = "\\resources\\images\\house\\house_detail\\";
			
			HDetailVO vo = adminService.gethousedecontent(hdid);
			
			String old_name = vo.getHd_file();
			String old[] = old_name.split(",");
			for (int i=0; i<old.length; i++) {
				File old_file = new File(root_path+attach_path+old[i]);
				if ( old_file.exists()) {
					old_file.delete();
				}
			}
			
			boolean result = adminService.getHdetailDelete(hdid);
			
			return result;
		}
		
		
		
		//���������� ����Ʈ
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
		//������ ���
		@RequestMapping(value="/adfood_write.do", method=RequestMethod.GET)
		public String adfood_write() {
			return "admin/adfood_write";
		}
		//������ ��� DB
		@RequestMapping(value="/adfood_write_proc.do", method={RequestMethod.GET,RequestMethod.POST})
		public ModelAndView adfood_write_proc(MultipartHttpServletRequest request, @RequestParam("file") MultipartFile[] file) throws Exception {
			ModelAndView mv = new ModelAndView();			
			
			String root_path = request.getSession().getServletContext().getRealPath("/");
			String attach_path = "\\resources\\images\\food\\food_detail\\";
			String fileOriginName = ""; 
			String fileMultiName = "";
			String fileMultiUplodaName= "";
			
			UUID uuid = UUID.randomUUID();
			for(int i=0; i<file.length; i++) { 
				fileOriginName = file[i].getOriginalFilename(); 
				System.out.println("���� ���ϸ� : "+fileOriginName); 
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
			FoodVO vo = new FoodVO();
			vo.setF_file(fileMultiName);
			vo.setF_sfile(fileMultiUplodaName);
			vo.setF_name(request.getParameter("f_name"));
			vo.setF_tag(request.getParameter("f_tag"));
			vo.setF_infor(request.getParameter("f_infor"));
			vo.setF_infor2(request.getParameter("f_infor2"));
			vo.setF_addr1(request.getParameter("f_addr1"));
			vo.setF_addr2(request.getParameter("f_addr2"));
			vo.setF_addr(vo.getF_addr1()+" "+vo.getF_addr2());
			vo.setF_vpoint(request.getParameter("f_vpoint"));
			vo.setF_hpoint(request.getParameter("f_hpoint"));
			vo.setF_hp(request.getParameter("f_hp"));
			
			boolean result = adminService.getFoodUpload(vo);
			
			mv.setViewName("redirect:/adfood.do");
			return mv;
			
		}
		
		//������ ��
		@RequestMapping(value="/adfood_content.do",method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView adfood_content(String fid) {
			ModelAndView mv = new ModelAndView();
			FoodVO vo = adminService.getFoodcontent(fid);
			String img[] = vo.getF_sfile().split(",");		
			
			mv.addObject("vo", vo);
			mv.addObject("img", img);
			mv.setViewName("admin/adfood_content");
			return mv;
		}
		
		//����������
		@RequestMapping(value="/adfood_update.do",method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView adfood_update(String fid) {
			ModelAndView mv = new ModelAndView();
			FoodVO vo = adminService.getFoodcontent(fid);
			String file[] = vo.getF_file().split(",");
			String sfile[] = vo.getF_sfile().split(",");	
			ArrayList<FoodVO> list = new ArrayList<FoodVO>();
			for (int i=0; i<sfile.length; i++) {
				FoodVO fvo = new FoodVO();
				fvo.setF_file(file[i]);
				fvo.setF_sfile(sfile[i]);				
				list.add(fvo);				
			}			
			mv.addObject("vo", vo);
			mv.addObject("list", list);
			mv.setViewName("admin/adfood_update");
			return mv;
		}
		
		//������ �����ϱ� DB
		@RequestMapping(value="/adfood_update_proc.do", method= {RequestMethod.GET,RequestMethod.POST})
		public ModelAndView adfood_update_proc(MultipartHttpServletRequest request, @RequestParam("file") MultipartFile[] file) throws Exception {
			ModelAndView mv = new ModelAndView();
			
			System.out.println("�����̸�" + request.getParameter("f_file"));
			System.out.print("���ϰ��" + request.getParameter("f_sfile"));
			
			String fileOldName=request.getParameter("f_file");
			String fileOldRoot = request.getParameter("f_sfile");
			
			String root_path = request.getSession().getServletContext().getRealPath("/");
			System.out.print(root_path);
			String attach_path = "\\resources\\images\\food\\food_detail\\";
			String fileOriginName = ""; 
			String fileMultiName = "";
			String fileMultiUplodaName= "";
			
			UUID uuid = UUID.randomUUID();
			
			System.out.print(file.length);

			for(int i=0; i<file.length; i++) { 
				fileOriginName = file[i].getOriginalFilename(); 
				System.out.println("���� ���ϸ� : "+fileOriginName); 
				File f = new File(root_path + attach_path + uuid +"_"+ fileOriginName); 
				file[i].transferTo(f);
				if (fileOriginName != "") {
					if(i==0) { 
						fileMultiName += fileOriginName; 
						fileMultiUplodaName += uuid +"_"+fileOriginName;
					} else { 
						fileMultiName += ","+fileOriginName; 
						fileMultiUplodaName += "," + uuid +"_"+fileOriginName;
					} 
				}
			}
			
			String old_name = request.getParameter("old_name");
			String old[] = old_name.split(",");
			for (int i=0; i<old.length; i++) {
				File old_file = new File(root_path+attach_path+old[i]);
				if ( old_file.exists()) {
					old_file.delete();
				}
			}

			FoodVO vo = new FoodVO();
			vo.setF_file(fileOldName+fileMultiName);
			vo.setF_sfile(fileOldRoot+fileMultiUplodaName);
			vo.setF_name(request.getParameter("f_name"));
			vo.setF_tag(request.getParameter("f_tag"));
			vo.setF_infor(request.getParameter("f_infor"));
			vo.setF_infor2(request.getParameter("f_infor2"));
			vo.setF_addr(request.getParameter("f_addr"));
			vo.setF_vpoint(request.getParameter("f_vpoint"));
			vo.setF_hpoint(request.getParameter("f_hpoint"));
			vo.setF_hp(request.getParameter("f_hp"));
			vo.setFid(request.getParameter("fid"));
			
			boolean result = adminService.getFoodUpdate(vo);
			
			mv.setViewName("redirect:/adfood_content.do?fid="+vo.getFid());
			return mv;
		}
		//������ ����
		@ResponseBody
		@RequestMapping(value = "/adfood_delete.do", method=RequestMethod.POST)
		public boolean adfood_delete(HttpServletRequest request) {
			String fid = request.getParameter("fid");			
			String root_path = request.getSession().getServletContext().getRealPath("/");
			String attach_path = "\\resources\\images\\food\\food_detail\\";
			
			FoodVO vo = adminService.getFoodcontent(fid);
			
			String old_name = vo.getF_sfile();
			String old[] = old_name.split(",");
			for (int i=0; i<old.length; i++) {
				File old_file = new File(root_path+attach_path+old[i]);
				if ( old_file.exists()) {
					old_file.delete();
				}
			}
			
			boolean result = adminService.getFoodDelete(fid);
			
			return result;
		}
		
		
		//���������� ����Ʈ
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
	
	
	// ������ �Խ���
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
	
	//������ �Խ��� �󼼺��� 
	@RequestMapping(value="/adboard_content.do",method= RequestMethod.GET)
	public ModelAndView adboard_content(String fid) {		
		ModelAndView mv = new ModelAndView();
		
		//�Խù� ����
		CommunityVO vo = communityService.getFreeContent(fid);		
		//��� ����
		ArrayList<CommunityVO> list = communityService.getFreeComment(fid);		
		
		mv.addObject("vo", vo);
		mv.addObject("list", list);
		mv.setViewName("admin/adboard_content");
		
		return mv;
				
	}
	
	//������ �Խñ� ����
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
	
	// ������ ��������
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
		
		//������ �������� �۾���
		@RequestMapping(value = "/adnotice_write.do", method=RequestMethod.GET)
		public String adnotice_write() {
			return "admin/adnotice_write";
		}
		
		//������ �������� �۾��� DB
		@RequestMapping(value = "/adnotice_write_proc.do", method=RequestMethod.POST)
		public ModelAndView admin_notice_write_process(HttpServletRequest request, NoticeVO vo, HttpSession session) throws Exception {
			ModelAndView mv = new ModelAndView();
			System.out.print(vo.getNtitle());
			System.out.print(vo.getNcontent());
			//���� ����
			String root_path = request.getSession().getServletContext().getRealPath("/");
			String attach_path = "\\resources\\upload\\";
			
			UUID uuid = UUID.randomUUID();
			//rfname �ߺ����� ó��			
			System.out.println((vo.getFile1().getOriginalFilename()));
			System.out.println((uuid +"_"+vo.getFile1().getOriginalFilename()));	
			
			if (vo.getFile1().getOriginalFilename() != "") {
				//DB����
				vo.setNfile(vo.getFile1().getOriginalFilename());
				vo.setNsfile(uuid+ "_"+vo.getFile1().getOriginalFilename());
			}
			
			boolean result = adminService.getNoticeWrite(vo);
			
			//DB���� �Ϸ� �� ������ �����ϱ�
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
		
		//�������� �󼼺���
		@RequestMapping(value = "/adnotice_content.do", method=RequestMethod.GET)
		public ModelAndView adnotice_content(String nid) {
			ModelAndView mv = new ModelAndView();
			
			NoticeVO vo = adminService.getNoticeContent(nid);
			mv.addObject("vo", vo);
			mv.setViewName("admin/adnotice_content");
			
			return mv;
		}
		
		//�������� �����ϱ�
		@RequestMapping(value = "/adnotice_update.do", method=RequestMethod.GET)
		public ModelAndView adnotice_update(String nid) {
			ModelAndView mv = new ModelAndView();
			
			NoticeVO vo = adminService.getNoticeContent(nid);
			mv.addObject("vo", vo);
			mv.setViewName("admin/adnotice_update");
			
			return mv;
		}
		
		//�������� ���� DB
		@RequestMapping(value = "/adnotice_update_proc.do", method=RequestMethod.POST)
		public ModelAndView adnotice_update_proc(HttpServletRequest request, NoticeVO vo) throws Exception {
			ModelAndView mv = new ModelAndView();
			String nid=vo.getNid();
			boolean result = false;
			if (vo.getFile1().getOriginalFilename() != "") {
				//���� ����
				String root_path = request.getSession().getServletContext().getRealPath("/");
				String attach_path = "\\resources\\upload\\";
				System.out.print(root_path);
				
				//rfname �ߺ����� ó��			
				UUID uuid = UUID.randomUUID();
				System.out.println((vo.getFile1().getOriginalFilename()));
				System.out.println((uuid +"_"+vo.getFile1().getOriginalFilename()));	
					
				//DB����
				vo.setNfile(vo.getFile1().getOriginalFilename());
				vo.setNsfile(uuid+ "_"+vo.getFile1().getOriginalFilename());
		
				//BoardDAO dao = new BoardDAO();
				String old_bsfile = adminService.getOldFile(vo.getNid());
				result = adminService.getFileYesUpdate(vo);
				
				//DB���� �Ϸ� �� ������ �����ϱ�
				if (result) {
					File file = new File(root_path+attach_path+vo.getNsfile());
					vo.getFile1().transferTo(file);
					
					//���� upload ������ �����ϴ� ���� ����
					File old_file = new File(root_path+attach_path+old_bsfile);
					if ( old_file.exists()) {
						old_file.delete();
					}
				}
				
			} else {
				//���� ������ ������Ʈ
				result = adminService.getFileNoUpdate(vo);
			}	
			
			
			mv.setViewName("redirect:/adnotice_content.do?nid="+nid);
			return mv;
		
	}
		
	//������ �������� ����
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
		
		
	// ������ ��û
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
	
	//������ �亯�ϱ�
	@RequestMapping (value = "/adrequest_re.do", method=RequestMethod.GET)
	public ModelAndView adrequest_re(String rid) {
		ModelAndView mv = new ModelAndView();
		
		CommunityVO vo = adminService.getRequestContent(rid);
		//�亯���� ��������
		CommunityVO rvo = adminService.getRequestCommentResult(rid);
		
		mv.addObject("vo", vo);
		mv.addObject("rvo", rvo);
		mv.setViewName("admin/adrequest_re");
		return mv;
	}
	
	//������ �亯�ϱ�
	@ResponseBody
	@RequestMapping(value="/adrequest_comment.do", method=RequestMethod.POST)
	public boolean adrequest_comment(HttpServletRequest request) {
		CommunityVO vo = new CommunityVO();
		vo.setRid(request.getParameter("rid"));
		vo.setRcontent(request.getParameter("textarea"));
		
		boolean result = adminService.getRequestComment(vo);
		
		return result;
		
	}
	
	//������ ��û�����ϱ�
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
	
	// ����� ����� �����
	
	// ������ �����â
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
	
	//����� �󼼺���
	@RequestMapping(value = "/adstore_content.do", method=RequestMethod.GET)
	public ModelAndView adstore_content(String sid) {
		ModelAndView mv = new ModelAndView();
		
		StoreVO vo = adminService.getStoreContent(sid);
		
		mv.setViewName("admin/adstore_content");
		mv.addObject("vo", vo);
		
		return mv;
	}
	
	//����� ���� ȭ��
	@RequestMapping(value = "/adstore_update.do", method=RequestMethod.GET)
	public ModelAndView adstore_update(String sid) {
		ModelAndView mv = new ModelAndView();
		
		StoreVO vo = adminService.getStoreContent(sid);
		
		mv.addObject("vo", vo);
		mv.setViewName("admin/adstore_update");
		
		return mv;
	}
	
	//����� ���� ó��
	@RequestMapping(value = "/adstore_update_proc.do", method=RequestMethod.POST)
	public ModelAndView adstore_update_proc(HttpServletRequest request, StoreVO vo) throws Exception {
		ModelAndView mv = new ModelAndView();
		String sid = vo.getSid();
		
		boolean result = false;
		
		if (vo.getSfile1().getOriginalFilename() != "") {
			//���� ����
			String root_path = request.getSession().getServletContext().getRealPath("/");
			String attach_path = "\\resources\\upload\\";
			//System.out.print(root_path);
			
			//rfname �ߺ����� ó��			
			UUID uuid = UUID.randomUUID();
			//System.out.println((vo.getSfile1().getOriginalFilename()));
			//System.out.println((uuid +"_"+vo.getSfile1().getOriginalFilename()));	
				
			//DB����
			vo.setS_image(vo.getSfile1().getOriginalFilename());
			vo.setS_sfile(uuid + "_" + vo.getSfile1().getOriginalFilename());
			
			vo.setS_content(vo.getSfile2().getOriginalFilename());
			vo.setS_ssfile(uuid + "_" + vo.getSfile2().getOriginalFilename());
	
			//BoardDAO dao = new BoardDAO();
			//String old_bsfile = adminService.getOldFile(vo.getSid());
			String old_sfile1 = adminService.getStoreOldFile(vo.getSid());
			
			result = adminService.getStoreUpdateFile(vo);
			
			//DB���� �Ϸ� �� ������ �����ϱ�
			if (result) {
				File file1 = new File(root_path + attach_path + vo.getS_sfile());
				vo.getSfile1().transferTo(file1);
				
				File file2 = new File(root_path + attach_path + vo.getS_ssfile());
				vo.getSfile2().transferTo(file2);
				
				//���� upload ������ �����ϴ� ���� ����
				File old_file = new File(root_path + attach_path + old_sfile1);
				if ( old_file.exists()) {
					old_file.delete();
				}
			}
			
		} else {
			//���� ������ ������Ʈ
			result = adminService.getStoreUpdateNoFile(vo);
		}
		mv.setViewName("redirect:/adstore_content.do?sid=" + sid);
		return mv;
	}
	
	

	//����� ��ǰ��� ȭ��
	@RequestMapping(value = "/adstore_write.do", method = RequestMethod.GET)
	public String adstore_write() {
		return "admin/adstore_write";
	}
	

	//store_write_proc.do : ����� ��ǰ ��� ó��
	@RequestMapping(value = "/adstore_write_proc.do", method = RequestMethod.POST)
	public ModelAndView adstore_write_proc(StoreVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		String root_path = "";
		String attach_path = "";
		
		if(vo.getSfile1().getSize() != 0) {
			// 1. ���� ���� ��ġ
			root_path = request.getSession().getServletContext().getRealPath("/");
			attach_path = "\\resources\\upload\\";
			
			// 2. ���� �̸� --> vo�� ����
			//rfname �ߺ����� ó��
			UUID uuid = UUID.randomUUID();
			
			//DB����
			vo.setS_image(vo.getSfile1().getOriginalFilename());
			vo.setS_sfile(uuid + "_" + vo.getSfile1().getOriginalFilename());
			
			vo.setS_content(vo.getSfile2().getOriginalFilename());
			vo.setS_ssfile(uuid + "_" + vo.getSfile2().getOriginalFilename());
		
		}
			
		// 3. DB����
		boolean result = adminService.getStoreInsertResult(vo);
		
		if(result) {
			
			// 4. DB ���� ���� --> upload ������ ����			//DB���� �Ϸ� �� ������ �����ϱ�
			File file = new File(root_path + attach_path + vo.getS_sfile());
			vo.getSfile1().transferTo(file);
			
			File file2 = new File(root_path + attach_path + vo.getS_ssfile());
			vo.getSfile2().transferTo(file2);
			
			mv.setViewName("redirect:/adstore.do");
		}
			
		return mv;
	}
	
	
	//������ ��ǰ ����
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


