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

@Component
@Slf4j
public  class NacosInstancesChangeEventListener extends Subscriber<InstancesChangeEvent> {

    @Override
    public void onEvent(InstancesChangeEvent event) {
        log.info("spring gateway receive refresh event ：{}, refresh cache start ...", JacksonUtils.toJson(event));
        LoadBalancerCacheManager cacheManager = BeanUtil.getBean(LoadBalancerCacheManager.class);
        Cache cache = cacheManager.getCache(CachingServiceInstanceListSupplier.SERVICE_INSTANCE_CACHE_NAME);
        if (cache != null) {
            cache.evict(event.getServiceName());
        }
        log.info("spring gateway refresh finish .");
    }

    @Override
    public Class<? extends com.alibaba.nacos.common.notify.Event> subscribeType() {
        return InstancesChangeEvent.class;
    }
}
