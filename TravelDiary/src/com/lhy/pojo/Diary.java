package com.lhy.pojo;

public class Diary {
	private	boolean ret;
	private String errcode;
	private String errmsg;
	private String ver;
	private Data data;
	public boolean isRet() {
		return ret;
	}
	public void setRet(boolean ret) {
		this.ret = ret;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Diary [ret=" + ret + ", errcode=" + errcode + ", errmsg=" + errmsg + ", ver=" + ver + ", data=" + data
				+ "]";
	}
	
	
}
