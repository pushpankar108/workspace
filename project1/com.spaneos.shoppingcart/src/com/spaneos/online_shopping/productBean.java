package com.spaneos.online_shopping;

public class productBean {
	private String pname, pdes, pcat;
	private int pno, price;
	String catname;
	public productBean() {
		super();
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdes() {
		return pdes;
	}
	public void setPdes(String pdes) {
		this.pdes = pdes;
	}
	public String getPcat() {
		return pcat;
	}
	public void setPcat(String pcat) {
		this.pcat = pcat;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "productBean [pname=" + pname + ", pdes=" + pdes + ", pcat=" + pcat + ", pno=" + pno + ", price=" + price
				+ "]";
	}	
	
	
	
}