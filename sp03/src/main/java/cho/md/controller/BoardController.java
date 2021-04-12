package cho.md.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cho.md.domain.Board;
import cho.md.service.BoardServiceImpl;

@Controller
@RequestMapping("/boards/*")
public class BoardController {
	@Autowired
	private BoardServiceImpl BoardService;
	
	@GetMapping("list.do")
	public ModelAndView list() {
		List<Board> list =BoardService.listS();
			ModelAndView mv = new ModelAndView("board/boardlist", "list", list);
		
		return mv;
	}
	
	@GetMapping("/write.do")
	public String write() {
		return "address/write";
	}
	
	@PostMapping("/write.do")
	public String writeOk(Board address) {
		BoardService.insertS(address);
		
		return "redirect:list.do";
	}
	
	@GetMapping("del.do")
	public String delete(long seq) {
		BoardService.deleteS(seq);
		return "redirect:list.do";
	}
}
