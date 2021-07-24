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

import com.myjeju.service.CafeService;
import com.myjeju.service.FoodService;
import com.myjeju.service.HouseService;
import com.myjeju.service.MemberService;
import com.myjeju.service.MypageService;
import com.myjeju.service.TravelService;
import com.myjeju.vo.BasketVO;
import com.myjeju.vo.CafeReviewVO;
import com.myjeju.vo.CafeVO;
import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.FoodReviewVO;
import com.myjeju.vo.FoodVO;
import com.myjeju.vo.HeartVO;
import com.myjeju.vo.HouseReviewVO;
import com.myjeju.vo.HouseVO;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.OrderVO;
import com.myjeju.vo.PointVO;
import com.myjeju.vo.StorevVO;
import com.myjeju.vo.TravelReviewVO;
import com.myjeju.vo.TravelVO;

@Controller
public class MypageController {

	@Autowired
	private MypageService MypageService;

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private HouseService HouseService;
	
	@Autowired
	private FoodService FoodService;
	
	@Autowired
	private TravelService TravelService;
	
	@Autowired
	private CafeService CafeService;

	/**
	 * ���������� ����
	 */
	@RequestMapping(value = "/mypage.do", method = RequestMethod.GET)
	public ModelAndView mypage(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		// �α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");
				
		//����Ʈ 
		int point = MypageService.getPoint(id);
		
		mv.setViewName("mypage/mypage");
		mv.addObject("point", point);
		
		
		return mv;
	}

	/**
	 * �⺻�������� ��û������
	 */
	@RequestMapping(value = "/myinfo_request.do", method = RequestMethod.GET)
	public String myinfo_request() {
		return "mypage/myinfo/myinfo_request";
	}

	/**
	 * �⺻�������� ����
	 */
	@RequestMapping(value = "/myinfo.do", method = RequestMethod.GET)
	public ModelAndView myinfo(HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		// �α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");

		MemberVO vo = MypageService.getMemberContent(id);

		String email[] = vo.getEmail().split("@");
		vo.setEmail1(email[0]);
		vo.setEmail2(email[1]);

		String hp[] = vo.getHp().split("-");
		vo.setHp1(hp[0]);
		vo.setHp2(hp[1]);
		vo.setHp3(hp[2]);

		mv.addObject("vo", vo);
		mv.setViewName("mypage/myinfo/myinfo");

		return mv;
	}

	/**
	 * ��й�ȣ ����
	 */
	@RequestMapping(value = "/myinfo_pass.do", method = RequestMethod.GET)
	public String myinfo_pass() {
		return "mypage/myinfo/myinfo_pass";
	}

	/**
	 * ȸ��Ż��
	 */
	@RequestMapping(value = "/myinfo_out.do", method = RequestMethod.GET)
	public String myinfo_out() {
		return "mypage/myinfo/myinfo_out";
	}

	/**
	 * �ֹ�����
	 */
	@RequestMapping(value = "/myorder.do", method = RequestMethod.GET)
	public ModelAndView myorder(HttpSession session) {
		ArrayList<String> hid = new ArrayList<String>();
		
		ModelAndView mv = new ModelAndView();
		String id = (String) session.getAttribute("session_id");
		
		//��ǰ�ֹ�����
		ArrayList<OrderVO> list = MypageService.getOrderList(id);
		
		//���ҿ��೻��
		ArrayList<OrderVO> mlist = MypageService.getMReservation(id);
		for (int i=0; i<mlist.size(); i++) {
			//�����̸���������
			OrderVO vo = MypageService.getHouseName(mlist.get(i).getHid());
			mlist.get(i).setH_name(vo.getH_name());
			mlist.get(i).setH_img(vo.getH_img());
			
			//���̸���������
			OrderVO ovo = MypageService.getRommName(mlist.get(i).getHdid());
			mlist.get(i).setHd_name(ovo.getHd_name());
			mlist.get(i).setHd_price(ovo.getHd_price());
		}			
		
		mv.setViewName("mypage/mystore/myorder");
		mv.addObject("list", list);
		mv.addObject("mlist", mlist);
		
		return mv;
	}

	/**
	 * ���������� -> ��ٱ���
	 */
	@RequestMapping(value = "/mybasket.do", method = RequestMethod.GET)
	public ModelAndView mybaskit(BasketVO vo, HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		String id = (String) session.getAttribute("session_id");

		ArrayList<BasketVO> list = MypageService.getBasketContent(id);
		int column = MypageService.getColumn(id);

		mv.setViewName("mypage/mystore/mybasket");
		mv.addObject("list", list);
		mv.addObject("column", column);

		return mv;
	}

