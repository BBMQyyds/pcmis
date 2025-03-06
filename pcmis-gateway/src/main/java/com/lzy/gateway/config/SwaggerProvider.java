package com.lzy.gateway.config;

// SwaggerProvider类提供了Swagger资源的获取功能，用于在Spring Cloud Gateway中集成Swagger
// 该类实现了SwaggerResourcesProvider接口，以提供自定义的Swagger资源列表
//@Component
//@Primary
public class SwaggerProvider {
//public class SwaggerProvider implements SwaggerResourcesProvider {
//    public static final String API_URI = "/v2/api-docs";
//    // RouteLocator用于获取路由信息
//    private final RouteLocator routeLocator;
//    // GatewayProperties包含网关的配置属性
//    private final GatewayProperties gatewayProperties;
//
//    // 构造函数注入RouteLocator和GatewayProperties
//    public SwaggerProvider(RouteLocator routeLocator, GatewayProperties gatewayProperties) {
//        this.routeLocator = routeLocator;
//        this.gatewayProperties = gatewayProperties;
//    }
//
//    // 获取Swagger资源列表
//    @Override
//    public List<SwaggerResource> get() {
//        List<SwaggerResource> resources = new ArrayList<>();
//        List<String> routes = new ArrayList<>();
//        // 取出gateway的route
//        routeLocator.getRoutes().subscribe(route -> routes.add(route.getId()));
//        // 结合配置的route-路径(Path)，和route过滤，只获取在枚举中说明的route节点
//        gatewayProperties.getRoutes().stream().filter(routeDefinition -> routes.contains(routeDefinition.getId()))
//                .forEach(routeDefinition -> routeDefinition.getPredicates().stream()
//                        // 目前只处理Path断言  Header或其他路由需要另行扩展
//                        .filter(predicateDefinition -> ("Path").equalsIgnoreCase(predicateDefinition.getName()))
//                        .forEach(predicateDefinition -> {
//                                    String routeId = routeDefinition.getId();
//                                    String swaggerInfo = ServerRouteEnum.getSwaggerInfoByRoutId(routeId);
//                                    // 这里重复的打印语句可能是为了调试，应考虑移除
//                                    System.out.println("routeId: " + routeId + " swaggerInfo: " + swaggerInfo);
//                                    System.out.println("routeId: " + routeId + " swaggerInfo: " + swaggerInfo);
//                                    System.out.println("routeId: " + routeId + " swaggerInfo: " + swaggerInfo);
//                                    System.out.println("routeId: " + routeId + " swaggerInfo: " + swaggerInfo);
//                                    System.out.println("routeId: " + routeId + " swaggerInfo: " + swaggerInfo);
//                                    System.out.println("routeId: " + routeId + " swaggerInfo: " + swaggerInfo);
//                                    System.out.println("routeId: " + routeId + " swaggerInfo: " + swaggerInfo);
//                                    System.out.println("routeId: " + routeId + " swaggerInfo: " + swaggerInfo);
//                                    if (StringUtils.isNotEmpty(swaggerInfo)) {
//                                        resources.add(swaggerResource(swaggerInfo, predicateDefinition.getArgs().get(NameUtils.GENERATED_NAME_PREFIX + "0").replace("/**", API_URI)));
//                                    }
//                                }
//                        ));
//        return resources;
//    }
//
//    // 创建SwaggerResource实例
//    private SwaggerResource swaggerResource(String name, String location) {
//        SwaggerResource swaggerResource = new SwaggerResource();
//        swaggerResource.setName(name);
//        swaggerResource.setLocation(location);
//        swaggerResource.setSwaggerVersion("3.0");
//        return swaggerResource;
//    }

}
