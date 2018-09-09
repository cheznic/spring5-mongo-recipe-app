# Spring 5 and MongoDB Recipe Application

[![CircleCI](https://circleci.com/gh/cheznic/spring5-recipe-app.svg?style=svg)](https://circleci.com/gh/cheznic/spring5-mongo-recipe-app)

Simple recipe management app.

Technologies used:
- [Thymeleaf template engine](https://www.thymeleaf.org/) for server side templates.
- [Spring 5](https://spring.io/)
  - [Spring Boot](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/) for project initialization and curated project dependency  
  - Spring Framework Core for
    - [Dependency injection](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-dependencies)
    - [I18N](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#context-functionality-messagesource) 
    - [Input validation](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#validation)
    - [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)
    - [Type conversion](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#validation)
  - [Spring Data JPA](https://spring.io/projects/spring-data) implementing [JPA](https://www.oracle.com/technetwork/java/javaee/tech/persistence-jsp-140049.html) for RDB access abstractions.
- [Lombok tag library](https://github.com/rzwitserloot/lombok) to reduce boiler plate code
- [MongoDB](https://www.mongodb.com/) for persistence
- [Junit 4](https://junit.org/junit4/) and [Mockito](https://site.mockito.org/) for Unit, Mocks and Integration testing
- [Gradle](https://gradle.org/) for build management
- [CircleCI for build automation](https://circleci.com/gh/cheznic/spring5-recipe-app)

