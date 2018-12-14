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

    //@Autowired
    //RestTemplate restTemplate;

    @Test
    public void testGetOrgById() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();


        final String baseUrl = "http://localhost:" + serverPort + "/organization/32";
        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());

        //OrgView view =  result.getBody();


        //ResponseEntity<OrgView> result = restTemplate.getForEntity(uri, OrgView.class);

        //Verify request succeed

        //Assert.assertEquals(true, result.getBody().contains("{data: {id:32, name:ЛондонПариж, fullName:ЛондонПариж, inn:1212313131, kpp:9090909090, address:г.Москва, ул.Островского 11Б, phone:+7-932-890-09-09, isActive:true}}"));


        /*assertThat(view.get("id"), is(32));
        assertThat(view.get("name"), is("ЛондонПариж"));
        assertThat(view.get("fullName"), is("ЛондонПариж"));
        assertThat(view.get("inn"), is(1212313131L));
        assertThat(view.get("kpp"), is(9090909090L));
        assertThat(view.get("address"), is("г.Москва, ул.Островского 11Б"));
        assertThat(view.get("phone"), is("+7-932-890-09-09"));
        assertThat(view.get("isActive"), is(true));*/

    }
/*
    @Test
    public void createTest() throws URISyntaxException {
        String url = "http://localhost:" + serverPort + "/api/user/save";
        URI uri = new URI(url);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        UserView sampleUser = new UserView();
        sampleUser.setOfficeId(2);
        sampleUser.setFirstName("Виктор");
        sampleUser.setPosition("Ассистент");

        HttpEntity<UserView> entity = new HttpEntity<>(sampleUser, headers);

        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertTrue(result.getBody().contains("result"));
        Assert.assertTrue(result.getBody().contains("success"));
    }
}
*/
}
