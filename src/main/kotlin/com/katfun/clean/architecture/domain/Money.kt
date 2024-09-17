package com.katfun.clean.architecture.domain

import java.math.BigDecimal

@JvmInline
value class Money(
    val amount: BigDecimal,
) {
    companion object {
        fun add(
            a: Money,
            b: Money,
        ): Money = Money(a.amount.add(b.amount))
    }

    fun isPositive() = this.amount > BigDecimal.ZERO

    fun negate(): Money = Money(this.amount.negate())
}
