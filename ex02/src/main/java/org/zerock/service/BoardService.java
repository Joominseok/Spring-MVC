package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
	
	//추가
	public void register(BoardVO board);
	
	//특정 번호 읽기
	public BoardVO get(Long bno);
	
	//수정
	public boolean modify(BoardVO board);
	
	//삭제
	public boolean remove(Long bno);
	
	//전체 읽기
	public List<BoardVO> getList();
}
