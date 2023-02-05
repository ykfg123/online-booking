package com.doudou.onlinebook.common.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 允许访问swagger的静态页面
 * @author 程就人生
 * @Date
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

//  @Value("${spring.servlet.multipart.location}")
//  private String uploadPath;

    /**
     * PUT方式提交，无法获取参数
     * @return
     */
    @Bean
    public HttpPutFormContentFilter httpPutFormContentFilter() {
        return new HttpPutFormContentFilter();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){

        //测试环境图片地址映射,映射成url就可以访问的
        // registry.addResourceHandler("/images/**").addResourceLocations("file:" + uploadPath);

        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

    }
}
