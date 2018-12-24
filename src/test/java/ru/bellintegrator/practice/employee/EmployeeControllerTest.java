package ru.bellintegrator.practice.employee;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import ru.bellintegrator.practice.view.EmplView;

import java.net.URI;
import java.net.URISyntaxException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT )
public class EmployeeControllerTest {
    @LocalServerPort
    int serverPort = 8888;

    @Test
    public void testGetEmplById() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();


        final String baseUrl = "http://localhost:" + serverPort + "/user/32";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<EmplView> result = restTemplate.exchange(uri, HttpMethod.GET, entity, EmplView.class);
        EmplView view = result.getBody();

        Assert.assertEquals(200, result.getStatusCodeValue());
        assertThat(view.getId(), is(32L));
        assertThat(view.getFirstName(), is("Чаплин"));
        assertThat(view.getSecondName(), is("Гротеск"));
        assertThat(view.getLastName(), is("Павлович"));
        assertThat(view.getPosition(), is("TeamLead"));
        assertThat(view.getPhone(), is("8-666-666-90-90"));
        assertThat(view.getDocName(), is("Паспорт РФ"));
        assertThat(view.getDocNumber(), is(1111111111L));
        assertThat(view.getDocDate(), is("1994-09-01"));
        assertThat(view.getCitizenshipCode(), is(61L));
        assertThat(view.getIsIdentefied(), is(true));

    }
}

