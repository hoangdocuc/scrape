package com.viettelpost.scrape.service.impl;

import com.viettelpost.scrape.api.RestApi;
import com.viettelpost.scrape.models.base.BaseResponse;
import com.viettelpost.scrape.models.tiktok.response.listcomment.ListComment;
import com.viettelpost.scrape.models.tiktok.response.userposts.UserPosts;
import com.viettelpost.scrape.service.UserPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserPostServiceImpl implements UserPostService {

    @Autowired
    private RestApi restApi;

    @Override
    public BaseResponse getUserPosts() throws Exception{
        UserPosts userPosts = restApi.getUserPosts();
        return new BaseResponse(200, false, "OK", userPosts);
    }

    @Override
    public BaseResponse listComments(String aweme_id) throws Exception {
        ListComment listComments = restApi.listComments(aweme_id, null, null);
        return new BaseResponse(200, false, "OK", listComments);
    }



}
