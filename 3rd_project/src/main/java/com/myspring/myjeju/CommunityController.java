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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.commons.Commons;
import com.myjeju.service.AdminService;
import com.myjeju.service.CommunityService;
import com.myjeju.service.NoticeService;
import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.NoticeVO;

@Controller
public class CommunityController {
	
	@Autowired
	private CommunityService communityService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private AdminService adminService;
	
	/**
	 * �����Խ��� ����Ʈ
	 */
	@RequestMapping(value = "/free_board.do", method=RequestMethod.GET )
	public ModelAndView free_board(String rpage) {
		ModelAndView mv = new ModelAndView();
		
		Commons commons = new Commons();
		HashMap map = commons.getPage(rpage, communityService, "Free");
		int start = (Integer)map.get("start");
		int end = (Integer)map.get("end");
		ArrayList<CommunityVO> list = communityService.getFreeList(start, end);
		//��������
		ArrayList<NoticeVO> nlist = noticeService.getNoticeList();
		
		mv.setViewName("community/free_board");
		mv.addObject("list", list);	
		mv.addObject("nlist", nlist);
		mv.addObject("dbcount", map.get("dbCount"));
		mv.addObject("rpage", map.get("rpage"));
		mv.addObject("pagesize", map.get("pageSize"));		
		
		return mv;
	}
	
	/**
	 * �����Խ��� �󼼺���
	 */
	@RequestMapping(value = "/free_board_content.do", method=RequestMethod.GET)
	public ModelAndView free_board_content(String fid) {
		ModelAndView mv = new ModelAndView();
		
		//�Խù� ����
		CommunityVO vo = communityService.getFreeContent(fid);
		
		//��� ����
		ArrayList<CommunityVO> list = communityService.getFreeComment(fid);
		
		//��ȸ��
		communityService.getHitUp(fid);
		
		mv.addObject("vo", vo);
		mv.addObject("list", list);
		mv.setViewName("community/free_board_content");
		
		return mv;
	}
	
	/**
	 * �����Խ��� �۾���
	 */
	@RequestMapping(value="/free_board_write.do", method=RequestMethod.GET)
	public String free_board_write() {
		return "community/free_board_write";
	}
	
	/**
	 * �����Խ��� �����ϱ�
	 */
	@RequestMapping(value="/free_board_update.do", method=RequestMethod.GET)
	public ModelAndView free_board_update(String fid) {
		ModelAndView mv = new ModelAndView();
		
		//�Խù� ����
		CommunityVO vo = communityService.getFreeContent(fid);
		
		mv.addObject("vo", vo);
		mv.setViewName("community/free_board_update");
		
		return mv;
	}
	
	/**
	 * �����Խ��� �۾��� DB
	 */
	@RequestMapping(value = "/free_write_proc.do", method=RequestMethod.POST)
	public ModelAndView free_write_proc(HttpServletRequest request, CommunityVO vo, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		//���� ����
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//rfname �ߺ����� ó��			
		UUID uuid = UUID.randomUUID();
		System.out.println((vo.getFile1().getOriginalFilename()));
		System.out.println((uuid +"_"+vo.getFile1().getOriginalFilename()));	
		
		if (vo.getFile1().getOriginalFilename() != "") {
			//DB����
			vo.setFfile(vo.getFile1().getOriginalFilename());
			vo.setFsfile(uuid+ "_"+vo.getFile1().getOriginalFilename());
		}
		
		//�α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");
		vo.setId(id);
		//BoardDAO dao = new BoardDAO();
		boolean result = communityService.getFreeWrite(vo);
		
		//DB���� �Ϸ� �� ������ �����ϱ�
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
	
	/**
	 * �����Խ��� ��� DB
	 */
	@ResponseBody
	@RequestMapping(value = "/comment_up.do", method=RequestMethod.POST)
	public boolean comment_up(HttpSession session, HttpServletRequest request) {
		//�α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");
		
		CommunityVO vo = new CommunityVO();
		vo.setComment_id(id);
		vo.setCcomment(request.getParameter("content"));
		vo.setFid(request.getParameter("fid"));
		
		boolean result = communityService.getCommentResult(vo);
		
		return result;		
		
	}
	
	/**
	 * �����Խ��� �����ϱ�
	 */
	@ResponseBody
	@RequestMapping(value = "/free_update_proc.do", method=RequestMethod.POST)
	public ModelAndView free_update_proc(HttpServletRequest request, CommunityVO vo) throws Exception {
			ModelAndView mv = new ModelAndView();
			
			if (vo.getFile1().getOriginalFilename() != "") {
				//���� ����
				String root_path = request.getSession().getServletContext().getRealPath("/");
				String attach_path = "\\resources\\upload\\";
					
				//rfname �ߺ����� ó��			
				UUID uuid = UUID.randomUUID();
				System.out.println((vo.getFile1().getOriginalFilename()));
				System.out.println((uuid +"_"+vo.getFile1().getOriginalFilename()));	
				System.out.print(vo.getFid());
					
				//DB����
				vo.setFfile(vo.getFile1().getOriginalFilename());
				vo.setFsfile(uuid+ "_"+vo.getFile1().getOriginalFilename());
		
				//BoardDAO dao = new BoardDAO();
				String old_bsfile = communityService.getFileResult(vo.getFid());
				boolean result = communityService.getFileYesUpdate(vo);
				
				//DB���� �Ϸ� �� ������ �����ϱ�
				if (result) {
					File file = new File(root_path+attach_path+vo.getFsfile());
					vo.getFile1().transferTo(file);
					
					//���� upload ������ �����ϴ� ���� ����
					File old_file = new File(root_path+attach_path+old_bsfile);
					if ( old_file.exists()) {
						old_file.delete();
					}
				}
				
			} else {
				//���� ������ ������Ʈ
				boolean result = communityService.getFileNoUpdate(vo);
			}	
		
			mv.setViewName("redirect:/free_board.do");
			return mv;
		
	}
	
	/**
	 * �����Խ��� ��� �����ϱ�
	 */
	@ResponseBody
	@RequestMapping(value = "/comment_delete.do", method=RequestMethod.POST)
	public boolean comment_delete(HttpServletRequest request) {
		boolean result = communityService.getCommentDelete(request.getParameter("cid"));
		
		return result;
	}
	
	/**
	 * �����Խ��� �Խñ� �����ϱ�
	 */
	@RequestMapping(value = "/free_board_delete.do", method=RequestMethod.GET)
	public ModelAndView free_board_delete(HttpServletRequest request, String fid, String type) {
		
		ModelAndView mv = new ModelAndView();
		
		String old_bsfile = communityService.getFileResult(fid);
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		File old_file = new File(root_path+attach_path+old_bsfile);
		if ( old_file.exists()) {
			old_file.delete();
		}
		
		boolean result = communityService.getFreeBoardDelete(fid);
		
		if (type.equals("board")) {
			mv.setViewName("redirect:/free_board.do");			
		} else if (type.equals("mypage")) {
			mv.setViewName("redirect:/myboard.do");		
		}
		
		return mv;
	}
	
	
	
	
	
	
	
	
	/**
	 * ��û�Խ��� ����Ʈ
	 */
	@RequestMapping(value = "/request_board.do", method=RequestMethod.GET )
	public ModelAndView request_board(String rpage) {
		ModelAndView mv = new ModelAndView();
		
		Commons commons = new Commons();
		HashMap map = commons.getPage(rpage, communityService, "Request");
		int start = (Integer)map.get("start");
		int end = (Integer)map.get("end");
		ArrayList<CommunityVO> list = communityService.getRequestList(start, end);
		
		mv.setViewName("community/request_board");
		mv.addObject("list", list);	
		mv.addObject("dbcount", map.get("dbCount"));
		mv.addObject("rpage", map.get("rpage"));
		mv.addObject("pagesize", map.get("pageSize"));		
		
		return mv;
	}
	
	/**
	 * ��û�Խ��� �󼼺��� �� ��й�ȣ�Է�
	 */
	@RequestMapping(value = "/request_board_number.do", method=RequestMethod.GET)
	public ModelAndView request_board_number(String rid) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("rid", rid);
		mv.setViewName("community/request_board_number");
		return mv;
	}
	
