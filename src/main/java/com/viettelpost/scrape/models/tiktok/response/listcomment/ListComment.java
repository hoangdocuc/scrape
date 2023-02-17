package com.viettelpost.scrape.models.tiktok.response.listcomment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListComment implements Serializable {

    @JsonProperty("alias_comment_deleted")
    private Boolean alias_comment_deleted;

    @JsonProperty("comments")
    private List<ListCommentComments> comments;

    @JsonProperty("total")
    private Integer total;

}
