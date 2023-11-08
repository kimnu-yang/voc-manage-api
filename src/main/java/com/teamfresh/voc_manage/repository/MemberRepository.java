package com.teamfresh.voc_manage.repository;

import java.util.Optional;

import com.teamfresh.voc_manage.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member save(Member member);

    Optional<Member> findById(Long id);
}
