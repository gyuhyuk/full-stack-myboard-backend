package com.myboard.myboard.article;

import java.time.LocalDateTime;

public class Article {
    private Long id; // PK
    private String title; // 제목
    private String content; // 본문
    private String hashtag; // 해시태그

    private LocalDateTime createdAt; // 생성일
    private String createdBy; // 생성자
}
