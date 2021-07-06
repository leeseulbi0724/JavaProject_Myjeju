package com.myspring.myjeju;

import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

	public static ArrayList<Integer> calprint(int year, int month, int maxrow) {
		
		
//		System.out.println("");
//
//		System.out.println(year + "�� " + month + "���� �޷�");
//		System.out.println("");

		int sum = 0;

		for (int i = 1583; i < year; i++) {
			if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
				// �����̶��
				sum += 2;
			} else {
				// ����̶��
				sum += 1;
			}
		}
		int first = (sum + 6) % 7; // �Է��� year�� 1�� 1���� ����
		
		for (int j = 1; j < month; j++) {
			first += monthDay(year, j) % 7;
		}
		
		int day = first % 7; // �Է��� month�� 1���� ����
		
		
		ArrayList<Integer> calv = new ArrayList<Integer>();
		
		
		int num = 1; // month�� �� ǥ��
		int max = monthDay(year, month); // �ش� month�� ������ �ִ� �� ��
		int pre_max = monthDay(year, month-1);
		int pre_day = pre_max-(day-1);
		int next_day = 1;
		
		boolean start = false;
//		System.out.println(" Sun  Mon  Tue  Wed  Thu  Fri  Sat ");

		loop: for (int row = 0; row < maxrow; row++) {
			for (int column = 0; column <= 6; column++) {
				if (row == 0 && !start) {
					// �޷��� ù ��
					if (column == day) {
						// ���� �Ͽ� �����ϸ�
						start = true;
					} else {
						// ���� �Ͽ� ���� ������ ����
						calv.add(pre_day);
						pre_day++;
						continue;
					}
				}
				if(num <= max) {
//					System.out.printf("  %02d ", num);
					calv.add(num);
					num++;
				}else {
//					System.out.print("     ");
					
					calv.add(next_day);
					next_day++;
				}
				
				if (num > max && column==6) {
					// �ִ� �� �� + ������ĭ�� �����ϸ� break loop
					break loop;
				}
			}
//			System.out.println("");
		}
//		System.out.println();
//		for(int i = 0; i < maxrow; i++) {
//			for(int j = 0; j <= 6;j++) {
//				System.out.print(cal[i][j] + " ");
//			}
//		}
		return calv;
	}


	/**
	 * main.do : ����������
	 */
	@RequestMapping(value="/calendar.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login(String preyear, String premonth) {
		ModelAndView mv = new ModelAndView();
		Calendar cal = Calendar.getInstance();
		
		
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
				// �����̶��
				sum += 2;
			} else {
				// ����̶��
				sum += 1;
			}
		}
		int first = (sum + 6) % 7; // �Է��� year�� 1�� 1���� ����
		
		int day = first % 7;

		maxday = day + monthDay(year, month);
		if(maxday >= 36) {
					maxrow = 6;
				} else {
					maxrow = 5;
				}
		
		ArrayList<Integer> value = calprint(year,month,maxrow);
		
		mv.setViewName("reservation/calendar");
		mv.addObject("calvalue",value);
		mv.addObject("maxrow",maxrow);
		mv.addObject("year",year);
		mv.addObject("month",month);
		return mv;
	}
	
	
}
