package com.myboard.myboard.comment;

import com.myboard.myboard.article.domain.Article;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
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
public class ArticleComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    @Setter @ManyToOne(optional = false) Article article; // 게시글 (ID)
    @Setter @Column(nullable = false, length = 500) String content; // 본문

    @Column(nullable = false) private LocalDateTime createdAt; // 생성일
    @Column(nullable = false) private String createdBy; // 생성자

    protected ArticleComment() {}
    private ArticleComment(Article article, String content) {
        this.article = article;
        this.content = content;
    }

    public static ArticleComment of(Article article, String content) {
        return new ArticleComment(article, content);
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
