package com.join.urlShrinker;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.join.urlShrinker.model.Url;
import com.join.urlShrinker.model.User;
import com.join.urlShrinker.repository.UrlRepository;
import com.join.urlShrinker.repository.UserRepository;

@SpringBootApplication
public class UrlShrinkerServerApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
		// fetch all Users
		for (User user : this.userRepository.findAll())
			this.logger.info(user.toString());

		// fetch all Urls
		for (Url url : this.urlRepository.findAll())
			this.logger.info(url.toString());
    }
}
