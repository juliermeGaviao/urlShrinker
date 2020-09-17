package com.join.urlShrinker.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.join.urlShrinker.dto.StatsDto;
import com.join.urlShrinker.dto.UrlDto;
import com.join.urlShrinker.dto.UserDto;

@Named
@ViewScoped
public class IndexController {

	private String inputText;
	private String inputText2;
	private StatsDto statsDto;
	private List<UrlDto> urlDtos;
	private UserDto userDto;

	public String getInputText() {
		return inputText;
	}

	public void setInputText(String inputText) {
		this.inputText = inputText;
	}

	public String getInputText2() {
		return inputText2;
	}

	public void setInputText2(String inputText2) {
		this.inputText2 = inputText2;
	}

	public StatsDto getStatsDto() {
		return statsDto;
	}

	public void setStatsDto(StatsDto statsDto) {
		this.statsDto = statsDto;
	}

	public List<UrlDto> getUrlDtos() {
		return urlDtos;
	}

	public void setUrlDtos(List<UrlDto> urlDtos) {
		this.urlDtos = urlDtos;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	private void clean(Object exception) {
		this.setInputText(null);
		this.setInputText2(null);

		if (exception != this.statsDto)
			this.setStatsDto(null);

		if (exception != this.urlDtos)
			this.setUrlDtos(null);

		if (exception != this.userDto)
			this.setUserDto(null);
	}

	private RestTemplate restTemplate = new RestTemplate();

	public void getGlobalStats() {
		ResponseEntity<StatsDto> restResult = this.restTemplate.getForEntity("http://localhost:8080/stats", StatsDto.class);

		if (restResult.getStatusCode().equals(HttpStatus.OK))
			this.setStatsDto(restResult.getBody());

		this.clean(this.getStatsDto());
	}

	public void getUserStats() {
		ResponseEntity<?> restResult = null;
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			Integer.parseInt(this.inputText);

			restResult = this.restTemplate.getForEntity("http://localhost:8080/users/{userId}/stats", UrlDto[].class, this.inputText);

			if (restResult.getStatusCode().equals(HttpStatus.OK)) {
				this.setUrlDtos(Arrays.asList((UrlDto[]) restResult.getBody()));
				this.clean(this.getUrlDtos());
			} else {
				context.addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "User Id doesn't exist or has no URL associated to", null));
				this.clean(null);
			}
		} catch (NumberFormatException e) {
			context.addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid User Id!", null));
			this.clean(null);
		}
	}

	public void getUrlStats() {
		ResponseEntity<?> restResult = null;
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			Integer.parseInt(this.inputText);

			restResult = this.restTemplate.getForEntity("http://localhost:8080/urls/{urlId}", UrlDto.class, this.inputText);

			if (restResult.getStatusCode().equals(HttpStatus.OK)) {
				List<UrlDto> urlDtoList = new ArrayList<UrlDto>();
				urlDtoList.add((UrlDto) restResult.getBody());
				this.setUrlDtos(urlDtoList);
				this.clean(this.getUrlDtos());
			} else {
				context.addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Url Id doesn't exist!", null));
				this.clean(null);
			}
		} catch (NumberFormatException e) {
			context.addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid URL Id!", null));
			this.clean(null);
		}
	}

	public void addUser() {
		FacesContext context = FacesContext.getCurrentInstance();

		if (this.inputText.trim().length() > 0) {
			ResponseEntity<?> restResult = this.restTemplate.postForEntity("http://localhost:8080/users/{userName}", null, UserDto.class, this.inputText.trim());

			if (restResult.getStatusCode().equals(HttpStatus.CREATED)) {
				this.setUserDto((UserDto) restResult.getBody());
				this.clean(this.getUserDto());
			} else {
				context.addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "The user [username=" + this.inputText + "] already exists!", null));
				this.clean(null);
			}
		} else {
			context.addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid User Name!", null));
			this.clean(null);
		}
	}

	public void addUrl() {
		ResponseEntity<?> restResult = null;
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			Integer.parseInt(this.inputText);
			
			if (this.inputText2.trim().length() > 0) {
				List<String> urls = new ArrayList<String>();

				urls.add(this.inputText2);
				restResult = this.restTemplate.postForEntity("http://localhost:8080/users/{userId}/urls", urls, UrlDto[].class, this.inputText);

				if (restResult.getStatusCode().equals(HttpStatus.CREATED)) {
					this.setUrlDtos(Arrays.asList((UrlDto[]) restResult.getBody()));
					this.clean(this.getUrlDtos());
				} else {
					context.addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "User Id doesn't exist!", null));
					this.clean(null);
				}
			} else {
				context.addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Hyperlink!", null));
				this.clean(null);
			}
		} catch (NumberFormatException e) {
			context.addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid User Id!", null));
			this.clean(null);
		}
	}

	public void deleteUser() {
		ResponseEntity<?> restResult = null;
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			Integer.parseInt(this.inputText);

			restResult = this.restTemplate.exchange("http://localhost:8080/user/{userId}", HttpMethod.DELETE, null, String.class, this.inputText);

			if (restResult.getStatusCode().equals(HttpStatus.OK))
				context.addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "User successfully deleted!", null));
			else
				context.addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "User Id doesn't exist!", null));
		} catch (NumberFormatException e) {
			context.addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid User Id!", null));
		}

		this.clean(null);
	}

	public void deleteUrl() {
		ResponseEntity<?> restResult = null;
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			Integer.parseInt(this.inputText);

			restResult = this.restTemplate.exchange("http://localhost:8080/urls/{urlId}", HttpMethod.DELETE, null, String.class, this.inputText);

			if (restResult.getStatusCode().equals(HttpStatus.OK)) {
				context.addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "Url successfully deleted!", null));
				this.getGlobalStats();
			} else {
				context.addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Url Id doesn't exist!", null));
				this.clean(null);
			}
		} catch (NumberFormatException e) {
			context.addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid URL Id!", null));
			this.clean(null);
		}
	}

}
