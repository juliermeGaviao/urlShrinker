package com.join.urlShrinker.bean;

import java.io.Serializable;

import com.join.urlShrinker.model.Url;

public class UrlBean implements Serializable {

	private static final long serialVersionUID = 5995561557899692055L;

	private int id;
	private Integer hits;
	private String url;
	private String shortUrl;

	public UrlBean() {
	}

	public UrlBean(Url url) {
		this.setUrl(url);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public void setUrl(Url url) {
		this.setId(url.getId());
		this.setUrl(url.getUrl());
		this.setShortUrl(url.getShortUrl());
	}

    @Override
    public String toString() {
        String result = String.format( "%nUrl [id=%d, url='%s', shorUrl='%s']%n", this.getId(), this.getUrl(), this.getShortUrl());

        return result;
    }
}
