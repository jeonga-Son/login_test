package com.ja.exam.wantrip.app.member.service;

import com.ja.exam.wantrip.app.member.entity.Member;
import com.ja.exam.wantrip.app.member.repository.MemberRepository;
import com.ja.exam.wantrip.app.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;

    public Member join(String username, String password, String email) {
        Member member = Member.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();

        memberRepository.save(member);

        return member;
    }

    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    public String genAccessToken(Member member) {
        return jwtProvider.generateAccessToken(member.getAccessTokenClaims(), 60 * 60 * 24 * 90); // 1분, 1시간, 24시간, 90일 (90일 까지 로그인 가능)
    }
}
