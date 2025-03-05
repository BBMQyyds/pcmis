# 启动Sentinel控制台
cd env
java -jar sentinel-dashboard-1.8.3.jar

# 解决启动报错
--add-opens java.base/java.time=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.lang.reflect=ALL-UNNAMED
