package com.join.urlShrinker.converter;

import org.springframework.stereotype.Service;

import com.join.urlShrinker.dto.UrlDto;
import com.join.urlShrinker.model.Url;

@Service
public class UrlConverter {

	public UrlDto entity2Dto(Url url) {
		UrlDto result = new UrlDto();

		result.setId(url.getId());
		result.setUrl(url.getUrl());
		result.setShortUrl(url.getShortUrl());

		return result;
	}

	public Url dto2Entity(UrlDto url) {
		Url result = new Url();

		result.setId(url.getId());
		result.setUrl(url.getUrl());
		result.setShortUrl(url.getShortUrl());

		return result;
	}

}
