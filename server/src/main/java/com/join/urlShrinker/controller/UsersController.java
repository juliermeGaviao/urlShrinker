package com.join.urlShrinker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.join.urlShrinker.converter.UrlConverter;
import com.join.urlShrinker.converter.UserConverter;
import com.join.urlShrinker.dto.UrlDto;
import com.join.urlShrinker.dto.UserDto;
import com.join.urlShrinker.model.Url;
import com.join.urlShrinker.model.User;
import com.join.urlShrinker.model.UserUrl;
import com.join.urlShrinker.repository.UrlRepository;
import com.join.urlShrinker.repository.UserRepository;

@RestController
public class UsersController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UrlRepository urlRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UrlConverter urlConverter;

	@RequestMapping(value="/users/{userId}/urls", method=RequestMethod.POST)
	public ResponseEntity<?> addUrls(@PathVariable Integer userId, @RequestBody List<String> urls) {
		ResponseEntity<?> result;
		User user = null;

		try {
			user = this.userRepository.findById(userId).get();
		} catch (Exception e) {
		}

		if (user != null) {
			for (String urlName: urls) {
				List<Url> urlList = this.urlRepository.findByUrl(urlName);
				Url url;

				if (urlList.isEmpty()) {
					url = new Url(urlName, "http://urlShrinker.com.br/" + System.currentTimeMillis());
					UserUrl userUrl = new UserUrl(user, url);

					user.getUserUrls().add(userUrl);
				} else {
					url = urlList.get(0);
					List<UserUrl> userUrls = this.urlRepository.getUserUrl(userId, url.getId());

					if (userUrls.isEmpty()) {
						UserUrl userUrl = new UserUrl(user, url);
						user.getUserUrls().add(userUrl);
					} else {
						userUrls.get(0).setCount(userUrls.get(0).getCount() + 1);
					}
				}

				this.urlRepository.save(url);
			}
			this.urlRepository.flush();

			List<UrlDto> urlBeans = this.getUserStats(userId);

			result = new ResponseEntity<List<UrlDto>>(urlBeans, HttpStatus.CREATED);
		} else
			result = new ResponseEntity<String>("User Id not found!", HttpStatus.NO_CONTENT);

		return result;
	}

	@RequestMapping(value="/users/{userId}/stats")
	public ResponseEntity<?> getUserStatsService(@PathVariable Integer userId) {
		List<UrlDto> urlBeanList = this.getUserStats(userId);
		ResponseEntity<?> result;

		if (urlBeanList.isEmpty())
			result = new ResponseEntity<String>("User Id doesn't exist or has no URL associated to", HttpStatus.NO_CONTENT);
		else
			result = new ResponseEntity<List<UrlDto>>(urlBeanList, HttpStatus.OK);

		return result;
	}

	@RequestMapping(value="/users/{userName}", method=RequestMethod.POST)
	public ResponseEntity<?> createUser(@PathVariable String userName) {
		List<User> existingUserList = this.userRepository.findByUserName(userName);

		if (existingUserList.isEmpty()) {
			User user = new User(userName);

			this.userRepository.saveAndFlush(user);

			return new ResponseEntity<UserDto>(this.userConverter.entity2Dto(user), HttpStatus.CREATED);
		} else
			return new ResponseEntity<String>("The user [username=" + userName + "] already exists!", HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value="/user/{userId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
		User user = null;

		try {
			user = this.userRepository.findById(userId).get();
		} catch (Exception e) {
		}

		if (user != null) {
			this.userRepository.delete(user);
			this.userRepository.flush();
			return new ResponseEntity<String>("User successfully deleted!", HttpStatus.OK);
		} else
			return new ResponseEntity<String>("User Id doesn't exist!", HttpStatus.NO_CONTENT);
	}

	private List<UrlDto> getUserStats(Integer userId) {
		List<UrlDto> result = new ArrayList<UrlDto>();
		List<UserUrl> userUrls = this.userRepository.getUserUrls(userId);

		for (UserUrl userUrl: userUrls) {
			UrlDto urlDto = this.urlConverter.entity2Dto(userUrl.getUrl());
			urlDto.setHits(userUrl.getCount());
			result.add(urlDto);
		}

		return result;
	}
}
