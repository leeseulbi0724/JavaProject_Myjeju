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
	
	
}
