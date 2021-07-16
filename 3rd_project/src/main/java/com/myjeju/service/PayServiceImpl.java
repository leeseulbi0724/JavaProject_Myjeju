package com.myjeju.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.PayDAO;
import com.myjeju.vo.BasketVO;

@Service("PayService")
public class PayServiceImpl implements PayService {

	@Autowired
	private PayDAO payDAO;
	
	public boolean getOrderResult(BasketVO vo) {
		int val = payDAO.getOrderResult(vo);
		boolean result = false;
		if (val !=0) {
			result = true;
		}
		return result;
	}
}
