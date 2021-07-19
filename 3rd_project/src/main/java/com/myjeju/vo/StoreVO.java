package com.myjeju.vo;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class StoreVO {
	String sid, s_category, s_name, s_image, s_sfile, s_content, s_ssfile;
	int s_price, rno;
	CommonsMultipartFile sfile1, sfile2;
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getS_category() {
		return s_category;
	}
	public void setS_category(String s_category) {
		this.s_category = s_category;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_image() {
		return s_image;
	}
	public void setS_image(String s_image) {
		this.s_image = s_image;
	}
	public String getS_sfile() {
		return s_sfile;
	}
	public void setS_sfile(String s_sfile) {
		this.s_sfile = s_sfile;
	}
	public String getS_content() {
		return s_content;
	}
	public void setS_content(String s_content) {
		this.s_content = s_content;
	}
	public String getS_ssfile() {
		return s_ssfile;
	}
	public void setS_ssfile(String s_ssfile) {
		this.s_ssfile = s_ssfile;
	}
	public int getS_price() {
		return s_price;
	}
	public void setS_price(int s_price) {
		this.s_price = s_price;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	
	
	public CommonsMultipartFile getSfile1() {
		return sfile1;
	}
	public void setSfile1(CommonsMultipartFile sfile1) {
		this.sfile1 = sfile1;
	}
	public CommonsMultipartFile getSfile2() {
		return sfile2;
	}
	public void setSfile2(CommonsMultipartFile sfile2) {
		this.sfile2 = sfile2;
	}
	
	
	

}
