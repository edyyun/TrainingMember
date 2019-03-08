package com.training.memberweb.Repository;

import com.training.memberweb.Entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testRepository(){
        Logger logger = LoggerFactory.getLogger(MemberRepositoryTest.class);
        Member member = new Member();
        Member a = new Member();
        a.setMemberAddress("jkl;");
        a.setMemberEmail("asdf");
        a.setMemberGender("Perempuan");
        a.setMemberName("Roka");
        a.setMemberPassword("Coklat bulat");

        //save or update
        memberRepository.save(member);
        member.setMemberName("asdfadsf");
        memberRepository.save(member);

        //findAll
        List<Member> list = memberRepository.findAll();
        logger.info(list.toString());
        //delete
        memberRepository.delete(member);
        list = memberRepository.findAll();
        logger.info(list.toString());

    }
}
