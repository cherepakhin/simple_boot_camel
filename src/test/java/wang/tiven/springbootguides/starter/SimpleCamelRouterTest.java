package wang.tiven.springbootguides.starter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import wang.tiven.springbootguides.camel.Book;
import wang.tiven.springbootguides.camel.SampleCamelRouter;
import wang.tiven.springbootguides.camel.StarterApplication;

import static org.junit.Assert.assertEquals;

//@RunWith(SpringRunner.class)
//@@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = StarterApplication.class)

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = StarterApplication.class)

public class SimpleCamelRouterTest {

    @LocalServerPort
    int webServerPort;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void testGetITest() throws Exception {
        // The API will be at /services/api. The context-path ("services")
        // is set in application.properties: camel.component.servlet.mapping.context-path
        // We tell TestRestTemplate to try to unmarshal the JSON into our
        // "ResponseType" object. This confirms that we're returning valid JSON
        ResponseEntity<Book> response = testRestTemplate.getForEntity(
                "http://localhost:" + webServerPort + "/camel-rest/books/9",
                Book.class);
        // We also use ResponseType, which is our custom response POJO,
        // which contains a single field, "message"

        // Check that the service returned HTTP 200 OK
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Since we unmarshalled the object into a POJO, we can also perform
        // a test assertion on it:
        assertEquals(new Book("isdn", "Book1"), response.getBody());
    }
}