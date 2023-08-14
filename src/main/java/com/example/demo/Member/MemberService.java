package com.example.demo.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    private String[] members = {"이태열","이도경","채오성","김수동","김정수","김지혜","김태경","김태홍","박경희",
    "박준제","안재원","양기석","왕경훈","이동명","이세인","이태웅","정민균","정준기","최영준","최웅진","허하나","현수정","이재명"};

    private List<Member> memberList = new ArrayList<>();

    public void saveMembers(){

        for (String member:
             members) {
            int random = (int) (Math.random()*10000);
            Member build = Member.builder().name(member).number(random).image("https://ca.slack-edge.com/T053ASVJV96-U056TNCRRF1-g80c98b86866-512").build();
            memberList.add(build);
        }

        memberRepository.saveAll(memberList);

    }

    public Page<Member> makeTeam(PageRequest pageRequest){
        return memberRepository.findAllbyCondition(pageRequest);
    }
    @Transactional
    public void updateMember(RequestUpdateImage request){
        Optional<Member> byId = memberRepository.findById(request.id());
        if(byId.isEmpty()) throw new RuntimeException("없는 사람");
        Member member = byId.get();
        member.setImage(request.image());
    }
    @Transactional
    public Member login(String name){
        Optional<Member> byName = memberRepository.findByName(name);
        Member member = byName.orElseThrow(() -> new RuntimeException("LOGIN FAIL"));
        return member;
    }
}
