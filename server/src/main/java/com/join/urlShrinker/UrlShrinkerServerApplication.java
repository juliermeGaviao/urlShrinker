package com.join.urlShrinker;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.join.urlShrinker.model.Url;
import com.join.urlShrinker.model.User;
import com.join.urlShrinker.model.UserUrl;
import com.join.urlShrinker.repository.UrlRepository;
import com.join.urlShrinker.repository.UserRepository;

@SpringBootApplication
public class UrlShrinkerServerApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(UrlShrinkerServerApplication.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UrlRepository urlRepository;

    public static void main(String[] args) {
        SpringApplication.run(UrlShrinkerServerApplication.class, args);
    }

	@Override
    @Transactional
    public void run(String... strings) throws Exception {
		// Create some users
		final User userFooBar = new User("FooBar");
		final User userJohn = new User("John");
		final User userMary = new User("Mary");

		// Create some urls
		final Url urlGoogle = new Url("http://www.google.com.br", "http://urlShrinker.com.br/" + System.currentTimeMillis());
		final Url urlAmazon = new Url("http://www.amazon.com", "http://urlShrinker.com.br/" + System.currentTimeMillis() + 1);

		final UserUrl fooBarGoogle = new UserUrl(userFooBar, urlGoogle);
		final UserUrl fooBarAmazon = new UserUrl(userFooBar, urlAmazon);
		final UserUrl johnAmazon = new UserUrl(userJohn, urlAmazon);
		final UserUrl maryGoogle = new UserUrl(userMary, urlGoogle);
		final UserUrl johnGoogle = new UserUrl(userJohn, urlGoogle);
		
		userFooBar.getUserUrls().add(fooBarGoogle);
		userFooBar.getUserUrls().add(fooBarAmazon);
		userJohn.getUserUrls().add(johnAmazon);
		userMary.getUserUrls().add(maryGoogle);
		userJohn.getUserUrls().add(johnGoogle);

		// Saving URLs, which are relationship referenced entities
		this.urlRepository.saveAll(new ArrayList<Url>() {
			private static final long serialVersionUID = 7277707135175253649L;
			{
				add(urlGoogle);
				add(urlAmazon);
			}
		});

		// Saving Users owners of relationship with URLs
		urlGoogle.getUserUrls().add(fooBarGoogle);
		urlGoogle.getUserUrls().add(maryGoogle);
		urlAmazon.getUserUrls().add(fooBarAmazon);
		urlAmazon.getUserUrls().add(johnAmazon);
		urlGoogle.getUserUrls().add(johnAmazon);
		this.userRepository.saveAll(new ArrayList<User>() {
			private static final long serialVersionUID = -428607830363289575L;
			{
				add(userFooBar);
				add(userJohn);
				add(userMary);
			}
		});

		// fetch all Users
		for (User user : this.userRepository.findAll())
			UrlShrinkerServerApplication.logger.info(user.toString());

		// fetch all Urls
		for (Url url : this.urlRepository.findAll())
			UrlShrinkerServerApplication.logger.info(url.toString());
    }
}
