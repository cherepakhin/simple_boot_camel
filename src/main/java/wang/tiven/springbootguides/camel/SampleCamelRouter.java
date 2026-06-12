package wang.tiven.springbootguides.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class SampleCamelRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
      restConfiguration()
              .component("servlet")
              .contextPath("/camel-rest-jpa").apiContextPath("/api-doc")
                  .apiProperty("api.title", "Camel REST API")
                  .apiProperty("api.version", "1.0")
                  .apiProperty("cors", "true")
                  .apiContextRouteId("doc-api")
              .bindingMode(RestBindingMode.auto);

      rest().path("/books")
              .description("Books REST service")
              .consumes("application/json")
              .produces("application/json")
              .get("/").to("direct:getAll");
      from("direct:getAll").routeId("my_route")
                .bean("bookRepository", "getAll") // вызов метода doSomething у бина с именем myBean
                .to("log:result");

//              .endRest()

//          .get("/{id}").description("Details of an book by id")
//              .route().routeId("book-api")
//              .bean("bookRepository", "getByIsbn(${header.id})");
    }

}
