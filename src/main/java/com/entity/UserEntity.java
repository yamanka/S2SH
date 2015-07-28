package com.entity;

import java.util.Date;

public class UserEntity implements java.io.Serializable{
Long userid;
String username;
String userpassword;
String userrealname;
String userschool;
String userphonenum;
String useremail;
String ifvip;
String bsflag;
Date createdate;
Date changedate;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUserpassword() {
	return userpassword;
}
public void setUserpassword(String userpassword) {
	this.userpassword = userpassword;
}
public String getUserrealname() {
	return userrealname;
}
public void setUserrealname(String userrealname) {
	this.userrealname = userrealname;
}
public String getUserschool() {
	return userschool;
}
public void setUserschool(String userschool) {
	this.userschool = userschool;
}
public Long getUserid() {
	return userid;
}
public void setUserid(Long userid) {
	this.userid = userid;
}
public String getIfvip() {
	return ifvip;
}
public void setIfvip(String ifvip) {
	this.ifvip = ifvip;
}
public String getBsflag() {
	return bsflag;
}
public void setBsflag(String bsflag) {
	this.bsflag = bsflag;
}
public String getUserphonenum() {
	return userphonenum;
}
public void setUserphonenum(String userphonenum) {
	this.userphonenum = userphonenum;
}
public String getUseremail() {
	return useremail;
}
public void setUseremail(String useremail) {
	this.useremail = useremail;
}

public Date getCreatedate() {
	return createdate;
}
public void setCreatedate(Date createdate) {
	this.createdate = createdate;
}
public Date getChangedate() {
	return changedate;
}
public void setChangedate(Date changedate) {
	this.changedate = changedate;
}

}
