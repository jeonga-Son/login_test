package com.ja.exam.wantrip.app.article.controller;

import com.ja.exam.wantrip.app.article.entity.Article;
import com.ja.exam.wantrip.app.article.service.ArticleService;
import com.ja.exam.wantrip.app.base.dto.RsData;
import com.ja.exam.wantrip.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articles") // Rest API에서는 s를 붙임 ex) articles
@RequiredArgsConstructor
public class ArticlesController {
    private final ArticleService articleService;

    @GetMapping("")
    public ResponseEntity<RsData> list() {
        List<Article> articles = articleService.findAll();

        return Util.spring.responseEntityOf(
                RsData.successOf(
                        Util.mapOf(
                                "articles", articles
                        )
                )
        );
    }
}