	/**
	 * ��й�ȣ Ȯ��
	 */
	@ResponseBody
	@RequestMapping(value = "/board_pass_check.do", method=RequestMethod.POST)
	public boolean board_pass_check(HttpServletRequest request) {
		boolean result = communityService.getBoardPass(request.getParameter("rid"), request.getParameter("pass"));
		
		return result;
	}
	
	/**
	 * ��û�Խ��� �󼼺���
	 */
	@RequestMapping(value = "/request_board_content.do", method=RequestMethod.GET) 
	public ModelAndView request_board_content(String rid) {
		ModelAndView mv = new ModelAndView();
		
		//�Խù� ����
		CommunityVO vo = communityService.getRequestContent(rid);
		//�亯 ����
		CommunityVO rvo = adminService.getRequestCommentResult(rid);
		
		mv.addObject("vo", vo);
		mv.addObject("rvo", rvo);
		mv.setViewName("community/request_board_content");
		
		return mv;
	}
	
	/**
	 * ��û�Խ��� �۾���
	 */
	@RequestMapping(value="/request_board_write.do", method=RequestMethod.GET)
	public String request_board_write() {
		return "community/request_board_write";
	}
	
	/**
	 * ��û�Խ��� �۾��� DB
	 */
	@RequestMapping(value = "/request_write_proc.do", method=RequestMethod.POST)
	public ModelAndView request_write_proc(HttpServletRequest request, CommunityVO vo, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		//���� ����
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		//rfname �ߺ����� ó��			
		UUID uuid = UUID.randomUUID();
		System.out.println((vo.getFile1().getOriginalFilename()));
		System.out.println((uuid +"_"+vo.getFile1().getOriginalFilename()));	
		
		if (vo.getFile1().getOriginalFilename() != "") {
			//DB����
			vo.setRfile(vo.getFile1().getOriginalFilename());
			vo.setRsfile(uuid+ "_"+vo.getFile1().getOriginalFilename());
		}
		
		//�α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");
		vo.setId(id);
		//BoardDAO dao = new BoardDAO();
		boolean result = communityService.getRequestWrite(vo);
		
		//DB���� �Ϸ� �� ������ �����ϱ�
		if (result) {
			System.out.println(root_path + attach_path + uuid +"_"+vo.getFile1().getOriginalFilename());
			
			if (vo.getFile1().getOriginalFilename() != "") {
				File file = new File(root_path + attach_path + uuid
						+"_"+vo.getFile1().getOriginalFilename()); vo.getFile1().transferTo(file);
			}
		}			
		
		mv.setViewName("redirect:/request_board.do");
		return mv;
		
	}
	
	/**
	 * �������� �󼼺���
	 */
	@RequestMapping(value="notice_content.do", method=RequestMethod.GET)
	public ModelAndView notice_content(String nid) {
		ModelAndView mv = new ModelAndView();
		
		NoticeVO vo = adminService.getNoticeContent(nid);
		
		mv.addObject("vo", vo);
		mv.setViewName("community/notice_content");
		return mv;
	}
	
	

	
	
		

}
