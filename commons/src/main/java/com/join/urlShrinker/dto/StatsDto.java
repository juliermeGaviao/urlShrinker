package com.join.urlShrinker.dto;

import java.io.Serializable;
import java.util.List;

public class StatsDto implements Serializable {

	private static final long serialVersionUID = -2027999314786698912L;

	private Long hits;
	private Long urlCount;
	private List<UrlDto> topUrls;

	public Long getHits() {
		return hits;
	}

	public void setHits(Long hits) {
		this.hits = hits;
	}

	public Long getUrlCount() {
		return urlCount;
	}

	public void setUrlCount(Long urlCount) {
		this.urlCount = urlCount;
	}

	public List<UrlDto> getTopUrls() {
		return topUrls;
	}

	public void setTopUrls(List<UrlDto> topUrls) {
		this.topUrls = topUrls;
	}

}
