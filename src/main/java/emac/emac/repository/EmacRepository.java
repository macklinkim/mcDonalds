package emac.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import emac.entity.CustomerEntity;
import emac.entity.Emcdonald;
import emac.entity.EmployeeEntity;
import emac.entity.UserEntity;

@Component
public class EmacRepository {
	JdbcTemplate jdbcTemplate;
	@Autowired
	public EmacRepository(DataSource ds){
		jdbcTemplate=new JdbcTemplate(ds);
	}
	
	public EmployeeEntity employeeCheck(UserEntity e) {
		String sql = "SELECT  * FROM TBL_EMPLOYEE WHERE ID=? AND PASSWORD=?";
		EmployeeEntity employee;
		try {
			employee = jdbcTemplate.queryForObject(sql,new RowMapper<EmployeeEntity>() {
				public EmployeeEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new EmployeeEntity(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs	.getString(6));
				}	}, e.getId(),e.getPassword());
		} catch (Exception exeption) {
			employee = null;
		}
		return employee;	}
	
	public CustomerEntity customerCheck(UserEntity c) {
		String sql = "SELECT * FROM TBL_CUSTOMER WHERE ID=? AND PW=?";
		CustomerEntity customer;
		try {
			customer = jdbcTemplate.queryForObject(sql, new RowMapper<CustomerEntity>(){
				public CustomerEntity mapRow(ResultSet rs, int rowNum)	throws SQLException {
					return new CustomerEntity(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				} },c.getId(),c.getPassword());
		} catch (Exception exeption) {
			customer = null;
		}
		return customer;	}
	
	public void customerReg(CustomerEntity c) {
		String sql = "INSERT INTO TBL_CUSTOMER(ID,PW,NAME,PHONE,ADDR) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(sql,c.getId(),c.getPassword(),c.getName(),c.getPhone(),c.getAddress());
	}

	public void employeeReg(EmployeeEntity e) {
		String sql = "INSERT INTO TBL_EMPLOYEE(ID, PASSWORD, NAME, POSITION,DEPT,PHONE) VALUES(?,?,?,?,?,?)";
		jdbcTemplate.update(sql, e.getId(), e.getPassword(), e.getName(), e.getPosition(),e.getDept(),e.getPhone());
	}

	public List<EmployeeEntity> employeeList() {
		RowMapper<EmployeeEntity> mapper = new RowMapper<EmployeeEntity>() {

			public EmployeeEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				return new EmployeeEntity(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}		};
		String sql="SELECT * FROM TBL_EMPLOYEE";
		return jdbcTemplate.query(sql, mapper);
	}

	public void infoChange(String password, String name, String phone,String address, String id) {
		String sql = "UPDATE  TBL_CUSTOMER SET PW = ?,NAME = ?,PHONE = ?, ADDR = ? WHERE ID=?";
		jdbcTemplate.update(sql,password,name,phone,address,id);
	}

	public void dropOut(CustomerEntity ce) {
		String sql = "UPDATE TBL_CUSTOMER SET PW = ?,NAME = ?,PHONE = ?, ADDR = ? WHERE ID=?";
		jdbcTemplate.update(sql," "," "," "," ",ce.getId());
	}

	public List<Emcdonald> personalOrderList(CustomerEntity ce) {
		RowMapper<Emcdonald> mapper = new RowMapper<Emcdonald>() {

			public Emcdonald mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				return new Emcdonald(rs.getString("menu_name"), rs.getInt("amount"), rs.getInt("price"), rs.getInt("allprice"), rowNum, rowNum, rs.getDate("wdate"),rs.getString("customer_name"),rs.getString("address"));
			}		};
		String sql = "SELECT * FROM TBL_REVENUE WHERE CUSTOMER_NAME=?";
		return jdbcTemplate.query(sql, mapper,ce.getName());
	}

	public List<CustomerEntity> customerList() {
		RowMapper<CustomerEntity> mapper = new RowMapper<CustomerEntity>() {

			public CustomerEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				return new CustomerEntity(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}		};
			String sql = "SELECT * FROM TBL_CUSTOMER";
			return jdbcTemplate.query(sql,mapper);
	}

	public void userDelete(String id) {
		String sql = "DELETE FROM TBL_BOARD WHERE WRITER=?";
		jdbcTemplate.update(sql,id);
		String sql2 = "DELETE FROM TBL_REPLY WHERE B_WRITER=?";
		jdbcTemplate.update(sql2,id);
		String sql3 = "DELETE FROM TBL_CUSTOMER WHERE ID=?";
		jdbcTemplate.update(sql3,id);
	}

}