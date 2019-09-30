package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	
	private int startPage; //페이징의 시작번호 
	private int endPage;   //페이징의 끝번호 
	private boolean prev;  //전 페이지
	private boolean next;  //다음 페이지
	
	private int total;     //전체 데이터 수
	private Criteria cri;  //안에 페이지번호(pageNum), 한페이지에 보이는데이터(amount)
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		//페이징의 끝 번호 계산
		this.endPage = (int) (Math.ceil(cri.getPageNum()/ 10.0)) * 10;
		//페이징의 시작 번호 계산
		this.startPage = this.endPage - 9;
		
		//total을 통한 endPage의 재계산
		int realEnd = (int) (Math.ceil((total * 1.0)/cri.getAmount()));
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		
		this.next = this.endPage < realEnd;
		
	}
	
}
