package emac.entity;

public class orderdetail {

	private int no;
	private int order_code;
	private String menu;
	private String opt;
	private int amount;
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
