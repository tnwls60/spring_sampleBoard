package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	//�׽�Ʈ ���� �ش� ��ȣ�� �Խù��� �����ϴ��� Ȯ���� ��
	private Long[] bnoArr = { 1081351L, 1081350L, 1081349L, 1081348L, 1081347L};

	@Setter( onMethod_ = @Autowired )
	private ReplyMapper mapper;
	
	
	@Test
	public void testList2() {
		Criteria cri = new Criteria(2, 10);
		
		//1081350L
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 1081350L);
		
		replies.forEach(reply -> log.info(reply));
	}
	
	
	
	/*
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		replies.forEach(reply -> log.info(reply));
	}
	
	
	@Test
	public void testUpdate() {
		
		Long targetRno = 5L;
		
		ReplyVO vo = mapper.read(targetRno);
		vo.setReply("Update Reply");
		
		int count = mapper.update(vo);
		log.info("UPDATE COUNT: " + count);
	}
	
	
	
	@Test
	public void testDelete() {
		Long targetRno = 1L;
		mapper.delete(targetRno);
	}
	
	
	@Test
	public void testRead() {
		
		//�ִ� ��ȣ�� �׽�Ʈ
		Long targetRno = 10L;
		ReplyVO vo = mapper.read(targetRno);
		log.info(vo);
	}
	
	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			
			ReplyVO vo = new ReplyVO();
			
			//�Խù��� ��ȣ
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("����׽�Ʈ" + i);
			vo.setReplyer("replyer" + i);
			
			mapper.insert(vo);
			
		});
	}
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	*/
	
}

