package cn.codeforfun.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class OauthTest {
  @Resource
  private WebApplicationContext context;
  @Resource
  private FilterChainProxy proxy;
  private MockMvc mvc;
  private String username = "admin";
  private String password = "admin";
  private String clientId = "client";
  private String clientSecret = "secret";

  @Before
  public void before() throws Exception {
    mvc = MockMvcBuilders.webAppContextSetup(context).addFilter(proxy).build();
    this.getToken();
  }

  @Test
  public void checkToken() throws Exception {
    MockHttpServletResponse response = mvc.perform(
            post("/oauth/check_token")
                    .param("token", this.getToken().accessToken)
    ).andReturn().getResponse();
    Assert.assertEquals(200, response.getStatus());
  }

  @Test
  public void refreshToken() throws Exception {
    MockHttpServletResponse response = mvc.perform(
            post("/oauth/token")
                    .param("grant_type", "refresh_token")
                    .param("refresh_token", getToken().refreshToken)
                    .header("Authorization", "Basic " + new String(Base64.encodeBase64((clientId + ":" + clientSecret).getBytes())))
    ).andReturn().getResponse();
    Assert.assertEquals(200, response.getStatus());
  }

  public Token getToken() throws Exception {
    MockHttpServletResponse response = mvc.perform(
            post("/oauth/token")
                    .param("username", username)
                    .param("password", password)
                    .param("grant_type", "password")
                    .header("Authorization", "Basic " + new String(Base64.encodeBase64((clientId + ":" + clientSecret).getBytes())))
    ).andReturn().getResponse();
    return new ObjectMapper().readValue(response.getContentAsString(), Token.class);
  }

  private MockHttpServletRequestBuilder get(String url) {
    return MockMvcRequestBuilders.get(url);
  }

  private MockHttpServletRequestBuilder post(String url) {
    return MockMvcRequestBuilders.post(url);
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  private static class Token {
    @JsonProperty("access_token")
    public String accessToken;
    @JsonProperty("refresh_token")
    public String refreshToken;
    @JsonProperty("token_type")
    public String tokenType;
    @JsonProperty("expires_in")
    public int expiresIn;
    @JsonProperty("scope")
    public String scope;
  }
}


