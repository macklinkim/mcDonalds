package emac.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import emac.entity.BoardEntity;
import emac.entity.CommEntity;

@Component
public class BoardRepository {

	private JdbcTemplate jdbcTemplate;
	public BoardRepository(){}
	@Autowired
	public BoardRepository(DataSource ds){
		jdbcTemplate=new JdbcTemplate(ds);
	}
	
	public List<BoardEntity> getAllBoard(final int page) {
		int page_size = 10;
		String sql1 = "select count(*) from tbl_board";
		int max = jdbcTemplate.queryForInt(sql1);
		class MyRowMapper implements RowMapper<BoardEntity> {

			public BoardEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				 BoardEntity board= new BoardEntity(rs.getInt("NO"),rs.getString("WRITER"),rs.getString("TITLE"),
						 rs.getString("CONTENT"),rs.getDate("WDATE"),rs.getInt("COUNT"),rs.getInt("REPLY"));
				 return board;
			}
		}
		String sql = "SELECT * FROM TBL_BOARD WHERE NO BETWEEN ? AND ? ORDER BY NO DESC";
		List<BoardEntity> boardList = jdbcTemplate.query(sql, new MyRowMapper(),max-page*page_size,max-(page -1)*page_size + 1);
		return boardList;
	}
	
	public void autoAddCount(int no){
		String sql = "select REPLY from TBL_BOARD where NO = ?";
		int cnt = jdbcTemplate.queryForInt(sql,no);
		cnt++;
		sql = "update TBL_BOARD set REPLY=? where NO=?";
		jdbcTemplate.update(sql, cnt,no);
		
	}
	public BoardEntity selectBoard(int no) {
		String sql = "SELECT * FROM TBL_BOARD WHERE NO=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<BoardEntity>(){

			public BoardEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				return  new BoardEntity(rs.getInt("NO"),rs.getString("WRITER"),rs.getString("TITLE"),
						 rs.getString("CONTENT"),rs.getDate("WDATE"),rs.getInt("COUNT"),rs.getInt("REPLY"));
			}
		},no);
	}
	public List<CommEntity> selectAllComm(int no) {
		class MyRowMapper implements RowMapper<CommEntity> {

			public CommEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				return  new CommEntity(rs.getInt(1),rs.getInt(2),rs.getString(3), 
				rs.getDate(4),rs.getString(5));
			}
		}
		String sql = "SELECT * FROM tbl_reply where BNO=? ORDER BY RNO";
		List<CommEntity> commList = jdbcTemplate.query(sql, new MyRowMapper(),no);
		return commList;
	
	}
	public void regComment(CommEntity comment) {
		String sql = "insert into tbl_reply(BNO,CONTENT,WDATE,B_WRITER) values(?,?,?,?)";
		jdbcTemplate.update(sql,comment.getBno(),comment.getContent(),comment.getWdate(),comment.getMid());
		int cnt = jdbcTemplate.queryForInt("select count(*) from tbl_reply where BNO = ?",comment.getBno());
		jdbcTemplate.update("update tbl_board set COUNT = ? where NO=?",cnt,comment.getBno());
	}

	public BoardEntity insertBoard(BoardEntity board) {
		String sql="INSERT INTO TBL_BOARD(WRITER,TITLE,CONTENT,WDATE,REPLY,COUNT) VALUES(?,?,?,?,?,?)";
		
		jdbcTemplate.update(sql,board.getId(),board.getTitle(),board.getContent(),new Date(),0,0);
		
		return board;
	
	}
	public BoardEntity deleteBoard(int bno) {
		String sql = "delete from TBL_REPLY where BNO = ?";
		jdbcTemplate.update(sql,bno);
		
		sql = "update tbl_board set TITLE = '삭제된 글입니다', CONTENT = ' ', REPLY = 0, COUNT = 0  where NO =?";
		jdbcTemplate.update(sql,bno);
		sql = "select * from tbl_board where NO = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<BoardEntity>(){

			public BoardEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				return new BoardEntity(rs.getInt("NO"),rs.getString("WRITER"),rs.getDate("WDATE"), 
						rs.getString("TITLE"),rs.getString("CONTENT"),rs.getInt("COUNT"),rs.getInt("REPLY")
						);
			}
			
			
		},bno);
	}
	public int updateBoard(int bno, BoardEntity board) {
		String sql = "update tbl_board set TITLE = ?, CONTENT = ?, WDATE =? where NO = ?";
		
		return jdbcTemplate.update(sql,board.getTitle(), board.getContent(), new Date(), bno);
	}
	public int deleteComm(int rno) {
		String sql = "select BNO from tbl_reply where RNO = ?";
		int bno = jdbcTemplate.queryForInt(sql,rno);
		sql = "delete from tbl_reply where RNO = ?";
		jdbcTemplate.update(sql,rno);
		
		return bno;
	}
	public List<BoardEntity> searchBoard(String column, String target) {
		class MyRowMapper implements RowMapper<BoardEntity> {

			public BoardEntity mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				 BoardEntity board= new BoardEntity(rs.getInt("NO"),rs.getString("WRITER"),rs.getDate("WDATE"), 
				rs.getString("title"),rs.getString("CONTENT"),rs.getInt("COUNT"),rs.getInt("REPLY"));
				 return board;
		
			}
		}
		String sql = "SELECT * FROM tbl_board where "+column+" like '%"+target+"%'";
		List<BoardEntity> boardList = jdbcTemplate.query(sql, new MyRowMapper());
		return boardList;
		
	 
	}
}
