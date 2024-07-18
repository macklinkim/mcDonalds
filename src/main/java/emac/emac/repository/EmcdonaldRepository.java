package emac.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import emac.entity.Emcdonald;

@Component
public class EmcdonaldRepository {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmcdonaldRepository(DataSource ds){
		jdbcTemplate = new JdbcTemplate(ds);
	}
	public void registOrder(Emcdonald emcdonald) {
		String sql="INSERT INTO TBL_REVENUE(MENU_NAME, AMOUNT, PRICE, TAX, ALLPRICE, REVENUE, WDATE) VALUES(?,?,?,?,?,?,?)";
		Date date = new Date();
		int year = date.getYear()+1900;
		int month = date.getMonth()+1;
		int day = date.getDate();

		jdbcTemplate.update(sql, emcdonald.getMenu_name(), emcdonald.getAmount(), emcdonald.getPrice(),
				emcdonald.getTax(), emcdonald.getAllprice(), emcdonald.getRevenue(),  year+"-"+month+"-"+day);
	}
	
	public List<Emcdonald> getOrderList() {
		class MyRowMapper implements RowMapper<Emcdonald>{
			public Emcdonald mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Emcdonald(rs.getString("menu_name"), rs.getInt("amount"), rs.getInt("price"), rs.getInt("allprice"), rs.getInt("tax"), rs.getInt("revenue"), rs.getDate("wdate"));
			}
		}
		String sql = "SELECT * FROM TBL_REVENUE";
		List<Emcdonald> emcdonaldOrderlist = jdbcTemplate.query(sql, new MyRowMapper());
		return emcdonaldOrderlist;
	}
	
	public List<Emcdonald> emcdonaldDetail(Model model, String menu_name) {
		class MyRowMapper implements RowMapper<Emcdonald>{
			public Emcdonald mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Emcdonald(rs.getString("menu_name"), rs.getInt("amount"), rs.getInt("price"), rs.getInt("allprice"), rs.getInt("tax"), rs.getInt("revenue"), rs.getDate("wdate"));
			}
		}
		String sql = "SELECT * FROM TBL_REVENUE WHERE MENU_NAME=?";
		List<Emcdonald> emcdonaldDetail = jdbcTemplate.query(sql, new MyRowMapper(), menu_name);
		model.addAttribute("emcdonaldDetail",emcdonaldDetail);
		return emcdonaldDetail;
	}
	
	public void emcdonaldDelete(Model model, String customer_id) {
		
		jdbcTemplate.update("DELETE FROM TBL_REVENUE WHERE customer_name=?", new Object[] {customer_id});
	}
	public List<Emcdonald> getOrder() {
		class MyRowMapper implements RowMapper<Emcdonald>{
			public Emcdonald mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Emcdonald( rs.getString("menu_name"), rs.getInt("amount"), rs.getInt("price"), rs.getInt("allprice"), rowNum, rowNum, rs.getDate("wdate"),rs.getString("customer_name"),rs.getString("address"));
			}
		}
		String sql = "SELECT * FROM TBL_REVENUE";
		List<Emcdonald> emcdonaldOrderlist = jdbcTemplate.query(sql, new MyRowMapper());
		return emcdonaldOrderlist;
	}
	public List<Integer> getTenData() {
		List<Integer> graphTen = new ArrayList<Integer>();
		
		Calendar cal = new GregorianCalendar();
		for(int i=0;i<10;i++){
		String sql = "select sum(ALLPRICE) from TBL_REVENUE where wdate = ?";
		graphTen.add(jdbcTemplate.queryForInt(sql,cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH) + 1)+"-"+cal.get(Calendar.DAY_OF_MONTH)  ));
		cal.add(Calendar.DATE, -1);
		}
		return graphTen;
	}
	public List<Integer> getThreeMonth() {
		List<Integer> graphMonth = new ArrayList<Integer>();
		
		Calendar cal = new GregorianCalendar();
		
		for(int i=0;i<3;i++){
			String sql = "select sum(ALLPRICE) from TBL_REVENUE where wdate like ?";
			if((cal.get(Calendar.MONTH) + 1)>10){
			graphMonth.add(jdbcTemplate.queryForInt(sql,cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH) + 1)+"%"  ));
			}else{
				graphMonth.add(jdbcTemplate.queryForInt(sql,cal.get(Calendar.YEAR)+"-0"+(cal.get(Calendar.MONTH) + 1)+"%"  ));
			}
			cal.add(Calendar.MONTH   , -1);
		}
		
		return graphMonth;
	}
}