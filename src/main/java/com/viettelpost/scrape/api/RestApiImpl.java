package com.viettelpost.scrape.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.viettelpost.scrape.models.tiktok.response.listcomment.ListComment;
import com.viettelpost.scrape.models.tiktok.response.userposts.UserPosts;
import com.viettelpost.scrape.ultils.TextUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class RestApiImpl implements RestApi {

    private Client client;

    private String scraptikUrlRoot = "https://scraptik.p.rapidapi.com/%s";

    private String user_tiktok_id = "7167164727611704326";

    private String sec_user_id = "MS4wLjABAAAAJTZbuRgfxPIE8huTskDGGfRbyoVotIOmzoUwazhZOcVkluRZM-4J9HDpG8PFmBiH";

    private String x_rapidapi_key = "76ec83d70bmsh0db68432ba4c53cp100e1ejsn93aafb3c5cfe";

    private String x_rapidapi_host = "scraptik.p.rapidapi.com";

    private String count = "50";

    private String max_cursor = "0";

    private ObjectMapper mapper;

    public RestApiImpl() {
        ClientConfig config = new DefaultClientConfig();
        client = Client.create(config);
        client.setReadTimeout(180000);
        client.setConnectTimeout(180000);
        mapper = new ObjectMapper();
    }

    public RestTemplate getRestTemplate(int time) {
        CloseableHttpClient httpClient
                = HttpClients.custom()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory
                = new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);
        requestFactory.setReadTimeout(time);
        requestFactory.setConnectTimeout(time);
        requestFactory.setConnectionRequestTimeout(time);
        return new RestTemplate(requestFactory);
    }

    @Override
    public UserPosts getUserPosts() throws Exception{
        StringBuilder urlPath = new StringBuilder();
        urlPath.append("user-posts?user_id=").append(user_tiktok_id)
                .append("&sec_user_id=").append(sec_user_id)
                .append("&count=").append(count)
                .append("&max_cursor=").append(max_cursor);
        String url = String.format(scraptikUrlRoot, urlPath.toString());
        log.info("url: "+url);
        WebResource webResource = client.resource(url);
        ClientResponse response = webResource
                .header("x-rapidapi-key",x_rapidapi_key)
                .header("x-rapidapi-host",x_rapidapi_host)
                .get(ClientResponse.class);
        String result = response.getEntity(String.class);
        UserPosts userPosts = mapper.readValue(result, UserPosts.class);
        return userPosts;
    }

    @Override
    public ListComment listComments(String aweme_id, String count, String cursor) throws Exception{
        StringBuilder urlPath = new StringBuilder();
        String countIn = TextUtils.isEmpty(count)? this.count : count;
        String cursorIn = TextUtils.isEmpty(cursor)? this.max_cursor : cursor;
        urlPath.append("list-comments?aweme_id=").append(aweme_id)
                .append("&count=").append(countIn)
                .append("&max_cursor=").append(cursorIn);
        String url = String.format(scraptikUrlRoot, urlPath.toString());
        log.info("url: "+url);
        WebResource webResource = client.resource(url);
        ClientResponse response = webResource
                .header("x-rapidapi-key",x_rapidapi_key)
                .header("x-rapidapi-host",x_rapidapi_host)
                .get(ClientResponse.class);
        String result = response.getEntity(String.class);
        ListComment listComment = mapper.readValue(result, ListComment.class);
        return listComment;
    }
}
