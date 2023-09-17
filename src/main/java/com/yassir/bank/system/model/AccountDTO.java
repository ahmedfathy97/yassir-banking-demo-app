package com.yassir.bank.system.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountDTO {


    @JsonProperty("accountNumber")
    @Schema(name = "accountNumber", required = true)
    private String accountNumber;

    @JsonProperty("balance")
    @NotNull
    @Positive
    @Schema(name = "balance", required = true)
    private BigDecimal balance;


    @JsonProperty("customerId")
    @NotNull
    @Schema(name = "customerId", required = true)
    private Long customerId;
}

