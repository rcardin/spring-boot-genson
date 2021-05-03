package in.rcard.genson;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.HttpMessageConverter;

@SpringBootTest
class SpringBootGensonApplicationTests {

	@Autowired
	private List<HttpMessageConverter<?>> converters;
	
	@Test
	void contextLoads() {
		System.out.println(converters);
	}

}
