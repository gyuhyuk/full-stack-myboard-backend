package com.myboard.myboard.comment.domain;

import com.myboard.myboard.article.domain.Article;
import com.myboard.myboard.common.entity.BaseEntity;
import com.myboard.myboard.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
}
)
@Entity
public class ArticleComment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    @Setter @ManyToOne(optional = false) Article article; // 게시글 (ID)
    @Setter @Column(nullable = false, length = 500) String content; // 본문

    @ManyToOne(optional = false)
    private Member member;

    protected ArticleComment() {}
    private ArticleComment(Article article, String content, Member member) {
        this.article = article;
        this.content = content;
        this.member = member;
    }

    public static ArticleComment of(Article article, String content, Member member) {
        return new ArticleComment(article, content, member);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleComment that = (ArticleComment) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
