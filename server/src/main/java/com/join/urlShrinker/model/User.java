package com.join.urlShrinker.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String userName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserUrl> userUrls;

    public User() {
    }

    public User(String userName) {
        this.setUserName(userName);
        this.setUserUrls(new ArrayList<UserUrl>());
    }

	@Override
	public String toString() {
		String result = String.format("%nUser [id=%d, userName='%s']%n", this.id, this.userName);

		if (this.userUrls != null)
			for (UserUrl userUrl : this.userUrls)
				result += String.format("Url[id=%d, url='%s', shorUrl='%s']%n", userUrl.getUrl().getId(),
						userUrl.getUrl().getUrl(), userUrl.getUrl().getShortUrl());

		return result;
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

	public List<UserUrl> getUserUrls() {
		return userUrls;
	}

	public void setUserUrls(List<UserUrl> userUrls) {
		this.userUrls = userUrls;
	}

}
