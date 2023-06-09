# changebook-web
### Web

### pom.xml
```
<dependency>
  <groupId>io.github.changebooks</groupId>
  <artifactId>changebook-web</artifactId>
  <version>1.0.1</version>
</dependency>
```

### 应用上下文
```
@Component
public class ApplicationContextHolder extends ApplicationContextHolderSupport {
}
```

### 跨域配置
```
cors:
  enable: true
  path-pattern: /**
  allow-headers:
  allow-methods: HEAD, GET, POST, PUT, DELETE, OPTIONS
  allow-origin-patterns:
  allow-credentials: true
  max-age: 1800
```

### 支持跨域
```
@Configuration
@EnableConfigurationProperties({CorsProperties.class})
public class CorsConfigurer extends CorsConfigurerSupport {

    @Resource
    private CorsProperties corsProperties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        super.addMappings(registry, corsProperties);
    }

}
```

### API文档配置
```
docket:
  enable: true
  title: Api Document
  description: Project Description
  version: 1.0.1
  license: Apache License, Version 2.0
  contact:
    name: 作者名
    url: http://localhost:8080
    email: 邮箱
  token:
    name: access-token
    description: Access Token
    example: Default Example
```

### 支持API文档
```
@Configuration
@EnableWebMvc
@EnableConfigurationProperties({DocketProperties.class})
public class DocketImpl extends DocketSupport {

    @Bean
    @Override
    public Docket docket(DocketProperties docketProperties) {
        return super.docket(docketProperties);
    }

}
```

### API文档地址
```
http://localhost:8080/swagger-ui/index.html
```

### Jackson 避免 long 丢失精度
```
@Configuration
public class JacksonConfigurer extends JacksonConfigurerSupport {
}
```

### 规范请求参数
```
@ControllerAdvice
public class RequestBodyImpl extends RequestBodySupport {
}
```

### 规范响应结果
```
@ControllerAdvice
public class ResponseBodyImpl extends ResponseBodySupport {
}
```

### 统一处理异常
```
@ControllerAdvice
public class WideExceptionHandlerImpl extends WideExceptionHandler {
}
```

### 配置参数验证 resources/META-INF/validation.xml
```
<?xml version="1.0" encoding="UTF-8"?>

<validation-config xmlns="http://jboss.org/xml/ns/javax/validation/configuration"
                   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                   xsi:schemaLocation="http://jboss.org/xml/ns/javax/validation/configuration" version="1.1">

    <property name="hibernate.validator.fail_fast">true</property>

</validation-config>
```
