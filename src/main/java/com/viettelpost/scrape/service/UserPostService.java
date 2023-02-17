package com.viettelpost.scrape.service;

import com.viettelpost.scrape.models.base.BaseResponse;

public interface UserPostService {

    public BaseResponse getUserPosts() throws Exception;

    public BaseResponse listComments(String aweme_id) throws Exception;

}
