package com.lzy.gateway.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 一个实用工具类，用于手动获取Spring上下文中的Bean
 * 实现了ApplicationContextAware接口，以自动装配ApplicationContext对象
 */
@Component
public class BeanUtil implements ApplicationContextAware {
    /**
     * 存储Spring上下文对象
     */
    private static ApplicationContext context;

    /**
     * 手动设置ApplicationContext对象
     *
     * @param applicationContext Spring上下文对象，包含Bean的定义和配置
     */
    public static void set(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    /**
     * 根据Bean的类类型获取Bean实例
     *
     * @param beanClass Bean的类类型
     * @param <T> 泛型参数，表示Bean的类型
     * @return 返回指定类型的Bean实例
     */
    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }

    /**
     * 根据Bean的名称获取Bean实例
     *
     * @param beanName Bean的名称
     * @param <T> 泛型参数，表示Bean的类型
     * @return 返回指定名称的Bean实例
     */
    public static <T> T getBean(String beanName) {
        return (T) context.getBean(beanName);
    }

    /**
     * 根据Bean的名称和类类型获取Bean实例
     *
     * @param name Bean的名称
     * @param beanClass Bean的类类型
     * @param <T> 泛型参数，表示Bean的类型
     * @return 返回指定名称和类型的Bean实例
     */
    public static <T> T getBean(String name, Class<T> beanClass) {
        return context.getBean(name, beanClass);
    }

    /**
     * 实现ApplicationContextAware接口的方法，用于自动装配ApplicationContext对象
     *
     * @param applicationContext Spring上下文对象，包含Bean的定义和配置
     * @throws BeansException 如果设置过程中出现错误
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
