package com.join.urlShrinker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.join.urlShrinker.model.User;
import com.join.urlShrinker.model.UserUrl;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select uu from UserUrl uu where uu.user.id = ?1")
	public List<UserUrl> getUserUrls(int userId);

	public List<User> findByUserName(String userName);
}
