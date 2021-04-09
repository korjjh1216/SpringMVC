package cho.md.mapper;

import java.util.List;

import cho.md.domain.Board;

public interface BoardMapper {
	 List<Board> list();
	void insert(Board board);
	List<Board> read(long seq);
	void update(Board board);
	void delete(long seq);
}
