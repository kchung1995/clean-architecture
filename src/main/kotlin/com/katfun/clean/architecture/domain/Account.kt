package com.katfun.clean.architecture.domain

import java.time.LocalDateTime

class Account(
    private val id: AccountId,
    private val baselineBalance: Money,
    private val activityWindow: ActivityWindow,
) {
    fun calculateBalance(): Money {
        return Money.add(
            this.baselineBalance,
            this.activityWindow.calculateBalance(this.id),
        )
    }

    fun withdraw(
        money: Money,
        targetAccountId: AccountId,
        now: LocalDateTime = LocalDateTime.now(),
    ): Boolean {
        if (mayWithdraw(money).not()) return false

        val withdrawal: Activity =
            Activity(
                null,
                this.id,
                this.id,
                targetAccountId,
                now,
                money,
            )
        this.activityWindow.addActivity(withdrawal)
        return true
    }

    private fun mayWithdraw(money: Money): Boolean {
        val moneyAdded =
            Money.add(
                this.calculateBalance(),
                money.negate(),
            )
        return moneyAdded.isPositive()
    }

    fun deposit(
        money: Money,
        sourceAccountId: AccountId,
        now: LocalDateTime = LocalDateTime.now(),
    ): Boolean {
        val deposit =
            Activity(
                null,
                this.id,
                sourceAccountId,
                this.id,
                now,
                money,
            )
        this.activityWindow.addActivity(deposit)
        return true
    }

    @JvmInline
    value class AccountId(val value: Long)
}
