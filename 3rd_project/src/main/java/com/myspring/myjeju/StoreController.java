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
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.dao.StofaqDAO;
import com.myjeju.dao.StorepDAO;
import com.myjeju.service.StofaqService;
import com.myjeju.service.StoreService;
import com.myjeju.service.StorepService;
import com.myjeju.vo.StofaqVO;
import com.myjeju.vo.StoreVO;
import com.myjeju.vo.StorepVO;

@Controller

public class StoreController {
	
	@Autowired
	private StoreService storeService;
	@Autowired
	private StofaqService stofaqService;
	@Autowired
	private StorepService storepService;
	
	/**
	 * store.do : ����� ���� ��ǰ ���
	 */
	@RequestMapping(value="/store.do", method=RequestMethod.GET)
	public ModelAndView store() {
		ModelAndView mv = new ModelAndView();
		
		//StoreDAO dao = new StoreDAO();
		ArrayList<StoreVO> bestlist = storeService.getBestList();
		ArrayList<StoreVO> eatlist = storeService.getEatList();
		ArrayList<StoreVO> souvelist = storeService.getSouveList();
		ArrayList<StoreVO> etclist = storeService.getEtcList();
		
		mv.setViewName("store/store");
		
		mv.addObject("bestlist", bestlist);
		mv.addObject("eatlist", eatlist);
		mv.addObject("souvelist", souvelist);
		mv.addObject("etclist", etclist);
		
		
		return mv;
	}
	
	/**
	 * store_eat.do : ����� ��ǰ ȭ��
	 */
	@RequestMapping(value = "/store_eat.do", method = RequestMethod.GET)
	public ModelAndView store_eat() {
		ModelAndView mv = new ModelAndView();
		//StoreDAO dao = new StoreDAO();
		ArrayList<StoreVO> list = storeService.getEatList2();
		
		mv.setViewName("store/storeeat");
		mv.addObject("eatlist", list);
		
		return mv;
	}
	
	/**
	 * store_souve.do : ����� ���ǰ ȭ��
	 */
	@RequestMapping(value = "/store_souve.do", method = RequestMethod.GET)
	public ModelAndView store_souve() {
		ModelAndView mv = new ModelAndView();
		//StoreDAO dao = new StoreDAO();
		ArrayList<StoreVO> list = storeService.getSouveList2();
		
		mv.setViewName("store/storesouve");
		mv.addObject("souvelist", list);
		
		return mv;
	}
	
	/**
	 * store_etc.do : ����� ��ȭ ȭ��
	 */
	@RequestMapping(value = "/store_etc.do", method = RequestMethod.GET)
	public ModelAndView store_etc() {
		ModelAndView mv = new ModelAndView();
		//StoreDAO dao = new StoreDAO();
		ArrayList<StoreVO> list = storeService.getEtcList2();
		
		mv.setViewName("store/storeetc");
		mv.addObject("etclist", list);
		
		return mv;
	}
	
	
	/**
	 * store_content.do : ����� ��ǰ ��ȭ��
	 */
	@RequestMapping(value = "/store_content.do", method = RequestMethod.GET)
	public ModelAndView store_content(String id, String sid, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		String user_id = (String) session.getAttribute("session_id");
		
		System.out.print(sid);
		//��ǰ ������ ��������
		//StoreDAO dao = new StoreDAO();
		StoreVO vo = storeService.getContent(sid);
		
		//���� ����Ʈ
		//StofaqDAO fdao = new StofaqDAO();
		ArrayList<StofaqVO> flist = stofaqService.getContent(sid);
		
		
		//�亯 ����Ʈ
		//StorepDAO rdao = new StorepDAO();
		ArrayList<StorepVO> rlist = storepService.getContent(sid);
		
		StofaqVO fvo = stofaqService.getStid(sid);
		
		
		mv.setViewName("store/store_content");
		
		mv.addObject("vo", vo);
		mv.addObject("flist", flist);
		mv.addObject("rlist", rlist);
		
		mv.addObject("sid", sid);
		
		mv.addObject("fvo", fvo);
		
		mv.addObject("id", user_id);
		
		return mv;
	}
	

	/**
	 * store_buy.do : ����� ���� ȭ��
	 */
	@RequestMapping(value = "/store_buy.do", method = RequestMethod.GET)
	public String store_buy() {
		return "store/storebuy";
	}
	
	
	/**
	 * store_faq_proc.do : ����� �����ϱ� ó��
	 */
	@RequestMapping(value = "/store_faq_proc.do", method = RequestMethod.GET)
	//public ModelAndView store_faq_proc(StofaqVO vo) {
	public ModelAndView store_faq_proc(StofaqVO fvo) {
		ModelAndView mv = new ModelAndView();
		
		//StofaqDAO dao = new StofaqDAO();
		boolean result = stofaqService.getInsertResult(fvo);
		
		if(result) {
			mv.setViewName("redirect:/store_content.do");
			mv.addObject("sid", fvo.getSid());
			
			
		}
		return mv;
	}
	
	
	/**
	 * store_faq_reply_proc.do : ����� ���� -> �亯 ó��
	 */
	@RequestMapping(value = "/store_faq_reply_proc.do", method = RequestMethod.GET)
	public ModelAndView store_faq_reply_proc(StorepVO rvo) {
		ModelAndView mv = new ModelAndView();
		
		//StorepDAO dao = new StorepDAO();
		boolean result = storepService.getInsertResult(rvo);
		
		if(result) {
			mv.setViewName("redirect:/store_content.do");
			mv.addObject("sid", rvo.getSid());
		}
		
		return mv;
	}
	
	/**
	 * store_write.do : ����� ��ǰ��� ȭ��
	 */
	@RequestMapping(value = "/store_write.do", method = RequestMethod.GET)
	public String store_write() {
		return "store/store_write";
	}
	
	/**
	 * store_write_proc.do : ����� ��ǰ ��� ó��
	 */
	@RequestMapping(value = "/store_write_proc.do", method = RequestMethod.POST)
	public ModelAndView store_write_proc(StoreVO vo, HttpServletRequest request) throws Exception {
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
		//StoreDAO dao = new StoreDAO();
		boolean result = storeService.getInsertResult(vo);
		
		if(result) {
			
			// 4. DB ���� ���� --> upload ������ ����			//DB���� �Ϸ� �� ������ �����ϱ�
			//File file = new File(root_path + attach_path + uuid + "_" + vo.getFile2().getOriginalFilename());
			File file = new File(root_path + attach_path + vo.getS_sfile());
			vo.getSfile1().transferTo(file);
			
			File file2 = new File(root_path + attach_path + vo.getS_ssfile());
			vo.getSfile2().transferTo(file2);
			
			mv.setViewName("redirect:/store.do");
		}
			
		return mv;
	}
}
