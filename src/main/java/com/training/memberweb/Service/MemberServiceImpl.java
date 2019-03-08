package com.training.memberweb.Service;

import com.training.memberweb.Entity.Member;
import com.training.memberweb.Repository.MemberRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member create(Member member) {
        if(member==null){
            return null;
        }
        memberRepository.save(member);
        return member;
    }

    @Override
    public Member findById(Long id) {
        Optional<Member> a = memberRepository.findById(id);
        if(a.isPresent())return a.get();
        else return null;
    }

    @Override
    public List<Member> findAll()
    {
        return memberRepository.findAll();
    }

    @Override
    public Member update(Member member,Long id) {
        member.setMemberId(id);
        memberRepository.save(member);
        return member;
    }

    @Override
    public Member delete(Long id) {
        memberRepository.delete(findById(id));
        return findById(id);
    }
}
