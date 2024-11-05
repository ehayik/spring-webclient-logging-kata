# Spring WebClient Logging Kata

This project demonstrates how to log full HTTP requests and responses in Spring WebClient based HTTP clients
for non-blocking calls while securing logged content by masking sensitive information using Logback.

## Overview

In modern web applications, it's crucial to log HTTP interactions for debugging and monitoring purposes. 
However, logging sensitive information can lead to security vulnerabilities. This project showcases how to achieve
detailed logging of HTTP requests and responses in a WebFlux-based asynchronous environment while ensuring sensitive
data is masked in the logs.

## Features

- Full logging of HTTP requests and responses using WebFlux.
- Custom Logback layout for masking sensitive information.
- Configurable patterns for masking via XML configuration.

## Credits

I learned a lot from the projects and resources listed below:

- [Logging Spring WebClient Calls](https://www.baeldung.com/spring-log-webclient-calls)
- [Mask Sensitive Data in Logs With Logback](https://www.baeldung.com/logback-mask-sensitive-data)
- [Log Spring WebClient Request and Response](https://blog.stackademic.com/log-spring-webclient-request-and-response-412559f07a47)
- [Using Logback with Spring Boot](https://springframework.guru/using-logback-spring-boot/)
- [Spring Boot - Logging](https://docs.spring.io/spring-boot/reference/features/logging.html)
- [MDC with WebClient in WebMVC](http://ttddyy.github.io/mdc-with-webclient-in-webmvc/)
