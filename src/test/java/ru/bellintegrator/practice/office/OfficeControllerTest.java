package ru.bellintegrator.practice.office;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import ru.bellintegrator.practice.view.OfficeView;
import ru.bellintegrator.practice.view.ResponseView;

import java.net.URI;
import java.net.URISyntaxException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OfficeControllerTest {
    @LocalServerPort
    int serverPort =8888;

    @Test
    public void testOffice() throws URISyntaxException{
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:" + serverPort + "/office/save";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        OfficeView sampleOffice = new OfficeView(1L);

        HttpEntity<OfficeView> entity = new HttpEntity<>(sampleOffice, headers);
        ResponseEntity<ResponseView> result = restTemplate.exchange(uri, HttpMethod.POST, entity, ResponseView.class);

        ResponseView view = result.getBody();

        Assert.assertEquals(200, result.getStatusCodeValue());
        assertThat(view.getSucceess(), is(true));
    }
}
