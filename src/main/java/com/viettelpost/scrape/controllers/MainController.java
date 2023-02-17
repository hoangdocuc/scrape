package com.viettelpost.scrape.controllers;

import com.viettelpost.scrape.api.RestApi;
import com.viettelpost.scrape.models.base.BaseResponse;
import com.viettelpost.scrape.models.tiktok.response.listcomment.ListComment;
import com.viettelpost.scrape.models.tiktok.response.listcomment.ListCommentComments;
import com.viettelpost.scrape.service.UserPostService;
import com.viettelpost.scrape.ultils.ExcelGenerator;
import com.viettelpost.scrape.ultils.LanguageUtils;
import com.viettelpost.scrape.ultils.Student;
import com.viettelpost.scrape.ultils.TextUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api")
@Slf4j
public class MainController {

    @Autowired
    private LanguageUtils languageUtils;

    @Autowired
    private UserPostService userPostService;

    @Autowired
    private RestApi restApi;

    @CrossOrigin
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity test(){
        return ResponseEntity.ok("OK");
    }

    @RequestMapping(value = "/user-posts", method = RequestMethod.GET)
    public ResponseEntity userPosts(HttpServletRequest req) {
        BaseResponse baseResponse = null;
        try {
            baseResponse = userPostService.getUserPosts();
        } catch (Exception e){
            log.error(e.getMessage(), e);
            baseResponse = new BaseResponse(200, true, "loi he thong");
        }
        return ResponseEntity.ok(baseResponse);
    }

    @RequestMapping(value = "/list-comments", method = RequestMethod.GET)
    public ResponseEntity listComments(HttpServletRequest req,
                                       @RequestParam(value="aweme_id") String aweme_id) {
        BaseResponse baseResponse = null;
        try {
            baseResponse = userPostService.listComments(aweme_id);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            baseResponse = new BaseResponse(200, true, "loi he thong");
        }
        return ResponseEntity.ok(baseResponse);
    }

    @GetMapping("/export-to-excel")
    public void exportIntoExcelFile(@RequestParam(value="aweme_id") String aweme_id,
                                    @RequestParam(value="count", required = false) String count,
                                    @RequestParam(value="cursor", required = false) String cursor,
                                    HttpServletResponse response) throws Exception {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=tiktok-comments-" + aweme_id + "-" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        
        ListComment listComments = restApi.listComments(aweme_id, count, cursor);

        List<ListCommentComments> comments = new ArrayList<>();
        for (ListCommentComments listCommentComments : listComments.getComments()) {
            comments.add(listCommentComments);
            if(!TextUtils.isNullOrEmpty(listCommentComments.getReply_comment_total()) && !listCommentComments.getReply_comment_total().equalsIgnoreCase("0")){
                comments.addAll(listCommentComments.getReply_comment());
            }
        }

        ExcelGenerator generator = new ExcelGenerator(comments);

        generator.generateExcelFile(response);
    }


}
