package cn.codeforfun.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Slf4j
public class OauthTest {



  private String username = "admin";
  private String password = "admin";
  private String clientId = "client";
  private String clientSecret = "secret";

  private String accessToken;
  private String refreshToken;

  @Before
  public void before() throws IOException {
    String url = "http://localhost:8110/oauth/token";
    OkHttpClient client = new OkHttpClient();
    FormBody.Builder builder = new FormBody.Builder();
    builder.add("username", username);
    builder.add("password", password);
    builder.add("grant_type", "password");
    byte[] bytes = Base64.encodeBase64((clientId + ":" + clientSecret).getBytes());
    Request request = new Request.Builder()
            .url(url)
            .post(builder.build())
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .addHeader("Authorization", "Basic " + new String(bytes))
            .build();
    Response response = client.newCall(request).execute();
    Map map = new ObjectMapper().readValue(response.body().string(), HashMap.class);
    this.accessToken = (String) map.get("access_token");
    this.refreshToken = (String) map.get("refresh_token");
  }

  @Test
  public void checkToken() throws IOException {
    String url = "http://localhost:8110/oauth/check_token";
    OkHttpClient client = new OkHttpClient();
    FormBody.Builder builder = new FormBody.Builder();
    builder.add("token", this.accessToken);
    Request request = new Request.Builder()
            .url(url)
            .post(builder.build())
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .build();
    Response response = client.newCall(request).execute();
    log.info(response.body().string());
    Assert.assertEquals(200, response.code());
  }

  @Test
  public void refreshToken() throws IOException {
    String url = "http://localhost:8110/oauth/token";
    OkHttpClient client = new OkHttpClient();
    FormBody.Builder builder = new FormBody.Builder();
    builder.add("refresh_token", this.refreshToken);
    builder.add("grant_type", "refresh_token");
    byte[] bytes = Base64.encodeBase64((clientId + ":" + clientSecret).getBytes());
    Request request = new Request.Builder()
            .url(url)
            .post(builder.build())
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .addHeader("Authorization", "Basic " + new String(bytes))
            .build();
    Response response = client.newCall(request).execute();
    log.info(response.body().string());
    Assert.assertEquals(200, response.code());

  }
}
