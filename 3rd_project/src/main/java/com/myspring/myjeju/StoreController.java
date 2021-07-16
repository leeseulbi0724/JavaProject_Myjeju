package com.myspring.myjeju;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.service.MypageService;
import com.myjeju.service.StofaqService;
import com.myjeju.service.StoreService;
import com.myjeju.vo.BasketVO;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.StofaqVO;
import com.myjeju.vo.StoreVO;

@Controller

public class StoreController {
	
	@Autowired
	private StoreService storeService;
	@Autowired	
	private StofaqService stofaqService;	
	@Autowired
	private MypageService mypageService;	

	
	/**
	 * store.do : 스토어 메인 상품 출력
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
	 * store_eat.do : 스토어 식품 화면
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
	 * store_souve.do : 스토어 기념품 화면
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
	 * store_etc.do : 스토어 잡화 화면
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
	 * store_content.do : 스토어 상품 상세화면
	 */
	@RequestMapping(value = "/store_content.do", method = RequestMethod.GET)
	public ModelAndView store_content(String id, String sid, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		String user_id = (String) session.getAttribute("session_id");
		
		//상품 상세정보 가져오기
		StoreVO vo = storeService.getContent(sid);
		
		//문의/답변 리스트
		ArrayList<StofaqVO> flist = stofaqService.getList(sid);
		
		mv.setViewName("store/store_content");
		
		mv.addObject("vo", vo);
		mv.addObject("flist", flist);
		
		mv.addObject("sid", sid);
		mv.addObject("id", user_id);
		
		return mv;
	}
	

	/**
	 * store_buy.do : 스토어 구매 화면 -- 장바구니에서
	 */
	@RequestMapping(value = "/store_buy.do", method = RequestMethod.GET)
	public ModelAndView store_buy(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		 String id = (String) session.getAttribute("session_id");
		 String type = request.getParameter("type");
		 
		 ArrayList<List<BasketVO>> basket_list = null;

			 String list = request.getParameter("list");
			 String sids[] = null;
			 
			 if ( list.contains(",")) {
				 sids = list.split(",");			 
				 basket_list = storeService.getBuyContent(sids, id);		
				 for(int i = 0; i <basket_list.size(); i++){ 
					 System.out.print(basket_list.get(i).get(0).getS_name()); 
					 mv.addObject("type", "many");
					 mv.addObject("option", "mypage");
					 mv.addObject("list", basket_list);					
					 mv.addObject("size", basket_list.size());
				 }		 
			 } else {
				 ArrayList<BasketVO> basket_one_list = storeService.getBuyContent(list, id);
				 System.out.print(basket_one_list.get(0).getS_name());
				 mv.addObject("type", "one");
				 mv.addObject("list", basket_one_list);
				 mv.addObject("option", "mypage");
				 mv.addObject("size", basket_one_list.size());
			 }
		 
		 
		MemberVO vo = mypageService.getMemberContent(id);	
		
		mv.addObject("vo", vo);
		mv.setViewName("store/storebuy");
		
		return mv;
	}
	
	/**
	 * store_buy.do : 스토어 구매 화면 -- 상품페이지에서
	 */
	@RequestMapping(value = "/store_buy2.do", method = RequestMethod.POST)
	public ModelAndView store_buy2(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		 String id = (String) session.getAttribute("session_id");
		
		 ArrayList<BasketVO> basket_one_list = new ArrayList<BasketVO>();
		 BasketVO bvo = new BasketVO();
		 bvo.setB_count(Integer.parseInt(request.getParameter("b_count")));
		 bvo.setS_image(request.getParameter("s_image"));
		 bvo.setS_name(request.getParameter("s_name"));
		 bvo.setS_price(Integer.parseInt(request.getParameter("s_price")));
		 bvo.setS_sfile(request.getParameter("s_sfile"));
		 bvo.setSid(request.getParameter("sid"));		 
		 basket_one_list.add(bvo);
		 
		 mv.addObject("size", 1);
		 mv.addObject("type", "one");
		 mv.addObject("option", "store");
		 mv.addObject("list", basket_one_list);

		 
		MemberVO vo = mypageService.getMemberContent(id);		
		mv.addObject("vo", vo);
		mv.setViewName("store/storebuy");
		
		return mv;
	}
	
	
	/**
	 * store_faq_proc.do : 스토어 문의 -> 문의 처리
	 */
	@RequestMapping(value = "/store_faq_proc.do", method = RequestMethod.GET)
	public ModelAndView store_faq_proc(StofaqVO vo) {
		ModelAndView mv = new ModelAndView();
		boolean result = stofaqService.getInsertResult(vo);
		if(result) {
			mv.setViewName("redirect:/store_content.do");
			mv.addObject("sid", vo.getSid());
		}
		return mv;
	}
	
	
	/**
	 * store_faq_reply_proc.do : 스토어 문의 -> 답변 처리
	 */
	@RequestMapping(value = "/store_faq_reply_proc.do", method = RequestMethod.GET)
	public ModelAndView store_faq_reply_proc(StofaqVO vo) {
		ModelAndView mv = new ModelAndView();
		boolean result = stofaqService.getReplyResult(vo);
		
		if(result) {
			mv.setViewName("redirect:/store_content.do");
			mv.addObject("sid", vo.getSid());
		}
		
		return mv;
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
			
			vo.setS_content(vo.getSfile2().getOriginalFilename());
			vo.setS_ssfile(uuid + "_" + vo.getSfile2().getOriginalFilename());
		
		}
			
		// 3. DB연동
		//StoreDAO dao = new StoreDAO();
		boolean result = storeService.getInsertResult(vo);
		
		if(result) {
			
			// 4. DB 연동 성공 --> upload 폴더에 저장			//DB저장 완료 후 폴더에 저장하기
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
