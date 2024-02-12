package hello.login.web.exception;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import hello.login.web.filter.LogFilter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Bean
	public FilterRegistrationBean logFilter(){
		FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
		filterFilterRegistrationBean.setFilter(new LogFilter());
		filterFilterRegistrationBean.setOrder(1);
		filterFilterRegistrationBean.addUrlPatterns("/*");
		filterFilterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ERROR);
		return filterFilterRegistrationBean;
	}

}
