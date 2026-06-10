https://github.com/tiven-wang/spring-boot-guides.git

branch camel

````shell
echo $JAVA_HOME
````
/usr/lib/jvm/java-1.8.0-openjdk-amd64

````shell
export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64
./mvnw spring-boot:run
````

````shell
http :8080/camel-rest-jpa/books
````

http://127.0.0.1:8080/camel-rest-jpa/api-doc

````shell
http :8080/camel-rest-jpa/books/9
````

id: 9
{
    "isbn": "9",
    "title": "This is book 9"
}

````shell
http :8080/camel-rest-jpa/books/
````

````shell
http :8080/beans
````

````shell
http :8080/mappings
````

````shell
http :8080/error
````
````text
HTTP/1.1 500 Internal Server Error
Connection: keep-alive
Content-Type: application/json;charset=UTF-8
Date: Wed, 10 Jun 2026 19:53:48 GMT
Transfer-Encoding: chunked
X-Application-Context: application

{
"error": "None",
"message": "No message available",
"status": 999,
"timestamp": 1781121228131
}
````

````shell
http :8080/metrics/
````

````json
{
    "classes": 11114,
    "classes.loaded": 11114,
    "classes.unloaded": 0,
    "counter.status.200.beans": 1,
    "counter.status.200.camel-rest-jpa.books.9": 1,
    "counter.status.200.camel.route-controller": 1,
    "counter.status.200.configprops": 2,
    "counter.status.200.info": 1,
    "counter.status.200.mappings": 1,
    "counter.status.404.camel.routes.id.info": 1,
    "counter.status.404.unmapped": 1,
    "counter.status.404.webjars.star-star": 1,
    "counter.status.500.error": 1,
    "gauge.response.beans": 77.0,
    "gauge.response.camel-rest-jpa.books.9": 239.0,
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

````shell
http :8080/health.json
````

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

````shell
http :8080/trace.json
````
выводит историю запросов

````shell
http :8080/mappings.json
````

````json
{
    "/**": {
        "bean": "resourceHandlerMapping"
    },
    "/**/favicon.ico": {
        "bean": "faviconHandlerMapping"
    },
    "/webjars/**": {
        "bean": "resourceHandlerMapping"
    },
    "{[/auditevents || /auditevents.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public org.springframework.http.ResponseEntity<?> org.springframework.boot.actuate.endpoint.mvc.AuditEventsMvcEndpoint.findByPrincipalAndAfterAndType(java.lang.String,java.util.Date,java.lang.String)"
    },
    "{[/autoconfig || /autoconfig.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/beans || /beans.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/camel/health/check || /camel/health/check.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/camel/health/check/{id}/invoke],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.apache.camel.spring.boot.actuate.endpoint.CamelHealthCheckMvcEndpoint.invoke(java.lang.String,java.util.Map<java.lang.String, java.lang.Object>)"
    },
    "{[/camel/health/check/{id}],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.apache.camel.spring.boot.actuate.endpoint.CamelHealthCheckMvcEndpoint.query(java.lang.String,java.util.Map<java.lang.String, java.lang.Object>)"
    },
    "{[/camel/route-controller || /camel/route-controller.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/camel/routes || /camel/routes.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/camel/routes/{id}/detail],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.apache.camel.spring.boot.actuate.endpoint.CamelRoutesMvcEndpoint.detail(java.lang.String)"
    },
    "{[/camel/routes/{id}/info],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.apache.camel.spring.boot.actuate.endpoint.CamelRoutesMvcEndpoint.info(java.lang.String)"
    },
    "{[/camel/routes/{id}/reset],methods=[POST],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.apache.camel.spring.boot.actuate.endpoint.CamelRoutesMvcEndpoint.reset(java.lang.String)"
    },
    "{[/camel/routes/{id}/resume],methods=[POST],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.apache.camel.spring.boot.actuate.endpoint.CamelRoutesMvcEndpoint.resume(java.lang.String)"
    },
    "{[/camel/routes/{id}/start],methods=[POST],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.apache.camel.spring.boot.actuate.endpoint.CamelRoutesMvcEndpoint.start(java.lang.String)"
    },
    "{[/camel/routes/{id}/stop],methods=[POST],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.apache.camel.spring.boot.actuate.endpoint.CamelRoutesMvcEndpoint.stop(java.lang.String,java.lang.Long,java.lang.Boolean)"
    },
    "{[/camel/routes/{id}/suspend],methods=[POST],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.apache.camel.spring.boot.actuate.endpoint.CamelRoutesMvcEndpoint.suspend(java.lang.String,java.lang.Long)"
    },
    "{[/configprops || /configprops.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/dump || /dump.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/env || /env.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/env/{name:.*}],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EnvironmentMvcEndpoint.value(java.lang.String)"
    },
    "{[/error],produces=[text/html]}": {
        "bean": "requestMappingHandlerMapping",
        "method": "public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)"
    },
    "{[/error]}": {
        "bean": "requestMappingHandlerMapping",
        "method": "public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)"
    },
    "{[/health || /health.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint.invoke(javax.servlet.http.HttpServletRequest,java.security.Principal)"
    },
    "{[/heapdump || /heapdump.json],methods=[GET],produces=[application/octet-stream]}": {
        "bean": "endpointHandlerMapping",
        "method": "public void org.springframework.boot.actuate.endpoint.mvc.HeapdumpMvcEndpoint.invoke(boolean,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse) throws java.io.IOException,javax.servlet.ServletException"
    },
    "{[/info || /info.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/loggers || /loggers.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/loggers/{name:.*}],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.LoggersMvcEndpoint.get(java.lang.String)"
    },
    "{[/loggers/{name:.*}],methods=[POST],consumes=[application/vnd.spring-boot.actuator.v1+json || application/json],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.LoggersMvcEndpoint.set(java.lang.String,java.util.Map<java.lang.String, java.lang.String>)"
    },
    "{[/mappings || /mappings.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/metrics || /metrics.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    },
    "{[/metrics/{name:.*}],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.MetricsMvcEndpoint.value(java.lang.String)"
    },
    "{[/trace || /trace.json],methods=[GET],produces=[application/vnd.spring-boot.actuator.v1+json || application/json]}": {
        "bean": "endpointHandlerMapping",
        "method": "public java.lang.Object org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter.invoke()"
    }
}
````

Весь лог со служебными API:

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

# spring-boot-guides
Spring Boot Guides

## Spring Boot Camel

The source codes of article [Spring Boot - Apache Camel](http://tiven.wang/articles/spring-boot-camel/#camel).
