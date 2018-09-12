package com.join.urlShrinker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.join.urlShrinker.bean.StatsBean;
import com.join.urlShrinker.bean.UrlBean;
import com.join.urlShrinker.model.Url;
import com.join.urlShrinker.repository.UrlRepository;

@RestController
public class StatsController {

    @Autowired
    private UrlRepository urlRepository;

	@RequestMapping("/stats")
	public ResponseEntity<StatsBean> getStats() {
		StatsBean statsBean = new StatsBean();

		statsBean.setHits(this.urlRepository.getUrlHits());
		statsBean.setUrlCount(new Long(this.urlRepository.findAll().size()));

		List<UrlBean> topUrls = new ArrayList<UrlBean>();
		List<Object[]> topUrlIds = this.urlRepository.getTopUrls();
		Object[] urlDataArray;
		UrlBean urlBean;

		for (int i = 0; i < 10 && i < topUrlIds.size(); i++) {
			urlDataArray = topUrlIds.get(i);
			urlBean = new UrlBean(this.urlRepository.getOne((Integer) urlDataArray[0]));
			urlBean.setHits(((Long) urlDataArray[1]).intValue());
			topUrls.add(urlBean);
		}
		statsBean.setTopUrls(topUrls);

		return new ResponseEntity<StatsBean>(statsBean, HttpStatus.OK);
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
			UrlBean urlBean = new UrlBean(url);
			urlBean.setHits(this.urlRepository.getUrlCount(urlId));
			result = new ResponseEntity<UrlBean>(urlBean, HttpStatus.OK);
		} else
			result = new ResponseEntity<String>("Url Id doesn't exist!", HttpStatus.NO_CONTENT);

		return result;
	}
}
