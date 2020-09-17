package com.join.urlShrinker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class UserUrl implements Serializable {
    private static final long serialVersionUID = 7118028361589265901L;

    @Id
    @ManyToOne
	private User user;

    @Id
    @ManyToOne
    private Url url;

    @NotNull
    @Column(name = "count")
    private int count;

    public UserUrl() {
    }

    public UserUrl(User user, Url url) {
		this.setUser(user);
		this.setUrl(url);
		this.setCount(1);
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Url getUrl() {
		return url;
	}

	public void setUrl(Url url) {
		this.url = url;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
