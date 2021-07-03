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
	 * store_deco.do : 스토어 실내장식품 화면
	 */
	@RequestMapping(value = "/store_deco.do", method = RequestMethod.GET)
	public String store_deco() {
		return "store/storedeco";
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

}