	/**
	 * ��ٱ��� �߰� ó�� - ��ٱ��� ȭ������
	 */
	@ResponseBody
	@RequestMapping(value = "/mybasket_proc1.do", method = RequestMethod.POST)
	public boolean mybasket_proc1(HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		String id = (String) session.getAttribute("session_id");
		String sid = request.getParameter("sid");
		String name = request.getParameter("s_name");
		String s_image = request.getParameter("s_image");
		String s_sfile = request.getParameter("s_sfile");

		String count = request.getParameter("b_count");
		if (count == null) {
			count = "0";
		}
		int b_count = Integer.parseInt(count);

		String price = request.getParameter("s_price");
		if (price == null) {
			price = "0";
		}
		int s_price = Integer.parseInt(price);
		BasketVO vo = new BasketVO();
		vo.setId(id);
		vo.setSid(sid);
		vo.setS_name(name);
		vo.setB_count(b_count);
		vo.setS_price(s_price);
		vo.setS_image(s_image);
		vo.setS_sfile(s_sfile);
		
		boolean result_true = false;
		//�̹� ��ϵ� ��ǰ���� Ȯ��
		boolean result = MypageService.getAlready(vo);
		
		if ( result ) {
			result_true = MypageService.getInsertResult(vo);			
		} else {
			//���� ���׷��̵常
			result_true = MypageService.getAlreadyCount(vo);
		}

		return result_true;
	}
	
	/**
	 * ��ٱ��� ����
	 */
	@ResponseBody
	@RequestMapping(value = "/basket_delete.do", method=RequestMethod.POST)
	public boolean getBasketDelete(HttpServletRequest request) {
		boolean result = MypageService.getBasketDelete(request.getParameter("sid"));
		
		return result;
	}
	

	/**
	 * ���� �Խñ�
	 */
	@RequestMapping(value = "/myboard.do", method = RequestMethod.GET)
	public ModelAndView myboard(HttpSession session) {
		ModelAndView mv = new ModelAndView();

		ArrayList<CommunityVO> list1 = MypageService.getFreeBoardResult((String) session.getAttribute("session_id"));
		ArrayList<CommunityVO> list2 = MypageService.getRequestBoardResult((String) session.getAttribute("session_id"));
		ArrayList<CommunityVO> list3 = MypageService.getCommentResult((String) session.getAttribute("session_id"));

		mv.addObject("list1", list1);
		mv.addObject("list2", list2);
		mv.addObject("list3", list3);
		mv.setViewName("mypage/myrecord/myboard");

		return mv;
	}

	/**
	 * ���� �ı�
	 */
	@RequestMapping(value = "/myreview.do", method = RequestMethod.GET)
	public ModelAndView myreview(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		String id = (String) session.getAttribute("session_id");
		
		ArrayList<StorevVO> storelist = MypageService.getStoreReview(id);
		ArrayList<TravelReviewVO> travellist = MypageService.getTravelReview(id);
		ArrayList<FoodReviewVO> foodlist = MypageService.getFoodReview(id);
		ArrayList<CafeReviewVO> cafelist = MypageService.getCafeReview(id);
		ArrayList<HouseReviewVO> houselist = MypageService.getHouseReview(id);
		

		
		mv.setViewName("mypage/myrecord/myreview");
		
		mv.addObject("store_list", storelist);
		mv.addObject("travel_list", travellist);
		mv.addObject("food_list", foodlist);
		mv.addObject("cafe_list", cafelist);
		mv.addObject("house_list", houselist);
		
		return mv;
	}

	/**
	 * ���� ���ƿ�
	 */
	@RequestMapping(value = "/myheart.do", method = RequestMethod.GET)
	public ModelAndView myheart(HttpSession session) {
		// �α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mypage/myrecord/myheart");
		
		ArrayList<HeartVO> h_list = MypageService.getHouseHeartList(id);
		for (int i=0; i<h_list.size(); i++) {
			HouseVO vo = HouseService.getHouseDetail(h_list.get(i).getHid());
			h_list.get(i).setH_img(vo.getH_img());
			h_list.get(i).setH_like(vo.getH_like());
		}
		ArrayList<HeartVO> f_list = MypageService.getFoodHeartList(id);
		for (int i=0; i<f_list.size(); i++) {
			FoodVO vo = FoodService.getFoodDetail(f_list.get(i).getFid());
			String img[] = vo.getF_sfile().split(",");
			f_list.get(i).setF_image1(img[0]);
			f_list.get(i).setF_like(vo.getF_like());
		}
		ArrayList<HeartVO> ca_list = MypageService.getCafeHeartList(id);
		for (int i=0; i<ca_list.size(); i++) {
			CafeVO vo = CafeService.getCafeDetail(ca_list.get(i).getCaid());
			String img[] = vo.getCa_sfile().split(",");
			ca_list.get(i).setCa_image1(img[0]);
			ca_list.get(i).setCa_like(vo.getCa_like());
		}
		ArrayList<HeartVO> t_list = MypageService.getTravelHeartList(id);
		for (int i=0; i<t_list.size(); i++) {
			TravelVO vo = TravelService.getTravelDetail(t_list.get(i).getTid());
			String img[] = vo.getT_sfile().split(",");
			t_list.get(i).setT_image1(img[0]);
			t_list.get(i).setT_like(vo.getT_like());
		}
		
		mv.addObject("h_list", h_list);
		mv.addObject("f_list", f_list);
		mv.addObject("ca_list", ca_list);
		mv.addObject("t_list", t_list);
		
		return mv;
	}

