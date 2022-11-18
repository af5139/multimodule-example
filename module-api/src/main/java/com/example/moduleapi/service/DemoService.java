package com.example.moduleapi.service;

import com.example.moduleapi.exception.CustomException;
import com.example.modulecommon.domain.Member;
import com.example.modulecommon.enums.CodeEnum;
import com.example.modulecommon.repositories.MemberRepository;
import com.example.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final CommonDemoService commonDemoService;
    private final MemberRepository memberRepository;

    public String save(){
        memberRepository.save(Member.builder()
                        .name(Thread.currentThread().getName())
                        .build());
        //System.out.println(CodeEnum.SUCCESS.getCode());
        //System.out.println(commonDemoService.commonService());
        return"save";
    }

    public String find(){
        return "find";
    }

    public String exception(){
        if(true){
            throw new CustomException(CodeEnum.UNKNOWN_ERROR);
        }
        return "exception";
    }
}
