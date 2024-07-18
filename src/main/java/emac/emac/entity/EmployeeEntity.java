package emac.entity;


public class EmployeeEntity extends UserEntity {
	String id;
	String password;
	String name;
	String position;
	String dept;
	String phone;
	public EmployeeEntity() {	}
	public EmployeeEntity(String id, String password, String name,
			String position, String dept, String phone) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.position = position;
		this.dept = dept;
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
