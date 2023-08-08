package com.example.demo.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
@CrossOrigin("*")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("save")
    public void saveMembers(){
        memberService.saveMembers();
    }

    @GetMapping
    public Page<Member> findAllByCondition(
            @RequestParam(required = false
                    , defaultValue = "0", name = "page")
            Integer page,
            @RequestParam(required = false
                    , defaultValue = "4", name = "size")
            Integer size){
        return memberService.makeTeam(PageRequest.of(page,size));
    }

    @PutMapping
    public void putMember(@RequestBody RequestUpdateImage request){
        if(request.image() == null||request.image().isEmpty() ) throw new RuntimeException("image is null");
        memberService.updateMember(request);
    }
}
