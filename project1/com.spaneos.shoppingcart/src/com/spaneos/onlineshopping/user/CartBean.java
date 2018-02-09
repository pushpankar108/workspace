package com.spaneos.onlineshopping.user;

public class CartBean {
	private String pname,price,stock,items,status;

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CartBean() {
		super();
	}
	@Override
	public String toString() {
		return "CartBean [pname=" + pname + ", price=" + price + ", stock=" + stock + ", items=" + items + ", status="
				+ status + "]";
	}

	
	
}