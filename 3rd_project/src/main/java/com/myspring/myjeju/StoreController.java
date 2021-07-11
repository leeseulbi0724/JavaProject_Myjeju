package com.myspring.myjeju;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.dao.StoreDAO;
import com.myjeju.vo.StoreVO;
import com.myjeju.vo.vo;

@Controller

public class StoreController {
	
	/**
	 * store.do : ����� ���� ��ǰ ���
	 */
	@RequestMapping(value="/store.do", method=RequestMethod.GET)
	public ModelAndView store() {
		ModelAndView mv = new ModelAndView();
		
		StoreDAO dao = new StoreDAO();
		ArrayList<StoreVO> bestlist = dao.getBestList();
		ArrayList<StoreVO> eatlist = dao.getEatList();
		ArrayList<StoreVO> souvelist = dao.getSouveList();
		ArrayList<StoreVO> etclist = dao.getEtcList();
		
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
	public String store_eat() {
		return "store/storeeat";
	}
	
	/**
	 * store_souve.do : ����� ���ǰ ȭ��
	 */
	@RequestMapping(value = "/store_souve.do", method = RequestMethod.GET)
	public String store_souve() {
		return "store/storesouve";
	}
	
	/**
	 * store_etc.do : ����� ��ȭ ȭ��
	 */
	@RequestMapping(value = "/store_etc.do", method = RequestMethod.GET)
	public String store_etc() {
		return "store/storeetc";
	}
	
	/**
	 * store_content.do : ����� ��ǰ ��ȭ��
	 */
	@RequestMapping(value = "/store_content.do", method = RequestMethod.GET)
	public String store_content() {
		return "store/store_content";
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
	public String store_faq_proc() {
		return "store/store_content";
	}
	
	
	/**
	 * store_faq_reply_proc.do : ����� ���� -> �亯 ó��
	 */
	@RequestMapping(value = "/store_faq_reply_proc.do", method = RequestMethod.GET)
	public String store_faq_reply_proc() {
		return "store/store_content";
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
		
		}
			
		// 3. DB����
		StoreDAO dao = new StoreDAO();
		boolean result = dao.getInsertResult(vo);
		
		if(result) {
			
			// 4. DB ���� ���� --> upload ������ ����
			//DB���� �Ϸ� �� ������ �����ϱ�
			//File file = new File(root_path + attach_path + uuid + "_" + vo.getFile2().getOriginalFilename());
			File file = new File(root_path + attach_path + vo.getS_sfile());
			vo.getSfile1().transferTo(file);
			
			mv.setViewName("redirect:/store.do");
		}
			
		return mv;
	}
}
