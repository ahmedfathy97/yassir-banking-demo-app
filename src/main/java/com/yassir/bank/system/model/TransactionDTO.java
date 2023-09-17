package com.yassir.bank.system.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.yassir.bank.system.model.enums.TransferDirection;
import com.yassir.bank.system.model.enums.TransactionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionDTO {

    @JsonProperty("sourceAccount")
    @NotNull
    @Schema(name = "sourceAccount", required = true)
    private Long sourceAccount;

    @JsonProperty("targetAccount")
    @NotNull
    @Schema(name = "targetAccount", required = true)
    private Long targetAccount;

    @JsonProperty("amount")
    @NotNull
    @Schema(name = "amount", required = true)
    private BigDecimal amount;


    @JsonProperty("transactionType")
    @NotNull
    @Schema(name = "transactionType", required = true)
    private TransactionType transactionType;


    @JsonProperty("transferDirection")
    @NotNull
    @Schema(name = "transferDirection", required = true)
    private TransferDirection transferDirection;
}

