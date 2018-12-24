package ru.bellintegrator.practice.organization;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import ru.bellintegrator.practice.view.OrgView;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT )
public class OrganizationControllerTest {
    @LocalServerPort
    int serverPort = 8888;

    @Test
    public void testGetOrgById() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();


        final String baseUrl = "http://localhost:" + serverPort + "/organization/32";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<OrgView> result = restTemplate.exchange(uri, HttpMethod.GET, entity, OrgView.class);
        OrgView view = result.getBody();


        Assert.assertEquals(200, result.getStatusCodeValue());
        assertThat(view.getId(), is(32L));
        assertThat(view.getName(), is("ЛондонПариж"));
        assertThat(view.getFullName(), is("ЛондонПариж"));
        assertThat(view.getInn(), is(1212313131L));
        assertThat(view.getKpp(), is(9090909090L));
        assertThat(view.getAddress(), is("г.Москва, ул.Островского 11Б"));
        assertThat(view.getPhone(), is("+7-932-890-09-09"));
        //assertThat(view.getActive(), is(true));


    }
}
