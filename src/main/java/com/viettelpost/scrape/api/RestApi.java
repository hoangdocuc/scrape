package com.viettelpost.scrape.api;

import com.viettelpost.scrape.models.tiktok.response.listcomment.ListComment;
import com.viettelpost.scrape.models.tiktok.response.userposts.UserPosts;

public interface RestApi {
    UserPosts getUserPosts() throws Exception;
    ListComment listComments(String aweme_id, String count, String cursor) throws Exception;
}
