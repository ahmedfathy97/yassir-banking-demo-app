package com.yassir.bank.system.exception;


import com.yassir.bank.system.model.Error;

public class ErrorConstants {

    private ErrorConstants() {
        throw new IllegalStateException("ErrorConstants class");
    }

    public static final Error NOT_HAS_ENOUGH_MONEY = new Error(1001, "No has enough money to transfer");
    public static final Error ACCOUNT_NOT_ACTIVE_STATUS = new Error(1002, "Your sourceAccount should be active status");
    public static final Error SAME_ACCOUNT = new Error(1003, "You can't send or receive money from your sourceAccount");
    public static final Error CURRENCY_SHOULD_SAME = new Error(1004, "The currency should be the same");

}
