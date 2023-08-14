package com.example.demo.Member;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
@CrossOrigin("*")
@Slf4j
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
            Integer size) throws InterruptedException {
        return memberService.makeTeam(PageRequest.of(page,size));
    }

    @PutMapping
    public void putMember(@RequestBody RequestUpdateImage request
            , HttpServletRequest req){
        log.info("{} {}", req.getRemoteAddr(), request.toString());
        if(request.image() == null && request.image().isEmpty() ) throw new RuntimeException("image is null");
        memberService.updateMember(request);
    }

    @PostMapping
    public Member login(@RequestBody Map<String, String> request
            , HttpServletRequest req){
        log.info("{} {}", req.getRemoteAddr(), request.toString());
        return memberService.login(request.get("name"));
    }

}
