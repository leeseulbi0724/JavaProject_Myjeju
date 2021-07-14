package com.myjeju.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.myjeju.vo.RoomVO;

public class ReservationDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace="mapper.reservation";
	
	public String getCurrentName(String hid) {
		return sqlSession.selectOne(namespace+".currentname", hid);
	}
	public ArrayList<RoomVO> searchroom(String start, String end,String hdid) {
		
		Map<String,String> se = new HashMap<String,String>();
		se.put("start", start);
		se.put("end", end);
		se.put("hdid", hdid);
		
		List<RoomVO> list = sqlSession.selectList(namespace+".searchroom", se);
		return (ArrayList<RoomVO>)list;
	}
	
}
