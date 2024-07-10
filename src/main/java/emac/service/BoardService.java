package emac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import emac.entity.BoardEntity;
import emac.entity.CommEntity;
import emac.repository.BoardRepository;

@Component
public class BoardService {
	
	@Autowired
	BoardRepository boardRepository;
	
	public List<BoardEntity> getAllBoard(int page) {
		return boardRepository.getAllBoard(page);
	}

	public void autoAddCount( int no) {
		boardRepository.autoAddCount(no);
	}

	public BoardEntity selectBoard(int no) {
		return boardRepository.selectBoard(no);
		
	}

	public List<CommEntity> selectAllComm(int no) {
		return boardRepository.selectAllComm(no);
	}

	public void regComment(CommEntity comment) {
		boardRepository.regComment(comment);
	}

	public void insertBoard(BoardEntity board) {
		boardRepository.insertBoard(board);
	}

	public BoardEntity deleteBoard(int bno) {
		return boardRepository.deleteBoard(bno);
	}

	public int updateBoard(int bno, BoardEntity board) {
		return boardRepository.updateBoard(bno,board);
	}

	public int deleteComm(int rno) {
		return boardRepository.deleteComm(rno);		
	}

	public List<BoardEntity> searchBoard(String column, String target) {
		return boardRepository.searchBoard(column, target);
	}


}
