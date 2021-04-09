package cho.md.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cho.md.domain.Board;


public interface BoardService {
	List<Board> listS();
	void insertS(Board address);
	List<Board> readS(long seq);
	void updateS(Board address);
	void deleteS(long seq);
}
