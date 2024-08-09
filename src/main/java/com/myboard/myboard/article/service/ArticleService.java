package com.myboard.myboard.article.service;

import com.myboard.myboard.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
}
