package com.myjeju.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjeju.dao.FoodDAO;
import com.myjeju.vo.FoodVO;

@Service("foodService")
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	private FoodDAO foodDAO;
	
	@Override
	public ArrayList<FoodVO> getList(){
		return foodDAO.getList();
	}
	
	@Override
	public ArrayList<FoodVO> getFoodList(){
		return foodDAO.getFoodList();
	}
	
	@Override
	public ArrayList<FoodVO> getFoodListTop3(){
		return foodDAO.getFoodListTop3();
	}
	
	@Override
	public FoodVO getFoodDetail(String fid) {
		return foodDAO.getFoodDetail(fid);
	}
}
