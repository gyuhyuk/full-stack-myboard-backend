package com.myboard.myboard.comment.repository;

import com.myboard.myboard.comment.domain.ArticleComment;
import com.myboard.myboard.comment.domain.QArticleComment;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

public interface ArticleCommentRepository extends
        JpaRepository<ArticleComment, Long>,
        QuerydslPredicateExecutor<ArticleComment>,
        QuerydslBinderCustomizer<QArticleComment>
{
    @Override
    default void customize(QuerydslBindings bindings, QArticleComment root) {
        bindings.excludeUnlistedProperties(true); // 리스팅을 하지 않은 프로퍼티는 검색에서 제외
        bindings.including(root.content, root.createdAt, root.member.nickname);
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq); // 문자열이 아니고 DateTimeExpression
        bindings.bind(root.member.nickname).first(StringExpression::containsIgnoreCase);
    }
}