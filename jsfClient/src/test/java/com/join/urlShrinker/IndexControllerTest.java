package com.join.urlShrinker;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.join.urlShrinker.bean.StatsBean;
import com.join.urlShrinker.bean.UrlBean;
import com.join.urlShrinker.bean.UserBean;
import com.join.urlShrinker.controller.IndexController;

@RunWith(PowerMockRunner.class)
@PrepareForTest({FacesContext.class})
public class IndexControllerTest {

	@InjectMocks
	private IndexController indexController;

	@Mock
	private RestTemplate restTemplate;

	@Mock
	private StatsBean statsBean;

	@Mock
	private UrlBean urlBean;

	@Mock
	private UserBean userBean;

	@Mock
	private List<UrlBean> urlBeans;

	@Before
	public void setup() {
		this.statsBean = new StatsBean();
		this.urlBean = new UrlBean();
		this.urlBeans = new ArrayList<UrlBean>();

		this.statsBean.setHits(10L);
		this.statsBean.setUrlCount(2L);

		this.urlBean.setId(1);
		this.urlBean.setHits(7);
		this.urlBean.setUrl("http://www.amazon.com");
		this.urlBean.setShortUrl("http://urlShrinker.com.br/15185889880411");
		this.urlBeans.add(urlBean);

		this.urlBean = new UrlBean();
		this.urlBean.setId(2);
		this.urlBean.setHits(3);
		this.urlBean.setUrl("http://www.google.com.br");
		this.urlBean.setShortUrl("http://urlShrinker.com.br/15185889880412");
		this.urlBeans.add(urlBean);

		this.statsBean.setTopUrls(this.urlBeans);

		this.userBean = new UserBean();
		this.userBean.setId(1);
		this.userBean.setUserName("Kate");
		this.userBean.setUrls(this.urlBeans);
	}

	@Test
	public void getGlobalStatsTest() {
		Mockito.when(this.restTemplate.getForEntity("http://localhost:8080/stats", StatsBean.class))
			.thenReturn(new ResponseEntity<StatsBean>(this.statsBean, HttpStatus.OK));

		this.indexController.getGlobalStats();

		StatsBean result = this.indexController.getStatsBean();
		assertThat(result.getHits()).isEqualTo(10L);
		assertThat(result.getUrlCount()).isEqualTo(2L);
		assertThat(result.getTopUrls().size()).isEqualTo(2);
		assertThat(result.getTopUrls().get(1).getUrl()).isEqualTo("http://www.google.com.br");
	}

