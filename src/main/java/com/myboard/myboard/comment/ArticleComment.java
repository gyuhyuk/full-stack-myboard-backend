package com.myboard.myboard.comment;

import com.myboard.myboard.article.Article;

import java.time.LocalDateTime;

public class ArticleComment {
    private Long id; // PK
    private Article article; // 게시글 (ID)
    private String content; // 본문

    private LocalDateTime createdAt; // 생성일
    private String createdBy; // 생성자
}
