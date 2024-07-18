package emac.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import emac.entity.CustomerEntity;
import emac.entity.Emcdonald;
import emac.entity.HappyEntity;
import emac.entity.MenuEntity;
import emac.entity.SnackEntity;



@Component
public class ManageRepositry {

	private JdbcTemplate jdbcTemplate;
	private MenuRowMapper rowMapper= new MenuRowMapper();

	@Autowired
	public ManageRepositry(DataSource ds){
		jdbcTemplate = new JdbcTemplate(ds);
	}
	class MenuRowMapper implements RowMapper<MenuEntity>{

		public MenuEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new MenuEntity(rs.getString(1),rs.getString(2),rs.getInt(3), rs.getString(4));
		}
		
	}

	public List<MenuEntity> selectAll() {
		String sql = "SELECT * FROM TBL_MENU";
		return jdbcTemplate.query(sql, rowMapper);
	}
	public List<HappyEntity> selectAll2() {
		RowMapper<HappyEntity> mapper = new RowMapper<HappyEntity>() {

			public HappyEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				// TODO Auto-generated method stub
				return new HappyEntity(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4));
			}
		};
		String sql = "SELECT * FROM TBL_HAPPY";
		return jdbcTemplate.query(sql, mapper);
	}
	
	public List<SnackEntity> selectAll3() {
		RowMapper<SnackEntity> mapper = new RowMapper<SnackEntity>() {

			public SnackEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				// TODO Auto-generated method stub
				return new SnackEntity(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4));
			}
		};
		String sql = "SELECT * FROM TBL_SNACK";
		return jdbcTemplate.query(sql, mapper);
	}
	
}
