package emac.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import emac.entity.BoardEntity;
import emac.entity.CommEntity;
import emac.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	
	
	@RequestMapping("{page}")
	public String getPageBoard(@PathVariable int page, Model model, HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		
		model.addAttribute("boardList",boardService.getAllBoard(page));
		model.addAttribute("page",page);
		return "/views/board";
		
	}
	
	@RequestMapping("detail/{no}")
	public String getBoard(@PathVariable("no") int no, Model model,HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		boardService.autoAddCount(no);
		
		model.addAttribute("board",boardService.selectBoard(no));
		model.addAttribute("commList", boardService.selectAllComm(no));

		
		return "/views/boardDetail";
	}
	

	@RequestMapping("comment/{no}")
	public String regComment(@PathVariable("no") int bno, 
			HttpServletRequest request,Model model) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		model.addAttribute("bno", bno);
		model.addAttribute("mid", request.getParameter("id"));
		CommEntity comment = new CommEntity(bno,request.getParameter("id"),request.getParameter("content"));
		boardService.regComment( comment);
		model.addAttribute("board",boardService.selectBoard(bno));
		model.addAttribute("commList", boardService.selectAllComm(bno));
		return "/views/boardDetail";
	}
	
	@RequestMapping("/regBoard")
	public String pass() {
		return "/views/regBoardForm";
	}
	@RequestMapping("/regBoardProc")
	public String regBoard(@RequestParam String title,@RequestParam String content,
			@RequestParam String writer,	Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		BoardEntity board = new BoardEntity(title,content, writer);
		boardService.insertBoard(board);
		return "redirect:main.jsp";
	}
	
	/*@RequestMapping("detail/delete/{bno}")
	public String deleteCheck(@PathVariable int bno, Model model){
		
		//비밀번호 재입력 받아 글삭제하기....
	}*/
	
	@RequestMapping("detail/delete/{bno}")
	public String deleteProc(@PathVariable int bno,  Model model){
		
		model.addAttribute("board",boardService.deleteBoard(bno));
		
		
		return "/views/deleteRes";
	}
	
	
	@RequestMapping("deleteComm/{rno}")
	public String deleteCom(@PathVariable int rno, Model model){
		
		return "redirect:../detail/"+boardService.deleteComm(rno);
	}
	
	@RequestMapping("detail/update/{bno}")
	public String updatePass(@PathVariable int bno, Model model){
		model.addAttribute("board", boardService.selectBoard(bno));
		model.addAttribute("bno",bno);
		return "views/updateBoardForm";
	}
	
	@RequestMapping("updateBoardProc/{bno}")
	public String updateProc(@PathVariable int bno, BoardEntity board, Model model){
		int tf = boardService.updateBoard(bno, board);
		return "views/updateBoardRes";
	}
	
	@RequestMapping("/searchBoard")
	public String searchBoard(@RequestParam("column")String column,@RequestParam("target")String target,  Model model){
		System.out.println("gethere?");
		model.addAttribute("boardList", boardService.searchBoard(column, target));
		return "views/board";
	}
}
