# Installs for Spring Boot starter project
```
- Spring Boot DevTools
- Spring Data JPA
- MySQL Driver
- Spring Web
```

# Pom.xml:
```
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
    </dependency>
    <dependency>
        <groupId>jakarta.servlet.jsp.jstl</groupId>
        <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
    </dependency>
    <dependency>
        <groupId>org.glassfish.web</groupId>
        <artifactId>jakarta.servlet.jsp.jstl</artifactId>
    </dependency>

    <!-- BOOTSTRAP DEPENDENCIES -->
    <dependency>
        <groupId>org.webjars</groupId>
        <artifactId>webjars-locator</artifactId>
        <version>0.46</version>
    </dependency>
    <dependency>
        <groupId>org.webjars</groupId>
        <artifactId>bootstrap</artifactId>
        <version>5.2.3</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency> 
    <dependency>
		<groupId>org.mindrot</groupId>
		<artifactId>jbcrypt</artifactId>
        <version>0.4</version>
	</dependency>

    <!-- For Image Uploading or anything that requires custom configuration -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-configuration-processor</artifactId>
        <optional>true</optional>
    </dependency>
```

# application.properties:
```
spring.mvc.view.prefix=/WEB-INF/
spring.datasource.url=jdbc:mysql://localhost:3306/<<YOUR_SCHEMA>>?createDatabaseIfNotExist=true
spring.datasource.username=<<dbuser>>
spring.datasource.password=<<dbpassword>>
spring.jpa.hibernate.ddl-auto=update
spring.mvc.hiddenmethod.filter.enabled=true

# For Image Uploading
spring.servlet.multipart.max-file-size=2000KB 
spring.servlet.multipart.max-request-size=2000KB
```

# jstl tag for c tags:
```
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!-- For JSTL Forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
```


# if you using bootstrap in your jsp pages:
```
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
```


