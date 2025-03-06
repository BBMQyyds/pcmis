package com.lzy.common.config;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

import java.lang.reflect.Field;
import java.util.List;
/**
 * Swagger配置类，用于配置Swagger/OpenAPI的相关属性和行为
 * 通过该类的配置，可以灵活地控制API文档的生成和访问
 */
@Component
@EnableOpenApi
@ConfigurationProperties(prefix = "swagger")
@Data
public class SwaggerConfig {

    /**
     * 是否启用Swagger/OpenAPI文档生成和访问
     * 在生产环境中通常设置为false，以避免暴露系统接口信息
     */
    private Boolean enable;

    /**
     * 应用程序名称，用于在API文档中显示
     */
    private String applicationName;

    /**
     * 应用程序版本，用于在API文档中显示
     */
    private String applicationVersion;

    /**
     * 应用程序描述，用于在API文档中显示
     */
    private String applicationDescription;

    /**
     * 创建和配置Swagger/OpenAPI文档的Bean
     *
     * @return Docket对象，包含Swagger/OpenAPI文档的配置
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .pathMapping("/")

                // 定义是否开启swagger，false为关闭，可以通过变量控制，线上关闭
                .enable(enable)

                //配置api文档元信息
                .apiInfo(apiInfo())

                // 选择哪些接口作为swagger的doc发布
                .select()

                //apis() 控制哪些接口暴露给swagger
                .apis(RequestHandlerSelectors.any())

                .paths(PathSelectors.any())

                .build();
    }

    /**
     * 构建API文档的元信息
     *
     * @return ApiInfo对象，包含API文档的标题、描述、联系信息和版本号
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(applicationName)
                .description(applicationDescription)
                .contact(new Contact("项目与案件管理系统接口文档", "", ""))
                .version(applicationVersion)
                .build();
    }

    /**
     * 自定义处理Swagger/OpenAPI文档生成处理器的Bean后处理器
     * 用于调整和优化Swagger/OpenAPI文档的生成和访问
     *
     * @return BeanPostProcessor对象，用于处理Bean的初始化后操作
     */
    @Bean
    public static BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return new BeanPostProcessor() {

            /**
             * 在Bean初始化完成后进行处理
             *
             * @param bean 初始化完成的Bean对象
             * @param beanName Bean的名称
             * @return 处理后的Bean对象
             * @throws BeansException 如果处理过程中发生异常
             */
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof WebMvcRequestHandlerProvider) {
                    customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
                }
                return bean;
            }

            /**
             * 自定义处理请求映射信息
             *
             * @param mappings 请求映射信息列表
             * @param <T> 映射信息的类型
             */
            private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(List<T> mappings) {
                List<T> copy = mappings.stream()
                        .filter(mapping -> mapping.getPatternParser() == null)
                        .toList();
                mappings.clear();
                mappings.addAll(copy);
            }

            /**
             * 获取处理请求映射信息的Bean中的映射信息列表
             *
             * @param bean 包含映射信息的Bean对象
             * @return 映射信息列表
             * @throws IllegalStateException 如果反射访问字段时发生异常
             */
            private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
                try {
                    Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
                    field.setAccessible(true);
                    return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    throw new IllegalStateException(e);
                }
            }
        };
    }
}
