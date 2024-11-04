package com.github.kdomo.paymentservice.payment.application.port.out

import com.github.kdomo.paymentservice.payment.domain.PaymentEvent
import reactor.core.publisher.Mono

interface SavePaymentPort {
    fun save(paymentEvent: PaymentEvent): Mono<Void>
}