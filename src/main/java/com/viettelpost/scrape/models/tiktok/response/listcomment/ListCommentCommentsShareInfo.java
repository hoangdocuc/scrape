package com.viettelpost.scrape.models.tiktok.response.listcomment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListCommentCommentsShareInfo implements Serializable {

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("url")
    private String url;

}
