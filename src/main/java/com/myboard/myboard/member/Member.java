package com.myboard.myboard.member;

import com.myboard.myboard.article.domain.Article;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true) private String email;

    @Column(nullable = false) private String password;

    @Column(nullable = false) private String nickname;

    @OneToMany(mappedBy = "member")
    private final Set<Article> memberArticle = new LinkedHashSet<>();

    protected Member() {}

    private Member(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    public static Member of(String email, String password, String nickname) {
        return new Member(email, password, nickname);
    }
}
