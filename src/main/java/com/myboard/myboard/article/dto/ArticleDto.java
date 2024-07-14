package com.myboard.myboard.article.dto;

import com.myboard.myboard.article.domain.Article;

import java.time.LocalDateTime;

public record ArticleDto(Long id, String title, String content, String hashtag, MemberArticleDto member,
                         LocalDateTime createdAt) {

    public static ArticleDto of(Long id, String title, String content, String hashtag, MemberArticleDto member, LocalDateTime createdAt) {
        return new ArticleDto(id, title, content, hashtag, member, createdAt);
    }

    public static ArticleDto from(Article entity) {
        return new ArticleDto(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getHashtag(),
                MemberArticleDto.from(entity.getMember()),
                entity.getCreatedAt()
        );
    }
}
