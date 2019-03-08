package com.training.memberweb.Service;

import com.training.memberweb.Entity.Member;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTest {

    private MemberService service;

    @Before
    public void setUp() throws Exception {
        service =new MemberServiceImpl();
    }

    @Test
    public void CreateTest(){
        Member a = new Member();
        a.setMemberAddress("jkl;");
        a.setMemberEmail("asdf");
        a.setMemberGender("Perempuan");
        a.setMemberName("Roka");
        a.setMemberPassword("Coklat bulat");
        service.create(a);
        Assert.assertTrue(service.findAll().size()==1);
        a = new Member();
        Assert.assertTrue(service.create(a)==null);
    }
    @Test
    public void FindByIdTest(){
        Member a = new Member();
        a.setMemberAddress("jkl;");
        a.setMemberEmail("asdf");
        a.setMemberGender("Perempuan");
        a.setMemberName("Roka");
        a.setMemberPassword("Coklat bulat");
        Assert.assertTrue(service.findById(a.getMemberId())==a);
    }
    @Test
    public void FindAllTest(){
        Member a = new Member();
        a.setMemberAddress("jkl;");
        a.setMemberEmail("asdf");
        a.setMemberGender("Perempuan");
        a.setMemberName("Roka");
        a.setMemberPassword("Coklat bulat");
        service.create(a);
        Member b = new Member();
        b.setMemberAddress("zcxv");
        b.setMemberEmail("qewr");
        b.setMemberGender("Laki Laki");
        b.setMemberName("Roti");
        b.setMemberPassword("Coklat pisang");
        service.create(b);
        Assert.assertTrue(service.findAll().size()==2);
    }
    @Test
    public void UpdateTest(){
        Member a = new Member();
        a.setMemberAddress("jkl;");
        a.setMemberEmail("asdf");
        a.setMemberGender("Perempuan");
        a.setMemberName("Roka");
        a.setMemberPassword("Coklat bulat");
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
        Assert.assertTrue(service.findAll().size() == 1);
    }
}