	/**
	 * ���� ����Ʈ
	 */
	@RequestMapping(value = "/mypoint.do", method = RequestMethod.GET)
	public ModelAndView mypoint(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		// �α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");
		//����Ʈ 
		int point = MypageService.getPoint(id);
		
		ArrayList<PointVO> list = MypageService.getPointList(id);
		mv.addObject("list", list);
		mv.addObject("point", point);
		mv.setViewName("mypage/mypoint");
		
		return mv;
	}

	/**
	 * �������� �� �н����� üũ
	 */
	@ResponseBody
	@RequestMapping(value = "/pass_check.do", method = RequestMethod.POST)
	public boolean pass_check(HttpSession session, HttpServletRequest request) {
		// �α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");

		boolean result = false;

		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPass(request.getParameter("pass"));

		int value = MypageService.getPassCheckResult(vo);

		if (value != 0) {
			result = true;
		}

		return result;

	}

	/**
	 * �������� DB
	 */
	@ResponseBody
	@RequestMapping(value = "/info_update.do", method = RequestMethod.POST)
	public boolean info_update(HttpSession session, HttpServletRequest request) {
		// �α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");

		MemberVO vo = new MemberVO();
		vo.setAddr1(request.getParameter("addr1"));
		vo.setAddr2(request.getParameter("addr2"));
		vo.setHp1(request.getParameter("hp1"));
		vo.setHp2(request.getParameter("hp2"));
		vo.setHp3(request.getParameter("hp3"));
		vo.setEmail1(request.getParameter("email1"));
		vo.setEmail2(request.getParameter("email2"));
		vo.setId(id);

		boolean result = MypageService.getInfoUpdate(vo);

		return result;
	}

	/**
	 * ��й�ȣ ����
	 */
	@ResponseBody
	@RequestMapping(value = "/mypass_update_proc.do", method = RequestMethod.POST)
	public boolean pass_update_proc2(HttpSession session, HttpServletRequest request) {
		// �α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");
		MemberVO vo = new MemberVO();

		vo.setId(id);
		vo.setPass(request.getParameter("pass"));

		boolean result = memberService.getPassUpdateResult(vo);

		return result;

	}

	/**
	 * ȸ��Ż��
	 */
	@ResponseBody
	@RequestMapping(value = "/info_out.do", method = RequestMethod.POST)
	public boolean info_out(HttpSession session) {
		// �α��� ȸ������ ��������
		String id = (String) session.getAttribute("session_id");

		boolean result = MypageService.getInfoOut(id);

		return result;

	}
	
	/**
	 * ���೻�� ����
	 */
	@RequestMapping(value="/myorder_delete.do", method=RequestMethod.GET)
	public ModelAndView myorder_delete(String rid) {
		ModelAndView mv = new ModelAndView();
		//���� ���� ��������
		OrderVO vo = MypageService.getOrderContent(rid);
		//���̿� ��� ��¥ ���ϱ�
		String first[] = vo.getFirstday().split("-");
		String last[] = vo.getLastday().split("-");
		vo.setFirstday(first[0]+first[1]+first[2]);
		vo.setLastday(last[0]+last[1]+last[2]);
		ArrayList<OrderVO> list = MypageService.getDayResult(vo);
		boolean result = false;
		//reservation ���̺� 0�����
		for (int i=0; i<list.size(); i++) {
			vo.setDay(list.get(i).getDay());
			result = MypageService.getReservationResult(vo);
		}
		if (result) {
			//���೻�� ����
			MypageService.getOrderDelete(rid);
		}
		mv.setViewName("redirect:/myorder.do");
		return mv;
		
	}
}
