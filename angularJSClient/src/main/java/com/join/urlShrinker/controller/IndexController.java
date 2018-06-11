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

import com.join.urlShrinker.bean.StatsBean;
import com.join.urlShrinker.bean.UrlBean;
import com.join.urlShrinker.bean.UserBean;

@RestController
public class IndexController {

	@Value("${br.join.serverEndpoint}")
	private String serverEndpoint;

	private RestTemplate restTemplate = new RestTemplate();

	@RequestMapping("/globalStats")
	public ResponseEntity<StatsBean> getGlobalStats() {
		ResponseEntity<StatsBean> result = this.restTemplate.getForEntity(this.serverEndpoint + "/stats", StatsBean.class);

		return result;
	}

	@RequestMapping("/userStats/{userId}")
	public ResponseEntity<UrlBean[]> getUserStats(@PathVariable("userId") String userId) {
		ResponseEntity<UrlBean[]> result;

		try {
			Integer.parseInt(userId);

			result = this.restTemplate.getForEntity(this.serverEndpoint + "/users/{userId}/stats", UrlBean[].class, userId);
		} catch (Exception e) {
			result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return result;
	}

	@RequestMapping("/urlStats/{urlId}")
	public ResponseEntity<UrlBean> getUrlStats(@PathVariable("urlId") String urlId) {
		ResponseEntity<UrlBean> result;

		try {
			Integer.parseInt(urlId);

			result = this.restTemplate.getForEntity(this.serverEndpoint + "/urls/{urlId}", UrlBean.class, urlId);
		} catch (Exception e) {
			result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return result;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<UserBean> addUser(@RequestBody UserBean userBean) {
		ResponseEntity<UserBean> result;

		if (userBean.getUserName().trim().length() > 0) {
			try {
				result = this.restTemplate.postForEntity(this.serverEndpoint + "/users/{userName}", null, UserBean.class, userBean.getUserName().trim());
			} catch (Exception e) {
				result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} else {
			result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return result;
	}

	@RequestMapping(value = "/addUrl/{userId}", method = RequestMethod.POST)
	public ResponseEntity<UrlBean[]> addUrl(@PathVariable("userId") Integer userId, @RequestBody UrlBean urlBean) {
		ResponseEntity<UrlBean[]> result;

		try {
			List<String> urls = new ArrayList<String>();
	
			urls.add(urlBean.getUrl());

			result = this.restTemplate.postForEntity(this.serverEndpoint + "/users/{userId}/urls", urls, UrlBean[].class, userId);
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
