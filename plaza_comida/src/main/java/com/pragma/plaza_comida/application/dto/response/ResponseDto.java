package com.pragma.plaza_comida.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
    private boolean error;
    private String message;
    private Object data;
}
