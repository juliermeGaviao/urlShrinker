package com.join.urlShrinker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.join.urlShrinker.converter.UrlConverter;
import com.join.urlShrinker.dto.StatsDto;
import com.join.urlShrinker.dto.UrlDto;
import com.join.urlShrinker.model.Url;
import com.join.urlShrinker.repository.UrlRepository;

@RestController
public class StatsController {

    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private UrlConverter urlConverter;

	@RequestMapping("/stats")
	public ResponseEntity<StatsDto> getStats() {
		StatsDto statsBean = new StatsDto();

		statsBean.setHits(this.urlRepository.getUrlHits());
		statsBean.setUrlCount(new Long(this.urlRepository.findAll().size()));

		List<UrlDto> topUrls = new ArrayList<UrlDto>();
		List<Object[]> topUrlIds = this.urlRepository.getTopUrls();
		Object[] urlDataArray;
		UrlDto urlDto;

		for (int i = 0; i < 10 && i < topUrlIds.size(); i++) {
			urlDataArray = topUrlIds.get(i);
			urlDto = this.urlConverter.entity2Dto(this.urlRepository.getOne((Integer) urlDataArray[0]));
			urlDto.setHits(((Long) urlDataArray[1]).intValue());
			topUrls.add(urlDto);
		}
		statsBean.setTopUrls(topUrls);

		return new ResponseEntity<StatsDto>(statsBean, HttpStatus.OK);
	}

	@RequestMapping("/stats/{urlId}")
	public ResponseEntity<?> getUrlStats(@PathVariable Integer urlId) {
		Url url = null;
		ResponseEntity<?> result;

		try {
			url = this.urlRepository.findById(urlId).get();
		} catch (Exception e) {
		}

		if (url != null) {
			UrlDto urlDto = this.urlConverter.entity2Dto(url);
			urlDto.setHits(this.urlRepository.getUrlCount(urlId));
			result = new ResponseEntity<UrlDto>(urlDto, HttpStatus.OK);
		} else
			result = new ResponseEntity<String>("Url Id doesn't exist!", HttpStatus.NO_CONTENT);

		return result;
	}
}
