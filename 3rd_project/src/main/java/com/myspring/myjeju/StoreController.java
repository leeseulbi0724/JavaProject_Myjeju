package com.myspring.myjeju;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class StoreController {
	
	/**
	 * store.do : 스토어 메인
	 */
	@RequestMapping(value="/store.do", method=RequestMethod.GET)
	public String store() {
		return "store/store";
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
	
	
}
