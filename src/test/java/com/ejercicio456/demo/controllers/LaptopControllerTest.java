package com.ejercicio456.demo.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.ejercicio456.demo.entities.Laptop;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

	private TestRestTemplate testRestTemplate;
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	@LocalServerPort
	private int port;

	@BeforeEach
	void setUp() throws Exception {
		restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
		testRestTemplate = new TestRestTemplate(restTemplateBuilder);
	}
@DisplayName("testeando el obtener todos")
	@Test
	void testFindAll() {
		ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(200, response.getStatusCodeValue());
		List<Laptop> laptops = Arrays.asList(response.getBody());

		System.out.println(laptops.isEmpty());
	}

	@Test
	void testFindOneById() {

	}
@DisplayName("testeando el metodo crear")
	@Test
	void testCreate() {
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		String json="""
				{
				"id":1,
				"marca":"asus",
				"year":2000
				}
				""";
		HttpEntity<String> request=new HttpEntity<>(json,headers);
		ResponseEntity<Laptop> response=testRestTemplate.exchange("/api/laptops",HttpMethod.POST, request, Laptop.class);
	Laptop result=response.getBody();
	assertEquals(result.getMarca(), "asus");
	}

	@Test
	void testUpdate() {

	}

	@Test
	void testDelete() {

	}

	@Test
	void testDeleteAll() {

	}

}
