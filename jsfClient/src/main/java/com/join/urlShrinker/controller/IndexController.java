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

import com.join.urlShrinker.bean.StatsBean;
import com.join.urlShrinker.bean.UrlBean;
import com.join.urlShrinker.bean.UserBean;

@Named
@ViewScoped
public class IndexController {

	private String inputText;
	private String inputText2;
	private StatsBean statsBean;
	private List<UrlBean> urlBeans;
	private UserBean userBean;

	private void clean(Object exception) {
		this.setInputText(null);
		this.setInputText2(null);

		if (exception != this.statsBean)
			this.setStatsBean(null);

		if (exception != this.urlBeans)
			this.setUrlBeans(null);

		if (exception != this.userBean)
			this.setUserBean(null);
	}

	private RestTemplate restTemplate = new RestTemplate();

	public void getGlobalStats() {
		ResponseEntity<StatsBean> restResult = this.restTemplate.getForEntity("http://localhost:8080/stats", StatsBean.class);

		if (restResult.getStatusCode().equals(HttpStatus.OK))
			this.setStatsBean(restResult.getBody());

		this.clean(this.getStatsBean());
	}

	public void getUserStats() {
		ResponseEntity<?> restResult = null;
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			Integer.parseInt(this.inputText);

			restResult = this.restTemplate.getForEntity("http://localhost:8080/users/{userId}/stats", UrlBean[].class, this.inputText);

			if (restResult.getStatusCode().equals(HttpStatus.OK)) {
				this.setUrlBeans(Arrays.asList((UrlBean[]) restResult.getBody()));
				this.clean(this.getUrlBeans());
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

			restResult = this.restTemplate.getForEntity("http://localhost:8080/urls/{urlId}", UrlBean.class, this.inputText);

			if (restResult.getStatusCode().equals(HttpStatus.OK)) {
				List<UrlBean> urlBeanList = new ArrayList<UrlBean>();
				urlBeanList.add((UrlBean) restResult.getBody());
				this.setUrlBeans(urlBeanList);
				this.clean(this.getUrlBeans());
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
			ResponseEntity<?> restResult = this.restTemplate.postForEntity("http://localhost:8080/users/{userName}", null, UserBean.class, this.inputText.trim());

			if (restResult.getStatusCode().equals(HttpStatus.CREATED)) {
				this.setUserBean((UserBean) restResult.getBody());
				this.clean(this.getUserBean());
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
				restResult = this.restTemplate.postForEntity("http://localhost:8080/users/{userId}/urls", urls, UrlBean[].class, this.inputText);

				if (restResult.getStatusCode().equals(HttpStatus.CREATED)) {
					this.setUrlBeans(Arrays.asList((UrlBean[]) restResult.getBody()));
					this.clean(this.getUrlBeans());
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

	public StatsBean getStatsBean() {
		return statsBean;
	}

	public void setStatsBean(StatsBean statsBean) {
		this.statsBean = statsBean;
	}

	public List<UrlBean> getUrlBeans() {
		return urlBeans;
	}

	public void setUrlBeans(List<UrlBean> urlBeans) {
		this.urlBeans = urlBeans;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

}
