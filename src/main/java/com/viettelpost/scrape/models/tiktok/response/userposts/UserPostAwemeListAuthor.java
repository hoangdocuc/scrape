package com.viettelpost.scrape.models.tiktok.response.userposts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserPostAwemeListAuthor implements Serializable {

    @JsonProperty("accept_private_policy")
    private String accept_private_policy;

    @JsonProperty("account_labels")
    private String account_labels;

    @JsonProperty("account_region")
    private String account_region;

    @JsonProperty("ad_cover_url")
    private String ad_cover_url;

    @JsonProperty("advance_feature_item_order")
    private String advance_feature_item_order;

    @JsonProperty("advanced_feature_info")
    private String advanced_feature_info;

    @JsonProperty("apple_account")
    private String apple_account;

    @JsonProperty("authority_status")
    private String authority_status;

    @JsonProperty("avatar_168x168")
    private Object avatar_168x168;

    @JsonProperty("avatar_300x300")
    private Object avatar_300x300;

    @JsonProperty("avatar_larger")
    private Object avatar_larger;

    @JsonProperty("avatar_medium")
    private Object avatar_medium;

    @JsonProperty("avatar_thumb")
    private Object avatar_thumb;

    @JsonProperty("avatar_uri")
    private String avatar_uri;

    @JsonProperty("aweme_count")
    private String aweme_count;

    @JsonProperty("bind_phone")
    private String bind_phone;

    @JsonProperty("bold_fields")
    private String bold_fields;

    @JsonProperty("can_message_follow_status_list")
    private String can_message_follow_status_list;

    @JsonProperty("can_set_geofencing")
    private String can_set_geofencing;

    @JsonProperty("cha_list")
    private String cha_list;

    @JsonProperty("comment_filter_status")
    private String comment_filter_status;

    @JsonProperty("comment_setting")
    private String comment_setting;

    @JsonProperty("commerce_user_level")
    private String commerce_user_level;

    @JsonProperty("cover_url")
    private List<Object> cover_url;

    @JsonProperty("create_time")
    private String create_time;

    @JsonProperty("custom_verify")
    private String custom_verify;

    @JsonProperty("cv_level")
    private String cv_level;

    @JsonProperty("download_prompt_ts")
    private String download_prompt_ts;

    @JsonProperty("download_setting")
    private String download_setting;

    @JsonProperty("duet_setting")
    private String duet_setting;

    @JsonProperty("enterprise_verify_reason")
    private String enterprise_verify_reason;

    @JsonProperty("events")
    private String events;

    @JsonProperty("favoriting_count")
    private String favoriting_count;

    @JsonProperty("follower_status")
    private String follower_status;

    @JsonProperty("followers_detail")
    private String followers_detail;

    @JsonProperty("following_count")
    private String following_count;

    @JsonProperty("friends_status")
    private String friends_status;

    @JsonProperty("geofencing")
    private String geofencing;

    @JsonProperty("google_account")
    private String google_account;

    @JsonProperty("has_email")
    private String has_email;

    @JsonProperty("has_facebook_token")
    private String has_facebook_token;

    @JsonProperty("has_insights")
    private String has_insights;

    @JsonProperty("has_orders")
    private String has_orders;

    @JsonProperty("has_twitter_token")
    private String has_twitter_token;

    @JsonProperty("has_youtube_token")
    private String has_youtube_token;

    @JsonProperty("hide_search")
    private String hide_search;

    @JsonProperty("homepage_bottom_toast")
    private String homepage_bottom_toast;

    @JsonProperty("ins_id")
    private String ins_id;

    @JsonProperty("is_ad_fake")
    private String is_ad_fake;

    @JsonProperty("is_block")
    private String is_block;

    @JsonProperty("is_discipline_member")
    private String is_discipline_member;

    @JsonProperty("is_phone_binded")
    private String is_phone_binded;

    @JsonProperty("is_star")
    private String is_star;

    @JsonProperty("item_list")
    private String item_list;

    @JsonProperty("language")
    private String language;

    @JsonProperty("live_agreement")
    private String live_agreement;

    @JsonProperty("live_commerce")
    private String live_commerce;

    @JsonProperty("live_verify")
    private String live_verify;

    @JsonProperty("mention_status")
    private String mention_status;

    @JsonProperty("mutual_relation_avatars")
    private String mutual_relation_avatars;

    @JsonProperty("need_points")
    private String need_points;

    @JsonProperty("need_recommend")
    private String need_recommend;

    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("original_musician")
    private Object original_musician;

    @JsonProperty("platform_sync_info")
    private String platform_sync_info;

    @JsonProperty("prevent_download")
    private String prevent_download;

    @JsonProperty("react_setting")
    private String react_setting;

    @JsonProperty("region")
    private String region;

    @JsonProperty("relative_users")
    private String relative_users;

    @JsonProperty("room_id")
    private String room_id;

    @JsonProperty("search_highlight")
    private String search_highlight;


}
