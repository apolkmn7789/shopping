package com.shop.repository.member;

import com.shop.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findByEmail(String email);
}
