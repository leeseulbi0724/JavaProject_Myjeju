package com.myjeju.vo;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class CommunityVO {

	CommonsMultipartFile file1;
	String id, fid, ftitle, fcontent,  ffile, fsfile, fdate;
	int rno, fhit;
	
	public CommonsMultipartFile getFile1() {
		return file1;
	}
	public void setFile1(CommonsMultipartFile file1) {
		this.file1 = file1;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFtitle() {
		return ftitle;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public String getFcontent() {
		return fcontent;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	public String getFfile() {
		return ffile;
	}
	public void setFfile(String ffile) {
		this.ffile = ffile;
	}
	public String getFsfile() {
		return fsfile;
	}
	public void setFsfile(String fsfile) {
		this.fsfile = fsfile;
	}
	public String getFdate() {
		return fdate;
	}
	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getFhit() {
		return fhit;
	}
	public void setFhit(int fhit) {
		this.fhit = fhit;
	}
	
	
}
