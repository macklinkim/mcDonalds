package emac.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Component;

import emac.entity.order;
import emac.entity.orderdetail;

@Component
public class orderrepository {

	
	private JdbcTemplate jdbc;
	
	@Autowired
	public orderrepository(DataSource data) {
		// TODO Auto-generated constructor stub
		jdbc = new JdbcTemplate(data);
	}

	public void saveOrder(order abc) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO TBL_ORDER(CODE,CUSTOMER_ID,ORDER_DATE,TOTAL_PRICE,DELEVERY) VALUES(?,?,?,?,?)";
		jdbc.update(sql, abc.getCode(),abc.getCustomer_id(),abc.getOrder_date(),abc.getTotal_price(),abc.getDelevery());
	}

	public void saveOrderDetail(orderdetail def) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO TBL_ORDER_DETAIL(ORDER_CODE, MENU_CODE, OPT,AMOUNT) VALUES(?,?,?,?)";
		System.out.println(def.getOrder_code());
		System.out.println(def.getMenu());
		System.out.println(def.getOpt());
		System.out.println(def.getAmount());
		jdbc.update(sql,def.getOrder_code(),def.getMenu(),def.getOpt(),def.getAmount());
	}

	public void deleteOrder(int no) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM TBL_ORDER WHERE CODE=?";
		jdbc.update(sql, no);
		
	}
	public void deleteOrderDetail(int no) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM TBL_ORDER_DETAIL WHERE CODE=?";
		jdbc.update(sql, no);
		
	}

	public List<orderdetail> selectOrderDetailAll() {
		// TODO Auto-generated method stub
		RowMapper<orderdetail> mapper=new RowMapper<orderdetail>() {
			public orderdetail mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				// TODO Auto-generated method stub
				return new orderdetail(rs.getInt("no"),rs.getInt("order_code"),rs.getString("menu"),rs.getString("opt"),rs.getInt("amount"));
			} 
		};
		String sql="SELECT * FROM TBL_ORDER_DETAIL";
		
		return jdbc.query(sql, mapper);
	}

	public List<order> selectOrderAll() {
		// TODO Auto-generated method stub
		RowMapper<order> mapper=new RowMapper<order>() {
			public order mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new order(rs.getInt("code"),rs.getString("customer_id"),rs.getString("order_date"),rs.getInt("total_price"),rs.getInt("delevery"));
			}
		};
		String sql="SELECT * FROM TBL_ORDER";
		return jdbc.query(sql,mapper);
	}
}
