package com.training.memberweb.Service;

import com.training.memberweb.Model.Member;

import java.util.ArrayList;

public interface MemberService {

    Member create(Member member);
    Member findById(int id);
    ArrayList<Member> findAll();
    Member update(Member member);
    Member delete(int id);
}
