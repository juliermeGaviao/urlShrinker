package com.join.urlShrinker.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.join.urlShrinker.dto.UserDto;
import com.join.urlShrinker.model.User;
import com.join.urlShrinker.model.UserUrl;

@Service
public class UserConverter {

	@Autowired
	private UrlConverter urlConverter;

	public UserDto entity2Dto(User user) {
		UserDto result = new UserDto();

		result.setId(user.getId());
		result.setUserName(user.getUserName());
		for (UserUrl userUrl: user.getUserUrls()) {
			result.getUrls().add(urlConverter.entity2Dto(userUrl.getUrl()));
		}

		return result;
	}

}
