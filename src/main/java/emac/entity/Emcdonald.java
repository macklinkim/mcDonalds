package emac.entity;

import java.util.Date;


public class Emcdonald {
	
	private String menu_name;
	private int amount;
	private int price;
	private int allprice;
	private int tax;
	private int revenue;
	private Date wdate;
	
	public Emcdonald(){}
	
	public Emcdonald( String menu_name, int amount, int price, int allprice, int tax,
			int revenue, Date wdate) {
		super();
		this.menu_name = menu_name;
		this.amount = amount;
		this.price = price;
		this.allprice= allprice;
		this.tax = tax;
		this.revenue = revenue;
		this.wdate = wdate;
	}
	

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAllprice() {
		allprice=getPrice()*getAmount();
		return allprice;
	}

	public void setAllprice(int allprice) {
		this.allprice = allprice;
	}

	public int getTax() {
		tax=getAllprice()/10;
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getRevenue() {
		revenue=getAllprice()-getTax();
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	
	
	
}