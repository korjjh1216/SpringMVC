package cho.md.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cho.md.domain.Board;
import cho.md.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper boardDao;
	
	@Override
	public List<Board> listS() {
		// TODO Auto-generated method stub
		return boardDao.list();
	}

	@Override
	public void insertS(Board board) {
		// TODO Auto-generated method stub
		boardDao.insert(board);
		
	}

	@Override
	public void deleteS(long seq) {
		// TODO Auto-generated method stub
		boardDao.delete(seq);
	}

	@Override
	public void updateS(Board board) {
		// TODO Auto-generated method stub
		boardDao.update(board);
	}

	@Override
	public List<Board> readS(long seq) {
		// TODO Auto-generated method stub
		return boardDao.read(seq);
	}

}
