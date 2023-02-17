package com.viettelpost.scrape.models.tiktok.response.userposts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserPosts implements Serializable {

    @JsonProperty("aweme_list")
    private List<UserPostAwemeList> aweme_list;

}
