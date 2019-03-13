package com.training.memberweb.Service;

import com.sun.xml.internal.ws.policy.AssertionSet;
import com.training.memberweb.Entity.Member;
import com.training.memberweb.Repository.MemberRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTest {

    private MemberService service;
    private MemberRepository memberRepository;

    @Before
    public void setUp() throws Exception {
        memberRepository = Mockito.mock(MemberRepository.class);
        service =new MemberServiceImpl(memberRepository);
    }

    @Test
    public void CreateTest(){
        Member a = new Member();
        a.setMemberAddress("jkl;");
        a.setMemberEmail("asdf");
        a.setMemberGender("Perempuan");
        a.setMemberName("Roka");
        a.setMemberPassword("Coklat bulat");
        Mockito.when(memberRepository.save(a)).thenReturn(a);
        Member b = service.create(a);
        Assert.assertTrue(b !=null);
        Assert.assertTrue(a.getMemberId()==b.getMemberId());

        Mockito.verify(memberRepository, Mockito.times(1)).save(a);
    }
    @Test
    public void FindByIdTest(){
        Member a = new Member();
        a.setMemberAddress("jkl;");
        a.setMemberEmail("asdf");
        a.setMemberGender("Perempuan");
        a.setMemberName("Roka");
        a.setMemberPassword("Coklat bulat");

        Mockito.when(memberRepository.save(a)).thenReturn(a);
        service.create(a);
        Mockito.when(memberRepository.findById(1L)).thenReturn(Optional.of(a));
        Mockito.when(memberRepository.findById(2L)).thenReturn(Optional.empty());

        Member result1 = service.findById(1L);
        Assert.assertTrue(result1!=null);

        Member result2 = service.findById(2L);
        Assert.assertTrue(result2 ==null );

        Mockito.verify(memberRepository,Mockito.times(1)).findById(1L);
        Mockito.verify(memberRepository,Mockito.times(1)).findById(2L);
    }
    @Test
    public void FindAllTest(){
        Member a = new Member();
        a.setMemberAddress("jkl;");
        a.setMemberEmail("asdf");
        a.setMemberGender("Perempuan");
        a.setMemberName("Roka");
        a.setMemberPassword("Coklat bulat");
        Mockito.when(memberRepository.save(a)).thenReturn(a);
        service.create(a);
        Member b = new Member();
        b.setMemberAddress("zcxv");
        b.setMemberEmail("qewr");
        b.setMemberGender("Laki Laki");
        b.setMemberName("Roti");
        b.setMemberPassword("Coklat pisang");
        service.create(b);
        List<Member> members = null;

        Mockito.when(memberRepository.findAll()).thenReturn(members);
        Assert.assertTrue(service.findAll()==null);
    }
    @Test
    public void UpdateTest(){
        Member a = new Member();
        a.setMemberAddress("jkl;");
        a.setMemberEmail("asdf");
        a.setMemberGender("Perempuan");
        a.setMemberName("Roka");
        a.setMemberPassword("Coklat bulat");
        Mockito.when(memberRepository.save(a)).thenReturn(a);
        service.create(a);
        Member b = new Member();
        b.setMemberAddress("zcxv");
        b.setMemberEmail("qewr");
        b.setMemberGender("Laki Laki");
        b.setMemberName("Roti");
        b.setMemberPassword("Coklat pisang");
        Member c= service.update(b,b.getMemberId());
        Assert.assertTrue(c!=null);
        Assert.assertTrue(b==c);
    }

    @Test
    public void DeleteTest() {

        Member a = new Member();
        a.setMemberAddress("jkl;");
        a.setMemberEmail("asdf");
        a.setMemberGender("Perempuan");
        a.setMemberName("Roka");
        a.setMemberPassword("Coklat bulat");
        Mockito.when(memberRepository.save(a)).thenReturn(a);
        service.create(a);
        Member b = new Member();
        b.setMemberAddress("zcxv");
        b.setMemberEmail("qewr");
        b.setMemberGender("Laki Laki");
        b.setMemberName("Roti");
        b.setMemberPassword("Coklat pisang");
        service.create(b);
        service.delete(3L);
        service.delete(1L);
        List<Member> members =null;
        Mockito.when(memberRepository.findAll()).thenReturn(members);
        Assert.assertTrue(service.findAll() == null);
    }
}
