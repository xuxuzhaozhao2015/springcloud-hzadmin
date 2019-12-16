# 创建eureka服务注册中心
> 简介：服务中心又称注册中心，管理各种服务功能包括服务的注册、发现、熔断、负载、降级等，比如dubbo admin后台的各种功能。

> Spring Cloud 封装了 Netflix 公司开发的 Eureka 模块来实现服务注册和发现。Eureka 采用了 C-S 的设计架构。Eureka Server 作为服务注册功能的服务器，它是服务注册中心。而系统中的其他微服务，使用 Eureka 的客户端连接到 Eureka Server，并维持心跳连接。这样系统的维护人员就可以通过 Eureka Server 来监控系统中各个微服务是否正常运行。Spring Cloud 的一些其他模块（比如Zuul）就可以通过 Eureka Server 来发现系统中的其他微服务，并执行相关的逻辑。
 
>Eureka由两个组件组成：Eureka服务器和Eureka客户端。Eureka服务器用作服务注册服务器。Eureka客户端是一个java客户端，用来简化与服务器的交互、作为轮询负载均衡器，并提供服务的故障切换支持。Netflix在其生产环境中使用的是另外的客户端，它提供基于流量、资源利用率以及出错状态的加权负载均衡。

![eureka架构图](./images/eureka架构图.png)

[微服务注册中心 Eureka 架构深入解读](https://www.infoq.cn/article/jlDJQ*3wtN2PcqTDyokh)

### 1、创建eureka服务注册中心

eureka项目中引入父模块
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <artifactId>eureka</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>eureka</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <!-- 父工程的依赖 -->
    <parent>
        <groupId>top.xuxuzhaozhao</groupId>
        <artifactId>springcloud_hzadmin</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <dependencies>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>RELEASE</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>

```
### 2、修改application.yml
```yaml
# 端口号
server:
  port: 8761
# 服务注册相关配置
eureka:
  # 服务实例主机名
  instance:
    hostname: localhost
  # 服务提供者配置
  client:
    # 只有在当服务注册中心是单点配置时才如此配置，因为单点情况下这两个值必然为false
    # 不进行注册（当服务注册中心是单点而非高可用时的配置方式）
    registerWithEureka: false
    # 不获取注册信息（当服务注册中心是单点而非高可用时的配置方式）
    fetchRegistry: false
    # 服务注册中心地址
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```
### 3、启用eureka-server
```java
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
```