package emac.entity;

public class SnackEntity {
	private String code;
	private String name;
	private int price;
	private String imgSrc;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public SnackEntity(String code, String name, int price, String imgSrc) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.imgSrc = imgSrc;
	}
	public SnackEntity(){}
	
}
