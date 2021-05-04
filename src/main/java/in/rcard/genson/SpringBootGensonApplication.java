package in.rcard.genson;

import com.owlike.genson.Genson;
import com.owlike.genson.ext.spring.GensonMessageConverter;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringBootGensonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGensonApplication.class, args);
	}

	@Configuration
	static class GensonConfiguration {
		
		@Bean
		public Genson genson() {
			return new Genson();
		}
		
		@Bean
		public HttpMessageConverter<Object> messageConverter() {
			return new GensonMessageConverter(genson());
		}
	}
	
}
