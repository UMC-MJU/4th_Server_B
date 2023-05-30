package com.umcblog.Blog.repository;

import com.umcblog.Blog.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByUser_id(String user_id);
}