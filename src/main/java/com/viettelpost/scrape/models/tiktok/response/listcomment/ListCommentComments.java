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
public class ListCommentComments implements Serializable {

    @JsonProperty("aweme_id")
    private String aweme_id;

    @JsonProperty("cid")
    private String cid;

    @JsonProperty("share_info")
    private ListCommentCommentsShareInfo share_info;

    @JsonProperty("user")
    private ListCommentCommentsUser user;

    @JsonProperty("create_time")
    private Long create_time;

    @JsonProperty("text")
    private String text;

    @JsonProperty("digg_count")
    private Integer digg_count;

    @JsonProperty("reply_comment_total")
    private String reply_comment_total;

    @JsonProperty("reply_comment")
    private List<ListCommentComments> reply_comment;


}
