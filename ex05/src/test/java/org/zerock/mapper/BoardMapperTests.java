package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	/*
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		
		BoardVO board = new BoardVO();
		board.setTitle("���� �ۼ��ϴ� ��");
		board.setContent("���� �ۼ��ϴ� ����");
		board.setWriter("����");
		
		mapper.insert(board);
		
		log.info(board);
	}
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO board = new BoardVO();
		board.setTitle("���� �ۼ��ϴ� �� select key");
		board.setContent("���� �ۼ��ϴ� ���� select key");
		board.setWriter("����");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	
	@Test
	public void testRead() {
		
		//�����ϴ� �Խù� ��ȣ�� �׽�Ʈ  5���� ��ȸ
		BoardVO board = mapper.read(5l);
		
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		//3���� ���� : ������ 1, ������ 0 ��ȯ
		log.info("DELETE COUNT : " + mapper.delete(20L));
	}
	
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		//�����ϴ� ��ȣ���� Ȯ���� ��
		board.setBno(1l);
		board.setTitle("������ ����");
		board.setContent("������ ����");
		board.setWriter("�ۼ���");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: " + count);
	}
	
	
	@Test
	public void testPaging() {
		
		Criteria cri = new Criteria();
		//10���� 3������
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board.getBno()));
	}
	*/
	
	@Test
	public void testSearch() {
		
		Criteria cri = new Criteria();
		cri.setKeyword("����");
		cri.setType("TCW");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
		
	}
	
	
}