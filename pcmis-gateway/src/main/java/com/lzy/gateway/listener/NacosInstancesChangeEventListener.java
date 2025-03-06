package com.lzy.gateway.listener;

import com.alibaba.nacos.client.naming.event.InstancesChangeEvent;
import com.alibaba.nacos.common.notify.listener.Subscriber;
import com.alibaba.nacos.common.utils.JacksonUtils;
import com.lzy.gateway.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cloud.loadbalancer.cache.LoadBalancerCacheManager;
import org.springframework.cloud.loadbalancer.core.CachingServiceInstanceListSupplier;
import org.springframework.stereotype.Component;

/**
 * 监听Nacos实例变化事件的组件
 * 该类继承自Subscriber，用于订阅Nacos实例变化事件，当事件触发时，更新Spring Gateway的缓存
 */
@Component
@Slf4j
public class NacosInstancesChangeEventListener extends Subscriber<InstancesChangeEvent> {

    /**
     * 处理实例变化事件
     * 当接收到实例变化事件时，更新负载均衡缓存中的服务实例列表
     *
     * @param event 实例变化事件，包含发生变化的服务名
     */
    @Override
    public void onEvent(InstancesChangeEvent event) {
        // 记录接收到的事件信息
        log.info("spring gateway receive refresh event ：{}, refresh cache start ...", JacksonUtils.toJson(event));
        // 获取负载均衡缓存管理器
        LoadBalancerCacheManager cacheManager = BeanUtil.getBean(LoadBalancerCacheManager.class);
        // 获取服务实例列表缓存
        Cache cache = cacheManager.getCache(CachingServiceInstanceListSupplier.SERVICE_INSTANCE_CACHE_NAME);
        // 如果缓存存在，则清除对应服务名的缓存，以触发重新获取实例列表
        if (cache != null) {
            cache.evict(event.getServiceName());
        }
        // 记录缓存更新完成
        log.info("spring gateway refresh finish .");
    }

    /**
     * 返回订阅的事件类型
     * 该方法用于指定该监听器感兴趣的事件类型，此处为InstancesChangeEvent
     *
     * @return 订阅的事件类型，这里是InstancesChangeEvent.class
     */
    @Override
    public Class<? extends com.alibaba.nacos.common.notify.Event> subscribeType() {
        return InstancesChangeEvent.class;
    }
}

