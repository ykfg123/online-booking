package com.doudou.onlinebook.common.configurer;



import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：zhuyk
 * @date ：Created in 2021/11/12 22:41
 * @modified By：
 * @version: $
 */
@Configuration
@MapperScan("com.doudou.onlinebook.dao*")
public class MybatisConfiguration {

    /*
     * 分页插件，自动识别数据库类型
     * 多租户，请参考官网【插件扩展】
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }



}


