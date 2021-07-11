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
	 * store.do : 스토어 메인 상품 출력
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
	 * store_eat.do : 스토어 식품 화면
	 */
	@RequestMapping(value = "/store_eat.do", method = RequestMethod.GET)
	public String store_eat() {
		return "store/storeeat";
	}
	
	/**
	 * store_souve.do : 스토어 기념품 화면
	 */
	@RequestMapping(value = "/store_souve.do", method = RequestMethod.GET)
	public String store_souve() {
		return "store/storesouve";
	}
	
	/**
	 * store_etc.do : 스토어 잡화 화면
	 */
	@RequestMapping(value = "/store_etc.do", method = RequestMethod.GET)
	public String store_etc() {
		return "store/storeetc";
	}
	
	/**
	 * store_content.do : 스토어 상품 상세화면
	 */
	@RequestMapping(value = "/store_content.do", method = RequestMethod.GET)
	public String store_content() {
		return "store/store_content";
	}

	/**
	 * store_buy.do : 스토어 구매 화면
	 */
	@RequestMapping(value = "/store_buy.do", method = RequestMethod.GET)
	public String store_buy() {
		return "store/storebuy";
	}
	
	/**
	 * store_faq_proc.do : 스토어 문의하기 처리
	 */
	@RequestMapping(value = "/store_faq_proc.do", method = RequestMethod.GET)
	public String store_faq_proc() {
		return "store/store_content";
	}
	
	
	/**
	 * store_faq_reply_proc.do : 스토어 문의 -> 답변 처리
	 */
	@RequestMapping(value = "/store_faq_reply_proc.do", method = RequestMethod.GET)
	public String store_faq_reply_proc() {
		return "store/store_content";
	}
	
	/**
	 * store_write.do : 스토어 상품등록 화면
	 */
	@RequestMapping(value = "/store_write.do", method = RequestMethod.GET)
	public String store_write() {
		return "store/store_write";
	}
	
	/**
	 * store_write_proc.do : 스토어 상품 등록 처리
	 */
	@RequestMapping(value = "/store_write_proc.do", method = RequestMethod.POST)
	public ModelAndView store_write_proc(StoreVO vo, HttpServletRequest request) throws Exception {
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
		
		}
			
		// 3. DB연동
		StoreDAO dao = new StoreDAO();
		boolean result = dao.getInsertResult(vo);
		
		if(result) {
			
			// 4. DB 연동 성공 --> upload 폴더에 저장
			//DB저장 완료 후 폴더에 저장하기
			//File file = new File(root_path + attach_path + uuid + "_" + vo.getFile2().getOriginalFilename());
			File file = new File(root_path + attach_path + vo.getS_sfile());
			vo.getSfile1().transferTo(file);
			
			mv.setViewName("redirect:/store.do");
		}
			
		return mv;
	}
}
