package com.training.memberweb.Service;

import com.training.memberweb.Entity.Member;

import java.util.List;

public interface MemberService {

    Member create(Member member);
    Member findById(Long id);
    List<Member> findAll();
    Member update(Member member,Long id);
    Member delete(Long id);
}
