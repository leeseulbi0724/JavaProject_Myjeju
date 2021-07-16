package com.myspring.myjeju;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.service.PayService;
import com.myjeju.service.StoreService;
import com.myjeju.vo.BasketVO;
import com.myjeju.vo.StoreVO;

@Controller
public class PayController {
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private PayService payService;
	
	
	/**
	 * 직접 카드결제
	 */
	@RequestMapping(value = "/payment.do", method=RequestMethod.GET)
	public ModelAndView payment(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView();		
		 String id = (String) session.getAttribute("session_id");
		 
		 mv.addObject("id", id);
		 mv.addObject("total", request.getParameter("total"));
		 mv.addObject("list", request.getParameter("list"));
		 mv.addObject("option", request.getParameter("option"));
		 mv.addObject("c", request.getParameter("c"));
		 mv.setViewName("pay/payment");
		 
		return mv;
		
	}
	
	/**
	 * 카드결제 proc
	 */
	@ResponseBody
	@RequestMapping(value = "/payment_proc.do", method=RequestMethod.POST)
		public boolean payment_proc(HttpServletRequest request, HttpSession session) {
			boolean result = false;
		
			String id = (String) session.getAttribute("session_id");
			String list = request.getParameter("list");
			String total = request.getParameter("total");
			String count = request.getParameter("count");
			String sids[] = null;
			ArrayList<List<BasketVO>> basket_list = null;
			
			System.out.print(count);
			
			 if ( list.contains(",")) {
				 sids = list.split(",");			 
				 basket_list = storeService.getBuyContent(sids, id);		 
				 
				 BasketVO vo = new BasketVO();
				 vo.setS_price(Integer.parseInt(total));
				 vo.setId(id);
				 vo.setS_name("");
				 vo.setS_image(basket_list.get(0).get(0).getS_image());
				 vo.setS_sfile(basket_list.get(0).get(0).getS_sfile());
				 for(int i = 0; i <basket_list.size(); i++){ 
					 vo.setS_name(vo.getS_name() + basket_list.get(i).get(0).getS_name() + " ");
					 vo.setB_count(vo.getB_count() + basket_list.get(i).get(0).getB_count());
				 }		 
				 System.out.print(vo.getS_name()); 
				 System.out.print(vo.getB_count());
				 result = payService.getOrderResult(vo);				 
				
			 } else {
				 BasketVO vo = new BasketVO();
				 ArrayList<BasketVO> basket_one_list = new ArrayList<BasketVO>();
				 if (request.getParameter("option").equals("mypage")) {
					 basket_one_list = storeService.getBuyContent(list, id);					 
					 vo.setId(id);
					 vo.setS_name(basket_one_list.get(0).getS_name());
					 vo.setS_price(basket_one_list.get(0).getS_price());
					 vo.setB_count(basket_one_list.get(0).getB_count());
					 vo.setS_sfile(basket_one_list.get(0).getS_sfile());
					 vo.setS_image(basket_one_list.get(0).getS_image());
				 } else {
					 StoreVO svo = storeService.getContent(list);
					 vo.setId(id);
					 vo.setS_name(svo.getS_name());
					 vo.setB_count(Integer.parseInt(count));
					 vo.setS_price(svo.getS_price()*vo.getB_count());
					 vo.setS_sfile(svo.getS_sfile());
					 vo.setS_image(svo.getS_image());
				 }
				 
				 //장바구니 삭제
				 if (result) {
					 if (request.getParameter("option").equals("mypage")) {
						 
					 }
				 }
				 
				 result = payService.getOrderResult(vo);
			 } 
			 
			 return result;
	
	}
	
	/**
	 * 카카오페이 결제
	 */
	@RequestMapping(value="/kakaopay.do", method=RequestMethod.GET)
	public String kakaopay() {
		return "pay/kakaopay";
	
	}

}
