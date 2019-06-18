
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import controller.TokenFilter;

@SpringBootApplication(scanBasePackages={"com.*", "exceptions.*"})
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean filterJwt(){
		FilterRegistrationBean filterRb = new FilterRegistrationBean();
		filterRb.setFilter(new TokenFilter());
		filterRb.addUrlPatterns("/private");
		return filterRb;
	}
}