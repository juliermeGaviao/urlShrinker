package com.join.urlShrinker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.join.urlShrinker.dto.StatsDto;
import com.join.urlShrinker.dto.UrlDto;
import com.join.urlShrinker.dto.UserDto;

@RestController
public class IndexController {

	@Value("${br.join.serverEndpoint}")
	private String serverEndpoint;

	private RestTemplate restTemplate = new RestTemplate();

	@RequestMapping("/globalStats")
	public ResponseEntity<StatsDto> getGlobalStats() {
		ResponseEntity<StatsDto> result = this.restTemplate.getForEntity(this.serverEndpoint + "/stats", StatsDto.class);

		return result;
	}

	@RequestMapping("/userStats/{userId}")
	public ResponseEntity<UrlDto[]> getUserStats(@PathVariable("userId") String userId) {
		ResponseEntity<UrlDto[]> result;

		try {
			Integer.parseInt(userId);

			result = this.restTemplate.getForEntity(this.serverEndpoint + "/users/{userId}/stats", UrlDto[].class, userId);
		} catch (Exception e) {
			result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return result;
	}

	@RequestMapping("/urlStats/{urlId}")
	public ResponseEntity<UrlDto> getUrlStats(@PathVariable("urlId") String urlId) {
		ResponseEntity<UrlDto> result;

		try {
			Integer.parseInt(urlId);

			result = this.restTemplate.getForEntity(this.serverEndpoint + "/urls/{urlId}", UrlDto.class, urlId);
		} catch (Exception e) {
			result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return result;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
		ResponseEntity<UserDto> result;

		if (userDto.getUserName().trim().length() > 0) {
			try {
				result = this.restTemplate.postForEntity(this.serverEndpoint + "/users/{userName}", null, UserDto.class, userDto.getUserName().trim());
			} catch (Exception e) {
				result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} else {
			result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return result;
	}

	@RequestMapping(value = "/addUrl/{userId}", method = RequestMethod.POST)
	public ResponseEntity<UrlDto[]> addUrl(@PathVariable("userId") Integer userId, @RequestBody UrlDto urlDto) {
		ResponseEntity<UrlDto[]> result;

		try {
			List<String> urls = new ArrayList<String>();
	
			urls.add(urlDto.getUrl());

			result = this.restTemplate.postForEntity(this.serverEndpoint + "/users/{userId}/urls", urls, UrlDto[].class, userId);
		} catch (Exception e) {
			result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return result;
	}

	@RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable("userId") String userId) {
		ResponseEntity<String> result;

		try {
			Integer.parseInt(userId);

			result = this.restTemplate.exchange(this.serverEndpoint + "/user/{userId}", HttpMethod.DELETE, null, String.class, userId);
		} catch (Exception e) {
			result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return result;
	}

	@RequestMapping(value = "/deleteUrl/{urlId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUrl(@PathVariable("urlId") String urlId) {
		ResponseEntity<String> result = null;

		try {
			Integer.parseInt(urlId);

			result = this.restTemplate.exchange(this.serverEndpoint + "/urls/{urlId}", HttpMethod.DELETE, null, String.class, urlId);
		} catch (Exception e) {
			result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return result;
	}

}