	@Test
	public void getUserStats() {
		// Success case
		String inputText = "1";
		Mockito.when(this.restTemplate.getForEntity("http://localhost:8080/users/{userId}/stats", UrlBean[].class, inputText))
			.thenReturn(new ResponseEntity<UrlBean[]>(this.urlBeans.toArray(new UrlBean[0]), HttpStatus.OK));

		this.indexController.setInputText(inputText);
		this.indexController.getUserStats();

		List<UrlBean> result = this.indexController.getUrlBeans();
		assertThat(result.size()).isEqualTo(2);
		assertThat(result.get(1).getHits()).isEqualTo(3);

		// Invalid User Id
		PowerMockito.mockStatic(FacesContext.class);
		FacesContext context = PowerMockito.mock(FacesContext.class);
		PowerMockito.when(FacesContext.getCurrentInstance()).thenReturn(context);
		PowerMockito.doNothing().when(context).addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid User Id!", null));
		inputText = "a";
		this.indexController.setInputText(inputText);
		this.indexController.getUserStats();

		result = this.indexController.getUrlBeans();
		assertThat(result).isNull();

		// User Id doesn't exist or has no URL associated to
		inputText = "5";
		Mockito.when(this.restTemplate.getForEntity("http://localhost:8080/users/{userId}/stats", UrlBean[].class, inputText))
			.thenReturn(new ResponseEntity<UrlBean[]>(this.urlBeans.toArray(new UrlBean[0]), HttpStatus.NO_CONTENT));
		Mockito.doNothing().when(context).addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "User Id doesn't exist or has no URL associated to", null));
		this.indexController.setInputText(inputText);
		this.indexController.getUserStats();

		result = this.indexController.getUrlBeans();
		assertThat(result).isNull();
	}

	@Test
	public void getUrlStats() {
		// Success case
		String inputText = "1";
		Mockito.when(this.restTemplate.getForEntity("http://localhost:8080/urls/{urlId}", UrlBean.class, inputText))
			.thenReturn(new ResponseEntity<UrlBean>(this.urlBean, HttpStatus.OK));

		this.indexController.setInputText(inputText);
		this.indexController.getUrlStats();

		List<UrlBean> result = this.indexController.getUrlBeans();
		assertThat(result.size()).isEqualTo(1);
		assertThat(result.get(0).getHits()).isEqualTo(3);

		// Invalid Url Id
		PowerMockito.mockStatic(FacesContext.class);
		FacesContext context = PowerMockito.mock(FacesContext.class);
		PowerMockito.when(FacesContext.getCurrentInstance()).thenReturn(context);
		PowerMockito.doNothing().when(context).addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid URL Id!", null));
		inputText = "a";
		this.indexController.setInputText(inputText);
		this.indexController.getUrlStats();

		result = this.indexController.getUrlBeans();
		assertThat(result).isNull();

		// Url Id doesn't exist
		inputText = "5";
		Mockito.when(this.restTemplate.getForEntity("http://localhost:8080/urls/{urlId}", UrlBean.class, inputText))
			.thenReturn(new ResponseEntity<UrlBean>(this.urlBean, HttpStatus.NO_CONTENT));
		Mockito.doNothing().when(context).addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Url Id doesn't exist!", null));
		this.indexController.setInputText(inputText);
		this.indexController.getUrlStats();

		result = this.indexController.getUrlBeans();
		assertThat(result).isNull();
	}

	@Test
	public void addUser() {
		// Success case
		Mockito.when(this.restTemplate.postForEntity("http://localhost:8080/users/{userName}", null, UserBean.class, this.userBean.getUserName()))
			.thenReturn(new ResponseEntity<UserBean>(this.userBean, HttpStatus.CREATED));
		
		this.indexController.setInputText(this.userBean.getUserName());
		this.indexController.addUser();

		UserBean result = this.indexController.getUserBean();
		assertThat(result.getUserName()).isEqualTo("Kate");
		assertThat(result.getUrls().size()).isEqualTo(2);

		// Invalid User Name
		PowerMockito.mockStatic(FacesContext.class);
		FacesContext context = PowerMockito.mock(FacesContext.class);
		PowerMockito.when(FacesContext.getCurrentInstance()).thenReturn(context);
		Mockito.doNothing().when(context).addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid User Name!", null));
		this.indexController.setInputText("");
		this.indexController.addUser();

		result = this.indexController.getUserBean();
		assertThat(result).isNull();

		// The user name already exists
		Mockito.when(this.restTemplate.postForEntity("http://localhost:8080/users/{userName}", null, UserBean.class, this.userBean.getUserName()))
			.thenReturn(new ResponseEntity<UserBean>(this.userBean, HttpStatus.NO_CONTENT));
		Mockito.doNothing().when(context).addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "The user [username=" + this.userBean.getUserName() + "] already exists!", null));

		this.indexController.setInputText(this.userBean.getUserName());
		this.indexController.addUser();

		result = this.indexController.getUserBean();
		assertThat(result).isNull();
	}

	@Test
	public void addUrl() {
		// Success case
		String inputText = "1";
		String inputText2 = "http://www.terra.com.br";

		this.urlBean = new UrlBean();
		this.urlBean.setId(3);
		this.urlBean.setHits(1);
		this.urlBean.setUrl(inputText2);
		this.urlBean.setShortUrl("http://urlShrinker.com.br/15185889880413");
		this.urlBeans.add(urlBean);
		List<String> urls = new ArrayList<String>();

		urls.add(inputText2);
		Mockito.when(this.restTemplate.postForEntity("http://localhost:8080/users/{userId}/urls", urls, UrlBean[].class, inputText))
			.thenReturn(new ResponseEntity<UrlBean[]>(this.urlBeans.toArray(new UrlBean[0]), HttpStatus.CREATED));

		this.indexController.setInputText(inputText);
		this.indexController.setInputText2(inputText2);
		this.indexController.addUrl();

		List<UrlBean> result = this.indexController.getUrlBeans();
		assertThat(result.size()).isEqualTo(3);
		assertThat(result.get(2).getHits()).isEqualTo(1);
		this.urlBeans.remove(2);

		// Invalid User Id
		PowerMockito.mockStatic(FacesContext.class);
		FacesContext context = PowerMockito.mock(FacesContext.class);
		PowerMockito.when(FacesContext.getCurrentInstance()).thenReturn(context);
		Mockito.doNothing().when(context).addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid User Id!", null));
		inputText = "a";
		this.indexController.setInputText(inputText);
		this.indexController.addUrl();

		result = this.indexController.getUrlBeans();
		assertThat(result).isNull();

		// Invalid Hyperlink
		Mockito.doNothing().when(context).addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Hyperlink!", null));
		inputText = "1";
		inputText2 = "";
		this.indexController.setInputText(inputText);
		this.indexController.setInputText(inputText2);
		this.indexController.addUrl();

		result = this.indexController.getUrlBeans();
		assertThat(result).isNull();

		// "User Id doesn't exist
		inputText = "1";
		inputText2 = "http://www.terra.com.br";

		Mockito.when(this.restTemplate.postForEntity("http://localhost:8080/users/{userId}/urls", urls, UrlBean[].class, inputText))
		.thenReturn(new ResponseEntity<UrlBean[]>(this.urlBeans.toArray(new UrlBean[0]), HttpStatus.NO_CONTENT));

		this.indexController.setInputText(inputText);
		this.indexController.setInputText(inputText2);
		this.indexController.addUrl();

		result = this.indexController.getUrlBeans();
		assertThat(result).isNull();
	}

	@Test
	public void deleteUser() {
		// Success case
		String inputText = "2";
		Mockito.when(this.restTemplate.exchange("http://localhost:8080/user/{userId}", HttpMethod.DELETE, null, String.class, inputText))
			.thenReturn(new ResponseEntity<String>("User successfully deleted!", HttpStatus.OK));
		PowerMockito.mockStatic(FacesContext.class);
		FacesContext context = PowerMockito.mock(FacesContext.class);
		PowerMockito.when(FacesContext.getCurrentInstance()).thenReturn(context);
		Mockito.doNothing().when(context).addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "User successfully deleted!", null));

		this.indexController.setInputText(inputText);
		this.indexController.deleteUser();

		assertThat(this.indexController.getInputText()).isNull();

		// Invalid User Id
		inputText = "a";
		Mockito.doNothing().when(context).addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid User Id!", null));

		this.indexController.setInputText(inputText);
		this.indexController.deleteUser();

		assertThat(this.indexController.getInputText()).isNull();

		// User Id doesn't exist
		inputText = "1";
		Mockito.when(this.restTemplate.exchange("http://localhost:8080/user/{userId}", HttpMethod.DELETE, null, String.class, inputText))
			.thenReturn(new ResponseEntity<String>("User Id doesn't exist!", HttpStatus.NO_CONTENT));

		this.indexController.setInputText(inputText);
		this.indexController.deleteUser();

		assertThat(this.indexController.getInputText()).isNull();
	}

	@Test
	public void deleteUrl() {
		// Success case
		String inputText = "2";

		this.urlBeans.remove(1);

		Mockito.when(this.restTemplate.exchange("http://localhost:8080/urls/{urlId}", HttpMethod.DELETE, null, String.class, inputText))
			.thenReturn(new ResponseEntity<String>("Url successfully deleted!", HttpStatus.OK));
		PowerMockito.mockStatic(FacesContext.class);
		FacesContext context = PowerMockito.mock(FacesContext.class);
		PowerMockito.when(FacesContext.getCurrentInstance()).thenReturn(context);
		Mockito.doNothing().when(context).addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Url successfully deleted!", null));
		Mockito.when(this.restTemplate.getForEntity("http://localhost:8080/stats", StatsBean.class))
			.thenReturn(new ResponseEntity<StatsBean>(this.statsBean, HttpStatus.OK));

		this.indexController.setInputText(inputText);
		this.indexController.deleteUrl();

		List<UrlBean> result = this.indexController.getStatsBean().getTopUrls();
		assertThat(result.size()).isEqualTo(1);

		this.urlBeans.add(this.urlBean);

		// Invalid Url Id
		inputText = "a";
		Mockito.doNothing().when(context).addMessage("warningKeyMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid URL Id!", null));

		this.indexController.setInputText(inputText);
		this.indexController.deleteUrl();

		assertThat(this.indexController.getInputText()).isNull();

		// Url Id doesn't exist
		inputText = "5";
		Mockito.when(this.restTemplate.exchange("http://localhost:8080/urls/{urlId}", HttpMethod.DELETE, null, String.class, inputText))
			.thenReturn(new ResponseEntity<String>("Url successfully deleted!", HttpStatus.OK));

		this.indexController.setInputText(inputText);
		this.indexController.deleteUrl();

		assertThat(this.indexController.getInputText()).isNull();
	}
}
