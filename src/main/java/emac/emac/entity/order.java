package emac.entity;

public class order {
	
	private int code;
	private String customer_id;
	private String order_date;
	private int total_price;
	private int delevery;
	
	public order(int code, String customer_id, String order_date, int total_price, int delevery) {
		// TODO Auto-generated constructor stub
		this.code=code;
		this.customer_id=customer_id;
		this.order_date=order_date;
		this.total_price=total_price;
		this.delevery=delevery;
	}
	public order() {
		// TODO Auto-generated constructor stub
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int getDelevery() {
		return delevery;
	}
	public void setDelevery(int delevery) {
		this.delevery = delevery;
	}
	
	
}
