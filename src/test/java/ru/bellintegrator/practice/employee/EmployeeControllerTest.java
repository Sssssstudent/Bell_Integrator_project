package ru.bellintegrator.practice.employee;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT )
public class EmployeeControllerTest {
    @LocalServerPort
    int serverPort = 8888;

    //@Autowired
    //RestTemplate restTemplate;

    @Test
    public void testGetEmplById() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();


        final String baseUrl = "http://localhost:" + serverPort + "/user/32";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());

    }
}

