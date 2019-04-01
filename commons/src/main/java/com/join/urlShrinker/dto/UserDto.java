package com.join.urlShrinker.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 1772674824049141836L;
	
    private int id;
    private String userName;
    private List<UrlDto> urls;

	public UserDto() {
		this.setUrls(new ArrayList<UrlDto>());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<UrlDto> getUrls() {
		return urls;
	}

	public void setUrls(List<UrlDto> urls) {
		this.urls = urls;
	}

}
