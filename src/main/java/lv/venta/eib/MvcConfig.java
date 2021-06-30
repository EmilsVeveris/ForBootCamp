package lv.venta.eib;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index.html").setViewName("index.html");
		registry.addViewController("/").setViewName("index.html");
		registry.addViewController("/register").setViewName("register");
		registry.addViewController("/login").setViewName("login");
	}

}