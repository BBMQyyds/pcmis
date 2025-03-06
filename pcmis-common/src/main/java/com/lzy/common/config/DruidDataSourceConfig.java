package com.lzy.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Druid数据源配置类
 */
@Configuration
public class DruidDataSourceConfig {

    /**
     * 创建并配置Druid数据源
     *
     * @return 配置好的Druid数据源实例
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @ConditionalOnProperty(name = "spring.datasource.type", havingValue = "com.alibaba.druid.pool.DruidDataSource")
    public DataSource druid() {
        return new DruidDataSource();
    }

    /**
     * 配置Druid的统计视图Servlet
     *
     * @return StatViewServlet的ServletRegistrationBean实例
     */
    @Bean
    @ConditionalOnClass(DruidDataSource.class)
    public ServletRegistrationBean statViewServlet() {
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "2003");
        initParams.put("allow", "");
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        bean.setInitParameters(initParams);
        return bean;
    }

    /**
     * 配置一个web监控的filter
     *
     * @return WebStatFilter的FilterRegistrationBean实例
     */
    @Bean
    @ConditionalOnClass(DruidDataSource.class)
    public FilterRegistrationBean webStatFilter() {
        Map<String, String> initParams = new HashMap<>();
        // 这些不进行统计
        initParams.put("exclusions", "*.js,*.css,/druid/*");

        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(List.of("/*"));
        return bean;
    }
}
