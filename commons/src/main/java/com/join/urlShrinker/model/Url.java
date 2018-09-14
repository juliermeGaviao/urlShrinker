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

import lombok.Data;

@Data
@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String url;

    @NotNull
    private String shortUrl;

    @OneToMany(mappedBy = "url", cascade=CascadeType.ALL)
    private List<UserUrl> userUrls;

    public Url() {
    }

    public Url(String url, String shortUrl){
        this.setUrl(url);
        this.setShortUrl(shortUrl);
        this.setUserUrls(new ArrayList<UserUrl>());
    }

    @Override
    public String toString() {
        String result = String.format( "%nUrl [id=%d, url='%s', shorUrl='%s']%n", this.getId(), this.getUrl(), this.getShortUrl());

        if (this.userUrls != null)
            for(UserUrl userUrl: this.userUrls)
                result += String.format("User [id=%d, userName='%s']%n", userUrl.getUser().getId(), userUrl.getUser().getUserName());

        return result;
    }
}
