package com.join.urlShrinker.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.join.urlShrinker.model.User;
import com.join.urlShrinker.model.UserUrl;

public class UserBean implements Serializable {

	private static final long serialVersionUID = 1772674824049141836L;
	
    private int id;
    private String userName;
    private List<UrlBean> urls;

	public UserBean() {
		this.setUrls(new ArrayList<UrlBean>());
	}

	public UserBean(User user) {
		this.setUrls(new ArrayList<UrlBean>());
		this.setUser(user);
	}

	public void setUser(User user) {
		this.setId(user.getId());
		this.setUserName(user.getUserName());
		for (UserUrl userUrl: user.getUserUrls())
			this.getUrls().add(new UrlBean(userUrl.getUrl()));
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

	public List<UrlBean> getUrls() {
		return urls;
	}

	public void setUrls(List<UrlBean> urls) {
		this.urls = urls;
	}

}
