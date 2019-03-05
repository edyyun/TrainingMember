package com.training.memberweb.Service;

import com.training.memberweb.Model.Member;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MemberServiceTest {

    private MemberService service;

    @Before
    public void setUp() throws Exception {
        service =new MemberServiceImpl();
    }

    @Test
    public void CreateTest(){
        Member a = new Member(1,"Roka","asdf","jkl;","Coklat bulat","Perempuan");
        service.create(a);
        Assert.assertTrue(service.findAll().size()==1);
        Assert.assertTrue(service.findById(1)==a);
        a = new Member();
        Assert.assertTrue(service.create(a)==null);
    }
    @Test
    public void FindByIdTest(){
        Member a = new Member(1,"Roka","asdf","jkl;","Coklat bulat","Perempuan");
        service.create(a);
        service.create(new Member(2,"Teddy","asdf","jkl;","Syahdan","Lakilaki"));
        service.create(new Member(3,null,"asdf","jkl;",null,"Lakilaki"));
        Assert.assertTrue(service.findById(1)==a);
    }
    @Test
    public void FindAllTest(){
        service.create(new Member(1,"Roka","asdf","jkl;","Coklat bulat","Perempuan"));
        service.create(new Member(2,"Teddy","asdf","jkl;","Syahdan","Lakilaki"));
        service.create(new Member(3,null,"asdf","jkl;",null,"Lakilaki"));
        Assert.assertTrue(service.findAll().size()==2);
    }
    @Test
    public void UpdateTest(){
        Member a = new Member(1,"Roka","asdf","jkl;","Coklat bulat","Perempuan");
        service.create(a);
        Member b = new Member(1,"Dodi","qewr","uiop;","Coklat bulat","Perempuan");
        Member c= service.update(b);
        Assert.assertTrue(c!=null);
        //System.out.println(c);
        //System.out.println(b);
        Assert.assertTrue(b==c);
    }

    @Test
    public void DeleteTest(){
        service.create(new Member(1,"Roka","asdf","jkl;","Coklat bulat","Perempuan"));
        service.create(new Member(2,"Teddy","asdf","jkl;","Syahdan","Lakilaki"));
        Assert.assertTrue(service.delete(3)==null);
        Assert.assertTrue(service.findById(1)==service.delete(1));
    }
}
