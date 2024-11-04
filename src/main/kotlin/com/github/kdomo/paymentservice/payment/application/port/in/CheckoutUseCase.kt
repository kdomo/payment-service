package com.github.kdomo.paymentservice.payment.application.port.`in`

import com.github.kdomo.paymentservice.payment.domain.CheckoutResult
import reactor.core.publisher.Mono

interface CheckoutUseCase {
    fun checkout(command: CheckoutCommand): Mono<CheckoutResult>
}