package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	
	//@Select("select * from tbl_board where bno > 0")
	// ->위에 @Select는 Boardmapper.xml을 사용하기 전에 사용했으므로 xml생성후에는 지워준것.
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	// 페이징 처리를 위한 메소드
	public List<BoardVO> getListWithPaging(Criteria cri);
	
}
