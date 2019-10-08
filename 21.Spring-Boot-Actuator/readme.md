# Actuator
SpringBoot自带监控功能Actuator，可以帮助实现对程序内部运行情况监控，比如监控状况、Bean加载情况、环境变量、日志信息、线程信息等。
</br>
Actuator同时还可以与外部应用监控系统整合，比如 Prometheus, Graphite, DataDog, Influx, Wavefront, New Relic等。这些系统提供了非常好的仪表盘、图标、分析和告警等功能，使得你可以通过统一的接口轻松的监控和管理你的应用。

# 配置Actuator

## pom
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

## peoperties
```
# 打开和关闭Actuator Endpoints
management.endpoint.<id>.enabled=true/false

# 通过HTTP暴露Actuator endpoints，默认health,info
management.endpoints.web.exposure.include=health,info 
management.endpoints.web.exposure.exclude=

# 通过JMX暴露Actuator endpoints，所有的endpoint默认通过jmx暴露
management.endpoints.jmx.exposure.include=*
management.endpoints.jmx.exposure.exclude=
```

# 查看信息
Actuator创建了所谓的endpoint来暴露HTTP或者JMX来监控和管理应用。

## 常用endpoint

|Endpoint ID |Description|
|--|--|
|auditevents|显示应用暴露的审计事件 (比如认证进入、订单失败)|
|info|显示应用的基本信息|
|health	显示应用的健康状态|
|metrics|显示应用多样的度量信息|
|loggers|显示和修改配置的loggers|
|logfile|返回log file中的内容(如果logging.file或者logging.path被设置)|
|httptrace|显示HTTP足迹，最近100个HTTP request/repsponse|
|env|显示当前的环境特性|
|flyway|显示数据库迁移路径的详细信息|
|liquidbase|显示Liquibase 数据库迁移的纤细信息|
|shutdown|让你逐步关闭应用|
|mappings|显示所有的@RequestMapping路径|
|scheduledtasks|显示应用中的调度任务|
|threaddump|执行一个线程dump|
|heapdump|返回一个GZip压缩的JVM堆dump|

</br>
上述endpoint除shutdown意外都默认开启。

## 打开/关闭endpoint
`management.endpoint.<id>.enabled=true/false`

## 获取endponit信息

127.0.0.1:8080/actuator/endpointName