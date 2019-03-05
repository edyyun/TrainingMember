package com.training.memberweb.Service;

import com.training.memberweb.Model.Member;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MemberServiceImpl implements MemberService{
    private ArrayList<Member> members=new ArrayList<>();

    @Override
    public Member create(Member member) {
        if(member.getMemberAddress()==null||
        member.getMemberEmail()==null||
        member.getMemberGender()==null||
        member.getMemberId()==0||
        member.getMemberName()==null||
        member.getMemberPassword()==null)return null;

        if(findById(member.getMemberId())==null)
        {
            members.add(member);
            return member;
        }else
            return null;
    }

    @Override
    public Member findById(int id) {
        for (Member a:members) {
            if(a.getMemberId()==id)return a;
        }
        return null;
    }

    @Override
    public ArrayList<Member> findAll() {
        return members;
    }

    @Override
    public Member update(Member member) {
        if(member.getMemberAddress()==null||
                member.getMemberEmail()==null||
                member.getMemberGender()==null||
                member.getMemberId()==0||
                member.getMemberName()==null||
                member.getMemberPassword()==null)return null;
        Member a=findById(member.getMemberId());
        if(a==null)
        {
            return null;
        }else{
            BeanUtils.copyProperties(member,a);
            return member;
        }

    }

    @Override
    public Member delete(int id) {
        if(id==0)return null;
        Member a = findById(id);
        if(a==null){
            return null;
        }else{
            members.remove(a);
            return a;
        }
    }
}
