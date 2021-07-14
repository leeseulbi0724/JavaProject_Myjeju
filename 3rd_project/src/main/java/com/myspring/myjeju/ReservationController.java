package com.myspring.myjeju;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myjeju.service.ReservationService;
import com.myjeju.vo.DateVO;
import com.myjeju.vo.RoomVO;

@Controller
public class ReservationController {
	public static int monthDay(int year, int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return 31;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		} else {
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
				return 29;
			} else {
				return 28;
			}
		}
	}

	public static ArrayList<DateVO> calprint(int year, int month, int maxrow) {

		int sum = 0;

		for (int i = 1583; i < year; i++) {
			if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
				// 윤년이라면
				sum += 2;
			} else {
				// 평년이라면
				sum += 1;
			}
		}
		int first = (sum + 6) % 7; // 입력한 year의 1월 1일의 요일
		
		for (int j = 1; j < month; j++) {
			first += monthDay(year, j) % 7;
		}
		
		int day = first % 7; // 입력한 month의 1일의 요일
		
		
		ArrayList<DateVO> calv = new ArrayList<DateVO>();
		
		
		
		int num = 1; // month의 일 표시
		int max = monthDay(year, month); // 해당 month가 가지는 최대 일 수
		int pre_max = monthDay(year, month-1);
		int pre_day = pre_max-(day-1);
		int next_day = 1;
		
		boolean start = false;

		loop: for (int row = 0; row < maxrow; row++) {
			for (int column = 0; column <= 6; column++) {
				DateVO date = new DateVO();
				if (row == 0 && !start) {
					// 달력의 첫 행
					if (column == day) {
						// 시작 일에 도달하면
						start = true;
					} else {
						// 시작 일에 도달 전에는 공백
						date.setDay(pre_day);
						date.setMonth(month-1);
						
						calv.add(date);
						pre_day++;
						continue;
					}
				}
				if(num <= max) {
					date.setDay(num);
					date.setMonth(month);
					
					calv.add(date);
					num++;
				}else {
					date.setDay(next_day);
					date.setMonth(month+1);
					
					calv.add(date);
					next_day++;
				}
				
				if (num > max && column==6) {
					// 최대 일 수 + 마지막칸에 도달하면 break loop
					break loop;
				}
			}
		}
		return calv;
	}
	@Autowired
	private ReservationService ReservationService;
	/**
	 * main.do : 시작페이지
	 */
	@RequestMapping(value="/calendar.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView calendar(String preyear, String premonth, String hid, String hdid) {
		
		String currentname = ReservationService.getCurrentName(hid);
		
		ModelAndView mv = new ModelAndView();
		Calendar cal = Calendar.getInstance();
		
		int today = (cal.get(Calendar.MONTH)+1)*100 + cal.get(Calendar.DAY_OF_MONTH);
				
		int year = 0;
		int month = 0;
		if(preyear == null && premonth == null) {
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH) + 1;
		}else {
			year = Integer.parseInt(preyear);
			month = Integer.parseInt(premonth);
		}
		
		if(month == 13) {
			year += 1;
			month -= 12;
		}
		if(month == 0) {
			year -=1;
			month += 12;
		}
		
		
		int maxrow = 0;
		int maxday = 0;
		
		int sum = 0;

		for (int i = 1583; i < year; i++) {
			if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
				// 윤년이라면
				sum += 2;
			} else {
				// 평년이라면
				sum += 1;
			}
		}
		int first = (sum + 6) % 7; // 입력한 year의 1월 1일의 요일
		
		int day = first % 7;

		maxday = day + monthDay(year, month);
		if(maxday >= 36) {
					maxrow = 6;
				} else {
					maxrow = 5;
				}
		
		ArrayList<DateVO> value = calprint(year,month,maxrow);
		
		
		String sMonth = String.valueOf(value.get(0).getMonth());
		if(sMonth.length() == 1) {
			sMonth = "0"+ sMonth;
		}
		String sDay = String.valueOf(value.get(0).getDay());
		if(sDay.length() == 1) {
			sDay = "0"+ sDay;
		}
		String start = year + sMonth + sDay;
		String eMonth = String.valueOf(value.get(value.size()-1).getMonth());
		if(eMonth.length() == 1) {
			eMonth = "0"+ eMonth;
		}
		String eDay = String.valueOf(value.get(value.size()-1).getDay());
		if(eDay.length() == 1) {
			eDay = "0"+ eDay;
		}
		
		String end = year + eMonth + eDay;
		
		ArrayList<RoomVO> searchroom = ReservationService.searchroom(start,end,hdid);
		String[] availdate = new String[searchroom.size()];		
		for(int i=0; i<searchroom.size(); i++) {
			availdate[i] = searchroom.get(i).getRdate();
		}
		ArrayList<String> arrayList = new ArrayList<String>();
		for(String item : availdate){
            if(!arrayList.contains(item))
                arrayList.add(item);
        }
		ArrayList<String> conver = new ArrayList<String>();
		for(int i =0; i<arrayList.size();i++) {
			String[] a = arrayList.get(i).split("-");
			String aa = a[0] + a[1] + a[2];
			conver.add(aa.substring(0,8));
		}
		ArrayList<String> availlast1 = new ArrayList<String>();
		
		for(int i = 0;i<value.size();i++) {
			String sMonth1 = String.valueOf(value.get(i).getMonth());
			if(sMonth1.length() == 1) {
				sMonth1 = "0"+ sMonth1;
			}
			String sDay1 = String.valueOf(value.get(i).getDay());
			if(sDay1.length() == 1) {
				sDay1 = "0"+ sDay1;
			}
			String start1 = year + sMonth1 + sDay1;
			availlast1.add(start1);
		}
		
		ArrayList<Integer> availlast = new ArrayList<Integer>();
		for(int i = 0;i<value.size();i++) {
			boolean check = false;
			for(int j = 0 ;j<conver.size();j++) {
				if(availlast1.get(i).equals(conver.get(j))) {
					availlast.add(0);
					check = true;
				}
			}
			if(!check) {
				availlast.add(1);
			}
		}
		
		mv.setViewName("reservation/calendar");
		mv.addObject("calvalue",value);
		mv.addObject("availlast",availlast);
		mv.addObject("hdid",hdid);
		mv.addObject("hid",hid);
		mv.addObject("maxrow",maxrow);
		mv.addObject("year",year);
		mv.addObject("month",month);
		mv.addObject("today",today);
		mv.addObject("currentname",currentname);
		return mv;
	}
	
	@RequestMapping(value="/reservationList.do", method=RequestMethod.POST)
	public String index() {
		return "reservation/reservationList";
	}
	
	@RequestMapping(value="/availcheck", method=RequestMethod.POST)
	@ResponseBody
	public String availcheck(int startvalue, int year, int month ,String hdid) {
		String val1 = String.valueOf(startvalue);
		String b = "";
		if(val1.length()==7) {
			StringBuffer a = new StringBuffer();
			a.append(val1);
			a.insert(6, "0");
			b = a.toString();
			startvalue = Integer.parseInt(b);
		}
		int start = startvalue;
		int end = 0;
		int monthday = monthDay(year,month);
		
		
		
		String compareval = String.valueOf(startvalue);
		String compareval1 = compareval.substring(6,8);
		int compare = Integer.parseInt(compareval1);
		
		if(compare+6 > monthday) {
			end = ((startvalue+6) - monthday) +100;
			if(month==12) {
				end = end - 1200;
			}
		}else {
			end = startvalue+6;
		}
		
		ArrayList<RoomVO> searchroom = ReservationService.searchroom(String.valueOf(start),String.valueOf(end),hdid);
		ArrayList<String> roomname = new ArrayList<String>(); 
		for(int i=0;i<searchroom.size();i++) {
			roomname.add(searchroom.get(i).getRoomid());
		}
		ArrayList<String> arrayList = new ArrayList<String>();
		for(String name : roomname){
	            if(!arrayList.contains(name))
	                arrayList.add(name);
	    }
		ArrayList<Integer> sequenceday = new ArrayList<Integer>();
		StringBuffer f_compare = new StringBuffer(); 
		f_compare.append(String.valueOf(startvalue));
		f_compare.insert(4, "-");	
		f_compare.insert(7, "-");	
		String ff_compare = f_compare.toString();
		
		
		
		for(int i = 0;i<arrayList.size();i++) {
			int val = 0;
			for(int j = 0; j<searchroom.size(); j++) {
				if(arrayList.get(i).equals(searchroom.get(j).getRoomid())){
					if(comparedate(ff_compare, searchroom.get(j).getRdate())>1) {
						j = searchroom.size();
					}else {
						val +=1;
						ff_compare = searchroom.get(j).getRdate();
					}
				}
			}
			sequenceday.add(val);
			ff_compare = f_compare.toString();
		}
		
		int max=Collections.max(sequenceday);
		int curday = comparedateplus(f_compare.toString(),1);
		int targetday = comparedateplus(f_compare.toString(),max);
		int curday2 = comparedateplus(f_compare.toString(),0);
		int targetday2 = comparedateplus(f_compare.toString(),max+1);
		String maxs=curday+"/"+targetday+"/"+curday2+"/"+targetday2;
		return maxs;
	}
	
	public static int comparedate(String curdate, String nextdate) {
		
		int cur_year = Integer.parseInt(curdate.substring(0,4));
		int next_year = Integer.parseInt(nextdate.substring(0,4));
		
		int cur_month = Integer.parseInt(curdate.substring(5,7));
		int naxt_month = Integer.parseInt(nextdate.substring(5,7));
		
		int cur_day = Integer.parseInt(curdate.substring(8,10));
		int next_day = Integer.parseInt(nextdate.substring(8,10));
		
		int month = naxt_month - cur_month;
		if(month < 0) {
			month = 1;
		}
		int day = next_day - cur_day;
		
		int value = (month*monthDay(cur_year,cur_month)) + day;
		
		return value;
	}
	public static int comparedateplus(String curdate, int max) {
		
		int cur_year = Integer.parseInt(curdate.substring(0,4));
		
		int cur_month = Integer.parseInt(curdate.substring(5,7));
		
		int cur_day = Integer.parseInt(curdate.substring(8,10));
		
		int day = cur_day+max;
		int month = cur_month;
		if(day>monthDay(cur_year,cur_month)){
			day -= monthDay(cur_year,cur_month);
			month += 1;
			if(month>12) {
				month -=12;
			}
		}
		
		int value = (month*100)+day;
		return value;
	}
	
}
