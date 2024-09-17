package com.katfun.clean.architecture.application.port.out

import com.katfun.clean.architecture.domain.Account.AccountId
import java.time.LocalDateTime

fun interface LoadAccountPort {
    fun loadAccount(
        accountId: AccountId,
        baselineDate: LocalDateTime,
    )
}
