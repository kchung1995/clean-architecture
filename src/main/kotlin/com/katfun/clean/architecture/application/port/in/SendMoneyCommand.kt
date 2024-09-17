package com.katfun.clean.architecture.application.port.`in`

import com.katfun.clean.architecture.domain.Account.AccountId
import com.katfun.clean.architecture.domain.Money
import java.math.BigDecimal

class SendMoneyCommand(
    private val sourceAccountId: AccountId,
    private val targetAccountId: AccountId,
    private val money: Money,
) {
    init {
        require(money.amount > BigDecimal.ZERO)
    }
}
