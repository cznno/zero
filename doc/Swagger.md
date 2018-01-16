#Generate REST doc with Swagger

[TOC]

## tutorial
- https://dzone.com/articles/spring-boot-restful-api-documentation-with-swagger  
- https://springfox.github.io/springfox/docs/current/
-----
## 使用方法

1. 添加依赖
```xml
<dependencies>
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger2</artifactId>
        <version>2.6.1</version>
        <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
        <version>2.6.1</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```
2. 配置javaconfig
```java
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //扫描包
                .apis(RequestHandlerSelectors.basePackage("guru.springframework.controllers"))
                //正则匹配路径
                .paths(regex("/product.*"))
                .build();
    }
}
```
3. 启动项目后
  在http://localhost:8080/v2/api-docs可以看到生成的json
  在http://localhost:8080/swagger-ui.html可以看到文档
4. 更丰富的文档需要用相关的注解生成, 在有权限管理的项目内记得开放权限

## 注解

- @ApiResponse单独使用不会被处理, 必须用在@ApiResponses里(见源码/文档)