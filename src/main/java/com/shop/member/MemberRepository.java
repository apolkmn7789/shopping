package com.shop.member;

import com.shop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

    // 이메일 찾기
    Member findByEmail(String email);
}
