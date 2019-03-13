package com.training.memberweb.Controller;

import com.training.memberweb.Entity.ApiKey;
import com.training.memberweb.Entity.Member;
import com.training.memberweb.Service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(
            value = "/member",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Member create(@RequestBody Member member){
        return memberService.create(member);
    }
    @RequestMapping(
            value = "/members",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Member> findAll(ApiKey apiKey){
        return memberService.findAll();
    }
    @RequestMapping(
            value = "/members/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Member findById(@PathVariable("id")Long id){
        return memberService.findById(id);
    }
    @RequestMapping(
            value = "/members/update/{id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Member update(@RequestBody Member member, @PathVariable("id")Long id) {
        return memberService.update(member,id);
    }
    @RequestMapping(
            value = "/members/delete/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Member delete(@PathVariable("id") Long id){
        return memberService.delete(id);
    }
}
