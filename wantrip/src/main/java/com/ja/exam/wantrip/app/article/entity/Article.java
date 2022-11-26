package com.ja.exam.wantrip.app.article.entity;

import com.ja.exam.wantrip.app.base.entity.BaseEntity;
import com.ja.exam.wantrip.app.member.entity.Member;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Article extends BaseEntity {
    @ManyToOne
    private Member author;

    private String subject;

    private String content;

    public Article(long id) {
        super(id);
    }
}
