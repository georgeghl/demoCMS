package top.clarkhg.democms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemocmsApplicationTests {

	@Test
	void contextLoads() {
		String test="aaa";
		Assertions.assertEquals("aaa", test);
	}

}
