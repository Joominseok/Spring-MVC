package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor  //<- 모든 파라미터를 이용할 수 있는 생성자를 만드는 어노테이션.
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		log.info("register....." + board);
		
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		// 조회 작업
		log.info("get....." + bno);
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// 수정 작업
		log.info("modify....." + board);
		
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		// 삭제 작업
		log.info("remove....." + bno);
		
		return mapper.delete(bno) == 1;
	}

/*	@Override
	public List<BoardVO> getList() {
		//목록(리스트) 작업의 구현
		
		log.info("getList.......");
		return mapper.getList();
	}*/
	
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		
		log.info("get List with criteria: "+ cri);
		
		return mapper.getListWithPaging(cri);
				
	}

}
