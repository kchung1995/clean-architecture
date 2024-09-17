package com.katfun.clean.architecture.application.service

import com.katfun.clean.architecture.application.port.`in`.SendMoneyCommand
import com.katfun.clean.architecture.application.port.out.AccountLock
import com.katfun.clean.architecture.application.port.out.LoadAccountPort
import com.katfun.clean.architecture.application.port.out.UpdateAccountStatePort

class SendMoneyService(
    loadAccountPort: LoadAccountPort,
    accountLock: AccountLock,
    updateAccountStatePort: UpdateAccountStatePort,
) {
    fun sendMoney(command: SendMoneyCommand): Boolean {
        TODO("비지니스 규칙 검증")
        TODO("모델 상태 조작")
        TODO("출력 값 변환")
    }
}
