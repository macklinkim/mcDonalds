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

}