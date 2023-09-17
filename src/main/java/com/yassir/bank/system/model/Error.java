package com.yassir.bank.system.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class Error {

    @JsonProperty("code")
    private Integer code;

    @JsonProperty("message")
    private String message;

    public Error(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

