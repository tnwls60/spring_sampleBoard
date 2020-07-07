package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
	//xml파일에 처리함
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);

	public BoardVO read(Long bno);
	
	//int : 몇 건의 데이터가 삭제,수정되었는지 반환
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
}
