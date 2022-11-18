package com.example.moduleapi.response;

import com.example.modulecommon.enums.CodeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter@Getter@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)//널이면 필드조차 보여주지 않겠따
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> {
    private String returnCode;
    private String returnMessage;
    private T info;

    public CommonResponse(CodeEnum codeEnum){
        setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());
    }

    public CommonResponse(T info){
        setReturnCode(CodeEnum.SUCCESS.getCode());
        setReturnMessage(CodeEnum.SUCCESS.getMessage());
        setInfo(info);
    }

    public CommonResponse(CodeEnum codeEnum, T info){
        setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());
        setInfo(info);
    }
}
