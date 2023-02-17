package com.viettelpost.scrape.models.tiktok.response.userposts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserPostAwemeList implements Serializable {

    @JsonProperty("aweme_id")
    private String aweme_id;

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("share_url")
    private String share_url;

}
