package emac.entity;

import java.util.Date;

public class orderdetail {

	private int no;
	private int order_code;
	private String menu;
	private String opt;
	private int amount;
	private int price;
	private int tax;
	private int allprice;
	private int revenue;
	private Date wdate;
	
	public int getPrice() {
		return price;
	}
	public int getTax() {
		tax=getAllprice()/10;
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public int getAllprice() {
		allprice=getPrice()*getAmount();
		return allprice;
	}
	public void setAllprice(int allprice) {
		this.allprice = allprice;
	}
	public int getRevenue() {
		revenue=getAllprice()-getTax();
		return revenue;
	}
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public orderdetail(int no, int order_code, String menu, String opt,
			int amount) {
		// TODO Auto-generated constructor stub
		this.no=no;
		this.order_code=order_code;
		this.menu=menu;
		this.opt=opt;
		this.amount=amount;
	}
	public orderdetail() {
		// TODO Auto-generated constructor stub
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getOrder_code() {
		return order_code;
	}
	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getOpt() {
		return opt;
	}
	public void setOpt(String option) {
		this.opt = option;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
