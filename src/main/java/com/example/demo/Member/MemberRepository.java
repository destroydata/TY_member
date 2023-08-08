package com.example.demo.Member;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long> {


    @Query("select m from Member m  order by m.number desc")
    Page<Member> findAllbyCondition(Pageable pageable);
}
