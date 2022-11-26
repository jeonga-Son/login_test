package com.ja.exam.wantrip.app.article.repository;

import com.ja.exam.wantrip.app.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
