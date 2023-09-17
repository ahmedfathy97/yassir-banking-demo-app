package com.yassir.bank.system.exception.handler;

import com.yassir.bank.system.model.Error;
import lombok.Getter;

@Getter
public class ProblemRunTimeException extends RuntimeException {

    public final Error error;

    public ProblemRunTimeException(Error errorApiResponse) {
        super(errorApiResponse.getMessage());
        this.error = errorApiResponse;
    }


}
