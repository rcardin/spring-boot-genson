package in.rcard.genson;

import static org.assertj.core.api.Assertions.assertThat;

import com.owlike.genson.ext.spring.GensonMessageConverter;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.HttpMessageConverter;

@SpringBootTest
class SpringBootGensonApplicationTests {

	@Autowired
	private List<HttpMessageConverter<?>> converters;
	
	@Autowired
	private GensonMessageConverter gensonMessageConverter;
	
	@Test
	void contextLoads() {
		assertThat(converters).contains(gensonMessageConverter);
	}

}
