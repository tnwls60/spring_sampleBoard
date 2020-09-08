package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	
	//xml���Ͽ� ó����
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);

	public BoardVO read(Long bno);
	
	//int : �� ���� �����Ͱ� ����,�����Ǿ����� ��ȯ
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	public int getTotalCount(Criteria cri);
	
	//��ۼ� ������Ʈ : �ΰ� �̻��� �����ʹ� @Param���� ó��
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
	
}
