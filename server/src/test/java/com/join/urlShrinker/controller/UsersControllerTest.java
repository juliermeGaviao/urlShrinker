package com.join.urlShrinker.controller;

import static org.assertj.core.api.Assertions.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsersControllerTest {

    private final MediaType jsonContentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    private final MediaType textPlainContentType = new MediaType(MediaType.TEXT_PLAIN.getType(), MediaType.TEXT_PLAIN.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private MockMvc mockMvc;

	@Test
	public void addUrls() {
		try {
			this.mockMvc.perform(post(new URI("/users/4/urls")).content("[\"http://www.terra.com.br\"]").contentType(this.jsonContentType)).andExpect(status().isCreated())
				.andExpect(content().contentType(this.jsonContentType));

			this.mockMvc.perform(post(new URI("/users/7/urls")).content("[\"http://www.terra.com.br\"]").contentType(this.jsonContentType)).andExpect(status().isNoContent())
				.andExpect(content().contentType(this.textPlainContentType))
				.andExpect(content().string("User Id not found!"));
			
			this.mockMvc.perform(delete(new URI("/urls/7")).contentType(this.jsonContentType)).andExpect(status().isOk())
				.andExpect(content().contentType(this.textPlainContentType))
				.andExpect(content().string("Url successfully deleted!"));
		} catch (URISyntaxException e) {
			fail("Invalid URI on addUrls calling");
		} catch (Exception e) {
			fail("Error on addUrls calling");
		}
	}

	@Test
	public void getUserStatsService() {
		try {
			this.mockMvc.perform(get(new URI("/users/3/stats")).contentType(this.jsonContentType)).andExpect(status().isOk())
				.andExpect(content().contentType(this.jsonContentType))
				.andExpect(jsonPath("[0].id", is(1)))
				.andExpect(jsonPath("[0].hits", is(1)))
				.andExpect(jsonPath("[0].url", is("http://www.google.com.br")));

			this.mockMvc.perform(get(new URI("/users/6/stats")).contentType(this.jsonContentType)).andExpect(status().isNoContent())
				.andExpect(content().contentType(this.textPlainContentType))
				.andExpect(content().string("User Id doesn't exist or has no URL associated to"));
		} catch (URISyntaxException e) {
			fail("Invalid URI on getUserStatsService calling");
		} catch (Exception e) {
			fail("Error on getUserStatsService calling");
		}
	}

	@Test
	public void createUser() {
		try {
			this.mockMvc.perform(post(new URI("/users/Andy"))).andExpect(status().isCreated())
			.andExpect(content().contentType(this.jsonContentType))
			.andExpect(jsonPath("id", is(8)))
			.andExpect(jsonPath("userName", is("Andy")))
			.andExpect(jsonPath("urls", hasSize(0)));

			this.mockMvc.perform(post(new URI("/users/Andy"))).andExpect(status().isNoContent())
				.andExpect(content().contentType(this.textPlainContentType))
				.andExpect(content().string("The user [username=Andy] already exists!"));
		} catch (URISyntaxException e) {
			fail("Invalid URI on createUser calling");
		} catch (Exception e) {
			fail("Error on createUser calling");
		}
	}

	@Test
	public void deleteUser() {
		try {
			this.mockMvc.perform(post(new URI("/users/Kate"))).andExpect(status().isCreated());

			this.mockMvc.perform(delete(new URI("/user/5")).contentType(this.jsonContentType)).andExpect(status().isOk())
				.andExpect(content().contentType(this.textPlainContentType))
				.andExpect(content().string("User successfully deleted!"));
			
			this.mockMvc.perform(delete(new URI("/user/5")).contentType(this.jsonContentType)).andExpect(status().isNoContent())
			.andExpect(content().contentType(this.textPlainContentType))
			.andExpect(content().string("User Id doesn't exist!"));
		} catch (URISyntaxException e) {
			fail("Invalid URI on deleteUser calling");
		} catch (Exception e) {
			fail("Error on deleteUser calling");
		}
	}
}
