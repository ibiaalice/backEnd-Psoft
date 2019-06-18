
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
		filterRb.addUrlPatterns("/api/private");
		filterRb.addUrlPatterns("/api/user");
		filterRb.addUrlPatterns("/api/discipline");
		return filterRb;
	}
	
	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}
	
}