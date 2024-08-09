package com.myboard.myboard.article.repository;

import com.myboard.myboard.article.domain.Article;
import com.myboard.myboard.article.domain.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

public interface ArticleRepository extends
        JpaRepository<Article, Long>,
        QuerydslPredicateExecutor<Article>,
        QuerydslBinderCustomizer<QArticle>
{
    @Override
    default void customize(QuerydslBindings bindings, QArticle root) {
        bindings.excludeUnlistedProperties(true); // 리스팅을 하지 않은 프로퍼티는 검색에서 제외
        bindings.including(root.title, root.content, root.hashtag, root.createdAt, root.member.nickname);
        bindings.bind(root.title).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.hashtag).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq); // 문자열이 아니고 DateTimeExpression
        bindings.bind(root.member.nickname).first(StringExpression::containsIgnoreCase); // 닉네임으로 비교
    }
}
