package emac.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
				return new Emcdonald( rs.getString("menu_name"), rs.getInt("amount"), rs.getInt("price"), rs.getInt("allprice"), rs.getInt("tax"), rs.getInt("revenue"), rs.getDate("wdate"));
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
		List<Emcdonald> emcdonaldDetail = jdbcTemplate.query(sql, new MyRowMapper(),menu_name);
		model.addAttribute("emcdonaldDetail",emcdonaldDetail);
		return emcdonaldDetail;
	}
}
