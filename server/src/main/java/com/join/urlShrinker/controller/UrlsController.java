package com.join.urlShrinker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.join.urlShrinker.model.Url;
import com.join.urlShrinker.repository.UrlRepository;

@RestController
public class UrlsController {

    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private StatsController statsController;

	@RequestMapping("/urls/{urlId}")
	public ResponseEntity<?> getUrlStats(@PathVariable Integer urlId) {
		return this.statsController.getUrlStats(urlId);
	}

	@RequestMapping(value="/urls/{urlId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteUrl(@PathVariable Integer urlId) {
		Url url = null;
		ResponseEntity<?> result;

		try {
			url = this.urlRepository.findById(urlId).get();
		} catch (Exception e) {
		}

		if (url != null) {
			this.urlRepository.delete(url);
			this.urlRepository.flush();
			result = new ResponseEntity<String>("Url successfully deleted!", HttpStatus.OK);
		} else
			result = new ResponseEntity<String>("Url Id doesn't exist!", HttpStatus.NO_CONTENT);

		return result;
	}
}
