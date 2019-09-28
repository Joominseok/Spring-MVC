package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	//페이지 번호
	private int pageNum;
	//한 페이지에 몇 개의 데이터를 보여줄것인가인 변수
	private int amount;
	
	public Criteria() {
		//한 1페이지에 10개로 지정.
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
