package com.yassir.bank.system.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yassir.bank.system.model.entity.Transaction;
import com.yassir.bank.system.model.enums.TransferDirection;
import com.yassir.bank.system.model.enums.TransactionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionsVTO {

    @JsonProperty("id")
    @NotNull
    @Schema(name = "id", required = true)
    private Long id;


    @JsonProperty("sourceAccountId")
    @Schema(name = "sourceAccountId", required = true)
    private Long sourceAccountId;

    @JsonProperty("targetAccount")
    @Schema(name = "targetAccountId", required = true)
    private Long targetAccountId;

    @JsonProperty("createdAt")
    @NotNull
    @Schema(name = "createdAt", required = true)
    private Date createdAt;

    @JsonProperty("transactionType")
    @Schema(name = "transactionType", required = true)
    private TransactionType transactionType;

    @JsonProperty("transferDirection")
    @Schema(name = "transferDirection", required = true)
    private TransferDirection transferDirection;

    @JsonProperty("amount")
    @Schema(name = "amount", required = true)
    private BigDecimal amount;

    @JsonProperty("balanceBeforeTransaction")
    @Schema(name = "balanceBeforeTransaction", required = true)
    private BigDecimal balanceBeforeTransaction;

    @JsonProperty("balanceAfterTransaction")
    @Schema(name = "balanceAfterTransaction", required = true)
    private BigDecimal balanceAfterTransaction;


    public TransactionsVTO(Transaction transaction) {
        this.id = transaction.getId();
        this.transactionType = transaction.getTransactionType();
        this.transferDirection = transaction.getTransferDirection();
        this.sourceAccountId = transaction.getSourceAccount().getId();
        this.targetAccountId = transaction.getTargetAccount().getId();
        this.createdAt = transaction.getCreatedAt();
        this.amount = transaction.getAmount();
        this.balanceBeforeTransaction = transaction.getBalanceBeforeTransaction();
        this.balanceAfterTransaction = transaction.getBalanceAfterTransaction();
    }

}

