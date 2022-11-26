package com.ja.exam.wantrip.app.article.service;

import com.ja.exam.wantrip.app.article.dto.request.ArticleModifyDto;
import com.ja.exam.wantrip.app.article.entity.Article;
import com.ja.exam.wantrip.app.article.repository.ArticleRepository;
import com.ja.exam.wantrip.app.member.entity.Member;
import com.ja.exam.wantrip.app.security.entity.MemberContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public Article write(Member author, String subject, String content) {
        Article article = Article.builder()
                .author(author)
                .subject(subject)
                .content(content)
                .build();

        articleRepository.save(article);

        return article;
    }

    public List<Article> findAll() {
        return articleRepository.findAllByOrderByIdDesc();
    }

    public Optional<Article> findById(Long id) {
        return articleRepository.findById(id);
    }

    public boolean actorCanDelete(MemberContext memberContext, Article article) {
        return memberContext.getId() == article.getAuthor().getId();
    }

    public void delete(Article article) {
        articleRepository.delete(article);
    }

    public void modify(Article article, ArticleModifyDto articleModifyDto) {
        article.setSubject(articleModifyDto.getSubject());
        article.setContent(articleModifyDto.getContent());
        articleRepository.save(article);
    }

    public boolean actorCanModify(MemberContext memberContext, Article article) {
        return actorCanDelete(memberContext, article);
    }
}
