package com.lzy.gateway.router;

public enum ServerRouteEnum {

    CASE_ROUTE("pcmis-case", "案件管理接口"),
    FILE_ROUTE("pcmis-file", "文件管理接口"),
    PROJECT_ROUTE("pcmis-project", "项目管理接口"),
    RISK_ROUTE("pcmis-risk", "风险评估接口"),
    SECURITY_ROUTE("pcmis-security", "系统安全接口"),
    USER_ROUTE("pcmis-user", "用户管理接口"),
    VISUAL_ROUTE("pcmis-visual", "可视化管理接口");

    private String routeId;
    private String swaggerInfo;

    ServerRouteEnum(String routeId, String swaggerInfo) {
        this.routeId = routeId;
        this.swaggerInfo = swaggerInfo;
    }

    public static String getSwaggerInfoByRoutId(String routId) {
        for (ServerRouteEnum routeEnum : ServerRouteEnum.values()) {
            if (routId.equals(routeEnum.getRouteId())) {
                return routeEnum.getSwaggerInfo();
            }
        }
        return null;
    }

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