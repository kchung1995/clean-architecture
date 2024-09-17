package com.katfun.clean.architecture.domain

import com.katfun.clean.architecture.domain.Account.AccountId
import java.time.LocalDateTime

class Activity(
    val id: ActivityId?,
    val ownerAccountId: AccountId,
    val sourceAccountId: AccountId,
    val targetAccountId: AccountId,
    val timestamp: LocalDateTime,
    val money: Money,
) {
    @JvmInline
    value class ActivityId(val value: Long)
}
