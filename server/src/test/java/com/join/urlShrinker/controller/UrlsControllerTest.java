package com.join.urlShrinker.controller;

import static org.assertj.core.api.Assertions.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
public class UrlsControllerTest {

    private final MediaType jsonContentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    private final MediaType textPlainContentType = new MediaType(MediaType.TEXT_PLAIN.getType(), MediaType.TEXT_PLAIN.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private MockMvc mockMvc;

	@Test
	public void getUrlStats() {
		try {
			this.mockMvc.perform(get(new URI("/urls/1")).contentType(this.jsonContentType)).andExpect(status().isOk())
				.andExpect(content().contentType(this.jsonContentType))
				.andExpect(jsonPath("hits", is(3)))
				.andExpect(jsonPath("url", is("http://www.google.com.br")));

			this.mockMvc.perform(get(new URI("/urls/2")).contentType(this.jsonContentType)).andExpect(status().isOk())
				.andExpect(content().contentType(this.jsonContentType))
				.andExpect(jsonPath("hits", is(2)))
				.andExpect(jsonPath("url", is("http://www.amazon.com")));

			this.mockMvc.perform(get(new URI("/urls/3")).contentType(this.jsonContentType)).andExpect(status().isNoContent())
				.andExpect(content().contentType(this.textPlainContentType))
				.andExpect(content().string("Url Id doesn't exist!"));
		} catch (URISyntaxException e) {
			fail("Invalid URI on getUrlStats calling");
		} catch (Exception e) {
			fail("Error on getUrlStats calling");
		}
	}

	@Test
	public void deleteUrl() {
		try {
			this.mockMvc.perform(post(new URI("/users/2/urls")).content("[\"http://www.terra.com.br\"]").contentType(this.jsonContentType)).andExpect(status().isCreated());

			this.mockMvc.perform(delete(new URI("/urls/3")).contentType(this.jsonContentType)).andExpect(status().isOk())
				.andExpect(content().contentType(this.textPlainContentType))
				.andExpect(content().string("Url successfully deleted!"));

			this.mockMvc.perform(delete(new URI("/urls/3")).accept(this.jsonContentType)).andExpect(status().isNoContent())
				.andExpect(content().contentType(this.jsonContentType))
				.andExpect(content().string("Url Id doesn't exist!"));
		} catch (URISyntaxException e) {
			fail("Invalid URI on deleteUrl calling");
		} catch (Exception e) {
			fail("Error on deleteUrl calling");
		}
	}
}
