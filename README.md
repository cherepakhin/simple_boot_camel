# SpringBoot + Camel REST API

Java 8

````shell
export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64
./mvnw spring-boot:run
````

---

[http://127.0.0.1:8081/camel-rest/api-doc](http://127.0.0.1:8081camel-rest/api-doc)

---
Запрос:
````shell
http :8080/camel-rest/books/
````

[http://127.0.0.1:8081/camel-rest/books/](http://127.0.0.1:8081camel-rest/books/)

Ответ:
````json
[
    {
        "isbn": "1",
        "title": "This is book 1"
    },
    {
        "isbn": "2",
        "title": "This is book 2"
    },
    {
        "isbn": "3",
        "title": "This is book 3"
    },
    {
        "isbn": "4",
        "title": "This is book 4"
    },
    {
        "isbn": "5",
        "title": "This is book 5"
    },
    {
        "isbn": "6",
        "title": "This is book 6"
    },
    {
        "isbn": "7",
        "title": "This is book 7"
    },
    {
        "isbn": "8",
        "title": "This is book 8"
    },
    {
        "isbn": "9",
        "title": "This is book 9"
    }
]
````

---

Запрос:
````shell
http :8081/camel-rest/books/9
````

[http://127.0.0.1:8081/camel-rest/books/9](http://127.0.0.1:8081/camel-rest/books/9)

Ответ:
````json
id: 9
{
    "isbn": "9",
    "title": "This is book 9"
}
````

---
Запрос:
````shell
http :8081/beans
````

[http://127.0.0.1:8081/beans](http://127.0.0.1:8081/beans)

Ответ:
[doc/beans.json](doc/beans.json)

---

````shell
http :8081/mappings
````

Ответ:
[doc/mappings.json](doc/mappings.json)

---

Запрос:
````shell
http :8081/error
````

Ответ:
````json
{
    "error": "None",
    "message": "No message available",
    "status": 999,
    "timestamp": 1781121228131
}
````

---

Запрос:
````shell
http :8081/metrics/
````

Ответ:
````json
{
    "classes": 11114,
    "classes.loaded": 11114,
    "classes.unloaded": 0,
    "counter.status.200.beans": 1,
    "counter.status.200.camel-rest.books.9": 1,
    "counter.status.200.camel.route-controller": 1,
    "counter.status.200.configprops": 2,
    "counter.status.200.info": 1,
    "counter.status.200.mappings": 1,
    "counter.status.404.camel.routes.id.info": 1,
    "counter.status.404.unmapped": 1,
    "counter.status.404.webjars.star-star": 1,
    "counter.status.500.error": 1,
    "gauge.response.beans": 77.0,
    "gauge.response.camel-rest.books.9": 239.0,
    "gauge.response.camel.route-controller": 4.0,
    "gauge.response.camel.routes.id.info": 88.0,
    "gauge.response.configprops": 160.0,
    "gauge.response.error": 10.0,
    "gauge.response.info": 15.0,
    "gauge.response.mappings": 6.0,
    "gauge.response.unmapped": 1.0,
    "gauge.response.webjars.star-star": 5.0,
    "gc.ps_marksweep.count": 2,
    "gc.ps_marksweep.time": 335,
    "gc.ps_scavenge.count": 10,
    "gc.ps_scavenge.time": 373,
    "heap": 3619328,
    "heap.committed": 678912,
    "heap.init": 256000,
    "heap.used": 154034,
    "instance.uptime": 575367,
    "mem": 766747,
    "mem.free": 524877,
    "nonheap": 0,
    "nonheap.committed": 89984,
    "nonheap.init": 2496,
    "nonheap.used": 87836,
    "processors": 4,
    "systemload.average": 1.65087890625,
    "threads": 23,
    "threads.daemon": 5,
    "threads.peak": 23,
    "threads.totalStarted": 30,
    "uptime": 590815
}
````

---

Запрос:
````shell
http :8081/health.json
````

Ответ:
````json
{
    "camel": {
        "contextStatus": "Started",
        "name": "SpringBootCamel",
        "status": "UP",
        "version": "2.20.0"
    },
    "camel-health-checks": {
        "route:book-api": "UP",
        "route:books-api": "UP",
        "route:doc-api": "UP",
        "status": "UP"
    },
    "diskSpace": {
        "free": 3200131072,
        "status": "UP",
        "threshold": 10485760,
        "total": 204755746816
    },
    "status": "UP"
}
````

---

````shell
http :8081/trace.json
````
выводит историю запросов

---

Конфигурация:
````shell
http :8081/mappings.json
````

Ответ [doc/mappings.json](doc/mappings.json)

---

### Информацию о системе:

Запрос:

````shell
http :8081/env
````

Ответ [doc/env.json](doc/env.json)

### Показывает маршруты и подробные статусы

Запрос:
````shell
http :8081/camel/routes.json
````

Ответ [doc/routes.json](doc/routes.json)

Внимание на book-api, bookS-api

### Состояние маршрутов (UP или DOWN)

````shell
http :8081/camel/health/check | jq > doc/health_check.json
````
(jq - форматирует вывод)

Ответ [doc/health_check.json](doc/health_check.json)

---

### Весь лог со служебными API:

````text
INFO 27374 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
INFO 27374 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
INFO 27374 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
INFO 27374 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
INFO 27374 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
WARN 27374 --- [           main] o.a.c.i.DefaultCamelBeanPostProcessor    : No CamelContext defined yet so cannot inject into bean: routesHealthCheckRepository
INFO 27374 --- [           main] o.a.c.i.converter.DefaultTypeConverter   : Type converters loaded (core: 192, classpath: 7)
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/configprops || /configprops.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/camel/route-controller || /camel/route-controller.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/info || /info.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/metrics/{name:.*}],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.MetricsMvcEndpoint.value(java.lang.String)
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/metrics || /metrics.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/health || /health.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint.invoke(javax.servlet.http.HttpServletRequest,java.security.Principal)
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/heapdump || /heapdump.json],methods=[GET],produces=[application/octet-stream]}" onto public void org.springframework.boot.actuate.endpoint.mvc.HeapdumpMvcEndpoint.invoke(boolean,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse) throws java.io.IOException,javax.servlet.ServletException
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/trace || /trace.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/mappings || /mappings.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/beans || /beans.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/camel/health/check/{id}/invoke],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.apache.camel.spring.boot.actuate.endpoint.CamelHealthCheckMvcEndpoint.invoke(java.lang.String,java.util.Map<java.lang.String, java.lang.Object>)
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/camel/health/check/{id}],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.apache.camel.spring.boot.actuate.endpoint.CamelHealthCheckMvcEndpoint.query(java.lang.String,java.util.Map<java.lang.String, java.lang.Object>)
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/camel/health/check || /camel/health/check.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/camel/routes/{id}/info],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.apache.camel.spring.boot.actuate.endpoint.CamelRoutesMvcEndpoint.info(java.lang.String)
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/camel/routes/{id}/detail],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.apache.camel.spring.boot.actuate.endpoint.CamelRoutesMvcEndpoint.detail(java.lang.String)
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/camel/routes/{id}/start],methods=[POST],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.apache.camel.spring.boot.actuate.endpoint.CamelRoutesMvcEndpoint.start(java.lang.String)
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/camel/routes/{id}/stop],methods=[POST],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.apache.camel.spring.boot.actuate.endpoint.CamelRoutesMvcEndpoint.stop(java.lang.String,java.lang.Long,java.lang.Boolean)
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/camel/routes/{id}/suspend],methods=[POST],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.apache.camel.spring.boot.actuate.endpoint.CamelRoutesMvcEndpoint.suspend(java.lang.String,java.lang.Long)
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/camel/routes/{id}/resume],methods=[POST],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.apache.camel.spring.boot.actuate.endpoint.CamelRoutesMvcEndpoint.resume(java.lang.String)
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/camel/routes/{id}/reset],methods=[POST],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.apache.camel.spring.boot.actuate.endpoint.CamelRoutesMvcEndpoint.reset(java.lang.String)
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/camel/routes || /camel/routes.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/env/{name:.*}],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EnvironmentMvcEndpoint.value(java.lang.String)
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/env || /env.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/loggers/{name:.*}],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.LoggersMvcEndpoint.get(java.lang.String)
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/loggers/{name:.*}],methods=[POST],consumes=[application/vnd.spring-boot.actuator.v1+json || application/json],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.LoggersMvcEndpoint.set(java.lang.String,java.util.Map<java.lang.String, java.lang.String>)
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/loggers || /loggers.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/auditevents || /auditevents.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public org.springframework.http.ResponseEntity<?> org.springframework.boot.actuate.endpoint.mvc.AuditEventsMvcEndpoint.findByPrincipalAndAfterAndType(java.lang.String,java.util.Date,java.lang.String)
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/autoconfig || /autoconfig.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO 27374 --- [           main] o.s.b.a.e.mvc.EndpointHandlerMapping     : Mapped "{[/dump || /dump.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}" onto public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()
INFO 27374 --- [           main] o.s.j.e.a.Annotation
````
---

TODO: дальше?

# spring-boot-guides
Spring Boot Guides

Стартовый проект со Spring-Boot и Maven [https://github.com/tiven-wang/spring-boot-guides.git](https://github.com/tiven-wang/spring-boot-guides.git)

## Spring Boot Camel

The source codes of article [Spring Boot - Apache Camel](http://tiven.wang/articles/spring-boot-camel/#camel).

