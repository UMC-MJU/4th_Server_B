package com.umcblog.Blog.service;

import com.umcblog.Blog.entity.Member;
import com.umcblog.Blog.repository.MemberRepository;
import jakarta.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

    @Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

        private final MemberRepository memberRepository;

        public CustomUserDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
        return memberRepository.findByUser_id(username)
        .map(user -> createUser(username, user))
        .orElseThrow(() ->new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다."));
        }

        private org.springframework.security.core.userdetails.User createUser(String username, Member member) {
        return new org.springframework.security.core.userdetails.User(username,
        member.getPassword(),
        new ArrayList<>());
        }
        }