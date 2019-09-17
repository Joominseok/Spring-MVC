package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	// BoardService 주입.
	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	//BoardService 주입이 잘 되었는지 테스트.
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
}
