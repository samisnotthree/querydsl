package com.jpa.querydsl.controller;

import com.jpa.querydsl.dto.MemberSearchCondition;
import com.jpa.querydsl.dto.MemberTeamDto;
import com.jpa.querydsl.repository.MemberJpaRepository;
import com.jpa.querydsl.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberJpaRepository memberJpaRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/v1/members")
    public List<MemberTeamDto> searchMemberV1(MemberSearchCondition condition) {
        return memberJpaRepository.search(condition);
    }

//    @GetMapping("/v2/members")
//    public Page<MemberTeamDto> searchMemberV2(MemberSearchCondition condition, Pageable pageable) {
//        return memberRepository.searchPageSimple(condition, pageable);
//    }

    @GetMapping("/v3/members")
    public Page<MemberTeamDto> searchMemberV3(MemberSearchCondition condition, Pageable pageable) {
        return memberRepository.searchPageComplex(condition, pageable);
    }
}