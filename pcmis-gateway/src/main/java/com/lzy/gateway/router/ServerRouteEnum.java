package com.lzy.gateway.router;

/**
 * 服务器路由枚举类，用于定义和管理服务器上不同服务的路由信息
 */
public enum ServerRouteEnum {

    // 定义各种路由的枚举实例，包括路由ID和Swagger信息
    CASE_ROUTE("pcmis-case", "案件管理接口"),
    FILE_ROUTE("pcmis-file", "文件管理接口"),
    PROJECT_ROUTE("pcmis-project", "项目管理接口"),
    RISK_ROUTE("pcmis-risk", "风险评估接口"),
    SECURITY_ROUTE("pcmis-security", "系统安全接口"),
    USER_ROUTE("pcmis-user", "用户管理接口"),
    VISUAL_ROUTE("pcmis-visual", "可视化管理接口");

    // 成员变量：路由ID和Swagger信息
    private String routeId;
    private String swaggerInfo;

    /**
     * 构造函数，初始化枚举实例
     *
     * @param routeId    路由ID，用于唯一标识一个服务路由
     * @param swaggerInfo Swagger信息，描述该路由提供的接口类型
     */
    ServerRouteEnum(String routeId, String swaggerInfo) {
        this.routeId = routeId;
        this.swaggerInfo = swaggerInfo;
    }

    /**
     * 根据路由ID获取对应的Swagger信息
     *
     * @param routId 路由ID，用于查找对应的Swagger信息
     * @return 如果找到匹配的路由ID，则返回对应的Swagger信息；否则返回null
     */
    public static String getSwaggerInfoByRoutId(String routId) {
        for (ServerRouteEnum routeEnum : ServerRouteEnum.values()) {
            if (routId.equals(routeEnum.getRouteId())) {
                return routeEnum.getSwaggerInfo();
            }
        }
        return null;
    }

    // Getter和Setter方法，用于获取和设置枚举实例的成员变量值
    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getSwaggerInfo() {
        return swaggerInfo;
    }

    public void setSwaggerInfo(String swaggerInfo) {
        this.swaggerInfo = swaggerInfo;
    }
}
