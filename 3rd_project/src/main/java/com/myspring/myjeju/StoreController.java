package com.myspring.myjeju;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class StoreController {
	
	/**
	 * store.do : ����� ����
	 */
	@RequestMapping(value="/store.do", method=RequestMethod.GET)
	public String store() {
		return "store/store";
	}
	
	/**
	 * store_eat.do : ����� ��ǰ ȭ��
	 */
	@RequestMapping(value = "/store_eat.do", method = RequestMethod.GET)
	public String store_eat() {
		return "store/storeeat";
	}
	
	/**
	 * store_deco.do : ����� �ǳ����ǰ ȭ��
	 */
	@RequestMapping(value = "/store_deco.do", method = RequestMethod.GET)
	public String store_deco() {
		return "store/storedeco";
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

}
