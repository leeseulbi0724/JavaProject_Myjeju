package com.myjeju.service;

import java.util.ArrayList;

import com.myjeju.vo.CafeVO;
import com.myjeju.vo.CarSpotVO;
import com.myjeju.vo.CommunityVO;
import com.myjeju.vo.FoodVO;
import com.myjeju.vo.HDetailVO;
import com.myjeju.vo.HouseVO;
import com.myjeju.vo.MemberVO;
import com.myjeju.vo.NoticeVO;
import com.myjeju.vo.PhotoSpotVO;
import com.myjeju.vo.RoomVO;
import com.myjeju.vo.RoomdeVO;
import com.myjeju.vo.StoreVO;
import com.myjeju.vo.TravelVO;

public interface AdminService {
	//包府磊 雀盔
	ArrayList<MemberVO> getlist(int startnum,int endnum);
	ArrayList<MemberVO> getlist(int startnum,int endnum,String search,String search_text);
	int targetPage(int pageNumber);
	int targetPage(int pageNumber,String search,String search_text);
	MemberVO getmember(String id);
	
	//包府磊 槛家
	HouseVO gethouse(String hid);
	ArrayList<HouseVO> getlisthouse(int startnum,int endnum);
	ArrayList<HouseVO> getlisthouse(int startnum,int endnum,String search,String search_text);
	int targethousePage(int pageNumber);
	int targethousePage(int pageNumber,String search,String search_text);
	boolean getHouseInsertResult(HouseVO vo);
	HouseVO getHouseContent(String hid);
	boolean getHouseUpdateFile(HouseVO vo);
	boolean getHouseUpdateNoFile(HouseVO vo);
	String getHouseOldFile(String hid);
	boolean getHouseDelete(String hid);
	
	//包府磊 按角
	ArrayList<HDetailVO> gethousede(String hid);
	HDetailVO gethousedecontent(String hdid);
	boolean getHdetailUpload(HDetailVO vo);
	boolean getHdetailUpdate(HDetailVO vo);
	boolean getHdetailDelete(String hdid);
	
	//包府磊 冯
	ArrayList<RoomdeVO> gethousederoom(String hdid);
	ArrayList<RoomVO> getmonthcheck(String month,String roomid);
	boolean insertres(RoomVO vo);
	boolean uploadroom(String hdid,String room_name);
	RoomdeVO getroom(String roomid);
	boolean deleteroom(String roomid);
	boolean notavail(String roomid,String date);
	boolean toavail(String roomid,String date);
	
	//包府磊 咐笼
	ArrayList<FoodVO> getlistfood(int startnum,int endnum);
	ArrayList<FoodVO> getlistfood(int startnum,int endnum,String search,String search_text);
	int targetfoodPage(int pageNumber);
	int targetfoodPage(int pageNumber,String search,String search_text);
	boolean getFoodUpload(FoodVO vo);
	FoodVO getFoodcontent(String fid);
	boolean getFoodUpdate(FoodVO vo);
	boolean getFoodDelete(String fid);
	
	//包府磊 咯青瘤
	ArrayList<TravelVO> getlisttravel(int startnum,int endnum);
	ArrayList<TravelVO> getlisttravel(int startnum,int endnum,String search,String search_text);
	int targettravelPage(int pageNumber);
	int targettravelPage(int pageNumber,String search,String search_text);
	TravelVO gettravel(String tid);
	boolean getTravelUpload(TravelVO vo);
	boolean getTravelUpdate(TravelVO vo);
	boolean getTravelDelete(String tid);
	
	boolean getTravelPhotoSpotUpload(PhotoSpotVO photovo);
	boolean getTravelCarSpotUpload(CarSpotVO carvo);
	
	PhotoSpotVO getPhotoSpot(String tid);
	CarSpotVO getCarSpot(String tid);
	
	boolean getPhotoSpotUpdate(PhotoSpotVO photovo);
	boolean getCarSpotUpdate(CarSpotVO carvo);
	
	boolean getPhotoSpotDelete(String tid);
	boolean getCarSpotDelete(String tid);
	
	//包府磊 墨其
	ArrayList<CafeVO> getlistcafe(int startnum, int endnum);
	ArrayList<CafeVO> getlistcafe(int startnum, int end, String search, String search_text);
	int targetcafePage(int pageNumber);
	int targetcafePage(int pageNumber,String search,String search_text);
	CafeVO getCafecontent(String fid);
	boolean getCafeUpload(CafeVO vo);
	boolean getCafeUpdate(CafeVO vo);
	boolean getCafeDelete(String fid);
	
	//包府磊 霸矫魄
	ArrayList<CommunityVO> getBoardList(int startnum,int endnum);
	int BoardPage(int pageNumber);
	int BoardPage(int pageNumber,String search,String search_text);
	ArrayList<CommunityVO> getBoardList(int startnum,int endnum,String search,String search_text);
	
	//包府磊 傍瘤荤亲
	boolean getNoticeWrite(NoticeVO vo);
	ArrayList<NoticeVO> getNoticeList(int startnum, int endnum);
	int NoticePage(int pageNumber);
	int NoticePage(int pageNumber,String search,String search_text);
	ArrayList<NoticeVO> getNoticeList(int startnum,int endnum,String search,String search_text);
	NoticeVO getNoticeContent(String nid);
	boolean getFileYesUpdate(NoticeVO vo);	
	boolean getFileNoUpdate(NoticeVO vo);
	String getOldFile(String nid);
	boolean getNoticeDelete(String nid);
	
	//包府磊 夸没
	ArrayList<CommunityVO> getRequestList(int startnum,int endnum,String search,String search_text);
	ArrayList<CommunityVO> getRequestList(int startnum, int endnum);
	int RequestPage(int pageNumber);
	int RequestPage(int pageNumber,String search,String search_text);
	CommunityVO getRequestContent(String rid);
	boolean getRequestComment(CommunityVO vo);
	CommunityVO getRequestCommentResult(String rid);
	boolean getRequestDelete(String rid);
	
	
	
	//包府磊 胶配绢
	ArrayList<StoreVO> getStoreList(int startnum, int endnum);
	ArrayList<StoreVO> getStoreList(int startnum, int endnum, String search, String search_text);
	int StorePage(int pageNumber);
	int StorePage(int pageNumber,String search,String search_text);
	StoreVO getStoreContent(String sid);
	boolean getStoreUpdateFile(StoreVO vo);
	boolean getStoreUpdateNoFile(StoreVO vo);
	String getStoreOldFile(String sid);
	boolean getStoreInsertResult(StoreVO vo);
	boolean getStoreDelete(String sid);
}
