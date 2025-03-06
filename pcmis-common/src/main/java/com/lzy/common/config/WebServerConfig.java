package com.lzy.common.config;

import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * Web服务器配置类，用于定制化Web服务器（如Tomcat）的配置
 * 通过实现WebServerFactoryCustomizer接口，我们可以灵活地配置Web服务器的各个方面
 */
@Component
public class WebServerConfig implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    /**
     * 定制化Web服务器工厂的方法
     * 这里我们特别定制了Tomcat的连接器配置，以满足特定的需求
     *
     * @param configurableWebServerFactory 可配置的Web服务器工厂，允许我们对其进行定制
     */
    @Override
    public void customize(ConfigurableWebServerFactory configurableWebServerFactory) {
        //使用对应工厂类提供给我们的接口定制化我们的tomcat connector
        ((TomcatServletWebServerFactory) configurableWebServerFactory).addConnectorCustomizers(connector -> {
            //获取connector的协议处理对象，这里是Http11NioProtocol
            Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();

            //定制化keepalivetimeout,设置60秒内没有请求则服务端自动断开keepalive链接
            protocol.setKeepAliveTimeout(60000);
            //当客户端发送超过10000个请求则自动断开keepalive链接
            protocol.setMaxKeepAliveRequests(10000);
        });
    }
}
