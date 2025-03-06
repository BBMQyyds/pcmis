package com.lzy.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * MybatisPlus配置类
 * 用于配置MybatisPlus的相关拦截器
 */
public class MybatisPlusConfig {

    /**
     * 创建性能拦截器
     * 性能拦截器用于拦截和分析SQL执行时间，帮助开发者发现和优化慢SQL
     *
     * @return PerformanceInterceptor 性能拦截器实例
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    /**
     * 创建分页拦截器
     * 分页拦截器用于对分页查询进行拦截和处理，实现高效的分页查询
     *
     * @return PaginationInterceptor 分页拦截器实例
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
