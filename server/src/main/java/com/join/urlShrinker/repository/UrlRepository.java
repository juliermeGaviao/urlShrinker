package com.join.urlShrinker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.join.urlShrinker.model.Url;
import com.join.urlShrinker.model.UserUrl;

public interface UrlRepository extends JpaRepository<Url, Integer> {

	public List<Url> findByUrl(String url);

	@Query("select sum(uu.count) from UserUrl uu")
	public Long getUrlHits();

	@Query("select uu.url.id, sum(uu.count) from UserUrl uu group by uu.url order by sum(uu.count) desc")
	public List<Object[]> getTopUrls();

	@Query("select sum(uu.count) from UserUrl uu where uu.url.id = ?1")
	public Integer getUrlCount(Integer urldId);

	@Query("select uu from UserUrl uu where uu.user.id = ?1 and uu.url.id = ?2")
	public List<UserUrl> getUserUrl(Integer userId, Integer urldId);
}
