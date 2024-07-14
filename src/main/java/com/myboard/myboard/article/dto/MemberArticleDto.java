package com.myboard.myboard.article.dto;

import com.myboard.myboard.member.Member;

public record MemberArticleDto(String nickname) {

    public static MemberArticleDto of(String nickname) {
        return new MemberArticleDto(nickname);
    }

    public static MemberArticleDto from(Member entity) {
        return new MemberArticleDto(entity.getNickname());
    }
}
